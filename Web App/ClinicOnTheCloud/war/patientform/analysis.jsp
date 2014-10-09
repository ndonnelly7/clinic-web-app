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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<h2>Analysis</h2>
<form id="test_form" action="form.do" method="GET">
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')">Patient Concerns</span>
  <span onclick="linkClick('neuro')">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')">Test Battery</span>
  <span onclick="linkClick('analysis')" class="current_page">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="analysis_form" class="pure-form pure-form-aligned" method="POST" action="analysis.do">
	<input type="hidden" value="${hiddenid}">
	<fieldset id="mem_results_field">
	<!-- All the test results from the Test BAttery on the previous page -->
		<legend>Test Results</legend>
		
		<div id="test_results">
			<div class="pure-control-group" id="mmse_div">
				<label for="mmse_result">MMSE:</label>
				<input type="number" name="mmse_result" id="mmse_result">
			</div>
			<div class="pure-control-group" id="moca_div">
				<label for="moca_result">MOCA:</label>
				<input type="number" name="moca_result" id="moca_result">
			</div>
			<div class="pure-control-group" id="gds_div">
				<label for="gds_result">GDS:</label>
				<input type="number" name="gds_result" id="gds_result">
			</div>
			<div class="pure-control-group" id="hads_div">
				<label for="hads_result">HADS:</label>
				<input type="number" name="hads_result" id="hads_result">
			</div>
		</div>
	
	</fieldset>
	<br><br>
	<fieldset id="form_results">
		<legend>Analysis</legend>
		
		<!-- the impression stuff -->
		<div class="pure-control-group" id="outcome_div">
			<!-- the new impressions get added to this 'grid' -->
			<div id="impression_grid">
				<div id="header_row" class="pure-g-r">
					<div class="pure-u-1-3 outcome_col">Impression</div>
					<div class="pure-u-1-3">Notes</div>
				</div>
				<div id="impression_entry" class="pure-g-r" style="margin-bottom:0.5em">
					<div class="pure-u-1-3 outcome_col">
						<select name="impression" class="imp">
							<option value="unknown">Unknown</option>
							<option value="difficulty_functioning_in_one_or_more_areas">Evidence of difficulty with functioning in one or more areas</option>
							<option value="decline_from_previous_norms">Evidence of decline from previous norms for that person</option>
							<option value="deviation_from_normative_tests">Deviation from normative test scores</option>
							<!-- These are the old impressions for the original set of impressions
							<option value="norm_neg">Normal Negative Screen</option>
							<option value="ab_neg">Abnormal Negative Screen</option>
							<option value="dementia">Possible for Dementia</option>
							<option value="stress">Possible for Stress</option>
							<option value="mood">Possible Mood Problem</option>
							<option value="acopia">Acopia</option>
							<option value="bereavement">Bereavemnet</option>
							<option value="reactive">Reactive Stress</option>
							<option value="social">Social Adjustment</option>
							-->
						</select>
					</div>
					<div class="pure-u-1-3 notes_colum"><textarea form="analysis_form" name="impression_notes" rows="2" cols="32"></textarea></div>
				</div>
			</div>
			<input type="button" onclick="addNewImpression()" class="pure-button" value="Add Impression">
		</div>
		
		<!-- Outcomes for the patient -->
		<div class="pure-control-group" id="outcome_div">
			<div id="outcome_grid">
				<div id="header_row" class="pure-g-r">
					<div class="pure-u-1-3 outcome_col">Outcome</div>
					<div class="pure-u-1-3">Notes</div>
				</div>
				<div class="pure-g-r" id="outcome_entry" style="margin-bottom:0.5em">
					<div class="pure-u-1-3 outcome_col">
						<select name="outcome" onchange="updateOutcome(this)" id="outcome">
							<option value="unknown">Unknown</option>
							<option value="counselling">Counselling</option>
							<option value="leaflets">Leaflets</option>
							<option value="gp_letter">Letter to GP</option>
							<option value="has_diagnosis">Has Diagnosis</option>
							<option value="coping_strategies">Coping Strategies</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_colum"><textarea form="analysis_form" name="outcome_notes" rows="2" cols="32"></textarea></div>
				</div>
			</div>
			<input type="button" onclick="addNewOutcome()" class="pure-button" value="Add Outcome">
		</div>		
		
		<div class="follow_up_div">
			<label for="follow_up" class="follow_label">Follow Up</label>
			<select name="follow_up" onchange="updateOutcome(this)">
				<option value="unknown">Unknown</option>
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
		<textarea form="analysis_form" name="letter" id="letter" rows="24" cols="100"></textarea>
	</fieldset>
	
	<fieldset id="notes_field">
		<legend>Extra Notes</legend>
		<textarea form="analysis_form" name="notes" id="extra" rows="12" cols="60"></textarea>
	</fieldset>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
</form>
<div class="footer">
	<span onclick="submitPage()">Submit and Finish Form</span>
</div>

<div id="dialog-confirm" title="Submit Page?" style="display:none">
  <p><span class="ui-icon" style="float:left; margin:0 7px 20px 0;"></span>Do you want to submit this page? (If you leave, the page will need to be filled in again)</p>
</div>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/analysis.js"></script>
<script>
//Sets the hiddenID on the page that is needed for submission to the servlet
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