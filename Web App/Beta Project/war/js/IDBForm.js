/**
 * 
 */

function initPatientForm(p_id) {
	PatientForm['p_id'] = p_id;
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		
		var store = transaction.objectStore("form_data");
		
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
	var objectStore = db.transaction(["form_data"], "readonly").objectStore("form_data");
	
	var req = objectStore.get(p_id);
	request.onerror = function(e){
		console.error("Couldn't find patient with id: " + p_id);
	}
	
	request.onsuccess = function(e){
		//Return patient with callback
		callback(req.result)
	}
}

function addPersonal(gp_county, county, relation, p_id) {
	if(db) {
		var tran = db.transaction(["form_data"],"readwrite");
		var store = tran.objectStore("form_data");
		var request = store.get(p_id);
		
		request.onsuccess = function(e){
			var pForm = request.result;
			pForm['gp_county'] = gp_county;
			pForm['county'] = county;
			pForm['relation'] = relation;
			
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

function addHistory(p_id, 
		drugs, psych, 
		therapy, past_therapy,
		collat_drugs,
		collat_psych, collat_therapy,
		collat_past_therapy){
	
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['drugs'] = drugs;
			pForm['psychiatric'] = psych;
			pForm['therapy'] = therapy;
			pForm['past_therapy'] = past_therapy;
			pForm['collat_drugs'] = collat_drugs;
			pForm['collat_psychiatric'] = collat_psych;
			pForm['collat_therapy'] = collat_therapy;
			pForm['collat_past_therapy'] = collat_past_therapy;
			
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

function addGPInfo(p_id, total_cholest, LDL, HDL, 
		Systolic, Diastolic, Thyroid, B12, Iron, Calc, Sod, Weight){
	
	if(db){
		var tran = db.transaction(["form_data"], "readwrite");
		var store = tran.objectStore("form_data");
		var req = store.get(p_id);
		
		req.onsuccess = function(e) {
			var pForm = req.result;
			pForm['total_cholesterol'] = total_cholest;
			pForm['ldl'] = LDL;
			pForm['hdl'] = HDL;
			pForm['systolic'] = Systolic;
			pForm['diastolic'] = Diastolic;
			pForm['thyroid'] = Thyroid;
			pForm['b12'] = B12;
			pForm['iron'] = Iron;
			pForm['calcium'] = Calc;
			pForm['sodium'] = Sod;
			pForm['weight'] = Weight;
			
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
function addConcerns(p_id, neuro, neuro_collat) {
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





