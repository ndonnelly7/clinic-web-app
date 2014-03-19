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
	<input type="hidden" name="hiddenid" id="hiddenid" value="${hiddenid}">
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
			<div class="pure-u-1-4 subtitle">Total Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="chol_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">LDL Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="ldl_cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="chol_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">HDL Cholesterol</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="hdl_cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="chol_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Systolic Blood Pressure</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4">
				<div style="font-size:small">mmHg</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="chol_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Diastolic Blood Pressure</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="cholest_test" size="4">
				<div style="font-size:small">mmHg</div>
			</div>
			<div id="cholest_qs"style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="chol_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Thyroid</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="thyroid_test" size="4">
				<div style="font-size:small">pg/mL</div>
			</div>
			<div id="thyroid_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box" style="">
					<select name="thyroid_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">B12</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="b12_test" size="4">
				<div style="font-size:small">mmol/L</div>
			</div>
			<div id="b12_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="b12_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Iron</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="iron_test" size="4">
				<div style="font-size:small">mcmol/L</div>
			</div>
			<div id="iron_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="iron_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Calcium</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="calc_test" size="4">
				<div style="font-size:small">mg/dL</div>
			</div>
			<div id="calc_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="calc_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Sodium</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="sodium_test" size="4">
				<div style="font-size:small">mEq/L</div>
			</div>
			<div id="sodium_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="sodium_time">
						<option value="three_mon">1 month</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_plus">2+ years</option>
					</select>
				</div>
			</div>
			<br>
			<div class="pure-u-1-4 subtitle">Weight</div>
			<div class="pure-u-1-4 select_box select_margin_change">
				<input type="text" name="sodium_test" size="4">
				<div style="font-size:small">kg</div>
			</div>
			<div id="weight_qs" style="display:inline;">
				<div class="pure-u-1-4 subtitle">When was the test done?</div>
				<div class="pure-u-1-4 select_box">
					<select name="sodium_time">
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
	<input type="submit" value="Submit"/>
</form>
<br><br>
<div class="footer">
	<span onclick="spanClick('history')">Previous Page</span>
	<span onclick="spanClick('concerns')">Next Page</span>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>