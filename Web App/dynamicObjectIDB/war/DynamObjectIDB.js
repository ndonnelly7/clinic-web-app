/**
 * 
 */

var db;

function IDBInit() {
	if(!window.indexedDB) {
		console.log("IndexedDB not available");
		return;
	}
	
	openRequest = indexedDB.open("clinicDB",1);
	
	openRequest.onupgradeneeded = function(e){
		db = e.target.result;
		
		if(!db.objectStoreNames.contains("form_data")) {
			var store = db.createObjectStore("form_data", {keyPath: "p_id"});
		}
	}
	
	openRequest.onsuccess = function(e) {
		db = e.target.result;
	}
	
	openRequest.onerror = function(e) {
		console.error("Error setting up IndexedDB");
	}
	
	openRequest.onblock = function(e) {
		console.error("Blocked somehow");
	}
}

function clearObjectStore() {
	if(db) {
		var transaction = db.transaction(["form_data"],"readwrite");
		var objectStore = transaction.objectStore("form_data");
		var request = objectStore.clear();		
	}
}

function createID(name, dob){
	var hash = 0;
	var str = name + dob;
	if(str == ""){
		return hash;
	}
	for(var i = 0; i < str.length; i++){
		var char = str.charAt(i);
		hash = ((hash << 5) - hash) + char;
		hash |= 0;
	}
	return hash;
}

function createPatient(name, dob){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
		
		transaction.onerror = function(e){
			console.error("Error adding patient to database: " + e.target);
		}
		
		var store = transaction.objectStore("form_data");
		
		var p = {};
		p["name"] = name;
		p["dob"] = dob;
		var pid = createID(name, dob);
		p["p_id"] = pid;
		
		var request = store.add(p);
		request.onsuccess = function(e){
			console.log("Successfully added a patient: " + e.target.result);
		}
		
		return pid;
	}
}

function getPatient(p_id){
	var objectStore = db.transaction(["form_data"], "readonly").objectStore("form_data");
	
	var req = objectStore.get(p_id);
	request.onerror = function(event){
		console.error("Couldn't find patient with id: " + p_id);
	}
	
	request.onsuccess = function(event) {
		//Need to return patient
	}
	
	return request.result;
}

function addParam(param, val, p_id){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
		
		transaction.onerror = function(e){
			console.error("Error adding detail to database: " + e.target.result);
		}
		
		var store = transaction.objectStore("form_data");
		
		var request = store.get(p_id);
		
		request.onsuccess = function(e){
			var p = request.result;
			p[param] = val;
			var update = store.put(p);
			update.onsuccess = function(event){
				console.log("Patient successfully updated");
			}
			
			update.onerror = function(e){
				console.log("Error updating patient " + param + ": " + e.target.errorCode);
			}
		}
	}
}

function addDetail(number, p_id){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
		
		transaction.onerror = function(e){
			console.error("Error adding detail to database: " + e.target.result);
		}
		
		var store = transaction.objectStore("form_data");
		
		var request = store.get(p_id);
		
		request.onsuccess = function(e){
			var p = request.result;
			p["number"] = number;
			var update = store.put(p);
			update.onsuccess = function(event){
				console.log("Patient successfully updated");
			}
			
			update.onerror = function(e){
				console.log("Error updating patient number: " + e.target.errorCode);
			}
		}
	}
}
