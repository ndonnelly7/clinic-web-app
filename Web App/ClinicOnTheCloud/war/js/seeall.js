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
	if(p.name == ""){
		return;
	}
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
	clearGrid();
	var name = $("#search_name").val();
	getPatientsByName(name, function(patients){
		if(patients.length < 1){
			$("#patient_grid").html("<div id='search_info_seeall'>Patient with name: <i>" + name + "</i> does not exist on local database</div>");
		}
		for(var p in patients){
			addPatient(patients[p]);
		}
	});
}