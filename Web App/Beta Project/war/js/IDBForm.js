/**
 * 
 */

function initPatientForm(p_id) {
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		
		var store = tran.objectStore("form_data");
		
		var pForm = {};
		pForm['p_id'] = p_id;
		var request = store.add(pForm);
		request.onsucess = function(e){
			console.log("Added Patient Form instance");
		}
		
		request.onerror = function(e){
			console.log(e.target.error.message);
		}
	}
}

function getPatientForm(p_id, callback){
	if(db){
		var objectStore = db.transaction(["form_data"], "readonly").objectStore("form_data");
		
		var req = objectStore.get(p_id);
		req.onerror = function(e){
			console.log("Couldn't find patient with id: " + p_id);
			console.log(e.target.error)
		}
		
		req.onsuccess = function(e){
			//Return patient with callback
			callback(req.result)
		}
	}
}

function addPersonal(gp_county, county, collatPresent, relation, p_id) {
	if(db) {
		var tran = db.transaction(["form_data"],"readwrite");
		var store = tran.objectStore("form_data");
		var request = store.get(p_id);
		
		request.onsuccess = function(e){
			console.log("Request successful");
			var pForm = request.result;
			pForm['gp_county'] = gp_county;
			pForm['county'] = county;
			pForm['collatPresent'] = collatPresent;
			pForm['relation'] = relation;
			
			var update = store.put(pForm);
			
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
		
		request.onerror = function(e){
			console.error("Request failed");
			console.log(e.target.error);
		}
	}
}

function addHistory(p_id, history) {
	
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['history'] = history;
			var update = store.put(pForm);
			
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
	}
}

function addGPInfo(p_id, gp_info){
	
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['gp_info'] = gp_info;
			
			var update = store.put(pForm);
			
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
	}
}
//Concerns should be an array corresponding to concerns form - should be in JSONArray
function addConcerns(p_id, concerns, concerns_collat) {
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['concerns'] = concerns;
			
			pForm['concerns_collat'] = concerns_collat;
			
			var update = store.put(pForm);
			
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
	}
}

//neuro should be an array corresponding to neuro form
function addNeuro(p_id, neuro, neuro_collat) {
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['neuro'] = neuro;
			
			pForm['neuro_collat'] = neuro_collat;
			
			var update = store.put(pForm);
			
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
	}
}

function addEventsActivities(p_id, EventsActivities) {
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['events_activities'] = EventsActivities;
			var update = store.put(pForm);
			update.onsuccess = function(e){
				console.log("Patient Updated Successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wasn't updated correctly: " + e.target.error.message);
			}
		}
	}
}

function addLiving(p_id, living, living_collat) {
	if(db) {
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['living'] = living;
			pForm['living_collat'] = living_collat;
			var update = store.put(pForm);
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wsan't updated correctly: " + e.target.error.message);
			}
		}
	}
}

function addLifestyle(p_id, lifestyle, lifestyle_collat) {
	if(db) {
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['lifestyle'] = lifestyle;
			pForm['lifestyle_collat'] = lifestyle_collat;
			var update = store.put(pForm);
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wsan't updated correctly: " + e.target.error.message);
			}
		}
	}
}

function addBattery(p_id, battery) {
	if(db) {
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['battery'] = battery;
			var update = store.put(pForm);
			update.onsuccess = function(e){
				console.log("Patient updated successfully");
			}
			
			update.onerror = function(e) {
				console.error("Something went wrong, patient wsan't updated correctly: " + e.target.error.message);
			}
		}
	}
}
