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
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')" class="current_page">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Test Battery</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="personal_form" class="pure-form pure-form-aligned" method="POST" action="personal_details.do">
	<fieldset id="personal_field">
		<legend>Personal</legend>
		<div class="pure-control-group">
		<label for="name">Name </label>
		<input name="name" type="text" id="name">
		</div>
		<div class="pure-control-group">
		<label for="dob">Date of Birth </label>
		<input name="dob" placeholder="dd/mm/yyyy" type="text" class="suggest_form" id="pickdate">
		</div>
		<div class="pure-control-group">
		<label for="age">Age </label>
		<input name="age" type="text" size="1" id="age">
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
		<div class="pure-control-group want_counties">
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
		<input type="text" name="age_left" size="1">
		</div>
		<div class="pure-control-group">
		<label>Have you completed:</label>
		</div>
		<div class="pure-control-group">
		<label for="junior_check">Junior Certificate</label>
		<input type="checkbox" name="junior_check">
		</div>
		<div id="junior_done" class="pure-control-group">
		<label for="leaving_check">Leaving Certificate</label>
		<input type="checkbox" name="leaving_check"><br>
		</div>
		<div id="leaving_done" class="pure-control-group">
		<label for="third_check">Third Level</label>
		<input type="checkbox" name="third_check" onclick="showHiddenDiv(this,'third_done')"><br>
		</div>
		<div id="third_done" class="hide_div pure-control-group">
		<label for="study_topic">Area of Study</label>
		<input type="text" name="study_topic"><br>
		</div>	
		<br>	
		<div class="pure-control-group">
		<label for="occupation">Occupation</label>
		<input name="occupation" type="text">
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
		<div class="pure-control-group want_counties">
		</div>
	</fieldset>
	<br><br>
	<fieldset id="family_pres_field">
		<legend>Others present</legend>
		<div class="pure-control-group">
			<label for="family_present_check">Are any family or friends present?</label>
			<input type="checkbox" name="family_present_check" id="collat_check" value="ff_present" onclick="collatChecked(this, 'family_pres_div')">
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
	<input type="submit" value="Submit"/>
</form>
<div class="footer">
	<span onclick="spanClick('history')">Next Page</span>
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
    $( "#pickdate" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:" + (new Date()).getFullYear(),
      dateFormat: "dd/MM/yy"
    });
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

function nextPage(page) {
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
	
	if(typeOf(Storage) !== "undefined")){
			sessionStorage.pID = p_id;
	}
		
	initPatientForm(p_id);
	getPatientForm(p_id, printPForm);
	
	var gp_county = $("#county")[1].val();
	var county = $("#county")[0].val();
	var collat = $("#collat_check").val() == 'on' ? true : false;
	var relation = collat ? $("#collat_present").val() : 'na';
	
	addPersonal(gp_county, county, collat, relation, p_id);
	
	spanClick(page);
}
</script>
</body>
</html>