<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Concerns</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/concerns.css" type="text/css"/> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/> 
</head>
<body>
<h2>Patient Concerns</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="nextPage('personal_details')">Patient Information</span>
  <span onclick="nextPage('history')">Patient History</span>
  <span onclick="nextPage('medical')">GP Information</span>
  <span onclick="nextPage('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="nextPage('neuro')">Neuro History</span>
  <span onclick="nextPage('events_activities')">Events and Activities</span>
  <span onclick="nextPage('living')">Living Situation</span>
  <span onclick="nextPage('lifestyle')">Patient Lifestyle</span>
  <span onclick="nextPage('memory_test')">Test Battery</span>
  <span onclick="nextPage('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="concerns_form" class="pure-form pure-form-stacked" method="POST" action="concerns.do">
	<fieldset id="med_field">
		<legend style="margin-bottom:-0.65em">What are the patient's concerns about their memory?</legend>
		
		<div id="concerns_grid">
			<div id="header_row">
				<div class="pure-u-1-5 title">
					<h3>Concern</h3>
				</div>
				<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
				</div>
				<div class="pure-u-1-5 select_box">
				<h4>Time Since Began</h4>
				</div>
				<div class="pure-u-1-5 select_box">
				<h3>Frequency</h3>
				</div>
				<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
				<h3>Notes</h3>
				</div>
			</div>
		
			<div id="events" class="concern">
				<div class="pure-u-1-5 title">Recent Events</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="rec_events_check" onclick="showConcernRow(this, '#events')" id="rec_events">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="rec_events_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="rec_events_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="rec_event_notes" form="concerns_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="faces" class="concern">
				<div class="pure-u-1-5 title">Faces</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="faces_check" onclick="showConcernRow(this,'#faces')" id="faces">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="faces_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="faces_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="faces_notes" form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="names" class="concern">
				<div class="pure-u-1-5 title">Names</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="names_check" onclick="showConcernRow(this,'#names')" id="names">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="names_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="names_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="names_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="losing_things" class="concern">
				<div class="pure-u-1-5 title">Losing Things</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="losing_things_check" onclick="showConcernRow(this,'#losing_things')" id="losing_things">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="losing_things_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="losing_things_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="losing_things_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="follow_conv" class="concern">
				<div class="pure-u-1-5 title">Trouble Following Conversations</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="follow_conv_check" onclick="showConcernRow(this,'#follow_conv')" id="follow_conv">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="follow_conv_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="follow_conv_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="follow_conv_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="right_words" class="concern">
				<div class="pure-u-1-5 title">Trouble Finding the Right Words</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="right_words_check" onclick="showConcernRow(this,'#right_words')" id="right_words">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="right_words_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="right_words_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="right_words_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="decisions" class="concern">
				<div class="pure-u-1-5 title">Difficulty Making Decisions</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="decisions_check" onclick="showConcernRow(this,'#decisions')" id="decisions">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="decisions_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="decisions_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="decisions_notes" form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="calculatons" class="concern">
				<div class="pure-u-1-5 title">Calculations</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="calculatons_check" onclick="showConcernRow(this,'#calculatons')" id="calculations">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="calculations_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="calculations_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="calculatons_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="prospective" class="concern">
				<div class="pure-u-1-5 title">Prospective Memory</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="prospective_check" onclick="showConcernRow(this,'#prospective')" id="prospective">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="prospective_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="prospective_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="prospective_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="anxiety" class="concern">
				<div class="pure-u-1-5 title">Anxious or Depressed about Forgetfulness</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="anxiety_check" onclick="showConcernRow(this,'#anxiety')" id="anxiety">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="anxiety_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="anxiety_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="anxiety_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="comments" class="concern">
				<div class="pure-u-1-5 title">Have others commented on your Memory</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="comments_check" onclick="showConcernRow(this,'#comments')" id="comments">
				</div>
				<div class="pure-u-1-5 select_box">
					<div id="timeframe_1m_3pyr_dis">
						<select name="comments_time" class="time_frame" disabled>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 select_box" >
					<select name="comments_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="comments_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
		</div>
	
		<div class="collat_div">
			<input type="button" onclick="addNewCollatOption()" class="pure-button" value="Add Concern from Collateral">
			<div class="hide_div" id="collat_concerns_grid">
				<div id="header_row">
					<div class="pure-u-1-5 title">
						<h3>Concern</h3>
					</div>
					<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
					</div>
					<div class="pure-u-1-5 select_box">
					<h4>Time Since Began</h4>
					</div>
					<div class="pure-u-1-5 select_box">
					<h3>Frequency</h3>
					</div>
					<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
					<h3>Notes</h3>
					</div>
				</div>
			
				<div id="events_collat" class="concern">
					<div class="pure-u-1-5 title" id="rec_events">Recent Events</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="rec_events_check_collat" onclick="showConcernRow(this, '#events_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="rec_events_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="rec_events_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="rec_event_notes_collat"form="concerns_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="faces_collat" class="concern">
					<div class="pure-u-1-5 title" id="faces">Faces</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="faces_check_collat" onclick="showConcernRow(this,'#faces_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="faces_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="faces_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="faces_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="names_collat" class="concern">
					<div class="pure-u-1-5 title" id="names">Names</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="names_check_collat" onclick="showConcernRow(this,'#names_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="names_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="names_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="names_notes_collat"form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="losing_things_collat" class="concern">
					<div class="pure-u-1-5 title" id="losing_things">Losing Things</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="losing_things_check_collat" onclick="showConcernRow(this,'#losing_things_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="losing_things_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="losing_things_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="losing_things_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="follow_conv_collat" class="concern">
					<div class="pure-u-1-5 title" id="conversations">Trouble Following Conversations</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="follow_conv_check_collat" onclick="showConcernRow(this,'#follow_conv_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="follow_conv_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="follow_conv_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="follow_conv_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="right_words_collat" class="concern">
					<div class="pure-u-1-5 title" id="right_words">Trouble Finding the Right Words</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="right_words_check_collat" onclick="showConcernRow(this,'#right_words_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="right_words_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="right_words_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="right_words_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="decisions_collat" class="concern">
					<div class="pure-u-1-5 title" id="decisions">Difficulty Making Decisions</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="decisions_check_collat" onclick="showConcernRow(this,'#decisions_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="decisions_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="decisions_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="decisions_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="calculatons_collat" class="concern">
					<div class="pure-u-1-5 title" id="calculations">Calculations</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="calculatons_check_collat" onclick="showConcernRow(this,'#calculatons_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="calculations_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="calculations_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="calculatons_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="prospective_collat" class="concern">
					<div class="pure-u-1-5 title" id="prospective">Prospective Memory</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="prospective_check_collat" onclick="showConcernRow(this,'#prospective_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="prospective_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="prospective_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="prospective_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="anxiety_collat" class="concern">
					<div class="pure-u-1-5 title" id="forgetfulness">Anxious or Depressed about Forgetfulness</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="anxiety_check_collat" onclick="showConcernRow(this,'#anxiety_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="anxiety_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="anxiety_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="anxiety_notes_collat" form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="comments_collat" class="concern">
					<div class="pure-u-1-5 title" id="comments">Have others commented on your Memory</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="comments_check_collat" onclick="showConcernRow(this,'#comments_collat')">
					</div>
					<div class="pure-u-1-5 select_box">
						<div id="timeframe_1m_3pyr_dis">
							<select name="comments_time_collat" class="time_frame" disabled>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 select_box" >
						<select name="comments_freq_collat" class="frequency" disabled>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="comments_notes_collat" form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<br><br>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
