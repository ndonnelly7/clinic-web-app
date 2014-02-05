var db;
var patient;

var color = new Array("#87ceeb", "#eedd82");
var colorIndex =0;

function Patient(name,address,ppsn,number,key){
	this.name = name;
	this.address = address;
	this.ppsn = ppsn;
	this.number = number;
	this.key = key;
}

function IDBInit() {
	if(!window.indexedDB) {
		$("#infotext").append("<span>ERROR: IndexedDB not in window</span><br>");
		return;
	}
	
	$("#infotext").append("<span>INFO: IndexedDB in window</span><br>");
	openRequest = indexedDB.open("patientdb", 1);
	
	openRequest.onupgradeneeded = function(e){
		db = e.target.result;
		$("#infotext").append("<span>INFO: Upgrade required for IndexedDB; applying...</span><br>");
		
		if(!db.objectStoreNames.contains("patients")) {
			var store = db.createObjectStore("patients", {keyPath: "ppsn"});
			store.createIndex("name", "name", {unique:false});
			store.createIndex("key", "key", {unique:true});
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
}

function addPatientToDB(p){
	$("#infotext").append("<span>INFO: Adding Patient: " + p.name + "</span><br>");
	if(db){
		$("#infotext").append("<span>INFO: Creating transaction</span><br>");
		var transaction = db.transaction(["patients"], "readwrite");
		
		transaction.oncomplete = function(e){
			$("#infotext").append("<span>INFO: Transaction completed</span><br>");
		}
		
		transaction.onerror = function(e){
			$("#infotext").append("<span>ERROR: Transaction error: " + e.target.result + "</span><br>");
		}
		
		transaction.onblock = function(e) {
			$("#infotext").append("<span>Blocking</span><br>")
		}
		
		var store = transaction.objectStore("patients");
		var request = store.add(p);
		request.onsuccess = function(e){
			$("#infotext").append("<span>INFO: Add successful: " + e.target.result + "</span><br>");
		}
	}
}

function getPatient(ppsn){
	$("#infotext").append("<span>INFO: Searching Patient with key: " + ppsn + "</span><br>");
	if(db) {
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(ppsn);
		
		request.onerror = function(e) {
			$("#infotext").append("<span>ERROR: Couldn't return patient</span><br>");
		}
		
		request.onsuccess = function(e) {
			$("#infotext").append("<span>INFO: Returned patient</span><br>");
			patient = e.target.result;
		}
	}	
}

function showPatient(p){
	var toAppend = "<div class='patient_info' id='patient_"+p.key+"' style='background-color:"+color[colorIndex]+"'>";
	toAppend += "<span>Name: " + p.name + " </span><br>";
	toAppend += "<span>Address: " + p.address + " </span><br>";
	toAppend += "<span>PPSN: " + p.ppsn + " </span><br>";
	toAppend += "<span>Number: " + p.number + " </span><br>";
	toAppend += ("<input type='button' value='More Info' onclick='getMoreInfoOn(this)' id='button_"+p.ppsn+"'><br>");
	toAppend += ("</div>");
	
	$("#patient_info").append(toAppend);
	
	colorIndex =  colorIndex == 0 ? 1 : 0; 
}

function showAllPatients(){
	var store = db.transaction(['patients']).objectStore("patients");
	store.openCursor().onsuccess = function(e) {
		var cursor = e.target.result;
		if(cursor){
			showPatient(cursor.value);
			cursor.continue();
		} else {
			$("#infotext").append("<span>INFO: No more patients</span><br>");
		}
	}
}

function getPatientWithKey(findKey){
	var objectStore = db.transaction("patients").objectStore("patients");
	
	objectStore.openCursor().onsuccess = function(event) {
		var cursor = event.target.result;
		
		if(cursor){
			if(cursor.value.key == findKey){
				patient = cursor.value;
				return;
			} else {
				cursor.continue();
			}
		} else {
			$("#infotext").append("<span>INFO: No patient with that key</span><br>");
		}
	}
}

function updatePatientWithKey(ppsn, newKey){
	var objectStore = db.transaction(["patients"], "readwrite").objectStore("patients");
	var request = objectStore.get(ppsn);
	
	request.onerror = function(event){
		$("#infotext").append("<span>ERROR: Couldn't find patient with ppsn: " +ppsn+"</span><br>");
	}
	
	request.onsucess = function(event){
		var data = request.result;
		data.key = newKey;
		
		var requestUpdate = objectStore.put(data);
		requestUpdate.onerror = function(event){
			$("#infotext").append("<span>ERROR: Couldn't update patient with key: " +key+"</span><br>");
			$("#infotext").append("<span>ERROR: " + event.target.result +"</span><br>");
		}
		
		requestUpdate.onsuccess = function(event){
			$("#infotext").append("<span>INFO: Update successful: " + event.target.result + "</span><br>");
		}
	}
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