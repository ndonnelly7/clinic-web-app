<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Neuro History</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>
<link rel="stylesheet" href="/css/neuro.css" type="text/css"/>  
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
</head>
<body>
<h2>Neuro History</h2>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')" >Patient Concerns</span>
  <span onclick="linkClick('neuro')" class="current_page">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')">Test Battery</span>
  <span onclick="linkClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form> 
<form id="neuro_form" class="pure-form pure-form-stacked" method="POST" action="neural.do">
	<fieldset id="med_field">
		<legend style="margin-bottom:-0.65em">Have there been any other issues?</legend>
		
		<div id="problems_grid">
			<div id="header_row">
				<div class="pure-u-1-5 title">
					<h3>Problem</h3>
				</div>
				<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
				</div>
				<div class="pure-u-1-5 neuro_column">
				<h4>Time Since First Occurrence</h4>
				</div>
				<div class="pure-u-1-5 neuro_column">
				<h3>Frequency</h3>
				</div>
				<div class="pure-u-1-5 neuro_column">
				<h4>Has This Been Investigated</h4>
				</div>
				<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
				<h3>Notes</h3>
				</div>
			</div>
			<div id="blackout" class="issue">
				<div class="pure-u-1-5 title">Blackouts</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="blackout_check" onclick="showHiddenRow(this, '#blackout')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="blackout_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blackout_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blackout_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="blackout_notes" form="neuro_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="blanks" class="issue">
				<div class="pure-u-1-5 title">Blanks</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="blanks_check" onclick="showHiddenRow(this,'#blanks')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="blanks_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blanks_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blanks_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="blanks_notes" form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="blurred_vision" class="issue">
				<div class="pure-u-1-5 title">Blurred Vision</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="blurred_vision_check" onclick="showHiddenRow(this,'#blurred_vision')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="blurred_vision_time" class="time_frame" disabled>	
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blurred_vision_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="blurred_vision_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="blurred_vision_notes" form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="dexterity" class="issue">
				<div class="pure-u-1-5 title">Issues with Dexterity (buttons, zips, etc.)</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="dexterity_check" onclick="showHiddenRow(this,'#dexterity')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="dexterity_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="dexterity_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="dexterity_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="dexterity_notes"form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="dizziness" class="issue">
				<div class="pure-u-1-5 title">Dizziness</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="dizziness_check" onclick="showHiddenRow(this,'#dizziness')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="dizziness_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="dizziness_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="dizziness_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="dizziness_notes"form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="fainting" class="issue">
				<div class="pure-u-1-5 title">Fainting</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="fainting_check" onclick="showHiddenRow(this,'#fainting')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="fainting_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="fainting_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="fainting_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="fainting_notes"form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="headaches" class="issue">
				<div class="pure-u-1-5 title">Headaches</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="headaches_check" onclick="showHiddenRow(this,'#headaches')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="headaches_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="headaches_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="headaches_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="headaches_notes"form="neuro_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="falling" class="issue">
				<div class="pure-u-1-5 title">Loss of Balance or Falling</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="falling_check" onclick="showHiddenRow(this,'#falling')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="falling_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="falling_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="falling_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="falling_notes"form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="seizures" class="issue">
				<div class="pure-u-1-5 title">Seizures</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="seizures_check" onclick="showHiddenRow(this,'#seizures')">
				</div>
				<div class="pure-u-1-5 neuro_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="seizures_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="seizures_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 neuro_column" >
					<select name="seizures_investigated" class="investigated" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="seizures_notes"form="neuro_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
		</div>
	
		<div class="collat_div">
			<input type="button" onclick="addNewCollatOption()" class="pure-button" value="Add Neuro History from Collateral">
			<div class="hide_div" id="collat_problems_grid">
				<div id="header_row">
					<div class="pure-u-1-5 title">
						<h3>Problem</h3>
					</div>
					<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
					</div>
					<div class="pure-u-1-5 neuro_column">
					<h4>Time Since First Occurrence</h4>
					</div>
					<div class="pure-u-1-5 neuro_column">
					<h3>Frequency</h3>
					</div>
					<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
					<h3>Notes</h3>
					</div>
				</div>
				<div id="blackout_collat" class="issue">
					<div class="pure-u-1-5 title">Blackouts</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="blackout_check_collat" onclick="showHiddenRow(this, '#blackout_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="blackout_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blackout_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blackout_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="blackout_notes_collat"form="neuro_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="blanks_collat" class="issue">
					<div class="pure-u-1-5 title">Blanks</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="blanks_check_collat" onclick="showHiddenRow(this,'#blanks_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="blanks_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blanks_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blanks_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="blanks_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="blurred_vision_collat" class="issue">
					<div class="pure-u-1-5 title">Blurred blurred_vision</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="blurred_vision_check_collat" onclick="showHiddenRow(this,'#blurred_vision_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="blurred_vision_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blurred_vision_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="blurred_vision_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="blurred_vision_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="dexterity_collat" class="issue">
					<div class="pure-u-1-5 title">Issues with dexterity (buttons, zips, etc.)</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="dexterity_check_collat" onclick="showHiddenRow(this,'#dexterity_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="dexterity_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="dexterity_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="dexterity_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="dexterity_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="dizziness_collat" class="issue">
					<div class="pure-u-1-5 title">Dizziness</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="dizziness_check_collat" onclick="showHiddenRow(this,'#dizziness_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="dizziness_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="dizziness_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="dizziness_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="dizziness_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="fainting_collat" class="issue">
					<div class="pure-u-1-5 title">Fainting</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="fainting_check_collat" onclick="showHiddenRow(this,'#fainting_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="fainting_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="fainting_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="fainting_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="fainting_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="headaches_collat" class="issue">
					<div class="pure-u-1-5 title">Headaches</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="headaches_check_collat" onclick="showHiddenRow(this,'#headaches_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="headaches_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="headaches_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="headaches_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="headaches_notes_collat"form="neuro_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="falling_collat" class="issue">
					<div class="pure-u-1-5 title">Loss of Balance or Falling</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="falling_check_collat" onclick="showHiddenRow(this,'#falling_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="falling_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="falling_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="falling_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="falling_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="seizures_collat" class="issue">
					<div class="pure-u-1-5 title">Seizures</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="seizures_check_collat" onclick="showHiddenRow(this,'#seizures_collat')">
					</div>
					<div class="pure-u-1-5 neuro_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="seizures_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="seizures_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 neuro_column" >
						<select name="seizures_investigated_collat" class="investigated" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="seizures_notes_collat"form="neuro_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<br><br>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
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
	var showingCollat = false;
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
	
	function addNewCollatOption(){
		if(!showingCollat){
			$('#collat_problems_grid').slideDown(500);
			showingCollat = true;
		} else {
			$('#collat_problems_grid').slideUp(500);
			showingCollat = false;
		}
	}
	
	
	function nextPage(page) {
		var p_id = -1;
		var collat = false;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		
		var neuro = new Array();
		for(var i = 0; i < $("#problems_grid .issue").length; i++){
			var iss = {};
			iss['issue']=$("#problems_grid .issue:eq("+i+")").attr("id");
			iss['checked'] = $("#problems_grid div.pure-u-1-5.check input").get(i-1).checked;
			iss['time']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+0+") select").val();
			iss['frequency']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+1+") select").val();
			iss['investigated']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+2+") select").val();
			
			neuro[i] = iss;
		}
		
		var collatNeuro = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_problems_grid .issue").length; i++){
				var iss = {};
				iss['issue']=$("#collat_problems_grid .issue:eq("+i+")").attr("id");
				iss['checked'] = $("#collat_problems_grid div.pure-u-1-5.check input").get(i-1).checked;
				iss['time']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+0+") select").val();
				iss['frequency']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+1+") select").val();
				iss['investigated']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+2+") select").val();
				
				collatNeuro[i] = iss;
			}
		}
		
		addNeuro(p_id, neuro, collatNeuro);
		spanClick(page);
	}
	
	function submitPage() {
		var p_id = -1;
		var collat = false;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		
		var neuro = new Array();
		for(var i = 0; i < $("#problems_grid .issue").length; i++){
			var iss = {};
			iss['issue']=$("#problems_grid .issue:eq("+i+")").attr("id");
			iss['checked'] = $("#problems_grid div.pure-u-1-5.check input").get(i-1).checked;
			iss['time']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+0+") select").val();
			iss['frequency']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+1+") select").val();
			iss['investigated']=$("#problems_grid .issue:eq("+i+") .neuro_column:eq("+2+") select").val();
			
			neuro[i] = iss;
		}
		
		var collatNeuro = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_problems_grid .issue").length; i++){
				var iss = {};
				iss['issue']=$("#collat_problems_grid .issue:eq("+i+")").attr("id");
				iss['checked'] = $("#collat_problems_grid div.pure-u-1-5.check input").get(i-1).checked;
				iss['time']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+0+") select").val();
				iss['frequency']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+1+") select").val();
				iss['investigated']=$("#collat_problems_grid .issue:eq("+i+") .neuro_column:eq("+2+") select").val();
				
				collatNeuro[i] = iss;
			}
		}
		
		addNeuro(p_id, neuro, collatNeuro);
		$("#neuro_form").submit();
	}
	
	function addToReactive(){
		
	};
</script>
</body>
</html>