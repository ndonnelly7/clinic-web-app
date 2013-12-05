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
</head>
<body>
<h2>Neuro History</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')" >Patient Concerns</span>
  <span onclick="spanClick('neuro')" class="current_page">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Memory Test</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form> 
<form id="problems_form" class="pure-form pure-form-stacked" method="POST" action="neural.do">
	<fieldset id="med_field">
		<legend style="margin-bottom:-0.65em">Have there been any other issues?</legend>
		
		<div id="problems_grid">
			<div id="header_row">
				<div class="pure-u-1-5 title">
					<h3>Problem</h3>
				</div>
				<div class="pure-u-1-5" style="max-width:3%;margin: 0px 1% 0px 1%">
				</div>
				<div class="pure-u-1-5 select_box">
				<h4>Time Since First Occurrence</h4>
				</div>
				<div class="pure-u-1-5 select_box">
				<h3>Frequency</h3>
				</div>
				<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
				<h3>Notes</h3>
				</div>
			</div>
			<div id="blackout">
				<div class="pure-u-1-5 title">Blackouts</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="blackout_check" onclick="showHiddenRow(this, '#blackout')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box" >
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="blackout_notes"form="problems_form" rows="2" cols="24"></textarea>
				</div>
			</div>
			
			<div id="blanks">
				<div class="pure-u-1-5 title">Blanks</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="blanks_check" onclick="showHiddenRow(this,'#blanks')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="blanks_notes"form="problems_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="vision">
				<div class="pure-u-1-5 title">Blurred Vision</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="vision_check" onclick="showHiddenRow(this,'#vision')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="vision_notes"form="problems_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="dizziness">
				<div class="pure-u-1-5 title">Dizziness</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="dizziness_check" onclick="showHiddenRow(this,'#dizziness')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="dizziness_notes"form="problems_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="fainting">
				<div class="pure-u-1-5 title">Fainting</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="fainting_check" onclick="showHiddenRow(this,'#fainting')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="fainting_notes"form="problems_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="headaches">
				<div class="pure-u-1-5 title">Headaches</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="headaches_check" onclick="showHiddenRow(this,'#headaches')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="headaches_notes"form="problems_form"  rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="balance">
				<div class="pure-u-1-5 title">Loss of Balance or Falling</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="balance_check" onclick="showHiddenRow(this,'#balance')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="balance_notes"form="problems_form" rows="2" cols="24"></textarea> 
				</div>
			</div>
			
			<div id="calculatons">
				<div class="pure-u-1-5 title">Seizures</div>
				<div class="pure-u-1-5 check">
				<input type="checkbox" name="calculatons_check" onclick="showHiddenRow(this,'#calculatons')">
				</div>
				<div class="pure-u-1-5 want_time_frame_dis select_box">
				</div>
				<div class="pure-u-1-5 want_frequency_dis select_box">
				</div>
				<div class="pure-u-1-5 notes_column">
				<textarea name="calculatons_notes"form="problems_form" rows="2" cols="24"></textarea> 
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
					<div class="pure-u-1-5 select_box">
					<h4>Time Since First Occurrence</h4>
					</div>
					<div class="pure-u-1-5 select_box">
					<h3>Frequency</h3>
					</div>
					<div class="pure-u-1-5 notes_column" style="max-width:160px;text-align:center">
					<h3>Notes</h3>
					</div>
				</div>
				<div id="blackout">
					<div class="pure-u-1-5 title">Blackouts</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="blackout_check" onclick="showHiddenRow(this, '#blackout')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box" >
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="blackout_notes"form="problems_form" rows="2" cols="24"></textarea>
					</div>
				</div>
				
				<div id="blanks">
					<div class="pure-u-1-5 title">Blanks</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="blanks_check" onclick="showHiddenRow(this,'#blanks')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="blanks_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="vision">
					<div class="pure-u-1-5 title">Blurred Vision</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="vision_check" onclick="showHiddenRow(this,'#vision')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="vision_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="dizziness">
					<div class="pure-u-1-5 title">Dizziness</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="dizziness_check" onclick="showHiddenRow(this,'#dizziness')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="dizziness_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="fainting">
					<div class="pure-u-1-5 title">Fainting</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="fainting_check" onclick="showHiddenRow(this,'#fainting')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="fainting_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="headaches">
					<div class="pure-u-1-5 title">Headaches</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="headaches_check" onclick="showHiddenRow(this,'#headaches')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="headaches_notes"form="problems_form"  rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="balance">
					<div class="pure-u-1-5 title">Loss of Balance or Falling</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="balance_check" onclick="showHiddenRow(this,'#balance')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="balance_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
				
				<div id="calculatons">
					<div class="pure-u-1-5 title">Seizures</div>
					<div class="pure-u-1-5 check">
					<input type="checkbox" name="calculatons_check" onclick="showHiddenRow(this,'#calculatons')">
					</div>
					<div class="pure-u-1-5 want_time_frame_dis select_box">
					</div>
					<div class="pure-u-1-5 want_frequency_dis select_box">
					</div>
					<div class="pure-u-1-5 notes_column">
					<textarea name="calculatons_notes"form="problems_form" rows="2" cols="24"></textarea> 
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<br><br>
</form>
<div class="footer">
	<a href="./concerns_form.html">Previous Page</a>
	<a href="./events_activities.html">Next Page</a>
</div>
<script>
	var showingCollat = false;
	function addNewCollatOption(){
		if(!showingCollat){
			$('#collat_problems_grid').slideDown(500);
			showingCollat = true;
		} else {
			$('#collat_problems_grid').slideUp(500);
			showingCollat = false;
		}
	}
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>