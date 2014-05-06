<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Analysis</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>
<link rel="stylesheet" href="/css/analysis.css" type="text/css"/>  
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<h2>Analysis</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Test Battery</span>
  <span onclick="spanClick('analysis')" class="current_page">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="analysis_form" class="pure-form pure-form-aligned" method="POST" action="analysis.do">
	<input type="hidden" value="${hiddenid}">
	<fieldset id="mem_results_field">
		<legend>Test Results</legend>
		
		<div id="test_results">
			<div class="pure-control-group" id="mmse_div">
				<label for="mmse_result">MMSE:</label>
				<input type="text" name="mmse_result" id="mmse_result" disabled>
			</div>
			<div class="pure-control-group" id="moca_div">
				<label for="cdt_result">MOCA:</label>
				<input type="text" name="moca_result" id="moca_result" disabled>
			</div>
			<div class="pure-control-group" id="gds_div">
				<label for="gds_result">GDS:</label>
				<input type="text" name="gds_result" id="gds_result" disabled>
			</div>
			<div class="pure-control-group" id="hads_div">
				<label for="hads_result">HADS:</label>
				<input type="text" name="hads_result" id="hads_result" disabled>
			</div>
		</div>
	
	</fieldset>
	<br><br>
	<fieldset id="form_results">
		<legend>Analysis</legend>
		
		<div class="pure-control-group" id="outcome_div">
			<div id="impression_grid">
				<div id="header_row" class="pure-g-r">
					<div class="pure-u-1-3 outcome_col">Impression</div>
					<div class="pure-u-1-3">Notes</div>
				</div>
				<div id="impression_entry" class="pure-g-r" style="margin-bottom:0.5em">
					<div class="pure-u-1-3 outcome_col">
						<select name="impression">
							<option value="norm_neg">Normal Negative Screen</option>
							<option value="ab_neg">Abnormal Negative Screen</option>
							<option value="dementia">Possible for Dementia</option>
							<option value="stress">Possible for Stress</option>
							<option value="mood">Possible Mood Problem</option>
							<option value="acopia">Acopia</option>
							<option value="bereavement">Bereavemnet</option>
							<option value="reactive">Reactive Stress</option>
							<option value="social">Social Adjustment</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_colum"><textarea form="analysis_form" name="impression_notes" rows="2" cols="32"></textarea></div>
				</div>
			</div>
			<input type="button" onclick="addNewImpression()" class="pure-button" value="Add Impression">
		</div>
		
		<div class="pure-control-group" id="outcome_div">
			<div id="outcome_grid">
				<div id="header_row" class="pure-g-r">
					<div class="pure-u-1-3 outcome_col">Outcome</div>
					<div class="pure-u-1-3">Notes</div>
				</div>
				<div class="pure-g-r" id="outcome_entry" style="margin-bottom:0.5em">
					<div class="pure-u-1-3 outcome_col">
						<select name="outcome_select">
							<option value="counselling">Counselling</option>
							<option value="leaflets">Leaflets</option>
							<option value="gp_letter">Letter to GP</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_colum"><textarea form="analysis_form" name="outcome_entry_notes" rows="2" cols="32"></textarea></div>
				</div>
			</div>
			<input type="button" onclick="addNewOutcome()" class="pure-button" value="Add Outcome">
		</div>		
		
		<div class="follow_up_div">
			<label for="follow_up" class="follow_label">Follow Up</label>
			<select name="follow_up">
				<option value="one_month">One Month</option>
				<option value="four_month">Four Months</option>
				<option value="six_month">Six Months</option>
				<option value="twelve_month">Twelve Months</option>
				<option value="gp_letter">Gp Letter</option>
			</select>
		</div>
		<div class="follow_up_div">
			<label for="follow_notes" class="follow_label">Notes:</label>
			<textarea form="analysis_form" name="follow_notes" rows="5" cols="40"></textarea>
		</div>
		
		<script type="text/javascript">
			function addNewOutcome(){
				$('#outcome_entry').clone().appendTo($('#outcome_grid'));
			}
			
			function addNewImpression(){
				$('#impression_entry').clone().appendTo($('#impression_grid'));
			}
		</script>
	</fieldset>
	
	<fieldset id="letter_field">
		<legend>Letter</legend>
		<textarea form="analysis_form" name="letter" id="letter" rows="24" cols="100">Will have letter template</textarea>
	</fieldset>
	
	<fieldset id="notes_field">
		<legend>Extra Notes</legend>
		<textarea form="analysis_form" name="notes" id="extra" rows="12" cols="60"></textarea>
	</fieldset>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
</form>
<div class="footer">
	<span onclick="submitPage()">Finish Form</span>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/analysis.js"></script>
<script>
$(document).ready(function() {
	if("${id}" != "")
		$("#hiddenID").val("${id}");
	else if(typeof(Storage) !== "undefined"){
		$("#hiddenID").val(sessionStorage.p_id);
		if(sessionStorage.collat)
			hideCollat();
	} else {
		$("#hiddenID").val("0");
	}
});
</script>
</body>
</html>