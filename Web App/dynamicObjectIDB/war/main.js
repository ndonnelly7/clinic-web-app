/**
 * 
 */

$(document).ready(function() {
	IDBInit();
});

$(function() {
    $( "#pickdate" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:" + (new Date()).getFullYear(),
      dateFormat: "dd/MM/yy"
    });
  });

function AddPatient() {
	var name = $("#name").val();
	var dob = $("#dob").val();
	
	$("#infotext").append("<span>INFO: Adding patient with name: " + name + " and DOB: " + dob + " </span><br>");
	var pid = createPatient(name, dob);
	$("#infotext").append("<span>INFO: Created ID: " + pid + "</span><br>");
};

function AddPatientNumber() {
	
};

function AddPatientParam() {
	
}