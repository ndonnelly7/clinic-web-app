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
		$("#infotext").append("<span>INFO: Upgrade required for IndexedDB; applying...</span><br>");
		if(!db.objectStoreNames.contains("form_data")) {
			var store = db.createObjectStore("form_data", {keyPath: "p_id"});
		}
	}
	
	openRequest.onsuccess = function(e) {
		$("#infotext").append("<span>INFO: Successfully Init IndexedDB</span><br>");
		db = e.target.result;
	}
	
	openRequest.onerror = function(e) {
		$("#infotext").append("<span>Error: IndexedDB failed to open</span><br>");
	}
	
	openRequest.onblock = function(e) {
		$("#infotext").append("<span>Error: Somehow got blocked</span><br>");
	}
}

function clearObjectStore() {
	if(db) {
		var transaction = db.transaction(["form_data"],"readwrite");
		var objectStore = transaction.objectStore("form_data");
		var request = objectStore.clear();	
		$("#infotext").append("<span>INFO: Cleared DB</span><br>");
	}
}

function createID(name, dob){
	var hash = 0;
	var str = name + dob;
	if(str.length == 0){
		return hash;
	}
	for(var i = 0; i < str.length; i++){
		char = str.charCodeAt(i);
		hash = ((hash << 5) - hash) + char;
		hash = hash & hash;
	}
	return Math.abs(hash);
}

function createPatient(name, dob){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
		
		$("#infotext").append("<span>INFO: Transaction ready</span><br>");
		var store = transaction.objectStore("form_data");
		$("#infotext").append("<span>INFO: Store retrieved</span><br>");
		var p = {};
		p["name"] = name;
		p["dob"] = dob;
		var pid = createID(name, dob);
		p["p_id"] = pid;
		
		var request = store.add(p);
		request.onsuccess = function(e){
			$("#infotext").append("<span>INFO: Successfully added patient</span><br>");
			console.log("Successfully added a patient: " + e.target.result);
		}
		
		request.onerror = function(e){
			$("#infotext").append("<span>ERROR: Failed to add patient: "+e.target.result+"</span><br>");
			console.log(e.target.error.message);
		}
		
		return pid;
	}
}

function getPatient(p_id){
	var objectStore = db.transaction(["form_data"], "readonly").objectStore("form_data");
	
	var req = objectStore.get(p_id);
	request.onerror = function(event){
		console.error("Couldn't find patient with id: " + p_id);
		$("#infotext").append("<span>Error: Couldn't find patient with id: " + p_id + "</span><br>");
	}
	
	request.onsuccess = function(event) {
		//Need to return patient
	}
	
	return request.result;
}

function addParam(param, val, p_id){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
		var store = transaction.objectStore("form_data");		
		var request = store.get(p_id);
		
		request.onsuccess = function(e){
			var p = request.result;
			p["param"] = val;
			var update = store.put(p);
			update.onsuccess = function(event){
				console.log("Patient successfully updated");
			}
			
			update.onerror = function(e){
				console.log("Error updating patient " + param + ": " + e.target.error.message);
			}
		}
	}
}

function addDetail(number, p_id){
	if(db){
		var transaction = db.transaction(["form_data"],"readwrite");
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
				console.log("Error updating patient number: " + e.target.error.message);
			}
		}
	}
}

function showP(p_id){
	if(db){
		var store = db.transaction(["form_data"]).objectStore("form_data");
		var request = store.get(p_id);
		request.onsuccess = function(e){
			console.log(request.result);
			var i = 0;
			for(var n in request.result) {
				$("#infotext").append("<span>"+n+": " + request.result[n] + "</span><br>");
				i++;
			}
		}
	}
}
