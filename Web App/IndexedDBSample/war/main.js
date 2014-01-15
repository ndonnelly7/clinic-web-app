/**
 * Sample to test the use of IndexedDB and the Shim
 * Should store sensitive Customer Data
 */

var db; //The IndexedDB database for customers stored locally
var customer;

function Customer (name, address, number, email, dob, key) {
	this.name = name;
	this.address = address;
	this.number = number;
	this.email = email;
	this.dob = dob;
	this.key = key;
};

//Initialises IndexedDB
document.addEventListener("DOMContentLoaded", function() {
	if(!window.indexedDB) {
		$("#infotext").append("<span>ERROR: IndexedDB not in window</span><br>");
		return;
	}
	
	$("#infotext").append("<span>INFO: IndexedDB in window</span><br>");
	openRequest = indexedDB.open("customerdb", 1);
	
	openRequest.onupgradeneeded = function(e){
		db = e.target.result;
		$("#infotext").append("<span>INFO: Upgrade required for IndexedDB; applying...</span><br>");
		
		if(!db.objectStoreNames.contains("customers")) {
			var store = db.createObjectStore("customers", {keyPath: "key"});
			store.createIndex("name", "name", {unique:false});
		}
	}
	
	openRequest.onsuccess = function(e) {
		$("#infotext").append("<span>INFO: Successful IndexedDB open</span><br>");
		db = e.target.result;
	}
	
	openRequest.onerror = function(e) {
		$("#infotext").append("<span>ERROR: Error setting up IndexedDB</span><br>");
	}
	
	openRequest.onblock = function(e) {
		$("#infotext").append("<span>ERROR: Blocked somehow</span><br>");
	}
});

function addCustomer(c){
	$("#infotext").append("<span>INFO: Adding Customer: " + c.name + "</span><br>");
	if(db){
		$("#infotext").append("<span>INFO: Creating transaction</span><br>");
		var transaction = db.transaction(["customers"], "readwrite");
		
		transaction.oncomplete = function(e){
			$("#infotext").append("<span>INFO: Transaction completed</span><br>");
		}
		
		transaction.onerror = function(e){
			$("#infotext").append("<span>ERROR: Transaction error: " + e.target.result + "</span><br>");
		}
		
		transaction.onblock = function(e) {
			$("#infotext").append("<span>Blocking</span><br>")
		}
		
		var store = transaction.objectStore("customers");
		var request = store.add(c);
		request.onsuccess = function(e){
			$("#infotext").append("<span>INFO: Add successful: " + e.target.result + "</span><br>");
		}
	}
}

function showAllCustomers() {
	var store = db.transaction(['customers']).objectStore("customers");
	store.openCursor().onsuccess = function(e) {
		var cursor = e.target.result;
		if(cursor){
			showCustomer(cursor.value);
			cursor.continue();
		}
	}
}

function getCustomer(key){
	$("#infotext").append("<span>INFO: Searching Customer with key: " + key + "</span><br>");
	if(db) {
		var transaction = db.transaction(["customers"], "readwrite");
		var objectStore = transaction.objectStore("customers");
		var request = objectStore.get(key);
		
		request.onerror = function(e) {
			$("#infotext").append("<span>ERROR: Couldn't return customer</span><br>");
		}
		
		request.onsuccess = function(e) {
			$("#infotext").append("<span>INFO: Returned customer</span><br>");
			customer = e.target.result;
			showCustomer(customer);
		}
	}	
}

function updateCustomer(oldID, newKey) {
	$("#infotext").append("<span>INFO: Updating Customer with key: " + oldID + "</span><br>");
	
	if(db) {
		var transaction = db.transaction(["customers"],"readwrite");
		var store = transaction.objectStore("customers");
		var req = store.get(oldID);
		
		req.onsuccess = function(event) {
			var c = event.target.result;
			c.key = newKey;
			
			var del_req = store.delete(oldID);
			
			del_req.onsuccess = function(e) {
				var new_req = store.add(c);
				
				new_req.onsuccess = function(e_suc) {
					$("#infotext").append("<span>INFO: Successful update of customer</span><br>");
				}
				
				new_req.onerror = function(e_suc) {
					$("#infotext").append("<span>ERROR: Couldn't add customer with key " + newKey + "</span><br>");
				}
			}
			
			del_req.onerror = function(e) {
				$("#infotext").append("<span>ERROR: Couldn't delete customer with key " + oldID + "</span><br>");
			}
		}
		
		req.onerror = function(event) {
			$("#infotext").append("<span>ERROR: Couldn't find customer with key " + oldID + "</span><br>");
		}
	} else {
		$("#infotext").append("<span>ERROR: Couldn't find database</span><br>");
	}
}

function showCustomer(c){
	var toAppend = "<div class='customer_info' id='customer_" + c.key + "'>";
	toAppend += "<span>CUSTOMER: Name - " + c.name + " </span><br>";
	
	toAppend += ("<span>CUSTOMER: Address - " + c.address + " </span><br>");
	toAppend += ("<span>CUSTOMER: Number - " + c.number + " </span><br>");
	toAppend += ("<span>CUSTOMER: Email - " + c.email + " </span><br>");
	toAppend += ("<span>CUSTOMER: DOB - " + c.dob + " </span><br>");
	toAppend += ("<span>CUSTOMER: Key - " + c.key + " </span><br>");
	toAppend += ("<input type='button' value='More Info' onclick='getMoreInfoOn(" + c.key +")' id='button_"+c.key+"'><br>");
	toAppend += ("</div>");
	
	$("#infotext").append(toAppend);
}

function getMoreInfoOn(akey) {
	$("#infotext").append("<span>The key: " + akey + "</span><br>");
	$("#infotext").append("<span>Key type: " + typeof akey + "</span><br>");
	$.ajax('/retrieval.do', {
		method: 'GET',
		datatype:'text',
		data: {
			key:akey
		},
		success:function(response){
			parseRetrieval(response);
		}
	});
}

function clearStore() {
	$.ajax('/indexeddbsample', {
		method: 'GET',
		datatype:'text',
		data: {
			instruction:'clear'
		},
		success:function(response){
			$("#infotext").append(response);
		}
	});
}

function parseRetrieval(json) {
	console.log(json["salesman"]);
	$("#infotext").append('#customer_' + json["key"]);
	var divStr = '#customer_' + json["key"];
	var btnStr = '#button_' + json["key"];
	$(btnStr).remove();
	var addString = "<span>CUSOTMER: Item Bought - " + json["item"] + "</span><br>";
	addString += "<span>CUSOTMER: Salesperson - " + json["salesman"] + "</span><br>";
	addString += "<span>CUSOTMER: Store Location - " + json["store_location"] + "</span><br>";
	addString += "<span>============================</span><br><br>";
	$(divStr).append(addString);
}

function getSpotlightCustomer(){
	return customer;
}