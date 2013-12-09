<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Activities</title>
<!--  <link rel="stylesheet" href="/css/jquery-ui.css" type="text/css"/> -->
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/events_activities.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/> 
</head>
<body>
<h2>Major Events and Social Activities</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')" class="current_page">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Memory Test</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="events_form" class="pure-form pure-form-stacked" method="POST" action="events_activities.do">
	<fieldset id="major_event_field">
		<legend>Major Life Events</legend>
		<div id="events_grid">
			<div id="header_row">
				<div class="pure-u-1-4 title">
					<h3>Event</h3>
				</div>
				<div class="pure-u-1-4" style="max-width:180px;margin: 0px 1% 0px 1%">
				</div>
				<div class="pure-u-1-4 select_box" style="text-align:center">
				<h3>When</h3>
				</div>
				<div class="pure-u-1-4 notes_column" style="max-width:160px;text-align:center">
				<h3>Notes</h3>
				</div>
			</div>
		
			<div id="divorce">
				<div class="pure-u-1-4 title">Divorce</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="divorce_check" onclick="showHiddenRowEA(this, '#divorce')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="rec_event_notes"form="events_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="Bereavement">
				<div class="pure-u-1-4 title">Bereavement</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="Bereavement_check" onclick="showHiddenRowEA(this,'#Bereavement')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="Bereavement_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="moving_house">
				<div class="pure-u-1-4 title">Moving House</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="moving_house_check" onclick="showHiddenRowEA(this,'#moving_house')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="moving_house_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="redundancy">
				<div class="pure-u-1-4 title">Redundancy</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="redundancy_check" onclick="showHiddenRowEA(this,'#redundancy')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="redundancy_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="disharmony">
				<div class="pure-u-1-4 title">Family Disharmony</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="disharmony_check" onclick="showHiddenRowEA(this,'#disharmony')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="disharmony_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="argument">
				<div class="pure-u-1-4 title">Other Relationship Disharmony</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="argument_check" onclick="showHiddenRowEA(this,'#argument')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="argument_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="financial">
				<div class="pure-u-1-4 title">Financial Issues</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="financial_check" onclick="showHiddenRowEA(this,'#financial')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="financial_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="retirement">
				<div class="pure-u-1-4 title">Retirement</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="retirement_check" onclick="showHiddenRowEA(this,'#retirement')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="retirement_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="job_stress">
				<div class="pure-u-1-4 title">Job Stress</div>
				<div class="pure-u-1-4 check">
				<input type="checkbox" name="job_stress_check" onclick="showHiddenRowEA(this,'#job_stress')" class="event_check">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="job_stress_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="other" class="life_event">
				<div class="pure-u-1-4 title">Other</div>
				<div class="pure-u-1-4" id="other_text_box">
				<input type="text" name="other_text" onchange="showHiddenRowEAText(this,'#other')" class="event_check" style="margin-right:3%">
				</div>
				<div class="pure-u-1-4 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-4 notes_column">
				<textarea name="other_notes"form="events_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
		</div>
		
		<div class="collat_div">
			<input type="button" onclick="addNewCollatEvents()" class="pure-button eaa-button" value="Add Event from Collateral">
			<div id="events_collat_grid" class="hide_div">
				<div id="header_row">
					<div class="pure-u-1-4 title">
						<h3>Event</h3>
					</div>
					<div class="pure-u-1-4" style="max-width:180px;margin: 0px 1% 0px 1%">
					</div>
					<div class="pure-u-1-4 select_box" style="text-align:center">
					<h3>When</h3>
					</div>
					<div class="pure-u-1-4 notes_column" style="max-width:160px;text-align:center">
					<h3>Notes</h3>
					</div>
				</div>
			
				<div id="divorce">
					<div class="pure-u-1-4 title">Divorce</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="divorce_check" onclick="showHiddenRowEA(this, '#divorce')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="rec_event_notes"form="events_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="Bereavement">
					<div class="pure-u-1-4 title">Bereavement</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="Bereavement_check" onclick="showHiddenRowEA(this,'#Bereavement')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="Bereavement_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="moving_house">
					<div class="pure-u-1-4 title">Moving House</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="moving_house_check" onclick="showHiddenRowEA(this,'#moving_house')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="moving_house_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="redundancy">
					<div class="pure-u-1-4 title">Redundancy</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="redundancy_check" onclick="showHiddenRowEA(this,'#redundancy')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="redundancy_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="disharmony">
					<div class="pure-u-1-4 title">Family Disharmony</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="disharmony_check" onclick="showHiddenRowEA(this,'#disharmony')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="disharmony_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="argument">
					<div class="pure-u-1-4 title">Other Relationship Disharmony</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="argument_check" onclick="showHiddenRowEA(this,'#argument')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="argument_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="financial">
					<div class="pure-u-1-4 title">Financial Issues</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="financial_check" onclick="showHiddenRowEA(this,'#financial')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="financial_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="retirement">
					<div class="pure-u-1-4 title">Retirement</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="retirement_check" onclick="showHiddenRowEA(this,'#retirement')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="retirement_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="job_stress">
					<div class="pure-u-1-4 title">Job Stress</div>
					<div class="pure-u-1-4 check">
					<input type="checkbox" name="job_stress_check" onclick="showHiddenRowEA(this,'#job_stress')" class="event_check">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="job_stress_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="other" class="life_event">
					<div class="pure-u-1-4 title">Other</div>
					<div class="pure-u-1-4" id="other_text_box">
					<input type="text" name="other_text" onchange="showHiddenRowEAText(this,'#other')" class="event_check" style="margin-right:3%">
					</div>
					<div class="pure-u-1-4 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-4 notes_column">
					<textarea name="other_notes"form="events_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset id="social_field">
		<legend>Changes in Social Activities</legend>
		<div id="social_div">
			<div class="title">What social activities have you been involved in?</div>
			<div id="activity_header" class="pure-g-r">
				<div class="pure-u-1-5 select_box header events-1-5" style="min-width:150px; margin: 10px 7% 10px 2%">Activity</div>
				<div class="pure-u-1-5 pure-control-group events-1-5 header">Still Involved?</div>
				<div class="pure-u-1-5 events-1-5 header" style="width:6.5%">Current hours per week</div>
				<div class="pure-u-1-5 events-1-5 header" style="width:7%">Previous hours per week</div>
				<div class="pure-u-1-5 events-1-5 header">Changed When?</div>
				<div class="pure-u-1-5 events-1-5 header">Reason for Change</div>
			</div>
			<div id="activity_entry" style="min-width:800px">
				<div class="pure-g-r">
					<div class="pure-u-1-5 select_box" style="max-width:150px; margin: 10px 7% 10px 2%;">
						<select name="activities_list">
							<option value="dancing">Dancing</option>
							<option value="reading">Reading</option>
							<option value="tv">Television</option>
							<option value="football">Football</option>
							<option value="golf">Golf</option>
							<option value="swimming">Swimming</option>
							<option value="walking">Walking</option>
							<option value="yoga">Yoga/Pilates</option>
							<option value="cards">Card Games</option>
							<option value="puzzles">Sudoku/Crosswords/Puzzles</option>
							<option value="restaraunts">Visiting Restaurants/Pubs</option>
							<option value="visiting">Visiting Friends/Family</option>
							<option value="sailing">Sailing</option>
							<option value="volunteering">Volunteering</option>
							<option value="gym">Gym</option>
							<option value="games">Computer Games</option>
							<option value="hiking">Hiking</option>
							<option value="cycling">Cycling</option>
							<option value="other">Other..</option>
						</select>
					</div>
					<div class="pure-u-1-5 pure-control-group events-1-5">
						<select name="still_active_check" onclick="changeActivity(this)">
							<option value="no">No</option>
							<option value="ongoing">Ongoing</option>
							<option value="decrease">Less active</option>
						</select>
					</div>
					<div class="pure-u-1-5 events-1-5 current_hours" style="width:7%">
						<input type="text" name="current_active_hours" class="current_hours_input" style="width:4em;">
					</div>
					<div class="pure-u-1-5 events-1-5 previous_hours" style="width:7%">
						<input type="text" name="previous_active_hours" class="prev_hours_input" style="width:4em;">
					</div>
					
					<div class="pure-u-1-5 events-1-5 when_stopped">
						<select name="time_frame" class="time_stopped_input" >
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
					
					<div class="pure-u-1-5 events-1-5 reason_notes notes_column">
							<textarea form="events_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
					</div>
				</div>
			</div>
		</div>
		<input type="button" onclick="addNewActivity()" style="margin-left:2%;" class="pure-button" value="Add Activity">
		
		<div class="collat_div">
			<input type="button" onclick="showCollatActivities()" class="pure-button eaa-button" value="Add Activity from Collateral">
			<div id="social_collat_div" class="hide_div">
				<div id="social_collat_grid">
					<div class="title">What social activities have they been involved in?</div>
					<div id="activity_header" class="pure-g-r">
						<div class="pure-u-1-5 select_box header events-1-5" style="min-width:150px; margin: 10px 7% 10px 2%">Activity</div>
						<div class="pure-u-1-5 pure-control-group events-1-5 header">Still Involved?</div>
						<div class="pure-u-1-5 events-1-5 header" style="width:6.5%">Current hours per week</div>
						<div class="pure-u-1-5 events-1-5 header" style="width:7%">Previous hours per week</div>
						<div class="pure-u-1-5 events-1-5 header">Changed When?</div>
						<div class="pure-u-1-5 events-1-5 header">Reason for Change</div>
					</div>
					<div id="collat_activity_entry" style="min-width:800px">
						<div class="pure-g-r">
							<div class="pure-u-1-5 select_box" style="max-width:150px; margin: 10px 7% 10px 2%;">
								<select name="activities_list">
									<option value="dancing">Dancing</option>
									<option value="reading">Reading</option>
									<option value="tv">Television</option>
									<option value="football">Football</option>
									<option value="golf">Golf</option>
									<option value="swimming">Swimming</option>
									<option value="walking">Walking</option>
									<option value="yoga">Yoga/Pilates</option>
									<option value="cards">Card Games</option>
									<option value="puzzles">Sudoku/Crosswords/Puzzles</option>
									<option value="restaraunts">Visiting Restaurants/Pubs</option>
									<option value="visiting">Visiting Friends/Family</option>
									<option value="sailing">Sailing</option>
									<option value="volunteering">Volunteering</option>
									<option value="gym">Gym</option>
									<option value="games">Computer Games</option>
									<option value="hiking">Hiking</option>
									<option value="cycling">Cycling</option>
									<option value="other">Other..</option>
								</select>
							</div>
							<div class="pure-u-1-5 pure-control-group events-1-5">
								<select name="still_active_check" onclick="changeActivity(this)">
									<option value="no">No</option>
									<option value="ongoing">Ongoing</option>
									<option value="decrease">Less active</option>
								</select>
							</div>
							<div class="pure-u-1-5 events-1-5 current_hours" style="width:7%">
								<input type="text" name="current_active_hours" class="current_hours_input" style="width:4em;">
							</div>
							<div class="pure-u-1-5 events-1-5 previous_hours" style="width:7%">
								<input type="text" name="previous_active_hours" class="prev_hours_input" style="width:4em;">
							</div>
							
							<div class="pure-u-1-5 events-1-5 when_stopped">
								<select name="time_frame" class="time_stopped_input" >
									<option value="three_mon">3 months</option>
									<option value="six_mon">6 months</option>
									<option value="one_yr">1 year</option>
									<option value="two_yr">2 years</option>
									<option value="threep_yr">3+ years</option>
								</select>
							</div>
							
							<div class="pure-u-1-5 events-1-5 reason_notes notes_column">
									<textarea form="events_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div>
		
				</div>
				<input type="button" onclick="addNewCollatActivity()" style="margin-left:2%;" class="pure-button" value="Add Activity">
			</div>
		</div>
	</fieldset>

	<fieldset id="anxiety_depression field">
		<legend>Anxiety and Depression</legend>
		<div>
			<span class="anx_dep_title">Do you feel anxious generally?</span>
			<input type="checkbox" name="anxiety_check"  onclick="showHiddenDiv(this,'anxiety_div')" id="anx_check"><br>
		</div>
		<br>
		<div id="anxiety_div" class="hide_div">
		<div class="anx_dep_subtitle">For how long?</div>
		<div id="anx_time" style="display:inline-block;margin-left:3.8em;">
			<select name="time_frame" onclick="showReactiveList(this,'#anxiety_div')">
				<option value="three_mon">3 months</option>
				<option value="six_mon">6 months</option>
				<option value="one_yr">1 year</option>
				<option value="two_yr">2 years</option>
				<option value="threep_yr">3+ years</option>
			</select>
		</div>
		<div class="hide_div reactive_list" style="margin-top:1em;">
			<div class="anx_dep_subtitle">Could this be related to:</div>
			<select name="life_events" style="display:inline-block;">
				<option value="other" selected="selected">Other...</option>
			</select>
		</div>		
		<div style="margin-top:0.8em;margin-left:2%;"><textarea name="anxiety_notes" rows="2" cols="30" form="events_form"></textarea></div>
		</div>
		<br><br>
		<div>
			<span class="anx_dep_title">Do you feel depressed generally?</span>
			<input type="checkbox" name="dep_check"  onclick="showHiddenDiv(this,'depression_div')" id="depress_check"><br>
		</div>
		<br>
		<div id="depression_div" class="hide_div">
			<div class="anx_dep_subtitle">For how long?</div>
			<div id="dep_time" style="display:inline-block;margin-left:3.8em;">
				<select name="time_frame" onclick="showReactiveList(this,'#depression_div')">
					<option value="three_mon">3 months</option>
					<option value="six_mon">6 months</option>
					<option value="one_yr">1 year</option>
					<option value="two_yr">2 years</option>
					<option value="threep_yr">3+ years</option>
				</select>
			</div>
			<div class="hide_div reactive_list" style="margin-top:1em;">
				<div class="anx_dep_subtitle">Could this be related to:</div>
				<select name="life_events" style="display:inline-block;">
					<option value="other" selected="selected">Other...</option>
				</select>
			</div>
			<div style="margin-top:0.8em;margin-left:2%;"><textarea form="events_form" rows="2" cols="30" name="depression_notes"></textarea></div>
		</div>
		<br>
	</fieldset>
	
</form>

<div class="footer">
	<a href="./neuro_history.html">Previous Page</a>
	<a href="./living_form.html">Next Page</a>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/events_script.js"></script>
</body>
</html>