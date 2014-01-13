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
  (function (util, undefined) {
    var ARRAY_TERMINATOR = { };
    var BYTE_TERMINATOR = 0;
    var TYPE_NUMBER = 1;
    var TYPE_DATE = 2;
    var TYPE_STRING = 3;
    var TYPE_ARRAY = 4;
    var MAX_TYPE_BYTE_SIZE = 12; // NOTE: Cannot be greater than 255

    util.encodeKey = function (key) {
      var stack = [key], writer = new HexStringWriter(), type = 0, dataType, obj;
      while ((obj = stack.pop()) !== undefined) {
        if (type % 4 === 0 && type + TYPE_ARRAY > MAX_TYPE_BYTE_SIZE) {
          writer.write(type);
          type = 0;
        }
        dataType = typeof obj;
        if (obj instanceof Array) {
          type += TYPE_ARRAY;
          if (obj.length > 0) {
            stack.push(ARRAY_TERMINATOR);
            var i = obj.length;
            while (i--) stack.push(obj[i]);
            continue;
          }
          else {
            writer.write(type);
          }
        }
        else if (dataType === "number") {
          type += TYPE_NUMBER;
          writer.write(type);
          encodeNumber(writer, obj);
        }
        else if (obj instanceof Date) {
          type += TYPE_DATE;
          writer.write(type);
          encodeNumber(writer, obj.valueOf());
        }
        else if (dataType === "string") {
          type += TYPE_STRING;
          writer.write(type);
          encodeString(writer, obj);
        }
        else if (obj === ARRAY_TERMINATOR) {
          writer.write(BYTE_TERMINATOR);
        }
        else return null;
        type = 0;
      }
      return writer.trim().toString();
    };

    util.decodeKey = function (encodedKey) {
      var rootArray = []; // one-element root array that contains the result
      var parentArray = rootArray;
      var type, arrayStack = [], depth, tmp;
      var reader = new HexStringReader(encodedKey);
      while (reader.read() != null) {
        if (reader.current === 0) // end of array
        {
          parentArray = arrayStack.pop();
          continue;
        }
        if (reader.current === null) {
          return rootArray[0];
        }
        do
        {
          depth = reader.current / 4 | 0;
          type = reader.current % 4;
          for (var i = 0; i < depth; i++) {
            tmp = [];
            parentArray.push(tmp);
            arrayStack.push(parentArray);
            parentArray = tmp;
          }
          if (type === 0 && reader.current + TYPE_ARRAY > MAX_TYPE_BYTE_SIZE) {
            reader.read();
          }
          else break;
        } while (true);

        if (type === TYPE_NUMBER) {
          parentArray.push(decodeNumber(reader));
        }
        else if (type === TYPE_DATE) {
          parentArray.push(new Date(decodeNumber(reader)));
        }
        else if (type === TYPE_STRING) {
          parentArray.push(decodeString(reader));
        }
        else if (type === 0) // empty array case
        {
          parentArray = arrayStack.pop();
        }
      }
      return rootArray[0];
    };

    // Utils
    var p16 = 0x10000;
    var p32 = 0x100000000;
    var p48 = 0x1000000000000;
    var p52 = 0x10000000000000;
    var pNeg1074 = 5e-324;                      // 2^-1074);
    var pNeg1022 = 2.2250738585072014e-308;     // 2^-1022

    function ieee754(number) {
      var s = 0, e = 0, m = 0;
      if (number !== 0) {
        if (isFinite(number)) {
          if (number < 0) {
            s = 1;
            number = -number;
          }
          var p = 0;
          if (number >= pNeg1022) {
            var n = number;
            while (n < 1) {
              p--;
              n *= 2;
            }
            while (n >= 2) {
              p++;
              n /= 2;
            }
            e = p + 1023;
          }
          m = e ? Math.floor((number / Math.pow(2, p) - 1) * p52) : Math.floor(number / pNeg1074);
        }
        else {
          e = 0x7FF;
          if (isNaN(number)) {
            m = 2251799813685248; // QNan
          }
          else {
            if (number === -Infinity) s = 1;
          }
        }
      }
      return { sign : s, exponent : e, mantissa : m };
    }

    function encodeNumber(writer, number) {
      var number = ieee754(number);
      if (number.sign) {
        number.mantissa = p52 - 1 - number.mantissa;
        number.exponent = 0x7FF - number.exponent;
      }
      var word, m = number.mantissa;

      writer.write((number.sign ? 0 : 0x80) | (number.exponent >> 4));
      writer.write((number.exponent & 0xF) << 4 | (0 | m / p48));

      m %= p48;
      word = 0 | m / p32;
      writer.write(word >> 8, word & 0xFF);

      m %= p32;
      word = 0 | m / p16;
      writer.write(word >> 8, word & 0xFF);

      word = m % p16;
      writer.write(word >> 8, word & 0xFF);
    }

    function decodeNumber(reader) {
      var b = reader.read() | 0;
      var sign = b >> 7 ? false : true;

      var s = sign ? -1 : 1;

      var e = (b & 0x7F) << 4;
      b = reader.read() | 0;
      e += b >> 4;
      if (sign) e = 0x7FF - e;

      var tmp = [sign ? (0xF - (b & 0xF)) : b & 0xF];
      var i = 6;
      while (i--) tmp.push(sign ? (0xFF - (reader.read() | 0)) : reader.read() | 0);

      var m = 0;
      i = 7;
      while (i--) m = m / 256 + tmp[i];
      m /= 16;

      if (m === 0 && e === 0) return 0;
      return (m + 1) * Math.pow(2, e - 1023) * s;
    }

    var secondLayer = 0x3FFF + 0x7F;

    function encodeString(writer, string) {
      /* 3 layers:
       Chars 0         - 7E            are encoded as 0xxxxxxx with 1 added
       Chars 7F        - (3FFF+7F)     are encoded as 10xxxxxx xxxxxxxx with 7F subtracted
       Chars (3FFF+80) - FFFF          are encoded as 11xxxxxx xxxxxxxx xx000000
       */
      for (var i = 0; i < string.length; i++) {
        var code = string.charCodeAt(i);
        if (code <= 0x7E) {
          writer.write(code + 1);
        }
        else if (code <= secondLayer) {
          code -= 0x7F;
          writer.write(0x80 | code >> 8, code & 0xFF);
        }
        else {
          writer.write(0xC0 | code >> 10, code >> 2 | 0xFF, (code | 3) << 6);
        }
      }
      writer.write(BYTE_TERMINATOR);
    }

    function decodeString(reader) {
      var buffer = [], layer = 0, unicode = 0, count = 0, $byte, tmp;
      while (true) {
        $byte = reader.read();
        if ($byte === 0 || $byte == null) break;

        if (layer === 0) {
          tmp = $byte >> 6;
          if (tmp < 2) {
            buffer.push(String.fromCharCode($byte - 1));
          }
          else // tmp equals 2 or 3
          {
            layer = tmp;
            unicode = $byte << 10;
            count++;
          }
        }
        else if (layer === 2) {
          buffer.push(String.fromCharCode(unicode + $byte + 0x7F));
          layer = unicode = count = 0;
        }
        else // layer === 3
        {
          if (count === 2) {
            unicode += $byte << 2;
            count++;
          }
          else // count === 3
          {
            buffer.push(String.fromCharCode(unicode | $byte >> 6));
            layer = unicode = count = 0;
          }
        }
      }
      return buffer.join("");
    }

    var HexStringReader = function (string) {
      this.current = null;

      var string = string;
      var lastIndex = string.length - 1;
      var index = -1;

      this.read = function () {
        return this.current = index < lastIndex ? parseInt(string[++index] + string[++index], 16) : null;
      }
    };

    var HexStringWriter = function () {
      var buffer = [], c;
      this.write = function ($byte) {
        for (var i = 0; i < arguments.length; i++) {
          c = arguments[i].toString(16);
          buffer.push(c.length === 2 ? c : c = "0" + c);
        }
      };
      this.toString = function () {
        return buffer.length ? buffer.join("") : null;
      };
      this.trim = function () {
        var length = buffer.length;
        while (buffer[--length] === "00");
        buffer.length = ++length;
        return this;
      }
    };

  }(window.indexedDB.util));
