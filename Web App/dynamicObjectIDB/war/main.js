/**
 * 
 */
var pid = 0;

$(document).ready(function() {
	IDBInit();
	$("#name").val("Person");
	$("#pickdate").val("16/April/2014");
	$("#number").val("0185712");
	$("#param").val("a");
	$("#value").val("1");
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
	var dob = $("#pickdate").val();
	
	$("#infotext").append("<span>INFO: Adding patient with name: " + name + " and DOB: " + dob + " </span><br>");
	pid = createPatient(name, dob);
	$("#infotext").append("<span>INFO: Created ID: " + pid + "</span><br>");
};

function AddPatientNumber() {
	var num = $("#number").val();
	
	$("#infotext").append("<span>INFO: Adding patient with pid: " + pid + " and number: " + num + " </span><br>");
	addDetail(num, pid);
};

function AddPatientParam() {
	var param = $("#param").val();
	var val = $("#value").val();
	
	$("#infotext").append("<span>INFO: Adding patient with pid: " + pid + " and parameter: " + param + " </span><br>");
	addParam(param, val, pid);
}

function showPat(){
	showP(pid);
}