/**
 * 
 */

$(document).ready(function() {
	var $window = $(window);
	setTimeout(loadPatients, 1000);
});

function clearGrid(){
	$("#patient_grid").html("");
}

function addPatient(p){
	var elem = $("#patient_entry").clone();
	elem.find("form div input#name").val(p.name);
	elem.find("form div input#dob").val(p.dob);
	elem.find("form input#id").val(p.p_id);
	elem.show();
	elem.appendTo("#patient_grid");
}

function loadPatients(){
	getPatientKeys(function(keys){
		for(var k in keys){
			addPatient(keys[k]);
		}
	});
}

function searchPatient(){
	var name = $("#search_name").val();
	getPatientsByName(function(keys){
		for(var k in keys){
			getPatient(keys[k], function(p){
				addPatient(p);
			});
		}
	});
}