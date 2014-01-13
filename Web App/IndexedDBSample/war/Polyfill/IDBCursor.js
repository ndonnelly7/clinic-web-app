/*
 Copyright 2012 Facebook Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

if (window.indexedDB.polyfill)
  (function (window, indexedDB, util, undefined) {
    var IDBCursor = util.IDBCursor = window.IDBCursor = function (source, direction, request) {
      this.source = source;
      this.direction = direction || IDBCursor.NEXT;
      this.key = null;        // position
      this.primaryKey = null; // effective key

      this._request = request;
      this._range = null;
      this._gotValue = true;
      this._effectiveKeyEncoded = null;
    };

    IDBCursor.prototype.update = function (value) {
      var objectStore = getObjectStore(this);
      IDBTransaction._assertNotReadOnly(objectStore.transaction);
      if (!(this instanceof util.IDBCursorWithValue) || !this._gotValue) throw util.error("InvalidStateError");
      if (objectStore.keyPath != null) {
        var key = util.extractKeyFromValue(objectStore.keyPath, value);
        if (key != this.primaryKey) throw util.error("DataError");
      }
      var request = new util.IDBRequest(this);
      var me = this;
      objectStore.transaction._queueOperation(function (sqlTx, nextRequestCallback) {
        objectStore._insertOrReplaceRecord(
          {
            request : request,
            sqlTx : sqlTx,
            nextRequestCallback : nextRequestCallback,
            noOverwrite : false,
            value : value,
            encodedKey : me._effectiveKeyEncoded
          });
      });
      return request;
    };

    IDBCursor.prototype.advance = function (count) {
      count = parseInt(count);
      if (isNaN(count) || count <= 0) throw util.error("TypeError");

      advanceOrContinue(this, count, null);
    };

    IDBCursor.prototype.continue = function (key) {
      advanceOrContinue(this, 1, key);
    };

    IDBCursor.prototype.delete = function () {
      var objectStore = getObjectStore(this);
      IDBTransaction._assertNotReadOnly(objectStore.transaction);
      if (!(this instanceof util.IDBCursorWithValue) || !this._gotValue) throw util.error("InvalidStateError");

      var request = new util.IDBRequest(this);
      var me = this;
      objectStore.transaction._queueOperation(function (sqlTx, nextRequestCallback) {
        objectStore._deleteRecord(sqlTx, me._effectiveKeyEncoded,
          function () {
            util.fireSuccessEvent(request);
            nextRequestCallback();
          },
          function (_, error) {
            util.fireErrorEvent(request, error);
            nextRequestCallback();
          });
      });
      return request;
    };

    // Internal methods
    function advanceOrContinue(me, count, key) {
      if (!me._gotValue) throw util.error("InvalidStateError");
      me._gotValue = false;

      var filter = util.IDBKeyRange._clone(me._range);
      filter.count = count;
      var isSourceIndex = me.source instanceof util.IDBIndex;
      var position = me.key;
      var noDuplicate = [IDBCursor.PREV_NO_DUPLICATE, IDBCursor.NEXT_NO_DUPLICATE].indexOf(me.direction) >= 0;
      if (key != null) {
        if (isDesc(me)) {
          if ((isSourceIndex && key > position) || key >= position) throw util.error("DataError");
          filter.upper = key;
          filter.upperOpen = false;
        }
        else {
          if ((isSourceIndex && key < position) || key <= position) throw util.error("DataError");
          filter.lower = key;
          filter.lowerOpen = false;
        }
      }
      else if (position != null) {
        var open = !isSourceIndex || noDuplicate;
        if (isDesc(me)) {
          filter.upper = position;
          filter.upperOpen = open;
        }
        else {
          filter.lower = position;
          filter.lowerOpen = open;
        }
      }
      if (isSourceIndex) iterateIndexCursor(me, filter);
      else iterateCursor(me, filter);
    }

    function iterateCursor(me, filter) {
      var tx = me.source.transaction;
      me._request.readyState = util.IDBRequest.LOADING;
      tx._queueOperation(function (sqlTx, nextRequestCallback) {
        var sql = ["SELECT hex(key) 'key', value FROM [" + me.source.name + "]"];
        var where = [];
        var args = [];
        if (filter.lower != null) {
          where.push("(key >" + (filter.lowerOpen ? "" : "=") + " X'" + util.encodeKey(filter.lower) + "')");
        }
        if (filter.upper != null) {
          where.push("(key <" + (filter.upperOpen ? "" : "=") + " X'" + util.encodeKey(filter.upper) + "')");
        }
        if (where.length > 0) {
          sql.push("WHERE", where.join(" AND "))
        }
        sql.push("ORDER BY key" + (isDesc(me) ? " DESC" : ""));
        sql.push("LIMIT", filter.count);

        sqlTx.executeSql(sql.join(" "), args,
          function (tx, results) {
            var request = me._request;
            request.readyState = util.IDBRequest.DONE;
            if (results.rows.length < filter.count) {
              me.key = me.primaryKey = me._effectiveKeyEncoded = undefined;
              if (typeof me.value !== "undefined") me.value = undefined;
              request.result = null;
            }
            else {
              var found = results.rows.item(filter.count - 1);
              me._effectiveKeyEncoded = found.key;
              me.key = me.primaryKey = util.decodeKey(found.key);
              if (typeof me.value !== "undefined") me.value = w_JSON.parse(found.value);
              me._gotValue = true;
              request.result = me;
            }
            util.fireSuccessEvent(request);
            nextRequestCallback();
          },
          function (tx, error) {
            util.fireErrorEvent(me._request, error);
            nextRequestCallback();
          });
      });
    }

    function iterateIndexCursor(me, filter) {
      var tx = me.source.objectStore.transaction;
      me._request.readyState = util.IDBRequest.LOADING;
      tx._queueOperation(function (sqlTx, nextRequestCallback) {
        var withValue = me instanceof IDBCursorWithValue;
        var desc = isDesc(me);
        var objectStoreName = me.source.objectStore.name;
        var tableName = util.indexTable(objectStoreName, me.source.name);
        var sql = ["SELECT hex(i.key) 'key', hex(i.primaryKey) 'primaryKey'" + (withValue ? ", t.value" : ""),
          "FROM [" + tableName + "] as i"];

        if (withValue) {
          sql.push("LEFT JOIN [" + objectStoreName + "] as t ON t.Id = i.recordId");
        }
        var where = [], args = [], encoded;
        if (filter.lower != null) {
          encoded = util.encodeKey(filter.lower);
          if (filter.lowerOpen) {
            where.push("(i.key > X'" + encoded + "')");
          }
          else {
            if (me._effectiveKeyEncoded == null || desc) {
              where.push("(i.key >= X'" + encoded + "')");
            }
            else {
              where.push("((i.key > X'" + encoded + "') OR (i.key = X'" + encoded +
                "' AND i.primaryKey > X'" + me._effectiveKeyEncoded + "'))");
            }
          }
        }
        if (filter.upper != null) {
          encoded = util.encodeKey(filter.upper);
          if (filter.upperOpen) {
            where.push("(i.key < X'" + encoded + "')");
          }
          else {
            if (me._effectiveKeyEncoded == null || !desc) {
              where.push("(i.key <= X'" + encoded + "')");
            }
            else {
              where.push("((i.key < X'" + encoded + "') OR (i.key = X'" + encoded +
                "' AND i.primaryKey < X'" + me._effectiveKeyEncoded + "'))");
            }
          }
        }
        if (where.length > 0) {
          sql.push("WHERE", where.join(" AND "))
        }
        var sDesc = desc ? " DESC" : "";
        sql.push("ORDER BY i.key" + sDesc + ", i.primaryKey" + sDesc);
        sql.push("LIMIT", filter.count);

        sqlTx.executeSql(sql.join(" "), args,
          function (sqlTx, results) {
            var request = me._request;
            request.readyState = util.IDBRequest.DONE;
            if (results.rows.length < filter.count) {
              me.key = me.primaryKey = me._effectiveKeyEncoded = undefined;
              if (typeof me.value !== "undefined") me.value = undefined;
              request.result = null;
            }
            else {
              var found = results.rows.item(filter.count - 1);
              me.key = util.decodeKey(found.key);
              me._effectiveKeyEncoded = found.primaryKey;
              me.primaryKey = util.decodeKey(found.primaryKey);
              if (typeof me.value !== "undefined") me.value = w_JSON.parse(found.value);
              me._gotValue = true;
              request.result = me;
            }
            util.fireSuccessEvent(request);
            nextRequestCallback();
          },
          function (_, error) {
            util.fireErrorEvent(me._request, error);
            nextRequestCallback();
          });
      });
    }

    // Utils
    var w_JSON = window.JSON;

    function isDesc(cursor) {
      return [IDBCursor.PREV, IDBCursor.PREV_NO_DUPLICATE].indexOf(cursor.direction) >= 0;
    }

    function getObjectStore(cursor) {
      if (cursor.source instanceof util.IDBObjectStore) {
        return cursor.source;
      }
      else if (cursor.source instanceof util.IDBIndex) {
        return cursor.source.objectStore;
      }
      return null;
    }

    IDBCursor.NEXT = "next";
    IDBCursor.NEXT_NO_DUPLICATE = "nextunique";
    IDBCursor.PREV = "prev";
    IDBCursor.PREV_NO_DUPLICATE = "prevunique";

    var IDBCursorWithValue = function (source, direction, request) {
      IDBCursor.apply(this, arguments);
      this.value = null;
    };
    IDBCursorWithValue.prototype = new IDBCursor();
    IDBCursorWithValue.prototype.constructor = IDBCursorWithValue;
    util.IDBCursorWithValue = window.IDBCursorWithValue = IDBCursorWithValue;

  }(window, window.indexedDB, window.indexedDB.util));
