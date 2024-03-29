/*! IndexedDBShim - v0.1.2 - 2013-07-11 
 * Author: nparashuram
 * Retrieved from: http://nparashuram.com/IndexedDBShim/dist/IndexedDBShim.min.js*/
"use strict";
var idbModules = {};
(function (e) {
	function t(e, t, n, o) {
		n.target = t, "function" == typeof t[e] && t[e].apply(t, [n]), "function" == typeof o && o()
	}
	function n(t, n, o) {
		var i = new DOMException.constructor(0, n);
		throw i.name = t, i.message = n, e.DEBUG && (console.log(t, n, o, i), console.trace && console.trace()), i
	}
	var o = function () {
		this.length = 0, this._items = [], Object.defineProperty && Object.defineProperty(this, "_items", {
			enumerable: !1
		})
	};
	if (o.prototype = {
		contains: function (e) {
			return -1 !== this._items.indexOf(e)
		},
		item: function (e) {
			return this._items[e]
		},
		indexOf: function (e) {
			return this._items.indexOf(e)
		},
		push: function (e) {
			this._items.push(e), this.length += 1;
			for (var t = 0; this._items.length > t; t++) this[t] = this._items[t]
		},
		splice: function () {
			this._items.splice.apply(this._items, arguments), this.length = this._items.length;
			for (var e in this) e === parseInt(e, 10) + "" && delete this[e];
			for (e = 0; this._items.length > e; e++) this[e] = this._items[e]
		}
	}, Object.defineProperty) for (var i in {
		indexOf: !1,
		push: !1,
		splice: !1
	}) Object.defineProperty(o.prototype, i, {
		enumerable: !1
	});
	e.util = {
		throwDOMException: n,
		callback: t,
		quote: function (e) {
			return "'" + e + "'"
		},
		StringList: o
	}
})(idbModules), function (idbModules) {
	var Sca = function () {
		return {
			decycle: function (object, callback) {
				function checkForCompletion() {
					0 === queuedObjects.length && returnCallback(derezObj)
				}
				function readBlobAsDataURL(e, t) {
					var n = new FileReader;
					n.onloadend = function (e) {
						var n = e.target.result,
							o = "blob";
						updateEncodedBlob(n, t, o)
					}, n.readAsDataURL(e)
				}
				function updateEncodedBlob(dataURL, path, blobtype) {
					var encoded = queuedObjects.indexOf(path);
					path = path.replace("$", "derezObj"), eval(path + '.$enc="' + dataURL + '"'), eval(path + '.$type="' + blobtype + '"'), queuedObjects.splice(encoded, 1), checkForCompletion()
				}
				function derez(e, t) {
					var n, o, i;
					if (!("object" != typeof e || null === e || e instanceof Boolean || e instanceof Date || e instanceof Number || e instanceof RegExp || e instanceof Blob || e instanceof String)) {
						for (n = 0; objects.length > n; n += 1) if (objects[n] === e) return {
							$ref: paths[n]
						};
						if (objects.push(e), paths.push(t), "[object Array]" === Object.prototype.toString.apply(e)) for (i = [], n = 0; e.length > n; n += 1) i[n] = derez(e[n], t + "[" + n + "]");
						else {
							i = {};
							for (o in e) Object.prototype.hasOwnProperty.call(e, o) && (i[o] = derez(e[o], t + "[" + JSON.stringify(o) + "]"))
						}
						return i
					}
					return e instanceof Blob ? (queuedObjects.push(t), readBlobAsDataURL(e, t)) : e instanceof Boolean ? e = {
						$type: "bool",
						$enc: "" + e
					} : e instanceof Date ? e = {
						$type: "date",
						$enc: e.getTime()
					} : e instanceof Number ? e = {
						$type: "num",
						$enc: "" + e
					} : e instanceof RegExp && (e = {
						$type: "regex",
						$enc: "" + e
					}), e
				}
				var objects = [],
					paths = [],
					queuedObjects = [],
					returnCallback = callback,
					derezObj = derez(object, "$");
				checkForCompletion()
			},
			retrocycle: function retrocycle($) {
				function dataURLToBlob(e) {
					var t, n, o, i = ";base64,";
					if (-1 === e.indexOf(i)) return n = e.split(","), t = n[0].split(":")[1], o = n[1], new Blob([o], {
						type: t
					});
					n = e.split(i), t = n[0].split(":")[1], o = window.atob(n[1]);
					for (var r = o.length, a = new Uint8Array(r), s = 0; r > s; ++s) a[s] = o.charCodeAt(s);
					return new Blob([a.buffer], {
						type: t
					})
				}
				function rez(value) {
					var i, item, name, path;
					if (value && "object" == typeof value) if ("[object Array]" === Object.prototype.toString.apply(value)) for (i = 0; value.length > i; i += 1) item = value[i], item && "object" == typeof item && (path = item.$ref, value[i] = "string" == typeof path && px.test(path) ? eval(path) : rez(item));
					else if (void 0 !== value.$type) switch (value.$type) {
					case "blob":
					case "file":
						value = dataURLToBlob(value.$enc);
						break;
					case "bool":
						value = Boolean("true" === value.$enc);
						break;
					case "date":
						value = new Date(value.$enc);
						break;
					case "num":
						value = Number(value.$enc);
						break;
					case "regex":
						value = eval(value.$enc)
					} else for (name in value)"object" == typeof value[name] && (item = value[name], item && (path = item.$ref, value[name] = "string" == typeof path && px.test(path) ? eval(path) : rez(item)));
					return value
				}
				var px = /^\$(?:\[(?:\d+|\"(?:[^\\\"\u0000-\u001f]|\\([\\\"\/bfnrt]|u[0-9a-zA-Z]{4}))*\")\])*$/;
				return rez($), $
			},
			encode: function (e, t) {
				function n(e) {
					t(JSON.stringify(e))
				}
				this.decycle(e, n)
			},
			decode: function (e) {
				return this.retrocycle(JSON.parse(e))
			}
		}
	}();
	idbModules.Sca = Sca
}(idbModules), function (e) {
	var t = ["", "number", "string", "boolean", "object", "undefined"],
		n = function () {
			return {
				encode: function (e) {
					return t.indexOf(typeof e) + "-" + JSON.stringify(e)
				},
				decode: function (e) {
					return e === void 0 ? void 0 : JSON.parse(e.substring(2))
				}
			}
		},
		o = {
			number: n("number"),
			"boolean": n(),
			object: n(),
			string: {
				encode: function (e) {
					return t.indexOf("string") + "-" + e
				},
				decode: function (e) {
					return "" + e.substring(2)
				}
			},
			undefined: {
				encode: function () {
					return t.indexOf("undefined") + "-undefined"
				},
				decode: function () {
					return void 0
				}
			}
		},
		i = function () {
			return {
				encode: function (e) {
					return o[typeof e].encode(e)
				},
				decode: function (e) {
					return o[t[e.substring(0, 1)]].decode(e)
				}
			}
		}();
	e.Key = i
}(idbModules), function (e) {
	var t = function (e, t) {
		return {
			type: e,
			debug: t,
			bubbles: !1,
			cancelable: !1,
			eventPhase: 0,
			timeStamp: new Date
		}
	};
	e.Event = t
}(idbModules), function (e) {
	var t = function () {
		this.onsuccess = this.onerror = this.result = this.error = this.source = this.transaction = null, this.readyState = "pending"
	},
		n = function () {
			this.onblocked = this.onupgradeneeded = null
		};
	n.prototype = t, e.IDBRequest = t, e.IDBOpenRequest = n
}(idbModules), function (e, t) {
	var n = function (e, t, n, o) {
		this.lower = e, this.upper = t, this.lowerOpen = n, this.upperOpen = o
	};
	n.only = function (e) {
		return new n(e, e, !0, !0)
	}, n.lowerBound = function (e, o) {
		return new n(e, t, o, t)
	}, n.upperBound = function (e) {
		return new n(t, e, t, open)
	}, n.bound = function (e, t, o, i) {
		return new n(e, t, o, i)
	}, e.IDBKeyRange = n
}(idbModules), function (e, t) {
	function n(n, o, i, r, a, s) {
		this.__range = n, this.source = this.__idbObjectStore = i, this.__req = r, this.key = t, this.direction = o, this.__keyColumnName = a, this.__valueColumnName = s, this.source.transaction.__active || e.util.throwDOMException("TransactionInactiveError - The transaction this IDBObjectStore belongs to is not active."), this.__offset = -1, this.__lastKeyContinued = t, this["continue"]()
	}
	n.prototype.__find = function (n, o, i, r) {
		var a = this,
			s = ["SELECT * FROM ", e.util.quote(a.__idbObjectStore.name)],
			u = [];
		s.push("WHERE ", a.__keyColumnName, " NOT NULL"), a.__range && (a.__range.lower || a.__range.upper) && (s.push("AND"), a.__range.lower && (s.push(a.__keyColumnName + (a.__range.lowerOpen ? " >" : " >= ") + " ?"), u.push(e.Key.encode(a.__range.lower))), a.__range.lower && a.__range.upper && s.push("AND"), a.__range.upper && (s.push(a.__keyColumnName + (a.__range.upperOpen ? " < " : " <= ") + " ?"), u.push(e.Key.encode(a.__range.upper)))), n !== t && (a.__lastKeyContinued = n, a.__offset = 0), a.__lastKeyContinued !== t && (s.push("AND " + a.__keyColumnName + " >= ?"), u.push(e.Key.encode(a.__lastKeyContinued))), s.push("ORDER BY ", a.__keyColumnName), s.push("LIMIT 1 OFFSET " + a.__offset), e.DEBUG && console.log(s.join(" "), u), o.executeSql(s.join(" "), u, function (n, o) {
			if (1 === o.rows.length) {
				var r = e.Key.decode(o.rows.item(0)[a.__keyColumnName]),
					s = "value" === a.__valueColumnName ? e.Sca.decode(o.rows.item(0)[a.__valueColumnName]) : e.Key.decode(o.rows.item(0)[a.__valueColumnName]);
				i(r, s)
			} else e.DEBUG && console.log("Reached end of cursors"), i(t, t)
		}, function (t, n) {
			e.DEBUG && console.log("Could not execute Cursor.continue"), r(n)
		})
	}, n.prototype["continue"] = function (e) {
		var n = this;
		this.__idbObjectStore.transaction.__addToTransactionQueue(function (o, i, r, a) {
			n.__offset++, n.__find(e, o, function (e, o) {
				n.key = e, n.value = o, r(n.key !== t ? n : t, n.__req)
			}, function (e) {
				a(e)
			})
		})
	}, n.prototype.advance = function (n) {
		0 >= n && e.util.throwDOMException("Type Error - Count is invalid - 0 or negative", n);
		var o = this;
		this.__idbObjectStore.transaction.__addToTransactionQueue(function (e, i, r, a) {
			o.__offset += n, o.__find(t, e, function (e, n) {
				o.key = e, o.value = n, r(o.key !== t ? o : t, o.__req)
			}, function (e) {
				a(e)
			})
		})
	}, n.prototype.update = function (n) {
		var o = this,
			i = this.__idbObjectStore.transaction.__createRequest(function () {});
		return e.Sca.encode(n, function (n) {
			this.__idbObjectStore.__pushToQueue(i, function (i, r, a, s) {
				o.__find(t, i, function (t) {
					var r = "UPDATE " + e.util.quote(o.__idbObjectStore.name) + " SET value = ? WHERE key = ?";
					e.DEBUG && console.log(r, n, t), i.executeSql(r, [e.Sca.encode(n), e.Key.encode(t)], function (e, n) {
						1 === n.rowsAffected ? a(t) : s("No rowns with key found" + t)
					}, function (e, t) {
						s(t)
					})
				}, function (e) {
					s(e)
				})
			})
		}), i
	}, n.prototype["delete"] = function () {
		var n = this;
		return this.__idbObjectStore.transaction.__addToTransactionQueue(function (o, i, r, a) {
			n.__find(t, o, function (i) {
				var s = "DELETE FROM  " + e.util.quote(n.__idbObjectStore.name) + " WHERE key = ?";
				e.DEBUG && console.log(s, i), o.executeSql(s, [e.Key.encode(i)], function (e, n) {
					1 === n.rowsAffected ? r(t) : a("No rowns with key found" + i)
				}, function (e, t) {
					a(t)
				})
			}, function (e) {
				a(e)
			})
		})
	}, e.IDBCursor = n
}(idbModules), function (idbModules, undefined) {
	function IDBIndex(e, t) {
		this.indexName = this.name = e, this.__idbObjectStore = this.objectStore = this.source = t;
		var n = t.__storeProps && t.__storeProps.indexList;
		n && (n = JSON.parse(n)), this.keyPath = n && n[e] && n[e].keyPath || e, ["multiEntry", "unique"].forEach(function (t) {
			this[t] = !! (n && n[e] && n[e].optionalParams && n[e].optionalParams[t])
		}, this)
	}
	IDBIndex.prototype.__createIndex = function (indexName, keyPath, optionalParameters) {
		var me = this,
			transaction = me.__idbObjectStore.transaction;
		transaction.__addToTransactionQueue(function (tx, args, success, failure) {
			me.__idbObjectStore.__getStoreProps(tx, function () {
				function error() {
					idbModules.util.throwDOMException(0, "Could not create new index", arguments)
				}
				2 !== transaction.mode && idbModules.util.throwDOMException(0, "Invalid State error, not a version transaction", me.transaction);
				var idxList = JSON.parse(me.__idbObjectStore.__storeProps.indexList);
				idxList[indexName] !== undefined && idbModules.util.throwDOMException(0, "Index already exists on store", idxList);
				var columnName = indexName;
				idxList[indexName] = {
					columnName: columnName,
					keyPath: keyPath,
					optionalParams: optionalParameters
				}, me.__idbObjectStore.__storeProps.indexList = JSON.stringify(idxList);
				var sql = ["ALTER TABLE", idbModules.util.quote(me.__idbObjectStore.name), "ADD", columnName, "BLOB"].join(" ");
				idbModules.DEBUG && console.log(sql), tx.executeSql(sql, [], function (tx, data) {
					tx.executeSql("SELECT * FROM " + idbModules.util.quote(me.__idbObjectStore.name), [], function (tx, data) {
						(function initIndexForRow(i) {
							if (data.rows.length > i) try {
								var value = idbModules.Sca.decode(data.rows.item(i).value),
									indexKey = eval("value['" + keyPath + "']");
								tx.executeSql("UPDATE " + idbModules.util.quote(me.__idbObjectStore.name) + " set " + columnName + " = ? where key = ?", [idbModules.Key.encode(indexKey), data.rows.item(i).key], function () {
									initIndexForRow(i + 1)
								}, error)
							} catch (e) {
								initIndexForRow(i + 1)
							} else idbModules.DEBUG && console.log("Updating the indexes in table", me.__idbObjectStore.__storeProps), tx.executeSql("UPDATE __sys__ set indexList = ? where name = ?", [me.__idbObjectStore.__storeProps.indexList, me.__idbObjectStore.name], function () {
								me.__idbObjectStore.__setReadyState("createIndex", !0), success(me)
							}, error)
						})(0)
					}, error)
				}, error)
			}, "createObjectStore")
		})
	}, IDBIndex.prototype.openCursor = function (e, t) {
		var n = new idbModules.IDBRequest;
		return new idbModules.IDBCursor(e, t, this.source, n, this.indexName, "value"), n
	}, IDBIndex.prototype.openKeyCursor = function (e, t) {
		var n = new idbModules.IDBRequest;
		return new idbModules.IDBCursor(e, t, this.source, n, this.indexName, "key"), n
	}, IDBIndex.prototype.__fetchIndexData = function (e, t) {
		var n = this;
		return n.__idbObjectStore.transaction.__addToTransactionQueue(function (o, i, r, a) {
			var s = ["SELECT * FROM ", idbModules.util.quote(n.__idbObjectStore.name), " WHERE", n.indexName, "NOT NULL"],
				u = [];
			e !== undefined && (s.push("AND", n.indexName, " = ?"), u.push(idbModules.Key.encode(e))), idbModules.DEBUG && console.log("Trying to fetch data for Index", s.join(" "), u), o.executeSql(s.join(" "), u, function (e, n) {
				var o;
				o = "count" == typeof t ? n.rows.length : 0 === n.rows.length ? undefined : "key" === t ? idbModules.Key.decode(n.rows.item(0).key) : idbModules.Sca.decode(n.rows.item(0).value), r(o)
			}, a)
		})
	}, IDBIndex.prototype.get = function (e) {
		return this.__fetchIndexData(e, "value")
	}, IDBIndex.prototype.getKey = function (e) {
		return this.__fetchIndexData(e, "key")
	}, IDBIndex.prototype.count = function (e) {
		return this.__fetchIndexData(e, "count")
	}, idbModules.IDBIndex = IDBIndex
}(idbModules), function (idbModules) {
	var IDBObjectStore = function (e, t, n) {
		this.name = e, this.transaction = t, this.__ready = {}, this.__setReadyState("createObjectStore", n === void 0 ? !0 : n), this.indexNames = new idbModules.util.StringList
	};
	IDBObjectStore.prototype.__setReadyState = function (e, t) {
		this.__ready[e] = t
	}, IDBObjectStore.prototype.__waitForReady = function (e, t) {
		var n = !0;
		if (t !== void 0) n = this.__ready[t] === void 0 ? !0 : this.__ready[t];
		else for (var o in this.__ready) this.__ready[o] || (n = !1);
		if (n) e();
		else {
			idbModules.DEBUG && console.log("Waiting for to be ready", t);
			var i = this;
			window.setTimeout(function () {
				i.__waitForReady(e, t)
			}, 100)
		}
	}, IDBObjectStore.prototype.__getStoreProps = function (e, t, n) {
		var o = this;
		this.__waitForReady(function () {
			o.__storeProps ? (idbModules.DEBUG && console.log("Store properties - cached", o.__storeProps), t(o.__storeProps)) : e.executeSql("SELECT * FROM __sys__ where name = ?", [o.name], function (e, n) {
				1 !== n.rows.length ? t() : (o.__storeProps = {
					name: n.rows.item(0).name,
					indexList: n.rows.item(0).indexList,
					autoInc: n.rows.item(0).autoInc,
					keyPath: n.rows.item(0).keyPath
				}, idbModules.DEBUG && console.log("Store properties", o.__storeProps), t(o.__storeProps))
			}, function () {
				t()
			})
		}, n)
	}, IDBObjectStore.prototype.__deriveKey = function (tx, value, key, callback) {
		function getNextAutoIncKey() {
			tx.executeSql("SELECT * FROM sqlite_sequence where name like ?", [me.name], function (e, t) {
				1 !== t.rows.length ? callback(0) : callback(t.rows.item(0).seq)
			}, function (e, t) {
				idbModules.util.throwDOMException(0, "Data Error - Could not get the auto increment value for key", t)
			})
		}
		var me = this;
		me.__getStoreProps(tx, function (props) {
			if (props || idbModules.util.throwDOMException(0, "Data Error - Could not locate defination for this table", props), props.keyPath) if (key !== void 0 && idbModules.util.throwDOMException(0, "Data Error - The object store uses in-line keys and the key parameter was provided", props), value) try {
				var primaryKey = eval("value['" + props.keyPath + "']");
				primaryKey ? callback(primaryKey) : "true" === props.autoInc ? getNextAutoIncKey() : idbModules.util.throwDOMException(0, "Data Error - Could not eval key from keyPath")
			} catch (e) {
				idbModules.util.throwDOMException(0, "Data Error - Could not eval key from keyPath", e)
			} else idbModules.util.throwDOMException(0, "Data Error - KeyPath was specified, but value was not");
			else key !== void 0 ? callback(key) : "false" === props.autoInc ? idbModules.util.throwDOMException(0, "Data Error - The object store uses out-of-line keys and has no key generator and the key parameter was not provided. ", props) : getNextAutoIncKey()
		})
	}, IDBObjectStore.prototype.__insertData = function (tx, value, primaryKey, success, error) {
		var paramMap = {};
		primaryKey !== void 0 && (paramMap.key = idbModules.Key.encode(primaryKey));
		var indexes = JSON.parse(this.__storeProps.indexList);
		for (var key in indexes) try {
			paramMap[indexes[key].columnName] = idbModules.Key.encode(eval("value['" + indexes[key].keyPath + "']"))
		} catch (e) {
			error(e)
		}
		var sqlStart = ["INSERT INTO ", idbModules.util.quote(this.name), "("],
			sqlEnd = [" VALUES ("],
			sqlValues = [];
		for (key in paramMap) sqlStart.push(key + ","), sqlEnd.push("?,"), sqlValues.push(paramMap[key]);
		sqlStart.push("value )"), sqlEnd.push("?)"), sqlValues.push(value);
		var sql = sqlStart.join(" ") + sqlEnd.join(" ");
		idbModules.DEBUG && console.log("SQL for adding", sql, sqlValues), tx.executeSql(sql, sqlValues, function () {
			success(primaryKey)
		}, function (e, t) {
			error(t)
		})
	}, IDBObjectStore.prototype.add = function (e, t) {
		var n = this,
			o = n.transaction.__createRequest(function () {});
		return idbModules.Sca.encode(e, function (i) {
			n.transaction.__pushToQueue(o, function (o, r, a, s) {
				n.__deriveKey(o, e, t, function (e) {
					n.__insertData(o, i, e, a, s)
				})
			})
		}), o
	}, IDBObjectStore.prototype.put = function (e, t) {
		var n = this,
			o = n.transaction.__createRequest(function () {});
		return idbModules.Sca.encode(e, function (i) {
			n.transaction.__pushToQueue(o, function (o, r, a, s) {
				n.__deriveKey(o, e, t, function (e) {
					var t = "DELETE FROM " + idbModules.util.quote(n.name) + " where key = ?";
					o.executeSql(t, [idbModules.Key.encode(e)], function (t, o) {
						idbModules.DEBUG && console.log("Did the row with the", e, "exist? ", o.rowsAffected), n.__insertData(t, i, e, a, s)
					}, function (e, t) {
						s(t)
					})
				})
			})
		}), o
	}, IDBObjectStore.prototype.get = function (e) {
		var t = this;
		return t.transaction.__addToTransactionQueue(function (n, o, i, r) {
			t.__waitForReady(function () {
				var o = idbModules.Key.encode(e);
				idbModules.DEBUG && console.log("Fetching", t.name, o), n.executeSql("SELECT * FROM " + idbModules.util.quote(t.name) + " where key = ?", [o], function (e, t) {
					idbModules.DEBUG && console.log("Fetched data", t);
					try {
						if (0 === t.rows.length) return i();
						i(idbModules.Sca.decode(t.rows.item(0).value))
					} catch (n) {
						idbModules.DEBUG && console.log(n), i(void 0)
					}
				}, function (e, t) {
					r(t)
				})
			})
		})
	}, IDBObjectStore.prototype["delete"] = function (e) {
		var t = this;
		return t.transaction.__addToTransactionQueue(function (n, o, i, r) {
			t.__waitForReady(function () {
				var o = idbModules.Key.encode(e);
				idbModules.DEBUG && console.log("Fetching", t.name, o), n.executeSql("DELETE FROM " + idbModules.util.quote(t.name) + " where key = ?", [o], function (e, t) {
					idbModules.DEBUG && console.log("Deleted from database", t.rowsAffected), i()
				}, function (e, t) {
					r(t)
				})
			})
		})
	}, IDBObjectStore.prototype.clear = function () {
		var e = this;
		return e.transaction.__addToTransactionQueue(function (t, n, o, i) {
			e.__waitForReady(function () {
				t.executeSql("DELETE FROM " + idbModules.util.quote(e.name), [], function (e, t) {
					idbModules.DEBUG && console.log("Cleared all records from database", t.rowsAffected), o()
				}, function (e, t) {
					i(t)
				})
			})
		})
	}, IDBObjectStore.prototype.count = function (e) {
		var t = this;
		return t.transaction.__addToTransactionQueue(function (n, o, i, r) {
			t.__waitForReady(function () {
				var o = "SELECT * FROM " + idbModules.util.quote(t.name) + (e !== void 0 ? " WHERE key = ?" : ""),
					a = [];
				e !== void 0 && a.push(idbModules.Key.encode(e)), n.executeSql(o, a, function (e, t) {
					i(t.rows.length)
				}, function (e, t) {
					r(t)
				})
			})
		})
	}, IDBObjectStore.prototype.openCursor = function (e, t) {
		var n = new idbModules.IDBRequest;
		return new idbModules.IDBCursor(e, t, this, n, "key", "value"), n
	}, IDBObjectStore.prototype.index = function (e) {
		var t = new idbModules.IDBIndex(e, this);
		return t
	}, IDBObjectStore.prototype.createIndex = function (e, t, n) {
		var o = this;
		n = n || {}, o.__setReadyState("createIndex", !1);
		var i = new idbModules.IDBIndex(e, o);
		return o.__waitForReady(function () {
			i.__createIndex(e, t, n)
		}, "createObjectStore"), o.indexNames.push(e), i
	}, IDBObjectStore.prototype.deleteIndex = function (e) {
		var t = new idbModules.IDBIndex(e, this, !1);
		return t.__deleteIndex(e), t
	}, idbModules.IDBObjectStore = IDBObjectStore
}(idbModules), function (e) {
	var t = 0,
		n = 1,
		o = 2,
		i = function (o, i, r) {
			if ("number" == typeof i) this.mode = i, 2 !== i && e.DEBUG && console.log("Mode should be a string, but was specified as ", i);
			else if ("string" == typeof i) switch (i) {
			case "readwrite":
				this.mode = n;
				break;
			case "readonly":
				this.mode = t;
				break;
			default:
				this.mode = t
			}
			this.storeNames = "string" == typeof o ? [o] : o;
			for (var a = 0; this.storeNames.length > a; a++) r.objectStoreNames.contains(this.storeNames[a]) || e.util.throwDOMException(0, "The operation failed because the requested database object could not be found. For example, an object store did not exist but was being opened.", this.storeNames[a]);
			this.__active = !0, this.__running = !1, this.__requests = [], this.__aborted = !1, this.db = r, this.error = null, this.onabort = this.onerror = this.oncomplete = null
		};
	i.prototype.__executeRequests = function () {
		if (this.__running && this.mode !== o) return e.DEBUG && console.log("Looks like the request set is already running", this.mode), void 0;
		this.__running = !0;
		var t = this;
		window.setTimeout(function () {
			2 === t.mode || t.__active || e.util.throwDOMException(0, "A request was placed against a transaction which is currently not active, or which is finished", t.__active), t.db.__db.transaction(function (n) {
				function o(t, n) {
					n && (a.req = n), a.req.readyState = "done", a.req.result = t, delete a.req.error;
					var o = e.Event("success");
					e.util.callback("onsuccess", a.req, o), s++, r()
				}
				function i() {
					a.req.readyState = "done", a.req.error = "DOMError";
					var t = e.Event("error", arguments);
					e.util.callback("onerror", a.req, t), s++, r()
				}
				function r() {
					return s >= t.__requests.length ? (t.__active = !1, t.__requests = [], void 0) : (a = t.__requests[s], a.op(n, a.args, o, i), void 0)
				}
				t.__tx = n;
				var a = null,
					s = 0;
				try {
					r()
				} catch (u) {
					e.DEBUG && console.log("An exception occured in transaction", arguments), "function" == typeof t.onerror && t.onerror()
				}
			}, function () {
				e.DEBUG && console.log("An error in transaction", arguments), "function" == typeof t.onerror && t.onerror()
			}, function () {
				e.DEBUG && console.log("Transaction completed", arguments), "function" == typeof t.oncomplete && t.oncomplete()
			})
		}, 1)
	}, i.prototype.__addToTransactionQueue = function (t, n) {
		this.__active || this.mode === o || e.util.throwDOMException(0, "A request was placed against a transaction which is currently not active, or which is finished.", this.__mode);
		var i = this.__createRequest();
		return this.__pushToQueue(i, t, n), i
	}, i.prototype.__createRequest = function () {
		var t = new e.IDBRequest;
		return t.source = this.db, t
	}, i.prototype.__pushToQueue = function (e, t, n) {
		this.__requests.push({
			op: t,
			args: n,
			req: e
		}), this.__executeRequests()
	}, i.prototype.objectStore = function (t) {
		return new e.IDBObjectStore(t, this)
	}, i.prototype.abort = function () {
		!this.__active && e.util.throwDOMException(0, "A request was placed against a transaction which is currently not active, or which is finished", this.__active)
	}, i.prototype.READ_ONLY = 0, i.prototype.READ_WRITE = 1, i.prototype.VERSION_CHANGE = 2, e.IDBTransaction = i
}(idbModules), function (e) {
	var t = function (t, n, o, i) {
		this.__db = t, this.version = o, this.__storeProperties = i, this.objectStoreNames = new e.util.StringList;
		for (var r = 0; i.rows.length > r; r++) this.objectStoreNames.push(i.rows.item(r).name);
		this.name = n, this.onabort = this.onerror = this.onversionchange = null
	};
	t.prototype.createObjectStore = function (t, n) {
		var o = this;
		n = n || {}, n.keyPath = n.keyPath || null;
		var i = new e.IDBObjectStore(t, o.__versionTransaction, !1),
			r = o.__versionTransaction;
		return r.__addToTransactionQueue(function (r, a, s) {
			function u() {
				e.util.throwDOMException(0, "Could not create new object store", arguments)
			}
			o.__versionTransaction || e.util.throwDOMException(0, "Invalid State error", o.transaction);
			var c = ["CREATE TABLE", e.util.quote(t), "(key BLOB", n.autoIncrement ? ", inc INTEGER PRIMARY KEY AUTOINCREMENT" : "PRIMARY KEY", ", value BLOB)"].join(" ");
			e.DEBUG && console.log(c), r.executeSql(c, [], function (e) {
				e.executeSql("INSERT INTO __sys__ VALUES (?,?,?,?)", [t, n.keyPath, n.autoIncrement ? !0 : !1, "{}"], function () {
					i.__setReadyState("createObjectStore", !0), s(i)
				}, u)
			}, u)
		}), o.objectStoreNames.push(t), i
	}, t.prototype.deleteObjectStore = function (t) {
		var n = function () {
			e.util.throwDOMException(0, "Could not delete ObjectStore", arguments)
		},
			o = this;
		!o.objectStoreNames.contains(t) && n("Object Store does not exist"), o.objectStoreNames.splice(o.objectStoreNames.indexOf(t), 1);
		var i = o.__versionTransaction;
		i.__addToTransactionQueue(function () {
			o.__versionTransaction || e.util.throwDOMException(0, "Invalid State error", o.transaction), o.__db.transaction(function (o) {
				o.executeSql("SELECT * FROM __sys__ where name = ?", [t], function (o, i) {
					i.rows.length > 0 && o.executeSql("DROP TABLE " + e.util.quote(t), [], function () {
						o.executeSql("DELETE FROM __sys__ WHERE name = ?", [t], function () {}, n)
					}, n)
				})
			})
		})
	}, t.prototype.close = function () {}, t.prototype.transaction = function (t, n) {
		var o = new e.IDBTransaction(t, n || 1, this);
		return o
	}, e.IDBDatabase = t
}(idbModules), function (e) {
	var t = 4194304;
	if (window.openDatabase) {
		var n = window.openDatabase("__sysdb__", 1, "System Database", t);
		n.transaction(function (t) {
			t.executeSql("SELECT * FROM dbVersions", [], function () {}, function () {
				n.transaction(function (t) {
					t.executeSql("CREATE TABLE IF NOT EXISTS dbVersions (name VARCHAR(255), version INT);", [], function () {}, function () {
						e.util.throwDOMException("Could not create table __sysdb__ to save DB versions")
					})
				})
			})
		}, function () {
			e.DEBUG && console.log("Error in sysdb transaction - when selecting from dbVersions", arguments)
		});
		var o = {
			open: function (o, i) {
				function r() {
					if (!u) {
						var t = e.Event("error", arguments);
						s.readyState = "done", s.error = "DOMError", e.util.callback("onerror", s, t), u = !0
					}
				}
				function a(a) {
					var u = window.openDatabase(o, 1, o, t);
					s.readyState = "done", i === void 0 && (i = a || 1), (0 >= i || a > i) && e.util.throwDOMException(0, "An attempt was made to open a database using a lower version than the existing version.", i), u.transaction(function (t) {
						t.executeSql("CREATE TABLE IF NOT EXISTS __sys__ (name VARCHAR(255), keyPath VARCHAR(255), autoInc BOOLEAN, indexList BLOB)", [], function () {
							t.executeSql("SELECT * FROM __sys__", [], function (t, c) {
								var d = e.Event("success");
								s.source = s.result = new e.IDBDatabase(u, o, i, c), i > a ? n.transaction(function (t) {
									t.executeSql("UPDATE dbVersions set version = ? where name = ?", [i, o], function () {
										var t = e.Event("upgradeneeded");
										t.oldVersion = a, t.newVersion = i, s.transaction = s.result.__versionTransaction = new e.IDBTransaction([], 2, s.source), e.util.callback("onupgradeneeded", s, t, function () {
											var t = e.Event("success");
											e.util.callback("onsuccess", s, t)
										})
									}, r)
								}, r) : e.util.callback("onsuccess", s, d)
							}, r)
						}, r)
					}, r)
				}
				var s = new e.IDBOpenRequest,
					u = !1;
				return n.transaction(function (e) {
					e.executeSql("SELECT * FROM dbVersions where name = ?", [o], function (e, t) {
						0 === t.rows.length ? e.executeSql("INSERT INTO dbVersions VALUES (?,?)", [o, i || 1], function () {
							a(0)
						}, r) : a(t.rows.item(0).version)
					}, r)
				}, r), s
			},
			deleteDatabase: function (o) {
				function i(t) {
					if (!s) {
						a.readyState = "done", a.error = "DOMError";
						var n = e.Event("error");
						n.message = t, n.debug = arguments, e.util.callback("onerror", a, n), s = !0
					}
				}
				function r() {
					n.transaction(function (t) {
						t.executeSql("DELETE FROM dbVersions where name = ? ", [o], function () {
							a.result = void 0;
							var t = e.Event("success");
							t.newVersion = null, t.oldVersion = u, e.util.callback("onsuccess", a, t)
						}, i)
					}, i)
				}
				var a = new e.IDBOpenRequest,
					s = !1,
					u = null;
				return n.transaction(function (n) {
					n.executeSql("SELECT * FROM dbVersions where name = ?", [o], function (n, s) {
						if (0 === s.rows.length) {
							a.result = void 0;
							var c = e.Event("success");
							return c.newVersion = null, c.oldVersion = u, e.util.callback("onsuccess", a, c), void 0
						}
						u = s.rows.item(0).version;
						var d = window.openDatabase(o, 1, o, t);
						d.transaction(function (t) {
							t.executeSql("SELECT * FROM __sys__", [], function (t, n) {
								var o = n.rows;
								(function a(n) {
									n >= o.length ? t.executeSql("DROP TABLE __sys__", [], function () {
										r()
									}, i) : t.executeSql("DROP TABLE " + e.util.quote(o.item(n).name), [], function () {
										a(n + 1)
									}, function () {
										a(n + 1)
									})
								})(0)
							}, function () {
								r()
							})
						}, i)
					})
				}, i), a
			},
			cmp: function (t, n) {
				return e.Key.encode(t) > e.Key.encode(n) ? 1 : t === n ? 0 : -1
			}
		};
		e.shimIndexedDB = o
	}
}(idbModules), function (e, t) {
	e.openDatabase !== void 0 && (e.shimIndexedDB = t.shimIndexedDB, e.shimIndexedDB && (e.shimIndexedDB.__useShim = function () {
		e.indexedDB = t.shimIndexedDB, e.IDBDatabase = t.IDBDatabase, e.IDBTransaction = t.IDBTransaction, e.IDBCursor = t.IDBCursor, e.IDBKeyRange = t.IDBKeyRange
	}, e.shimIndexedDB.__debug = function (e) {
		t.DEBUG = e
	})), e.indexedDB = e.indexedDB || e.webkitIndexedDB || e.mozIndexedDB || e.oIndexedDB || e.msIndexedDB, e.indexedDB === void 0 && e.openDatabase !== void 0 ? e.shimIndexedDB.__useShim() : (e.IDBDatabase = e.IDBDatabase || e.webkitIDBDatabase, e.IDBTransaction = e.IDBTransaction || e.webkitIDBTransaction, e.IDBCursor = e.IDBCursor || e.webkitIDBCursor, e.IDBKeyRange = e.IDBKeyRange || e.webkitIDBKeyRange, e.IDBTransaction || (e.IDBTransaction = {}), e.IDBTransaction.READ_ONLY = e.IDBTransaction.READ_ONLY || "readonly", e.IDBTransaction.READ_WRITE = e.IDBTransaction.READ_WRITE || "readwrite")
}(window, idbModules);
//@ sourceMappingURL=http://nparashuram.com/IndexedDBShim/dist/IndexedDBShim.min.map