</form>
<div class="footer">
	<span onclick="submitPage()">Next Page</span>
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
	});
	
	function addNewCollatOption(){
		if(!showingCollat){
			$('#collat_concerns_grid').slideDown(500);
			showingCollat = true;
		} else {
			$('#collat_concerns_grid').slideUp(500);
			showingCollat = false;
		}
	}
	
	function printForm(){
		var p_id = -1;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
		}
		
		getPatientForm(p_id, printPForm);
	}
	
	function showConcernRow(box, rowId){
		if(box.checked){
			$(rowId + " select").prop("disabled",false);
		} else {
			$(rowId + " select").prop("disabled",true);
		}
	}
	
	function nextPage(page){
		
		var p_id = -1;
		var collat = false;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		
		var concerns = {};
		var concernArr = new Array();
		for(var i = 0; i < $("#concerns_grid .concern").length; i++){
			var c = {};
			c['concern']=$("#concerns_grid .concern:eq("+i+")").attr("id");
			c['checked']= $("#concerns_grid div.pure-u-1-5.check input").get(i).checked;
			c['time']=$("#concerns_grid .concern:eq("+i+") .select_box:eq("+0+") select").val();
			c['frequency']=$("#concerns_grid .concern:eq("+i+") .select_box:eq("+1+") select").val();
			
			concernArr[i] = c;
		}
		concerns['array'] = concernArr;
		
		var collatArr = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_concerns_grid .concern").length; i++){
				var c = {};
				c['concern']=$("#collat_concerns_grid .concern:eq("+i+")").attr("id");
				c['checked']= $("#collat_concerns_grid div.pure-u-1-5.check input").get(i-1).checked;
				c['time']=$("#collat_concerns_grid .concern:eq("+i+") .select_box:eq("+0+") select").val();
				c['frequency']=$("#collat_concerns_grid .concern:eq("+i+") .select_box:eq("+1+") select").val();
				
				collatArr[i] = c;
			}
			concerns['collat'] = collatArr;
		}
		
		console.log(concerns);
		
		addConcerns(p_id, concernArr, collatArr);
		spanClick(page)
	}
	
	function submitPage() {
		var p_id = -1;
		var collat = false;
		if(typeof(Storage) !== "undefined"){
			p_id = sessionStorage.p_id;
			collat = sessionStorage.collat;
		}
		
		var concerns = {};
		var concernArr = new Array();
		for(var i = 0; i < $("#concerns_grid .concern").length; i++){
			var c = {};
			c['concern']=$("#concerns_grid .concern:eq("+i+")").attr("id");
			c['checked']= $("#concerns_grid div.pure-u-1-5.check input").get(i).checked;
			c['time']=$("#concerns_grid .concern:eq("+i+") .select_box:eq("+0+") select").val();
			c['frequency']=$("#concerns_grid .concern:eq("+i+") .select_box:eq("+1+") select").val();
			
			concernArr[i] = c;
		}
		concerns['array'] = concernArr;
		
		var collatArr = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_concerns_grid .concern").length; i++){
				var c = {};
				c['concern']=$("#collat_concerns_grid .concern:eq("+i+")").attr("id");
				c['checked']= $("#collat_concerns_grid div.pure-u-1-5.check input").get(i-1).checked;
				c['time']=$("#collat_concerns_grid .concern:eq("+i+") .select_box:eq("+0+") select").val();
				c['frequency']=$("#collat_concerns_grid .concern:eq("+i+") .select_box:eq("+1+") select").val();
				
				collatArr[i] = c;
			}
			concerns['collat'] = collatArr;
		}
		
		console.log(concerns);
		
		addConcerns(p_id, concernArr, collatArr);
		
		$("#concerns_form").submit();
	}
</script>
</body>
</html>