<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient History</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/history.css" type="text/css"/>  
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
</head>
<body>
<h2>Patient History</h2>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')" class="current_page">Patient History</span>
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
<form id="history_form" class="pure-form pure-form-aligned" method="POST" action="patient_history.do">
	<input type="hidden" name="hiddenid" id="hiddenid" value="${hiddenid}">
	<fieldset id="med_field">
		<legend>Medical History</legend>
		<div id="med_history">
			<div id="med_adds">
				<div class="title">What is your current medical history?</div>
				<div id="med_row">
					<div class="pure-g-u">
						<div class="pure-u-1-3 select_box" style="max-width:150px">
							<select name="med_histories">
								<option value="none_selected">--Condition--</option>
								<option value="cardio">Cardiovascular</option>
								<option value="cancer">Cancer</option>
								<option value="trauma">Trauma</option>
								<option value="epilepsy">Epilepsy</option>
								<option value="pain">Pain/Painful Condition</option>
								<option value="hormonal">Hormonal Problems</option>
								<option value="breathing">Breathing Problems</option>
								<option value="gastric">Gastric Problems</option>
								<option value="diabetes">Diabetes</option>
								<option value="surgery">Recent Surgery</option>
								<option value="other_endocrine">Other Endocrine</option>
								<option value="other_resolved">Other Resolved Illnesses</option>
								<option value="other">Other Illness</option>
							</select>
						</div>
						
						<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
							<label for="med_time">How long ago were you diagnosed?</label>
							<select name="med_time">
								<option value="no_time">--Choose Time--</option>
								<option value="one_week">Week</option>
								<option value="two_week">Fortnight</option>
								<option value="one_mo">Month</option>
								<option value="three_mo">Three Months</option>
								<option value="six_mo">Six Months</option>
								<option value="one_yr">Year</option>
								<option value="two_yr">Two Years</option>
								<option value="five_yr">Five Years</option>
								<option value="ten_yr">Ten Years +</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="medical_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
					</div>
					<br>
				</div>
			</div>
			<input type="button" onclick="addNewOption(0)" class="pure-button history_button" value="Add History">
			<br>
			<div class="collat_div history_collat">
				<div id="med_collat_adds" class="hide_div">
					<div class="title">What is their current medical history?</div>
					<div id="med_collat_row">
						<div class="pure-g-u">
							<div class="pure-u-1-3 select_box" style="max-width:150px">
								<select name="med_collat_histories">
									<option value="none_selected">--Condition--</option>
									<option value="cardio">Cardiovascular</option>
									<option value="cancer">Cancer</option>
									<option value="trauma">Trauma</option>
									<option value="epilepsy">Epilepsy</option>
									<option value="pain">Pain/Painful Condition</option>
									<option value="hormonal">Hormonal Problems</option>
									<option value="breathing">Breathing Problems</option>
									<option value="gastric">Gastric Problems</option>
									<option value="diabetes">Diabetes</option>
									<option value="other_endocrine">Other Endocrine</option>
									<option value="other_resolved">Other Resolved Illnesses</option>
									<option value="other">Other Illness</option>
								</select>
							</div>
							
							<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
								<label for="med_collat_time">How long ago were they diagnosed?</label>
								<select name="med_collat_time">
									<option value="no_time">--Choose Time--</option>
									<option value="one_week">Week</option>
									<option value="two_week">Fortnight</option>
									<option value="one_mo">Month</option>
									<option value="three_mo">Three Months</option>
									<option value="six_mo">Six Months</option>
									<option value="one_yr">Year</option>
									<option value="two_yr">Two Years</option>
									<option value="five_yr">Five Years</option>
									<option value="ten_yr">Ten Years +</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="medical_collat_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
						</div>
						<br>
					</div>
				</div>
				<input type="button" onclick="addNewCollatOption(0)" class="pure-button history_button collat_button" value="Add History from Collateral">
			</div>
		</div>
	</fieldset>
	<br><br>
	<fieldset id="drug_field">
		<legend>Drug History</legend>
		<div id="drug_history">
			<div id="drug_adds">
				<div class="title">Are you currently taking any medicine?</div>
				<div id="drug_row">
					<div class="pure-g-u">
						<div class="pure-u-1-3 select_box" style="max-width:150px">
							<select name="drug_histories" onchange="DrugChoice(this)" class="drug_select">
								<option value="none_selected">--Medicine--</option>
								<option value="statin">Statins</option>
								<option value="antihypertensive">Antihypertensive Medication</option>
								<option value="gastric">Gastric Medication</option>
								<option value="antidepressants">Antidepressants</option>
								<option value="antipsychotic">Antipsychotic</option>
								<option value="sleeping">Sleeping Medication</option>
								<option value="benzo">Benzodiazepine</option>
								<option value="pain_meds">Pain Medication</option>
								<option value="cancer">Cancer Medication</option>
								<option value="vitamins">Vitamins</option>
								<option value="thyroxine">Thyroxine</option>
								<option value="hrt">HRT</option>
								<option value="parkinsons">Anti-Parkinsonian Drugs</option>
								<option value="inhalers">Inhalers</option>
								<option value="nebulisers">Nebulisers</option>
								<option value="steroids">Steroids</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="pure-u-1-3 select_box" style="max-width:150px;display:none" id="sleeping_med_div">
							<select name="sleeping_drug" id="sleeping_drug">
								<option value="none_selected">--Sleeping Medicine--</option>
								<option value="zimovane">Zimovane</option>
								<option value="stilnoct">Stilnoct</option>
								<option value="zopiclone">Zopiclone</option>
								<option value="zolpidem">Zolpidem</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="pure-u-1-3 select_box" style="max-width:150px;display:none" id="benzo_med_div">
							<select name="benzo_drug" id="benzo_drug" disabled>
								<option value="none_selected">--Benzodiazepine Medicine--</option>
								<option value="nortem">Nortem</option>
								<option value="mogadon">Mogadon</option>
								<option value="halcion">Halcion</option>
								<option value="dalmane">Dalmane</option>
								<option value="noctamid">Noctamid</option>
								<option value="valium">Valium</option>
								<option value="xanax">Xanax</option>
								<option value="temazepam">Temazepam</option>
								<option value="nitrazepam">Nitrazepam</option>
								<option value="triazolam">Triazolam</option>
								<option value="flurazepam">Flurazepam</option>
								<option value="diazepam">Diazepam</option>
								<option value="alprazolam">Alprazolam</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
							<label for="drug_time">How long have you been taking it?</label>
							<select name="drug_time" class="drug_time">
								<option value="no_time">--Choose Time--</option>
								<option value="one_week">Week</option>
								<option value="two_week">Fortnight</option>
								<option value="one_mo">Month</option>
								<option value="three_mo">Three Months</option>
								<option value="six_mo">Six Months</option>
								<option value="one_yr">Year</option>
								<option value="two_yr">Two Years</option>
								<option value="five_yr">Five Years</option>
								<option value="ten_yr">Ten Years +</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="drug_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
					</div>
					<br>
				</div>
			</div>
			<input type="button" onclick="addNewOption(1)" class="pure-button history_button" value="Add Medicine" value="Add more">
			<div class="collat_div history_collat">
				<div id="drug_collat_adds" class="hide_div">
					<div class="title">Are they currently taking any medicine?</div>
					<div id="drug_collat_row">
						<div class="pure-g-u">
							<div class="pure-u-1-3 select_box" style="max-width:150px">
								<select name="drug_collat_histories" onchange="DrugChoice(this)" class="collat_drug_select">
									<option value="none_selected">--Medicine--</option>
									<option value="statin">Statins</option>
									<option value="antihypertensive">Antihypertensive Medication</option>
									<option value="gastric">Gastric Medication</option>
									<option value="antidepressants">Antidepressants</option>
									<option value="antipsychotic">Antipsychotic</option>
									<option value="sleeping">Sleeping Medication</option>
									<option value="benzo">Benzodiazepine</option>
									<option value="pain_meds">Pain Medication</option>
									<option value="cancer">Cancer Medication</option>
									<option value="vitamins">Vitamins</option>
									<option value="thyroxine">Thyroxine</option>
									<option value="hrt">HRT</option>
									<option value="vallium">Vallium</option>
									<option value="parkinsons">Anti-Parkinsonian Drugs</option>
									<option value="inhalers">Inhalers</option>
									<option value="nebulisers">Nebulisers</option>
									<option value="steroids">Steroids</option>
									<option value="other">Other</option>
								</select>
							</div>
							<div class="pure-u-1-3 select_box" style="max-width:150px;display:none" id="sleeping_med_div">
								<select name="sleeping_collat_drug" id="collat_sleeping_drug">
									<option value="none_selected">--Sleeping Medicine--</option>
									<option value="zimovane">Zimovane</option>
									<option value="stilnoct">Stilnoct</option>
									<option value="zopiclone">Zopiclone</option>
									<option value="zolpidem">Zolpidem</option>
									<option value="other">Other</option>
								</select>
							</div>
							<div class="pure-u-1-3 select_box" style="max-width:150px;display:none" id="benzo_med_div">
								<select name="benzo_collat_drug" id="collat_benzo_drug" disabled>
									<option value="none_selected">--Benzodiazepine Medicine--</option>
									<option value="nortem">Nortem</option>
									<option value="mogadon">Mogadon</option>
									<option value="halcion">Halcion</option>
									<option value="dalmane">Dalmane</option>
									<option value="noctamid">Noctamid</option>
									<option value="valium">Valium</option>
									<option value="xanax">Xanax</option>
									<option value="temazepam">Temazepam</option>
									<option value="nitrazepam">Nitrazepam</option>
									<option value="triazolam">Triazolam</option>
									<option value="flurazepam">Flurazepam</option>
									<option value="diazepam">Diazepam</option>
									<option value="alprazolam">Alprazolam</option>
									<option value="other">Other</option>
								</select>
							</div>
							<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
								<label for="drug_collat_time">How long have they been taking it?</label>
								<select name="drug_collat_time" class="collat_drug_time">
									<option value="no_time">--Choose Time--</option>
									<option value="one_week">Week</option>
									<option value="two_week">Fortnight</option>
									<option value="one_mo">Month</option>
									<option value="three_mo">Three Months</option>
									<option value="six_mo">Six Months</option>
									<option value="one_yr">Year</option>
									<option value="two_yr">Two Years</option>
									<option value="five_yr">Five Years</option>
									<option value="ten_yr">Ten Years +</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="drug_collat_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
						</div>
						<br>
					</div>
				</div>
				<input type="button" onclick="addNewCollatOption(1)" class="pure-button history_button collat_button" value="Add History from Collateral">
			</div>
		</div>
	</fieldset>
	<br><br>
	<fieldset id="psych_field">
		<legend>Psychiatric History</legend>
		<div id="psych_history">
			<div id="psych_adds">
				<div class="title">Do you have a history of any psychiatric illnesses?</div>
				<div id="psych_row">
					<div class="pure-g-u">
						<div class="pure-u-1-3 select_box"  style="max-width:150px">
							<select name="psych_histories" class="psych_select">
								<option value="none_selected">--Condition--</option>
								<option value="depression">Depression</option>
								<option value="anxiety">Anxiety</option>
								<option value="mood">Mood Related</option>
								<option value="stress">Stress Related</option>
								<option value="sleep">Sleeping Problems</option>
								<option value="perception">Perceptual Problems</option>
								<option value="other">Other...</option>
							</select>
						</div>
						<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
							<label for="psych_time">How long ago where you diagnosed?</label>
							<select name="psych_time" class="psych_time">
								<option value="no_time">--Choose Time--</option>
								<option value="one_week">Week</option>
								<option value="two_week">Fortnight</option>
								<option value="one_mo">Month</option>
								<option value="three_mo">Three Months</option>
								<option value="six_mo">Six Months</option>
								<option value="one_yr">Year</option>
								<option value="two_yr">Two Years</option>
								<option value="five_yr">Five Years</option>
								<option value="ten_yr">Ten Years +</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="psych_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
					</div>
					<br>
				</div>
			</div>
			<input type="button" onclick="addNewOption(2)" class="pure-button history_button" value="Add History" value="Add more">
			<div class="collat_div history_collat">
				<div id="psych_collat_adds" class="hide_div">
					<div class="title">Do they have a history of any psychiatric illnesses?</div>
					<div id="psych_collat_row">
						<div class="pure-g-u">
							<div class="pure-u-1-3 select_box"  style="max-width:150px">
								<select name="psych_collat_histories" class="collat_psych_select">
									<option value="none_selected">--Condition--</option>
									<option value="depression">Depression</option>
									<option value="anxiety">Anxiety</option>
									<option value="mood">Mood Related</option>
									<option value="stress">Stress Related</option>
									<option value="sleep">Sleeping Problems</option>
									<option value="perception">Perceptual Problems</option>
									<option value="other">Other...</option>
								</select>
							</div>
							<div class="pure-u-1-3 pure-control-group" style="margin-top:10px;">
								<label for="psych_collat_time">How long ago where they diagnosed?</label>
								<select name="psych_collat_time" class="collat_psych_time">
									<option value="no_time">--Choose Time--</option>
									<option value="one_week">Week</option>
									<option value="two_week">Fortnight</option>
									<option value="one_mo">Month</option>
									<option value="three_mo">Three Months</option>
									<option value="six_mo">Six Months</option>
									<option value="one_yr">Year</option>
									<option value="two_yr">Two Years</option>
									<option value="five_yr">Five Years</option>
									<option value="ten_yr">Ten Years +</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_colum"><textarea form="history_form" name="psych_collat_notes" rows="2" cols="24" placeholder="Notes"></textarea></div>
						</div>
						<br>
					</div>
				</div>
				<input type="button" onclick="addNewCollatOption(2)" class="pure-button history_button collat_button" value="Add History from Collateral">
			</div>
		</div>
	</fieldset>
	<br><br>
	<fieldset id="counsel_field">
		<legend>Counselling/Therapy</legend>
		<div id="ther_history">
			<div id="ther_adds">
				<div id="current_ther">
					<!-- <label for="current_therapy_check" class="title">Are you currently going through any counselling or therapy?</label>
					<input type="checkbox" name="current_therapy_check" /> -->
					<label for="current_therapy_check" class="title">Are you currently going through any counselling or therapy?</label>
					<select name="current_therapy_check" id="current_therapy_check">
						<option value="unknown">Unknown</option>
						<option value="no">No</option>
						<option value="yes">Yes</option>
					</select>
				</div>
				<br>
				<div id="past_ther">
					<!-- <label for="past_therapy_check" class="title">Have you ever been to any counselling or therapy?</label>
					<input type="checkbox" name="past_therapy_check" /> -->
					<label for="past_therapy_check" class="title">Have you ever been to any counselling or therapy?</label>
					<select name="past_therapy_check" id="past_therapy_check">
						<option value="unknown">Unknown</option>
						<option value="no">No</option>
						<option value="yes">Yes</option>
					</select>
				</div>
				<div class="collat_div history_collat">
					<input type="button" onclick="showCollatPsych()" class="pure-button history_button collat_button" value="Difference from Collateral">
					<div class="hide_div" id="collat_psych">
						<div id="current_ther">
							<!-- <label for="collat_current_therapy_check" class="title">Are they currently going through any counselling or therapy?</label>
							<input type="checkbox" name="collat_current_therapy_check"/> -->
							<label for="current_therapy_check_collat" class="title">Are they currently going through any counselling or therapy?</label>
							<select name="current_therapy_check_collat" id="current_therapy_check_collat">
								<option value="unknown">Unknown</option>
								<option value="no">No</option>
								<option value="yes">Yes</option>
							</select>
						</div>
						<br>
						<div id="past_ther">
							<!-- <label for="collat_past_therapy_check" class="title">Have they ever been to any counselling or therapy?</label>
							<input type="checkbox" name="collat_past_therapy_check"/> -->
							<label for="past_therapy_check_collat" class="title">Have they ever been to any counselling or therapy?</label>
							<select name="past_therapy_check_collat" id="past_therapy_check_collat">
								<option value="unknown">Unknown</option>
								<option value="no">No</option>
								<option value="yes">Yes</option>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div><textarea form="history_form" name="therapy_notes" rows="3" cols="36"></textarea></div>
			</div>
		</div>
	</fieldset>
	<br><br>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
