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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/> 
</head>
<body>
<h2>Patient Concerns</h2>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="linkClick('neuro')">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')">Test Battery</span>
  <span onclick="linkClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="concerns_form" class="pure-form pure-form-stacked" method="POST" action="concerns.do">
<!-- Check to see if the patient wants their memory problems to be investigated -->
	<fieldset id="invest_field">
		<div>
			<div class="concern_q">If we do find a problem with your memory, would you want to investigate it further at this point?</div>
			<div class="concern_a">
				<select id="wants_memory_investigation" name="wants_memory_investigation">
					<option value="not_sure">Not sure</option> <!-- Not sure is set to default in case the nurse does not know -->
					<option value="yes">Yes</option>
					<option value="no">No</option>
				</select> 
			</div>
		</div>
	</fieldset>
	
	<!-- the memory concerns of the patient -->
	<fieldset id="med_field">
		<legend style="margin-bottom:-0.65em">What are the patient's concerns about their memory?</legend>
		
		<!-- Any new concerns should be added to this grid -->
		<!-- Every concern has a title which has the name of the concern (rec_events etc.), a check box that ends with _check, the time that it began ending in _time -->
		<!-- The frequency with which the concern arises ends with _freq and the severity ends with _severity, Whether the concern is worsening ends with _worsening -->
		<div id="concerns_grid">
			<div id="header_row">
				<div class="pure-u-1-5 title">
					<h3>Concern</h3>
				</div>
				<div class="pure-u-1-5 concerns_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
				<h4>Time Since Began</h4>
				</div>
				<div class="pure-u-1-5 concerns_column">
				<h3>Frequency</h3>
				</div>
				<div class="pure-u-1-5 concerns_column">
				<h4 class="severity_title">Severity (Scale 1- 10)</h4>
				</div>
				<div class="pure-u-1-5 concerns_column worse_title">
				<h4 class="worse">Has it been Worsening?</h4>
				</div>
				<div class="pure-u-1-5 concern_notes" style="max-width:90px;text-align:center">
				<h3>Notes</h3>
				</div>
			</div>
		
		<!-- Recent Events concerns -->
			<div id="events" class="concern">
				<div class="pure-u-1-5 title">Recent Events</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="rec_events_check" onclick="showConcernRow(this, '#events')" id="rec_events" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="rec_events_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="rec_events_freq" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="rec_events_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="rec_events_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="rec_event_notes" form="concerns_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="faces" class="concern">
				<div class="pure-u-1-5 title">Faces</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="faces_check" onclick="showConcernRow(this,'#faces')" id="faces" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="faces_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="faces_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="faces_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="faces_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="faces_notes" form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="names" class="concern">
				<div class="pure-u-1-5 title">Names</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="names_check" onclick="showConcernRow(this,'#names')" id="names" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="names_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="names_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="names_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="names_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="names_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="losing_things" class="concern">
				<div class="pure-u-1-5 title">Losing Things</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="losing_things_check" onclick="showConcernRow(this,'#losing_things')" id="losing_things" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="losing_things_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="losing_things_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="losing_things_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="losing_things_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="losing_things_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="follow_conv" class="concern">
				<div class="pure-u-1-5 title">Trouble Following Conversations</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="follow_conv_check" onclick="showConcernRow(this,'#follow_conv')" id="follow_conv" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="follow_conv_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="follow_conv_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="follow_conv_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="follow_conv_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="follow_conv_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="right_words" class="concern">
				<div class="pure-u-1-5 title">Trouble Finding the Right Words</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="right_words_check" onclick="showConcernRow(this,'#right_words')" id="right_words" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="right_words_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="right_words_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="right_words_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="right_words_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="right_words_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="decisions" class="concern">
				<div class="pure-u-1-5 title">Difficulty Making Decisions</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="decisions_check" onclick="showConcernRow(this,'#decisions')" id="decisions" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="decisions_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="decisions_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="decisions_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="decisions_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="decisions_notes" form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="calculatons" class="concern">
				<div class="pure-u-1-5 title">Calculations</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="calculatons_check" onclick="showConcernRow(this,'#calculatons')" id="calculations" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="calculations_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="calculations_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="calculations_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="calculations_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="calculatons_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="prospective" class="concern">
				<div class="pure-u-1-5 title">Prospective Memory</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="prospective_check" onclick="showConcernRow(this,'#prospective')" id="prospective" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="prospective_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="prospective_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="prospective_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="prospective_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="prospective_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="anxiety" class="concern">
				<div class="pure-u-1-5 title">Anxious or Depressed about Forgetfulness</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="anxiety_check" onclick="showConcernRow(this,'#anxiety')" id="anxiety" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="anxiety_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="anxiety_freq" class="frequency" disabled>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="anxiety_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="anxiety_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="anxiety_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="comments" class="concern">
				<div class="pure-u-1-5 title">Have others commented on your Memory</div>
				<div class="pure-u-1-5 concerns_check">
				<input type="checkbox" name="comments_check" onclick="showConcernRow(this,'#comments')" id="comments" class="concern_check">
				</div>
				<div class="pure-u-1-5 concerns_column">
					<div id="timeframe_1m_3pyr_dis">
						<select name="comments_time" class="time_frame" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="comments_freq" class="frequency" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="daily">Daily</option>
						<option value="weekly">Weekly</option>
						<option value="monthly">Monthly</option>
						<option value="yearly">Yearly</option>
						<option value="once">One off</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="comments_severity" class="severity" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="one">1 - Not Bad at all</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
						<option value="five">5</option>
						<option value="six">6</option>
						<option value="seven">7</option>
						<option value="eight">8</option>
						<option value="nine">9</option>
						<option value="ten">10 - Very Bad</option>
					</select>
				</div>
				<div class="pure-u-1-5 concerns_column" >
					<select name="comments_worsening" class="worse" disabled>
						<option value="not_sure">Not Sure</option>
						<option value="same">Stayed the same</option>
						<option value="little_worse">Little worse</option>
						<option value="Much worse">Much worse</option>
					</select>
				</div>
				<div class="pure-u-1-5 concern_notes">
				<textarea name="comments_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
		</div>
		
		<!-- This is filled dynamically based on the check boxes for the concerns so the most worrying concern can be chosen -->
		<div id="concerns_reactive" class="reactive_div">
			<div class="title" style="display:inline-block">What concern do you think has the biggest impact on your life?</div>
			<select name="most_impactful_concern" id="most_impactful_concern" style="display:inline-block">
			</select>
		</div>
		
		<!-- Same as above but for collateral operations -->
		<div class="collat_div">
			<input type="button" onclick="addNewCollatOption()" class="pure-button" value="Add Concern from Collateral">
			<div class="hide_div" id="collat_concerns_grid">
				<!-- Any new concerns should be added to this grid -->
				<!-- Every concern has a title which has the name of the concern (rec_events etc.), a check box that ends with _check_collat, the time that it began ending in _time_collat -->
				<!-- The frequency with which the concern arises ends with _freq_collat and the severity ends with _severity_collat, Whether the concern is worsening ends with _worsening_collat -->
				<div id="header_row">
					<div class="pure-u-1-5 title">
						<h3>Concern</h3>
					</div>
					<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
					</div>
					<div class="pure-u-1-5 concerns_column">
					<h4>Time Since Began</h4>
					</div>
					<div class="pure-u-1-5 concerns_column">
					<h3>Frequency</h3>
					</div>
					<div class="pure-u-1-5 concern_notes" style="max-width:90px;text-align:center">
					<h3>Notes</h3>
					</div>
				</div>
			
				<div id="events_collat" class="concern">
					<div class="pure-u-1-5 title" id="rec_events">Recent Events</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="rec_events_check_collat" onclick="showConcernRow(this, '#events_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="rec_events_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="rec_events_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="rec_events_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="rec_events_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="rec_event_notes_collat"form="concerns_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="faces_collat" class="concern">
					<div class="pure-u-1-5 title" id="faces">Faces</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="faces_check_collat" onclick="showConcernRow(this,'#faces_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="faces_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="faces_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="faces_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="faces_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="faces_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="names_collat" class="concern">
					<div class="pure-u-1-5 title" id="names">Names</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="names_check_collat" onclick="showConcernRow(this,'#names_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="names_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="names_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="names_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="names_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="names_notes_collat"form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="losing_things_collat" class="concern">
					<div class="pure-u-1-5 title" id="losing_things">Losing Things</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="losing_things_check_collat" onclick="showConcernRow(this,'#losing_things_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="losing_things_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="losing_things_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="losing_things_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="losing_things_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="losing_things_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="follow_conv_collat" class="concern">
					<div class="pure-u-1-5 title" id="conversations">Trouble Following Conversations</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="follow_conv_check_collat" onclick="showConcernRow(this,'#follow_conv_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="follow_conv_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="follow_conv_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="follow_conv_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="follow_conv_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="follow_conv_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="right_words_collat" class="concern">
					<div class="pure-u-1-5 title" id="right_words">Trouble Finding the Right Words</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="right_words_check_collat" onclick="showConcernRow(this,'#right_words_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="right_words_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="right_words_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="right_words_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="right_words_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="right_words_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="decisions_collat" class="concern">
					<div class="pure-u-1-5 title" id="decisions">Difficulty Making Decisions</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="decisions_check_collat" onclick="showConcernRow(this,'#decisions_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="decisions_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="decisions_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="decisions_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="decisions_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="decisions_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="calculatons_collat" class="concern">
					<div class="pure-u-1-5 title" id="calculations">Calculations</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="calculatons_check_collat" onclick="showConcernRow(this,'#calculatons_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="calculations_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="calculations_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="calculations_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="calculations_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="calculatons_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="prospective_collat" class="concern">
					<div class="pure-u-1-5 title" id="prospective">Prospective Memory</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="prospective_check_collat" onclick="showConcernRow(this,'#prospective_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="prospective_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="prospective_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="prospective_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="prospective_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="prospective_notes_collat"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="anxiety_collat" class="concern">
					<div class="pure-u-1-5 title" id="forgetfulness">Anxious or Depressed about Forgetfulness</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="anxiety_check_collat" onclick="showConcernRow(this,'#anxiety_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="anxiety_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="anxiety_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="anxiety_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="anxiety_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="anxiety_notes_collat" form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="comments_collat" class="concern">
					<div class="pure-u-1-5 title" id="comments">Have others commented on your Memory</div>
					<div class="pure-u-1-5 concerns_check">
					<input type="checkbox" name="comments_check_collat" onclick="showConcernRow(this,'#comments_collat')" class="concern_check_collat">
					</div>
					<div class="pure-u-1-5 concerns_column">
						<div id="timeframe_1m_3pyr_dis">
							<select name="comments_time_collat" class="time_frame" disabled>
								<option value="not_sure">Not Sure</option>
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>	
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="comments_freq_collat" class="frequency" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
							<option value="yearly">Yearly</option>
							<option value="once">One off</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="comments_severity_collat" class="severity" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="one">1 - Not Bad at all</option>
							<option value="two">2</option>
							<option value="three">3</option>
							<option value="four">4</option>
							<option value="five">5</option>
							<option value="six">6</option>
							<option value="seven">7</option>
							<option value="eight">8</option>
							<option value="nine">9</option>
							<option value="ten">10 - Very Bad</option>
						</select>
					</div>
					<div class="pure-u-1-5 concerns_column" >
						<select name="comments_worsening_collat" class="worse" disabled>
							<option value="not_sure">Not Sure</option>
							<option value="same">Stayed the same</option>
							<option value="little_worse">Little worse</option>
							<option value="Much worse">Much worse</option>
						</select>
					</div>
					<div class="pure-u-1-5 concern_notes">
					<textarea name="comments_notes_collat" form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
			
				<div id="collat_concerns_reactive" class="reactive_div">
					<div class="title" style="display:inline-block">What concern do you think has the biggest impact on their life?</div>
					<select name="most_impactful_concern_collat" id="most_impactful_concern_collat" style="display:inline-block">
					</select>
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
		//Sets the hiddenID for submission
		if("${id}" != "")
			$("#hiddenID").val("${id}");
		else if(typeof(Storage) !== "undefined"){
			$("#hiddenID").val(sessionStorage.p_id);
			if(sessionStorage.collat)
				hideCollat();
		} else {
			$("#hiddenID").val("0");
		}
		//Figures out if the collateral is needed to be shown using the SessionStorage
		if(typeof(Storage) !== "undefined")
			if(!(sessionStorage.collat))
				hideCollat();
		
		populateReactive();
	});
	
	//Reveals or hides the collateral grid
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
	
	//Populates the drop down box suing the check boxes
	function populateReactive(rowID){
		$("#most_impactful_concern").html("<option value='unknown'>Unknown</option>");
		$("#most_impactful_concern_collat").html("<option value='unknown'>Unknown</option>");
		
		$(".concern_check").each(function() {
			if($(this).prop("checked")){
				var option_name = $(this).parent().parent().prop("id");
				var option_val = ($(this).parent().parent().children(".title").html());
				$("#most_impactful_concern").append('<option value='+option_name+'>'+option_val+'</option>');
			}
		});
		
		$(".concern_check_collat").each(function() {
			if($(this).prop("checked")){
				var option_name = $(this).parent().parent().prop("id");
				var option_val = ($(this).parent().parent().children(".title").html());
				$("#most_impactful_concern_collat").append('<option value='+option_name+'>'+option_val+'</option>');
			}
		});
	}
	
	//Either disables or re-enables the row of concerns based on if a checkbox was clicked
	//The box is the checkbox itself, and the rowId is the identifier of the row that should be enabled
	function showConcernRow(box, rowId){
		if(box.checked){
			$(rowId + " select").prop("disabled",false);
		} else {
			$(rowId + " select").prop("disabled",true);
		}
		
		populateReactive(rowId);
	}
	
	//Stores stuff locally before moving to another page
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
			c['checked']= $("#concerns_grid div.pure-u-1-5.concerns_check input").get(i).checked;
			c['time']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+0+") select").val();
			c['frequency']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+1+") select").val();
			c['severity']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+2+") select").val();
			c['worsening']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+3+") select").val();
			
			concernArr[i] = c;
		}
		concerns['array'] = concernArr;
		
		var collatArr = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_concerns_grid .concern").length; i++){
				var c = {};
				c['concern']=$("#collat_concerns_grid .concern:eq("+i+")").attr("id");
				c['checked']= $("#collat_concerns_grid div.pure-u-1-5.concerns_check input").get(i-1).checked;
				c['time']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+0+") select").val();
				c['frequency']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+1+") select").val();
				c['severity']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+2+") select").val();
				c['worsening']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+3+") select").val();
				
				collatArr[i] = c;
			}
			concerns['collat'] = collatArr;
		}
		
		console.log(concerns);
		
		addConcerns(p_id, concernArr, collatArr);
		spanClick(page)
	}
	
	//Stores values locally and then submits the page to the servlet
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
			c['checked']= $("#concerns_grid div.pure-u-1-5.concerns_check input").get(i).checked;
			c['time']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+0+") select").val();
			c['frequency']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+1+") select").val();
			c['severity']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+2+") select").val();
			c['worsening']=$("#concerns_grid .concern:eq("+i+") .concerns_column:eq("+3+") select").val();
			
			concernArr[i] = c;
		}
		concerns['array'] = concernArr;
		
		var collatArr = new Array();
		if(collat){
			for(var i = 0; i < $("#collat_concerns_grid .concern").length; i++){
				var c = {};
				c['concern']=$("#collat_concerns_grid .concern:eq("+i+")").attr("id");
				c['checked']= $("#collat_concerns_grid div.pure-u-1-5.concerns_check input").get(i-1).checked;
				c['time']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+0+") select").val();
				c['frequency']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+1+") select").val();
				c['severity']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+2+") select").val();
				c['worsening']=$("#collat_concerns_grid .concern:eq("+i+") .concerns_column:eq("+3+") select").val();
				
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