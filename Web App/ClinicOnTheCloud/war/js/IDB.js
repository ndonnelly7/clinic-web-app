/**
 * 
 */

var db;

function Patient(name, address, dob, home_number, mob_number, email, gp_name, gp_address, p_id){
	this.name = name;
	this.address = address;
	this.dob = dob;
	this.home_number = home_number;
	this.mob_number = mob_number;
	this.email = email;
	this.gp_name = gp_name;
	this.gp_address = gp_address;
	this.p_id = p_id;
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
	return (Math.abs(hash)).toString();
}

function IDBInit() {
	if(!window.indexedDB) {
		console.log("IndexedDB not available");
		return;
	}
	
	openRequest = indexedDB.open("clinic_cloud",3);
	
	openRequest.onupgradeneeded = function(e){
		db = e.target.result;
		console.log("Update needed for IndexedDB");
		if(!db.objectStoreNames.contains("patients")) {
			var store = db.createObjectStore("patients", {keyPath: "p_id"});
			store.createIndex("name", "name", {unique:false});
			console.log("Created Object Store: Patients");
		}
		
		if(!db.objectStoreNames.contains("form_data")) {
			var store = db.createObjectStore("form_data", {keyPath: "p_id"});
			console.log("Created Object Store: Form Data");
		}
		
		console.log("Initing IndexedDB");
	}
	
	openRequest.onsuccess = function(e) {
		db = e.target.result;
		console.log("Request successful");
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
		var transaction = db.transaction(["patients"],"readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.clear();
		
		var tran2 = db.transaction(["form_data"],"readwrite");
		var store = tran2.objectStore("form_data");
		var req = store.clear();
	}
}

function addPatientToDB(p){
	if(db){
		var transaction = db.transaction(["patients"],"readwrite");
		
		transaction.onerror = function(e){
			console.log("Error with transaction: ");
			console.log(e.target.error);
			updatePatient(p.p_id, p);
		}
		
		var store = transaction.objectStore("patients");
		var request = store.add(p);
		request.onsuccess = function(e){
			console.log("Successfully added a patient: " + e.target.result);
		}		
	}
}

function createPatientAndAddToDB(name, address, home_number, mob_number, email, gp_name, gp_address, dob){
	var p_id = createID(name, dob);
	var p = new Patient(name, address, dob, home_number, mob_number, email, gp_name, gp_address, p_id);
	addPatientToDB(p);
	return p_id;
}

function updatePatient(p_id, p){
	var objectStore = db.transaction(["patients"], "readwrite").objectStore("patients");
	var request = objectStore.get(p_id);
	
	request.onerror = function(event){
		console.error("Error in retrieving patient with id for Update: " + p_id);
	}
	
	request.onsuccess = function(event){
		var updateReq = objectStore.put(p);
		
		updateReq.onerror = function(e){
			console.log("Error updating patient with name: " + p.name);
		}
	}
}

function getPatient(p_id, callback){
	var objectStore = db.transaction(["patients"], "readonly").objectStore("patients");
	
	var req = objectStore.get(p_id);
	req.onerror = function(event){
		console.error("Couldn't find patient with id: " + p_id);
		callback("ERROR:Couldn't find patient with id: " + p_id);
	}
	
	req.onsuccess = function(event) {
		callback(req.result)
	}
	
}

function showPatient(p){
	console.log(p);
}

function getPatientsByName(name, callback){
	if(db){
		var store = db.transaction(["patients"], "readonly").objectStore("patients");
		var keys = new Array();
		var i = 0;
		var index  = store.index("name");
		index.openCursor().onsuccess = function(event) {
			var cursor = event.target.result;
			if(cursor){
				if(cursor.key == name){
					keys[i] = cursor.value;
					i++;
				}
				cursor.continue();
			} else {
				callback(keys);
			}
		}
	}
}

function getAllPatients(callback){
	if(db){
		var store = db.transaction(["patients"], "readonly").objectStore("patients");
		var patients = new Array();
		var i = 0;
		store.openCursor().onsuccess = function(event) {
			var cursor = event.target.result;
			if(cursor){
				patients.push(cursor.value);
				cursor.continue();
			}
			else {
				callback(patients);
			}
		}
	}
}

function getArrayAsJSONString(arr) {
	var arrString = "";
	for(var i = 0; i < arr.length; i++){
		arrString+= arr[i] + ":";
	}
	return JSON.stringify(arrString);
}

function getPatientKeys(callback){
	if(db){
		var store = db.transaction(["patients"], "readonly").objectStore("patients");
		var keys = new Array();
		var i = 0;
		store.openCursor().onsuccess = function(event) {
			var cursor = event.target.result;
			if(cursor){
				keys[i] = cursor.value;
				i++;
				cursor.continue();
			} else {
				callback(keys);
			}
		}
	}
}

function removePatient(p_id){
	var objectStore = db.transaction(["patients"], "readwrite").objectStore("patients");
	var request = objectStore.delete(p_id);
	
	request.onsucess = function(event){
		console.log("INFO: Remove for: "+p_id+" successful: " + event.target.result);
	}
	
	request.onerror = function(event){
		console.log("INFO: Remove for: "+p_id+" went wrong: " + event.target.result);
	}
}

