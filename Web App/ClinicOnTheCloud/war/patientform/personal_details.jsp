<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Patient Details</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<h2>Personal Details</h2>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')" class="current_page">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')">Patient Concerns</span>
  <span onclick="linkClick('neuro')">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')">Test Battery</span>
  <span onclick="linkClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="personal_form" class="pure-form pure-form-aligned" method="POST" action="personal_details.do">
	<div class="pure-control-group">
		<label for="assessment">Date of Assessment</label>
		<input name="assessment" placeholder="dd/mm/yyyy" type="text" class="suggest_form pickdate" id="assessment">
	</div>
	
	<fieldset id="personal_field">
		<legend>Personal</legend>
		<div class="pure-control-group">
		<label for="name">Name </label>
		<input name="name" type="text" id="name">
		</div>
		<div class="pure-control-group">
		<label for="dob">Date of Birth </label>
		<input name="dob" placeholder="dd/mm/yyyy" type="text" class="suggest_form pickdate" id="pickdate">
		</div>
		<div class="pure-control-group">
		<label for="age">Age </label>
		<input name="age" type="number" size="1" id="age">
		</div>
		<div class="pure-control-group">		
		<label for="gender_m">Male</label>
		<input type="radio" name="gender" id="gender_m" value="male">
		</div>
		<div class="pure-control-group">
		<label for="gender_f">Female</label>
		<input type="radio" name="gender" id="gender_f" value="female">
		</div>
	</fieldset>
	<br>
	<fieldset id="contact_field">
		<legend>Contact Details</legend>
		<div class="pure-control-group">
		<label for="address">Address </label>
		<textarea name="address" rows="4" form="personal_form" id="address"></textarea>
		</div>
		<div id="counties_select" class="pure-control-group">
			<label for="county">County </label>
			<select name="county" id="county">
				<option value="antrim">Antrim</option>
				<option value="armagh">Armagh</option>
				<option value="carlow">Carlow</option>
				<option value="cavan">Cavan</option>
				<option value="clare">Clare</option>
				<option value="cork">Cork</option>
				<option value="derry">Derry</option>
				<option value="donegal">Donegal</option>
				<option value="down">Down</option>
				<option value="dublin">Dublin</option>
				<option value="fermanagh">Fermanagh</option>
				<option value="galway">Galway</option>
				<option value="kerry">Kerry</option>
				<option value="kildare">Kildare</option>
				<option value="kilkenny">Kilkenny</option>
				<option value="laois">Laois</option>
				<option value="leitrim">Leitrim</option>
				<option value="limerick">Limerick</option>
				<option value="longford">Longford</option>
				<option value="louth">Louth</option>
				<option value="mayo">Mayo</option>
				<option value="meath">Meath</option>
				<option value="monaghan">Monaghan</option>
				<option value="offaly">Offaly</option>
				<option value="roscommon">Roscommon</option>
				<option value="sligo">Sligo</option>
				<option value="tipperary">Tipperary</option>
				<option value="tyrone">Tyrone</option>
				<option value="waterford">Wateford</option>
				<option value="westmeath">Westmeath</option>
				<option value="wexford">Wexford</option>
				<option value="wicklow">Wicklow</option>
			</select>
		</div>
		<div class="pure-control-group">
		<label for="home_tel">Home Telephone Number </label>
		<input name="home_tel" type="text" id="home_number">
		</div>
		<div class="pure-control-group">
		<label for="mob_number">Mobile Phone Number </label>
		<input name="mob_number" type="text" id="mob_number">
		</div>
		<div class="pure-control-group">
		<label for="email">Email </label>
		<input name="email" type="email" id="email">
		</div>
	</fieldset>
	<br><br>
	<fieldset id="edu_field">
		<legend>Education and Employment</legend>
		<div class="pure-control-group">
		<label for="age_left">Age Left Education</label>
		<input type="number" name="age_left" size="1" id="age_left">
		</div>
		<div class="pure-control-group">
		<label>Have you completed:</label>
		</div>
		<div class="pure-control-group">
		<label for="junior_check">Junior Certificate</label>
		<input type="checkbox" name="junior_check" id="junior_check">
		</div>
		<div id="junior_done" class="pure-control-group">
		<label for="senior_check">Leaving Certificate</label>
		<input type="checkbox" name="senior_check" id="senior_check"><br>
		</div>
		<div id="leaving_done" class="pure-control-group">
		<label for="third_check">Third Level (or Equivalent)</label>
		<input type="checkbox" name="third_check" id="third_check" onclick="showHiddenDiv(this,'third_done')"><br>
		</div>
		<div id="third_done" class="hide_div pure-control-group">
		<label for="study_topic">Area of Study</label>
		<input type="text" name="study_topic" id="study_topic"><br>
		</div>	
		<br>	
		<div class="pure-control-group">
		<label for="occupation">Occupation</label>
		<input name="occupation" type="text" id="occupation">
		</div>
	</fieldset>
	<br><br>
	<fieldset id="gp_field">
		<legend>GP Details</legend>
		<div class="pure-control-group">
		<label for="gp_name">GP Name</label>
		<input type="text" name="gp_name" id="gp_name">
		</div>
		<div class="pure-control-group">
		<label for="gp_address">GP Address</label>
		<textarea name="gp_address" rows="4" form="personal_form" id="gp_address"></textarea>
		</div>
		<div id="counties_select" class="pure-control-group">
			<label for="gp_county">County </label>
			<select name="gp_county" id="gp_county">
				<option value="antrim">Antrim</option>
				<option value="armagh">Armagh</option>
				<option value="carlow">Carlow</option>
				<option value="cavan">Cavan</option>
				<option value="clare">Clare</option>
				<option value="cork">Cork</option>
				<option value="derry">Derry</option>
				<option value="donegal">Donegal</option>
				<option value="down">Down</option>
				<option value="dublin">Dublin</option>
				<option value="fermanagh">Fermanagh</option>
				<option value="galway">Galway</option>
				<option value="kerry">Kerry</option>
				<option value="kildare">Kildare</option>
				<option value="kilkenny">Kilkenny</option>
				<option value="laois">Laois</option>
				<option value="leitrim">Leitrim</option>
				<option value="limerick">Limerick</option>
				<option value="longford">Longford</option>
				<option value="louth">Louth</option>
				<option value="mayo">Mayo</option>
				<option value="meath">Meath</option>
				<option value="monaghan">Monaghan</option>
				<option value="offaly">Offaly</option>
				<option value="roscommon">Roscommon</option>
				<option value="sligo">Sligo</option>
				<option value="tipperary">Tipperary</option>
				<option value="tyrone">Tyrone</option>
				<option value="waterford">Wateford</option>
				<option value="westmeath">Westmeath</option>
				<option value="wexford">Wexford</option>
				<option value="wicklow">Wicklow</option>
			</select>
		</div>
	</fieldset>
	<br><br>
	<fieldset id="family_pres_field">
		<legend>Other questions</legend>
		<div class="pure-control-group">
			<label for="testing_reason">Why are you taking this test?</label>
			<select id="testing_reason" name="testing_reason">
				<option value="reassurance">Reassurance</option>
				<option value="assessment">Assessment</option>
				<option value="information">Information</option>
			</select> 
		</div>
		<div class="pure-control-group">
			<label for="family_present_check">Are any family or friends present?</label>
			<input type="checkbox" name="family_present" id="collat_check" onclick="collatChecked(this, 'family_pres_div')">
		</div>
		<div class="pure-control-group hide_div" id="family_pres_div">
			<label for="who_present">Relation</label>
			<select name="who_present" id="collat_present">
				<option value="partner">Partner</option>
				<option value="child">Child</option>
				<option value="sibling">Sibling</option>
				<option value="friend">Friend</option>
			</select>
		</div>
	</fieldset>
	<br><br>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
	<input type="hidden" id="linkedPage" name="linkedPage" value="history"/>