</form>
<br><br>
<div class="footer">
	<span onclick="submitPage('medical')">Submit and Continue</span>
</div>
<div id="dialog-confirm" title="Submit Page?" style="display:none">
  <p><span class="ui-icon" style="float:left; margin:0 7px 20px 0;"></span>Do you want to submit this page? (If you leave, the page will need to be filled in again)</p>
</div>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script type="text/javascript">
	var patient;
	$(document).ready(function() {
		var source = "${source}";
		if(source == "file_dispatch"){
			console.log("FROM DISPATCH");
		} else if(source == "page_link") {
			if(<%= request.getAttribute("patient") != null %>){
				patient = <%= request.getAttribute("patient").toString() %>
				console.log(patient);
			}
		}
		if("${id}" != "")
			$("#hiddenID").val("${id}");
		else if(typeof(Storage) !== "undefined"){
			$("#hiddenID").val(sessionStorage.p_id);
		} else {
			$("#hiddenID").val("0");
		}
		if(typeof(Storage) !== "undefined")
			if(!(sessionStorage.collat))
				hideCollat();
	});

	var showingCollatPsych = false;
	function addNewOption(field) {
		switch(field){
		case 0:
			$('#med_row').clone().appendTo($('#med_adds')).hide().show(500);
			break;
		case 1:
			$('#drug_row').clone().appendTo($('#drug_adds')).hide().show(500);
			break;
		case 2:
			$('#psych_row').clone().appendTo($('#psych_adds')).hide().show(500);
			break;
		default:
			break;
		}
	}
	
	function addNewCollatOption(field) {
		switch(field){
		case 0:
			if($('#med_collat_adds').is(":visible")) {
				$('#med_collat_row').clone().appendTo($('#med_collat_adds')).hide().show(500);
			} else { 
				$('#med_collat_adds').show(500);
			}
			break;
		case 1:
			if($('#drug_collat_adds').is(":visible")) {
				$('#drug_collat_row').clone().appendTo($('#drug_collat_adds')).hide().show(500);
			} else { 
				$('#drug_collat_adds').show(500);
			}
			break;
		case 2:
			if($('#psych_collat_adds').is(":visible")) {
				$('#psych_collat_row').clone().appendTo($('#psych_collat_adds')).hide().show(500);
			} else { 
				$('#psych_collat_adds').show(500);
			}
			break;
		default:
			break;
		}		
	}
	
	function showCollatPsych() {
		if(!showingCollatPsych){
			$('#collat_psych').slideDown(500);
			showingCollatPsych = true;
		} else {
			$('#collat_psych').slideUp(500);
			showingCollatPsych = false;
		}
	}
	
	function DrugChoice(select) {
		if(select.value=="sleeping"){			
			var child = $(select.parentNode.parentNode).children("#sleeping_med_div");
			child.show();
			child.children('select').prop('disabled', false);
			var child1 = $(select.parentNode.parentNode).children("#benzo_med_div");
			child1.hide();
			child1.children('select').prop("disabled",true);
		} else if(select.value=="benzo"){
			var child = $(select.parentNode.parentNode).children("#benzo_med_div");
			child.show();
			child.children('select').prop('disabled', false);
			var child2 = $(select.parentNode.parentNode).children("#sleeping_med_div");
			child2.hide();
			child2.children('select').prop("disabled",true);
		} else {
			var child1 = $(select.parentNode.parentNode).children("#benzo_med_div");
			child1.hide();
			child1.children('select').prop("disabled",true);
			var child2 = $(select.parentNode.parentNode).children("#sleeping_med_div");
			child2.hide();
			child2.children('select').prop("disabled",true);
		}
	}
	
	function printPForm(pf){
		console.log(pf);
	}
	
	function nextPage(page) {
		
		var p_id;
		var collat;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		getPatientForm(p_id, printPForm);
		
		var history = {};
		var drugsArr = new Array();
		var psychArr = new Array();
		
		for(var ind = 0; ind < $(".drug_select").size(); ind++){
			var drug = {};
			drug['drug'] = $(".drug_select:eq("+ind+")").val();
			drug['time'] = $(".drug_time:eq("+ind+")").val();
			if(drug['drug']=='sleeping'){
				drug['sleep_med'] = $("#sleeping_drug").val();
			} else if(drug['drug'] == 'benzo'){
				drug['benzo_med'] = $("#benzo_drug").val();
			}
			
			drugsArr[ind] = drug;
		}
		
		for(var ind = 0; ind < $(".psych_select").size(); ind++){
			var psych = {};
			psych['psych'] = $(".psych_select:eq("+ind+")").val();
			psych['time'] = $(".psych_time:eq("+ind+")").val();
			
			psychArr[ind] = psych;
		}
		
		history['drugs'] = drugsArr;
		history['psych'] = psychArr;
		
		if(collat){
			var drugsC = new Array();
			var psychC = new Array();
			for(var ind = 0; ind < $(".collat_drug_select").size(); ind++){
				var drug = {};
				drug['drug'] = $(".collat_drug_select:eq("+ind+")").val();
				drug['time'] = $(".collat_drug_time:eq("+ind+")").val();
				if(drug['drug']=='sleeping'){
					drug['sleep_med'] = $("#collat_sleeping_drug").val();
				} else if(drug['drug'] == 'benzo'){
					drug['benzo_med'] = $("#collat_benzo_drug").val();
				}
				
				drugsC[ind] = drug;
			}
			
			for(var ind = 0; ind < $(".collat_psych_select").size(); ind++){
				var psych = {};
				psych['psych'] = $(".collat_psych_select:eq("+ind+")").val();
				psych['time'] = $(".collat_psych_time:eq("+ind+")").val();
				
				psychC[ind] = drug;
			}
			
			history['DrugsCollat'] = drugsC;
			history['PsychCollat'] = psychC;
		}
		
		addHistory(p_id, history);
		
		setTimeout(function() {
			$("#history_form").submit();
		}, 100);
	}
	
	function submitPage()
	{
		var p_id;
		var collat;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		getPatientForm(p_id, printPForm);
		
		var history = {};
		var drugsArr = new Array();
		var psychArr = new Array();
		
		for(var ind = 0; ind < $(".drug_select").size(); ind++){
			var drug = {};
			drug['drug'] = $(".drug_select:eq("+ind+")").val();
			drug['time'] = $(".drug_time:eq("+ind+")").val();
			if(drug['drug']=='sleeping'){
				drug['sleep_med'] = $("#sleeping_drug").val();
			} else if(drug['drug'] == 'benzo'){
				drug['benzo_med'] = $("#benzo_drug").val();
			}
			
			drugsArr[ind] = drug;
		}
		
		for(var ind = 0; ind < $(".psych_select").size(); ind++){
			var psych = {};
			psych['psych'] = $(".psych_select:eq("+ind+")").val();
			psych['time'] = $(".psych_time:eq("+ind+")").val();
			
			psychArr[ind] = psych;
		}
		
		history['drugs'] = drugsArr;
		history['psych'] = psychArr;
		
		if(collat){
			var drugsC = new Array();
			var psychC = new Array();
			for(var ind = 0; ind < $(".collat_drug_select").size(); ind++){
				var drug = {};
				drug['drug'] = $(".collat_drug_select:eq("+ind+")").val();
				drug['time'] = $(".collat_drug_time:eq("+ind+")").val();
				if(drug['drug']=='sleeping'){
					drug['sleep_med'] = $("#collat_sleeping_drug").val();
				} else if(drug['drug'] == 'benzo'){
					drug['benzo_med'] = $("#collat_benzo_drug").val();
				}
				
				drugsC[ind] = drug;
			}
			
			for(var ind = 0; ind < $(".collat_psych_select").size(); ind++){
				var psych = {};
				psych['psych'] = $(".collat_psych_select:eq("+ind+")").val();
				psych['time'] = $(".collat_psych_time:eq("+ind+")").val();
				
				psychC[ind] = drug;
			}
			
			history['DrugsCollat'] = drugsC;
			history['PsychCollat'] = psychC;
		}
		
		addHistory(p_id, history);
		
		setTimeout(function() {
			$("#history_form").submit();
		}, 100);
	}
</script>
</body>
</html>