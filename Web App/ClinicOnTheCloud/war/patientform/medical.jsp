<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Information</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<h2>Medical Details</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')" class="current_page">GP Information</span>
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
<form id="medical_form" class="pure-form pure-form-aligned" method="POST" action="medical.do">
	<fieldset id="med_field">
		<legend>GP Information</legend>
		
		<div id="gp_info" class="pure-g-u">
			<div class="pure-u-1-2 title">Have you discussed any of this with your GP?</div>
			<div class="pure-u-1-2 check" style="margin-top:18px;">
				<input type="checkbox" name="gp_talked" onclick="showHiddenDiv(this, 'talked_with_gp')">
			</div>
			<br>
			<div id="talked_with_gp" class="hide_div">
				<div style="width:80px;float:left;height:60px;"></div>
				<div class="pure-u-1-2 subtitle">With what result?</div>
				<div class="pure-u-1-2 select_box select_margin_change">
					<select name="gp_results">
						<option value="referral_us">Referral to Us</option>
						<option value="referral_other">Referral to other</option>
						<option value="socialize">Socialize More</option>
						<option value="test">Tests</option>
						<option value="blood_test">Blood Tests</option>
						<option value="medication">Medication</option>			
					</select>
				</div> <br>
				<div class="pure-u-1-2 subtitle">What was prescribed?</div>
				<div class="pure-u-1-2 select_box select_margin_change">
					<select name="gp_meds">
						<option value="unsure">Not Sure</option>
						<option value="anxiolytic">Anxiolytic</option>
						<option value="antidepressant">Antidepressant</option>
						<option value="nmda">NMDA Receptors</option>
						<option value="blood_test">Acetylcholinesterase Inhibitor</option>
						<option value="medication">Other</option>			
					</select>
				</div>
				<br>
			</div>
			<textarea form="medical_form" name="gp_notes" rows="3" cols="40" style="margin-left:10px;"></textarea>
		</div>
		
		<br>
		<hr/>
		<br>
		
		<div id="med_tests" class="pure-g-u">
			<div class="title">Do you have the results of any of the following tests?</div>
			<br>
			
			<div>
			<div class="pure-u-1-4 subtitle">Total Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4" id="cholesterol" onchange="cholestChanged()">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="cholest_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">LDL Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_ldl" size="4" id="ldl" onchange="ldlChanged()">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="ldl_cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="ldl_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">HDL Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_hdl" size="4" id="hdl" onchange="hdlChanged()">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="hdl_cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="hdl_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Systolic Blood Pressure</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="systolic" size="4" id="systolic" onchange="systolicChanged()">
				<div style="font-size:small">mmHg</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="systolic_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Diastolic Blood Pressure</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="diastolic" size="4" id="diastolic" onchange="diastolicChanged()">
				<div style="font-size:small">mmHg</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="diastolic_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Thyroid</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="thyroid_test" size="4" id="thyroid" onchange="thyroidChanged()">
				<div style="font-size:small">pg/mL</div>
			</div>
			<div id="thyroid_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box" style="">
					<select name="thyroid_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">B12</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="b12_test" size="4" id="b12" onchange="b12Changed()">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="b12_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="b12_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Iron</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="iron_test" size="4" id="iron" onchange="ironChanged()">
				<div style="font-size:small">mcmol/L</div>
			</div>
			<div id="iron_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="iron_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Calcium</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="calc_test" size="4" id="calcium" onchange="calciumChanged()">
				<div style="font-size:small">mg/dL</div>
			</div>
			<div id="calc_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="calc_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div>
			<div class="pure-u-1-4 subtitle">Sodium</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="sodium_test" size="4" id="sodium" onchange="sodiumChanged()">
				<div style="font-size:small">mEq/L</div>
			</div>
			<div id="sodium_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="sodium_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<div class="warning_span hide_div" style="display:inline-block;color:red;margin-top:18px;">Unhealthy levels</div>
			</div>
			
			<br>
			<div class="pure-u-1-4 subtitle">Weight</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="weight_test" size="4" id="weight">
				<div style="font-size:small">kg</div>
			</div>
			<div id="weight_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="weight_time">
						<option value="unknown">Unknown</option>
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
		</div>
		<textarea form="medical_form" name="med_test_notes" rows="3" cols="40" style="margin-left:10px;"></textarea>
		<br>
		<br><hr/><br>
		
		<div id="kin_q" class="pure-g-u">
			<div class="pure-u-1-2 title">How has your family reacted to this?</div>
			<div class="pure-u-1-2 select_box">
				<select name="kin_response">
					<option value="none_selected">Reaction</option>
					<option value="not_noticed">Haven't Noticed</option>
					<option value="joke">Joking</option>
					<option value="make_light">Made Light of</option>
					<option value="concerned">Concerned</option>
				</select>
			</div>
			<br>
			<div class="pure-u-1-2 title">For how long have they been acting like this?</div>
			<div class="pure-u-1-2 select_box">
				<select name="response_time">
						<option value="unknown">Unknown</option>
					<option value="three_mon">1 month</option>
					<option value="three_mon">3 months</option>
					<option value="six_mon">6 months</option>
					<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
				</select>
			</div>
		</div>
		<textarea form="medical_form" name="kin_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
	</fieldset>
	<br><br>
	<input type="hidden" name="hiddenID" id="hiddenID" value="${id}">
