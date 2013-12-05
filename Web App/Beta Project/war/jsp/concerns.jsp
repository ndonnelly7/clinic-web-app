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
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Memory Test</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
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
		
			<div id="events">
				<div class="pure-u-1-5 title">Recent Events</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="rec_events" onclick="showHiddenRow(this, '#events')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box" >
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="rec_event_notes" form="concerns_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="faces">
				<div class="pure-u-1-5 title">Faces</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="faces_check" onclick="showHiddenRow(this,'#faces')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="faces_notes" form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="names">
				<div class="pure-u-1-5 title">Names</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="names_check" onclick="showHiddenRow(this,'#names')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="names_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="losing_things">
				<div class="pure-u-1-5 title">Losing Things</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="losing_things_check" onclick="showHiddenRow(this,'#losing_things')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="losing_things_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="follow_conv">
				<div class="pure-u-1-5 title">Trouble Following Conversations</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="follow_conv_check" onclick="showHiddenRow(this,'#follow_conv')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="follow_conv_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="right_words">
				<div class="pure-u-1-5 title">Trouble Finding the Right Words</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="right_words_check" onclick="showHiddenRow(this,'#right_words')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="right_words_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="decision_making">
				<div class="pure-u-1-5 title">Difficulty Making Decisions</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="decision_making_check" onclick="showHiddenRow(this,'#decision_making')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="decision_making_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="calculatons">
				<div class="pure-u-1-5 title">Calculations</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="calculatons_check" onclick="showHiddenRow(this,'#calculatons')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="calculatons_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="prospective">
				<div class="pure-u-1-5 title">Prospective Memory</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="prospective_check" onclick="showHiddenRow(this,'#prospective')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="prospective_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="anxiety">
				<div class="pure-u-1-5 title">Anxious or Depressed about Forgetfulness</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="anxiety_check" onclick="showHiddenRow(this,'#anxiety')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="anxiety_notes"form="concerns_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="comments">
				<div class="pure-u-1-5 title">Have others commented on your Memory</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="comments_check" onclick="showHiddenRow(this,'#comments')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
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
			
				<div id="events">
					<div class="pure-u-1-5 title">Recent Events</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="rec_events" onclick="showHiddenRow(this, '#events')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box" >
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="rec_event_notes"form="concerns_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="faces">
					<div class="pure-u-1-5 title">Faces</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="faces_check" onclick="showHiddenRow(this,'#faces')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="faces_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="names">
					<div class="pure-u-1-5 title">Names</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="names_check" onclick="showHiddenRow(this,'#names')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="names_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="losing_things">
					<div class="pure-u-1-5 title">Losing Things</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="losing_things_check" onclick="showHiddenRow(this,'#losing_things')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="losing_things_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="follow_conv">
					<div class="pure-u-1-5 title">Trouble Following Conversations</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="follow_conv_check" onclick="showHiddenRow(this,'#follow_conv')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="follow_conv_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="right_words">
					<div class="pure-u-1-5 title">Trouble Finding the Right Words</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="right_words_check" onclick="showHiddenRow(this,'#right_words')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="right_words_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="decision_making">
					<div class="pure-u-1-5 title">Difficulty Making Decisions</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="decision_making_check" onclick="showHiddenRow(this,'#decision_making')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="decision_making_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="calculatons">
					<div class="pure-u-1-5 title">Calculations</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="calculatons_check" onclick="showHiddenRow(this,'#calculatons')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="calculatons_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="prospective">
					<div class="pure-u-1-5 title">Prospective Memory</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="prospective_check" onclick="showHiddenRow(this,'#prospective')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="prospective_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="anxiety">
					<div class="pure-u-1-5 title">Anxious or Depressed about Forgetfulness</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="anxiety_check" onclick="showHiddenRow(this,'#anxiety')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="anxiety_notes"form="concerns_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="comments">
					<div class="pure-u-1-5 title">Have others commented on your Memory</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="comments_check" onclick="showHiddenRow(this,'#comments')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="comments_notes"form="concerns_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<br><br>
</form>
<div class="footer">
	<a href="./medical_form.html">Previous Page</a>
	<a href="./neuro_history.html">Next Page</a>
</div>

<script>
	var showingCollat = false;
	function addNewCollatOption(){
		if(!showingCollat){
			$('#collat_concerns_grid').slideDown(500);
			showingCollat = true;
		} else {
			$('#collat_concerns_grid').slideUp(500);
			showingCollat = false;
		}
	}
</script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>