</form>
<div class="footer">
	<span onclick="submitPage()">Submit and Continue</span>
</div>

<div id="dialog-confirm" title="Submit Page?" style="display:none">
  <p><span class="ui-icon" style="float:left; margin:0 7px 20px 0;"></span>Do you want to submit this page? (If you leave, the page will need to be filled in again)</p>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script>

$(document).ready(function() {
	$('#collat_check').prop("checked", checkCollateral());
	$('#family_pres_div').show();
	
	
});

$(function() {
    $( ".pickdate" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:" + (new Date()).getFullYear(),
      dateFormat: "dd/MM/yy"
    });
    $("#assessment").datepicker('setDate', new Date());
    
 });
  
function collatChecked(elem, divID){
	showHiddenDiv(elem, divID);
	
	storeCollateral(elem);
};

function storeCollateral(elem) {
	if(typeof(sessionStorage) != 'undefined') {
		sessionStorage.collatPresent = ($(elem).prop("checked"));
	} else {
		console.log("No session storage :(")
	}
}

function printPForm(pf){
	console.log(pf);
}

function nextPage(page) {
// 	if(confirm("Do you want to submit this page? (If you leave, the page will need to be filled in again)")){
// 		$("#linkedPage").val(page);
// 		submitPage();
// 	} else {
// 		spanClick(page);
// 	}
	
	$( "#dialog-confirm" ).dialog({
        resizable: false,
        width:360,
        modal: true,
        buttons: {
          "Submit": function() {
        	  $("#linkedPage").val(page);
      		  submitPage();
              $( this ).dialog( "close" );
          },
          "Do not Submit": function() {
        	  spanClick(page);
              $( this ).dialog( "close" );
          },
          Cancel: function() {
        	  $( this ).dialog( "close" );
          }
        }
     });
}

function submitPage() {
	var name = $("#name").val();
	var address = $("#address").val();
	var home_number = $("#home_number").val();
	var mob_number = $("#mob_number").val();
	var email = $("#email").val();
	var gp_name = $("#gp_name").val();
	var gp_address = $("#gp_address").val();
	var dob = $("#pickdate").val();
	
	var p_id = createPatientAndAddToDB(name, address, home_number, mob_number, email, gp_name, gp_address, dob);
	console.log("Patient ID created: " + p_id);
		
	initPatientForm(p_id);
	getPatientForm(p_id, printPForm);
	
	var gp_county = $("#gp_county").val();
	var county = $("#county").val();
	var collat = $("#collat_check").is(":checked") ? true : false;
	var relation = collat ? $("#collat_present").val() : 'na';
	
	if(typeof(Storage) !== "undefined"){
		sessionStorage.p_id = p_id;
		sessionStorage.collat = collat;
		sessionStorage.gender = $("input[name=gender]:checked").val();
	}
	
	addPersonal(gp_county, county, collat, relation, p_id);	
	$("#hiddenID").val(p_id);
	
	setTimeout(function() {
		$("#personal_form").submit();
	}, 100);
	
}
</script>
</body>
</html>