</form>
<br><br>
<div class="footer">
	<span onclick="submitPage()">Next Page</span>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script type="text/javascript">
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
		if(typeof(Storage) !== "undefined")
			if(!(sessionStorage.collat))
				hideCollat();
	});

	function nextPage(page){
		
		var medical = {};
		medical['cholesterol'] = $("#cholesterol");
		medical['ldl'] = $("#ldl");
		medical['hdl'] = $("#hdl");
		medical['systolic'] = $("#systolic");
		medical['diastolic'] = $("#diastolic");
		medical['thyroid'] = $("#thyroid");
		medical['b12'] = $("#b12");
		medical['iron'] = $("#iron");
		medical['calcium'] = $("#calcium");
		medical['sodium'] = $("#sodium");
		medical['weight'] = $("#weight");
		
		var p_id;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
		}
		
		addGPInfo(p_id, medical);
		
		spanClick(page);
	}
	
	function submitPage(){
		
		var medical = {};
		medical['cholesterol'] = $("#cholesterol");
		medical['ldl'] = $("#ldl");
		medical['hdl'] = $("#hdl");
		medical['systolic'] = $("#systolic");
		medical['diastolic'] = $("#diastolic");
		medical['thyroid'] = $("#thyroid");
		medical['b12'] = $("#b12");
		medical['iron'] = $("#iron");
		medical['calcium'] = $("#calcium");
		medical['sodium'] = $("#sodium");
		medical['weight'] = $("#weight");
		
		var p_id;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
		}
		
		addGPInfo(p_id, medical);
		
		$("#medical_form").submit();
	}
	
	function cholestChanged(){
		var c = parseFloat($("#cholesterol").val());
		if(c > 5){
			addWarning($("#cholesterol"));
			sessionStorage.cholesterol = true;
		} else {
			removeWarning($("#cholesterol"));
			sessionStorage.cholesterol = false;
		}
	}
	
	function ldlChanged(){
		var l = parseFloat($('#ldl').val());
		if(l > 3){
			addWarning($('#ldl'));
			sessionStorage.ldl = true;
		} else {
			removeWarning($('#ldl'));
			sessionStorage.ldl = false;
		}
	}
	
	function hdlChanged(){
		var l = parseFloat($('#hdl').val());
		if(l < 1){
			addWarning($('#hdl'));
			sessionStorage.hdl = true;
		} else {
			removeWarning($('#hdl'));
			sessionStorage.hdl = false;
		}
	}
	
	function systolicChanged(){
		var l = parseInt($('#systolic').val());
		if(l < 140){
			addWarning($('#systolic'));
			sessionStorage.systolic = true;
		} else {
			removeWarning($('#systolic'));
			sessionStorage.systolic = false;
		}
	}
	
	function diastolicChanged(){
		var l = parseInt($('#diastolic').val());
		if(l < 90){
			addWarning($('#diastolic'));
			sessionStorage.diastolic = true;
		} else {
			removeWarning($('#diastolic'));
			sessionStorage.diastolic = false;
		}
	}
	
	function thyroidChanged(){
		var l = parseFloat($('#thyroid').val());
		if(l < 0.1 || l > 2.0){
			addWarning($('#thyroid'));
			sessionStorage.thyroid = true;
		} else {
			removeWarning($('#thyroid'));
			sessionStorage.thyroid = false;
		}
	}
	
	function b12Changed(){
		var l = parseInt($('#b12').val());
		if(l < 100 || l > 520){
			addWarning($('#b12'));
			sessionStorage.b12 = true;
		} else {
			removeWarning($('#b12'));
			sessionStorage.b12 = false;
		}
	}
	
	function ironChanged(){
		var l = parseInt($('#iron').val());
		if(l < 30 || l > 560){
			addWarning($('#iron'));
			sessionStorage.iron = true;
		} else {
			removeWarning($('#iron'));
			sessionStorage.iron = false;
		}
	}
	
	function calciumChanged(){
		var l = parseFloat($('#calcium').val());
		if(l < 2.18 || l > 2.6){
			addWarning($('#calcium'));
			sessionStorage.calcium = true;
		} else {
			removeWarning($('#calcium'));
			sessionStorage.calcium = false;
		}
	}
	
	function sodiumChanged(){
		var l = parseFloat($('#sodium').val());
		if(l < 135 || l > 145){
			addWarning($('#sodium'));
			sessionStorage.sodium = true;
		} else {
			removeWarning($('#sodium'));
			sessionStorage.sodium = false;
		}
	}
	
	function addWarning(elem){
		elem.css({'border':'2px solid #FF0000'});
		elem.parent().parent().children('.warning_span').show();
	}
	
	function removeWarning(elem){
		elem.removeAttr('style');
		elem.parent().parent().children('.warning_span').hide();
	}

</script>
</body>
</html>