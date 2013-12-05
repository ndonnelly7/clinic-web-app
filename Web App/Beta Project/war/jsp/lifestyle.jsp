<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Lifestyle</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/>
<link rel="stylesheet" href="/css/lifestyle.css"/>
</head>
<body>
<h2>Patient Lifestyle</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')" class="current_page">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Memory Test</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="lifestyle_form" class="pure-form pure-form-stacked" method="POST" action="lifestyle.do">
	<fieldset id="sleeping_field">
		<legend>Sleep</legend>
		
		<div id="sleep_difficulty" class="pure-g-u">
			<div class="pure-u-1-3 lifestyle_title">Do you generally find it difficult to fall asleep?</div>
			<div class="pure-u-1-3 check">
				<input type="checkbox" name="difficulty_sleep_check" onclick="showHiddenDiv(this, 'difficulty_sleep')">
			</div>
			<div class="pure-u-1-3 notes_column">
				<textarea name="sleep_difficulty_notes" form="lifestyle_form" rows="2"></textarea>
			</div>
			
			<div id="difficulty_sleep" class="pure-g-u hide_div">
				<div id="difficulty_reason">
					<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="reason">
							<option value="diet">Diet</option>
							<option value="anxiety">Anxiety</option>
							<option value="other">Other...</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				<div id="difficulty_start">
					<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="time_frame">
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				
				<div id="difficulty_often">
					<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="frequency">
							<option value="daily">Every Day</option>
							<option value="freq">Frequently</option>
							<option value="semi_rare">Every So Often</option>
							<option value="rare">Rarely</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
			</div>
		</div>
		
		<div id="night_waking" class="pure-g-u">
			<div class="pure-u-1-3 lifestyle_title">Do you ever wake up during the night?</div>
			<div class="pure-u-1-3 check">
				<input type="checkbox" name="difficulty" onclick="showHiddenDiv(this, 'night_waking_qs')">
			</div>
			<div class="pure-u-1-3 notes_column">
				<textarea name="night_waking_notes" form="lifestyle_form" rows="2"></textarea>
			</div>
			
			<div id="night_waking_qs" class="pure-g-u hide_div">
				<div id="difficulty_reason">
					<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="reason">
							<option value="diet">Diet</option>
							<option value="anxiety">Anxiety</option>
							<option value="other">Other...</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				<div id="difficulty_start">
					<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="time_frame">
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				
				<div id="difficulty_often">
					<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="frequency">
							<option value="daily">Every Day</option>
							<option value="freq">Frequently</option>
							<option value="semi_rare">Every So Often</option>
							<option value="rare">Rarely</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
			</div>
		</div>
		
		<div id="early_waking" class="pure-g-u">
			<div class="pure-u-1-3 lifestyle_title">
				<span>Do you wake up very early in the morning?</span>
			</div>
			<div class="pure-u-1-3 check">
				<input type="checkbox" name="difficulty" onclick="showHiddenDiv(this, 'early_waking_qs')">
			</div>
			<div class="pure-u-1-3 notes_column">
				<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
			</div>
			
			<div id="early_waking_qs" class="pure-g-u hide_div">
				<div id="difficulty_reason">
					<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="reason">
							<option value="diet">Diet</option>
							<option value="anxiety">Anxiety</option>
							<option value="other">Other...</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				<div id="difficulty_start">
					<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="time_frame">
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
				
				<div id="difficulty_often">
					<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="frequency">
							<option value="daily">Every Day</option>
							<option value="freq">Frequently</option>
							<option value="semi_rare">Every So Often</option>
							<option value="rare">Rarely</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
			</div>
		</div>
		
		<div id="general_sleep" class="pure-g-u">
			<div id="hours_sleep">
				<div class="lifestyle_title pure-u-1-3">How many hours do you usually sleep a night?</div>
				<div class="lifestyle_select pure-u-1-3">
					<select name="sleep_length" class="hours_life">
						<option value="two">&gt; 2</option>
						<option value="five">2 - 5</option>
						<option value="eight">6 - 8</option>
						<option value="ten">8 - 10</option>
						<option value="plus">10+</option>
					</select>
					<div class="life_select_tag">Hours</div>
				</div>
			</div>
			
			<div id="meds_sleep">
				<div class="lifestyle_title pure-u-1-3">Do you ever take medication to help you sleep?</div>
				<div class="pure-u-1-3 check">
					<input type="checkbox" name="meds" onclick="showHiddenDiv(this, 'meds_sleep_qs')">
				</div>
				<div id="meds_sleep_qs" class="hide_div">
					<div class="pure-u-1-3 lifestyle_subtitle" id="subtitle_margin_change">What medication?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="sleep_meds">
							<option value="med_one">Sleep Med 1</option>
							<option value="med_two">Sleep Med 2</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
			</div>
			
			<div id="naps">
				<div class="lifestyle_title pure-u-1-3">Do you ever take naps during the day?</div>
				<div class="pure-u-1-3 check">
					<input type="checkbox" name="naps_check" onclick="showHiddenDiv(this, 'nap_qs')">
				</div>
				<div id="nap_qs" class="hide_div">
					<div class="pure-u-1-3 lifestyle_subtitle">For how long?</div>
					<div class="lifestyle_select pure-u-1-3">
						<select name="nap_length" class="hours_life">
							<option value="less_one">&gt; 1</option>
							<option value="one_two">1 - 2</option>
							<option value="two_plus">2+</option>
						</select>
						<div class="life_select_tag">Hours</div>
					</div>
					<br>
					<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
					<div class="pure-u-1-3 life_select_box">
						<select name="time_frame">
							<option value="daily">Every day</option>
							<option value="regular">Few days a week</option>
							<option value="semi_reg">Every so often</option>
							<option value="rare">Rarely</option>
						</select>
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
				</div>
			</div>
		</div>		
	
		<div class="collat_div">
			<input type="button" onclick="addCollatSleep()" class="pure-button lifestyle_button" value="Add Information from Collateral">
			
			<div id="collat_sleep" class="hide_div collat_life_div">
				<div id="sleep_difficulty" class="pure-g-u">
					<div class="pure-u-1-3 lifestyle_title">Do they generally find it difficult to fall asleep?</div>
					<div class="pure-u-1-3 check">
						<input type="checkbox" name="difficulty_sleep_check" onclick="showHiddenDiv(this, 'difficulty_sleep')">
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="sleep_difficulty_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
					
					<div id="difficulty_sleep" class="pure-g-u hide_div">
						<div id="difficulty_reason">
							<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="reason">
									<option value="diet">Diet</option>
									<option value="anxiety">Anxiety</option>
									<option value="other">Other...</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						<div id="difficulty_start">
							<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="time_frame">
									<option value="three_mon">3 months</option>
									<option value="six_mon">6 months</option>
									<option value="one_yr">1 year</option>
									<option value="two_yr">2 years</option>
									<option value="threep_yr">3+ years</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						
						<div id="difficulty_often">
							<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="frequency">
									<option value="daily">Every Day</option>
									<option value="freq">Frequently</option>
									<option value="semi_rare">Every So Often</option>
									<option value="rare">Rarely</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div id="night_waking" class="pure-g-u">
					<div class="pure-u-1-3 lifestyle_title">Do they ever wake up during the night?</div>
					<div class="pure-u-1-3 check">
						<input type="checkbox" name="difficulty" onclick="showHiddenDiv(this, 'night_waking_qs')">
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="night_waking_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
					
					<div id="night_waking_qs" class="pure-g-u hide_div">
						<div id="difficulty_reason">
							<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="reason">
									<option value="diet">Diet</option>
									<option value="anxiety">Anxiety</option>
									<option value="other">Other...</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						<div id="difficulty_start">
							<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="time_frame">
									<option value="three_mon">3 months</option>
									<option value="six_mon">6 months</option>
									<option value="one_yr">1 year</option>
									<option value="two_yr">2 years</option>
									<option value="threep_yr">3+ years</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						
						<div id="difficulty_often">
							<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="frequency">
									<option value="daily">Every Day</option>
									<option value="freq">Frequently</option>
									<option value="semi_rare">Every So Often</option>
									<option value="rare">Rarely</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div id="early_waking" class="pure-g-u">
					<div class="pure-u-1-3 lifestyle_title">Do they wake up very early in the morning?</div>
					<div class="pure-u-1-3 check">
						<input type="checkbox" name="difficulty" onclick="showHiddenDiv(this, 'early_waking_qs')">
					</div>
					<div class="pure-u-1-3 notes_column">
						<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
					</div>
					
					<div id="early_waking_qs" class="pure-g-u hide_div">
						<div id="difficulty_reason">
							<div class="pure-u-1-3 lifestyle_subtitle">Reason:</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="reason">
									<option value="diet">Diet</option>
									<option value="anxiety">Anxiety</option>
									<option value="other">Other...</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_reason_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						<div id="difficulty_start">
							<div class="pure-u-1-3 lifestyle_subtitle">When did this start?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="time_frame">
									<option value="three_mon">3 months</option>
									<option value="six_mon">6 months</option>
									<option value="one_yr">1 year</option>
									<option value="two_yr">2 years</option>
									<option value="threep_yr">3+ years</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_start_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
						
						<div id="difficulty_often">
							<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="frequency">
									<option value="daily">Every Day</option>
									<option value="freq">Frequently</option>
									<option value="semi_rare">Every So Often</option>
									<option value="rare">Rarely</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="difficulty_often_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
					</div>
				</div>
				
				<div id="general_sleep" class="pure-g-u">
					<div id="hours_sleep">
						<div class="lifestyle_title pure-u-1-3">How many hours do they usually sleep a night?</div>
						<div class="lifestyle_select pure-u-1-3">
							<select name="sleep_length" class="hours_life">
								<option value="two">&gt; 2</option>
								<option value="five">2 - 5</option>
								<option value="eight">6 - 8</option>
								<option value="ten">8 - 10</option>
								<option value="plus">10+</option>
							</select>
							<div class="life_select_tag">Hours</div>
						</div>
					</div>
					
					<div id="meds_sleep">
						<div class="lifestyle_title pure-u-1-3">Do they ever take medication to help them sleep?</div>
						<div class="pure-u-1-3 check">
							<input type="checkbox" name="meds" onclick="showHiddenDiv(this, 'meds_sleep_qs')">
						</div>
						<div id="meds_sleep_qs" class="hide_div">
							<div class="pure-u-1-3 lifestyle_subtitle" id="subtitle_margin_change">What medication?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="sleep_meds">
									<option value="med_one">Sleep Med 1</option>
									<option value="med_two">Sleep Med 2</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
					</div>
					
					<div id="naps">
						<div class="lifestyle_title pure-u-1-3">Do they ever take naps during the day?</div>
						<div class="pure-u-1-3 check">
							<input type="checkbox" name="naps_check" onclick="showHiddenDiv(this, 'nap_qs')">
						</div>
						<div id="nap_qs" class="hide_div">
							<div class="pure-u-1-3 lifestyle_subtitle">For how long?</div>
							<div class="lifestyle_select pure-u-1-3">
								<select name="nap_length" class="hours_life">
									<option value="less_one">&gt; 1</option>
									<option value="one_two">1 - 2</option>
									<option value="two_plus">2+</option>
								</select>
								<div class="life_select_tag">Hours</div>
							</div>
							<br>
							<div class="pure-u-1-3 lifestyle_subtitle">How often?</div>
							<div class="pure-u-1-3 life_select_box">
								<select name="time_frame">
									<option value="daily">Every day</option>
									<option value="regular">Few days a week</option>
									<option value="semi_reg">Every so often</option>
									<option value="rare">Rarely</option>
								</select>
							</div>
							<div class="pure-u-1-3 notes_column">
								<textarea name="early_waking_notes" form="lifestyle_form" rows="2"></textarea>
							</div>
						</div>
					</div>
				</div>		
			
			</div>
		</div>
	</fieldset>
	
	<fieldset id="exercise_field">
		<legend>Exercise</legend>
		
		<div id="exercise_div">
			<div class="pure-g-u">
				<div class="pure-u-1-3 title">Do you do any exercise?</div>
				<div class="pure-u-1-3 check">
					<input type="checkbox" name="difficulty_sleep_check" onclick="showHiddenDiv(this, 'does_exercise')">
				</div>
				<div id="does_exercise" class="hide_div">
					<div id="exercise_grid">
						<div class="title">What exercise do you do?</div>
						<div id="exercise_header" class="pure-g-r">
							<div class="pure-u-1-5 select_box header" style="min-width:100px; margin: 10px 5% 10px 2%">Exercise</div>
							<div class="pure-u-1-5 pure-control-group header">Still Involved?</div>
							<div class="pure-u-1-5 header" style="width:6.5%">Current hours per week</div>
							<div class="pure-u-1-5 header" style="width:7%">Previous hours per week</div>
							<div class="pure-u-1-5 header">Changed When?</div>
							<div class="pure-u-1-5 header">Reason for Change</div>
						</div>
						<div id="exercise_entry" style="min-width:800px;">
							<div class="pure-g-r">
								<div class="pure-u-1-5 select_box" style="max-width:100px; margin: 10px 5% 10px 2%;">
									<select name="activities_list">
										<option value="dancing">Dancing</option>
										<option value="football">Football</option>
										<option value="golf">Golf</option>
										<option value="swimming">Swimming</option>
										<option value="walking">Walking</option>
										<option value="yoga">Yoga/Pilates</option>
										<option value="sailing">Sailing</option>
										<option value="gym">Gym</option>
										<option value="hiking">Hiking</option>
										<option value="cycling">Cycling</option>
										<option value="other">Other..</option>
									</select>
								</div>
								<div class="pure-u-1-5 pure-control-group ex-1-5">
									<select name="still_active_check" onclick="changeExercise(this)">
										<option value="no">No</option>
										<option value="ongoing">Ongoing</option>
										<option value="decrease">Less active</option>
									</select>
								</div>
								<div class="pure-u-1-5 ex-1-5 current_hours" style="width:7%">
									<input type="text" name="current_active_hours" class="current_hours_input" style="width:4em;">
								</div>
								<div class="pure-u-1-5 ex-1-5 previous_hours" style="width:7%">
									<input type="text" name="previous_active_hours" class="prev_hours_input" style="width:4em;">
								</div>
								
								<div class="pure-u-1-5 ex-1-5 when_stopped">
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
					<input type="button" onclick="addNewExercise()" style="margin-left:2%;" class="pure-button" value="Add Exercise">
				
					<div class="collat_div">
						<input type="button" onclick="addCollatExercise()" class="pure-button lifestyle_button" value="Add Information from Collateral">
					
						<div id="collat_exercise" class="hide_div collat_life_div">
							<div id="collat_exercise_grid">
								<div class="title">What exercise do you do?</div>
								<div id="exercise_header" class="pure-g-r">
									<div class="pure-u-1-5 select_box header" style="min-width:100px; margin: 10px 5% 10px 2%">Exercise</div>
									<div class="pure-u-1-5 pure-control-group header">Still Involved?</div>
									<div class="pure-u-1-5 header" style="width:6.5%">Current hours per week</div>
									<div class="pure-u-1-5 header" style="width:7%">Previous hours per week</div>
									<div class="pure-u-1-5 header">Changed When?</div>
									<div class="pure-u-1-5 header">Reason for Change</div>
								</div>
								<div id="exercise_entry" style="min-width:800px;">
									<div class="pure-g-r">
										<div class="pure-u-1-5 select_box" style="max-width:100px; margin: 10px 5% 10px 2%;">
											<select name="activities_list">
												<option value="dancing">Dancing</option>
												<option value="football">Football</option>
												<option value="golf">Golf</option>
												<option value="swimming">Swimming</option>
												<option value="walking">Walking</option>
												<option value="yoga">Yoga/Pilates</option>
												<option value="sailing">Sailing</option>
												<option value="gym">Gym</option>
												<option value="hiking">Hiking</option>
												<option value="cycling">Cycling</option>
												<option value="other">Other..</option>
											</select>
										</div>
										<div class="pure-u-1-5 pure-control-group ex-1-5">
											<select name="still_active_check" onclick="changeExercise(this)">
												<option value="no">No</option>
												<option value="ongoing">Ongoing</option>
												<option value="decrease">Less active</option>
											</select>
										</div>
										<div class="pure-u-1-5 ex-1-5 current_hours" style="width:7%">
											<input type="text" name="current_active_hours" class="current_hours_input" style="width:4em;">
										</div>
										<div class="pure-u-1-5 ex-1-5 previous_hours" style="width:7%">
											<input type="text" name="previous_active_hours" class="prev_hours_input" style="width:4em;">
										</div>
										
										<div class="pure-u-1-5 ex-1-5 when_stopped">
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
							
							<input type="button" onclick="addNewCollatExercise()" style="margin-left:2%;" class="pure-button" value="Add Exercise">
						</div>
					</div>
				</div>
			</div>			
		</div>	
		<br>	
	</fieldset>
	
	<fieldset id="diet_field">
		<legend>Diet</legend>
		
		<div id="diet">
			<div class="title">What do you typically have for each meal on a normal day?</div>
			<div class="pure-g-u">
				<div class="pure-u-1-2 lifestyle_subtitle">Breakfast:</div>
				<div class="pure-u-1-2"><textarea name="diet_breakfast_notes" form="lifestyle_form" rows="2"></textarea></div><br>
				<div class="pure-u-1-2 lifestyle_subtitle">Lunch:</div>
				<div class="pure-u-1-2"><textarea name="diet_lunch_notes" form="lifestyle_form" rows="2"></textarea></div><br>
				<div class="pure-u-1-2 lifestyle_subtitle">Dinner:</div>
				<div class="pure-u-1-2"><textarea name="diet_dinner_notes" form="lifestyle_form" rows="2"></textarea></div><br>
			</div>
			<br>
			<div class="pure-g-u">
				<div id="miss_meals">
					<div class="pure-u-1-2 title">Do you ever miss meals?</div>
					<div class="pure-u-1-2 check">
						<input type="checkbox" name="miss_meals_check" onclick="showHiddenDiv(this, 'miss_qs')">
					</div>
					<div id="miss_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
						<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="daily">Daily</option>
							<option value="few">Few times a week</option>
							<option value="weekly">Once a week</option>
							<option value="fortnight">Once every fortnight</option>
							<option value="rare">Rarely</option>
						</select>
						</div>
					</div>
				</div>
				<div id="sweets">
					<div class="pure-u-1-2 title">Do you have a sweet tooth?</div>
					<div class="pure-u-1-2 check">
						<input type="checkbox" name="sweets_check" onclick="showHiddenDiv(this, 'sweets_qs')">
					</div>
					<div id="sweets_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_subtitle">How often do you have seet things?</div>
						<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="few_day">Few a day</option>
							<option value="daily">One a day</option>
							<option value="few">Few a week</option>
							<option value="weekly">One a week</option>
							<option value="fortnight">One every fortnight</option>
							<option value="rare">Rarely</option>
						</select>
						</div>
					</div>
				</div>
				
				<div id="fried_food">
					<div class="pure-u-1-2 title">Do you eat any fried food?</div>
					<div class="pure-u-1-2 check">
						<input type="checkbox" name="fried_check" onclick="showHiddenDiv(this, 'fried_qs')">
					</div>
					<div id="fried_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
						<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="few_day">More than once a day</option>
							<option value="daily">Once a day</option>
							<option value="few">Few times a week</option>
							<option value="weekly">Once a week</option>
							<option value="fortnight">Once every fortnight</option>
							<option value="rare">Rarely</option>
						</select>
						</div>
					</div>
				</div>
				
				<div id="takeaway">
					<div class="pure-u-1-2 title">Do you ever have a takeaway?</div>
					<div class="pure-u-1-2 check">
						<input type="checkbox" name="takeaway_check" onclick="showHiddenDiv(this, 'takeaway_qs')">
					</div>
					<div id="takeaway_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
						<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="daily">Once a day</option>
							<option value="few">Few a week</option>
							<option value="weekly">Once a week</option>
							<option value="fortnight">Once every fortnight</option>
							<option value="rare">Rarely</option>
						</select>
						</div>
					</div>
				</div>
				
				<div id="cakes_biscuits">
					<div class="pure-u-1-2 title">Do you ever have cakes or biscuits?</div>
					<div class="pure-u-1-2 check">
						<input type="checkbox" name="cakes_check" onclick="showHiddenDiv(this, 'cakes_qs')">
					</div>
					<div id="cakes_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
						<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="few_day">Few a day</option>
							<option value="daily">One a day</option>
							<option value="few">Few a week</option>
							<option value="weekly">One a week</option>
							<option value="fortnight">One every fortnight</option>
							<option value="rare">Rarely</option>
						</select>
						</div>
					</div>
				</div>
				
				<div id="fruit_veg">
					<div class="pure-u-1-2 title">How much fruit and veg do you have?</div>
					<div class="pure-u-1-2 life_select_box">
						<select name="frequency">
							<option value="five_plus">5+</option>
							<option value="four">4</option>
							<option value="three">3</option>
							<option value="two">2</option>
							<option value="one">1</option>
							<option value="week">Few a week</option>
						</select>
					</div>
				</div>
			</div>
			<div class="lifestyle_subtitle">Notes:</div>
			<textarea form="lifestyle_form" name="diet_notes" rows="3" cols="40" style="margin-left:3%;"></textarea>
			
			<div class="collat_div">
				<input type="button" onclick="addCollatDiet()" class="pure-button lifestyle_button" value="Add Information from Collateral">
			
				<div id="collat_diet" class="hide_div collat_life_div">
					<div class="title">What do you typically have for each meal on a normal day?</div>
					<div class="pure-g-u">
						<div class="pure-u-1-2 lifestyle_subtitle">Breakfast:</div>
						<div class="pure-u-1-2"><textarea name="diet_breakfast_notes" form="lifestyle_form" rows="2"></textarea></div><br>
						<div class="pure-u-1-2 lifestyle_subtitle">Lunch:</div>
						<div class="pure-u-1-2"><textarea name="diet_lunch_notes" form="lifestyle_form" rows="2"></textarea></div><br>
						<div class="pure-u-1-2 lifestyle_subtitle">Dinner:</div>
						<div class="pure-u-1-2"><textarea name="diet_dinner_notes" form="lifestyle_form" rows="2"></textarea></div><br>
					</div>
					<br>
					<div class="pure-g-u">
						<div id="miss_meals">
							<div class="pure-u-1-2 title">Do you ever miss meals?</div>
							<div class="pure-u-1-2 check">
								<input type="checkbox" name="miss_meals_check" onclick="showHiddenDiv(this, 'miss_qs')">
							</div>
							<div id="miss_qs" class="hide_div">
								<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
								<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="daily">Daily</option>
									<option value="few">Few times a week</option>
									<option value="weekly">Once a week</option>
									<option value="fortnight">Once every fortnight</option>
									<option value="rare">Rarely</option>
								</select>
								</div>
							</div>
						</div>
						<div id="sweets">
							<div class="pure-u-1-2 title">Do you have a sweet tooth?</div>
							<div class="pure-u-1-2 check">
								<input type="checkbox" name="sweets_check" onclick="showHiddenDiv(this, 'sweets_qs')">
							</div>
							<div id="sweets_qs" class="hide_div">
								<div class="pure-u-1-2 lifestyle_subtitle">How often do you have seet things?</div>
								<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="few_day">Few a day</option>
									<option value="daily">One a day</option>
									<option value="few">Few a week</option>
									<option value="weekly">One a week</option>
									<option value="fortnight">One every fortnight</option>
									<option value="rare">Rarely</option>
								</select>
								</div>
							</div>
						</div>
						
						<div id="fried_food">
							<div class="pure-u-1-2 title">Do you eat any fried food?</div>
							<div class="pure-u-1-2 check">
								<input type="checkbox" name="fried_check" onclick="showHiddenDiv(this, 'fried_qs')">
							</div>
							<div id="fried_qs" class="hide_div">
								<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
								<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="few_day">More than once a day</option>
									<option value="daily">Once a day</option>
									<option value="few">Few times a week</option>
									<option value="weekly">Once a week</option>
									<option value="fortnight">Once every fortnight</option>
									<option value="rare">Rarely</option>
								</select>
								</div>
							</div>
						</div>
						
						<div id="takeaway">
							<div class="pure-u-1-2 title">Do you ever have a takeaway?</div>
							<div class="pure-u-1-2 check">
								<input type="checkbox" name="takeaway_check" onclick="showHiddenDiv(this, 'takeaway_qs')">
							</div>
							<div id="takeaway_qs" class="hide_div">
								<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
								<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="daily">Once a day</option>
									<option value="few">Few a week</option>
									<option value="weekly">Once a week</option>
									<option value="fortnight">Once every fortnight</option>
									<option value="rare">Rarely</option>
								</select>
								</div>
							</div>
						</div>
						
						<div id="cakes_biscuits">
							<div class="pure-u-1-2 title">Do you ever have cakes or biscuits?</div>
							<div class="pure-u-1-2 check">
								<input type="checkbox" name="cakes_check" onclick="showHiddenDiv(this, 'cakes_qs')">
							</div>
							<div id="cakes_qs" class="hide_div">
								<div class="pure-u-1-2 lifestyle_subtitle">How often?</div>
								<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="few_day">Few a day</option>
									<option value="daily">One a day</option>
									<option value="few">Few a week</option>
									<option value="weekly">One a week</option>
									<option value="fortnight">One every fortnight</option>
									<option value="rare">Rarely</option>
								</select>
								</div>
							</div>
						</div>
						
						<div id="fruit_veg">
							<div class="pure-u-1-2 title">How much fruit and veg do you have?</div>
							<div class="pure-u-1-2 life_select_box">
								<select name="frequency">
									<option value="five_plus">5+</option>
									<option value="four">4</option>
									<option value="three">3</option>
									<option value="two">2</option>
									<option value="one">1</option>
									<option value="week">Few a week</option>
								</select>
							</div>
						</div>
					</div>
					<div class="lifestyle_subtitle">Notes:</div>
					<textarea form="lifestyle_form" name="diet_notes" rows="3" cols="40" style="margin-left:3%;"></textarea>
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset id="vices_field">
		<legend>Alcohol</legend>
		
		<div id="alcohol" class="pure-g-u">
			<div class="lifestyle_vice_title pure-u-1-2">Do you drink any alcohol?</div>
			<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="alcohol_check" value="alcohol" onclick="showHiddenDiv(this, 'alcohol_qs')"></div>
			
			<div id="alcohol_qs" class="hide_div">
				<div id="beer">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Beer:</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="beer_pints" onchange="updateThisUnit(this, 'beer_pint_units')"> Pints
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="beer_pint_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
					</div>
				</div>
				<div id="beer">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Beer:</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="beer_bottles" onchange="updateThisUnit(this, 'beer_bottle_units')"> Bottles
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="beer_bottle_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
					</div>
				</div>
				<div id="spirit">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Spirits:</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="spirit_glasses" onchange="updateThisUnit(this, 'spirit_units')"> Glasses
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="spirit_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
					</div>
				</div>
				<div id="wine">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Wine:</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="wine_glasses" onchange="updateThisUnit(this, 'wine_glass_units')"> Glasses
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="wine_glass_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
					</div>
				</div>
				<div id="alcopop">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Alcopop:</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="pop_bottles" onchange="updateThisUnit(this, 'pop_units')"> Bottles
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="pop_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
					</div>
				</div>
				<div id="total">
					<div class="pure-u-1-3 lifestyle_vice_subtitle">Total:</div>
					<div class="pure-u-1-3 life_select_box">
					</div>
					<div class="pure-u-1-3 life_select_box">
						<input type="text" name="total_units" placeholder="0"> Units
					</div>
				</div>
			</div>
			<textarea form="lifestyle_form" name="alcohol_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
			
			<div class="collat_div">
				<input type="button" onclick="addCollatAlcohol()" class="pure-button lifestyle_button" value="Add Information from Collateral">
			
				<div id="collat_alcohol" class="hide_div collat_life_div">
					<div class="lifestyle_vice_title pure-u-1-2">Do they drink any alcohol?</div>
					<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="alcohol_check" value="alcohol" onclick="showHiddenDiv(this, 'alcohol_collat_qs')"></div>
					
					<div id="alcohol_collat_qs" class="hide_div">
						<div id="beer">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Beer:</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="beer_pints" onchange="updateThisUnit(this, 'beer_pint_units')"> Pints
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="beer_pint_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
							</div>
						</div>
						<div id="beer">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Beer:</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="beer_bottles" onchange="updateThisUnit(this, 'beer_bottle_units')"> Bottles
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="beer_bottle_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
							</div>
						</div>
						<div id="spirit">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Spirits:</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="spirit_glasses" onchange="updateThisUnit(this, 'spirit_units')"> Glasses
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="spirit_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
							</div>
						</div>
						<div id="wine">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Wine:</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="wine_glasses" onchange="updateThisUnit(this, 'wine_glass_units')"> Glasses
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="wine_glass_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
							</div>
						</div>
						<div id="alcopop">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Alcopop:</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="pop_bottles" onchange="updateThisUnit(this, 'pop_units')"> Bottles
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="pop_units" placeholder="0" class="units_box" onchange="updateUnits()"> Units
							</div>
						</div>
						<div id="total">
							<div class="pure-u-1-3 lifestyle_vice_subtitle">Total:</div>
							<div class="pure-u-1-3 life_select_box">
							</div>
							<div class="pure-u-1-3 life_select_box">
								<input type="text" name="total_units" placeholder="0"> Units
							</div>
						</div>
					</div>
					<textarea form="lifestyle_form" name="alcohol_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
				</div>
			</div>
		</div>
		<br><br>
		<legend>Smoking</legend>
		<div id="smoking" class="pure-g-u">
			<div class="lifestyle_vice_title pure-u-1-2">Do you smoke?</div>
			<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="smoke_check" value="smoking" onclick="showHiddenDiv(this, 'smoking_qs')"></div>
			<div id="smoking_qs" class="hide_div">
				<div class="pure-u-1-2 lifestyle_vice_subtitle">How much:</div>
				<div class="pure-u-1-2 life_select_box" id="smoke_div">
					<div style="display:inline-block">
						<select name="packets" class="hours_life">
							<option value="one_five">1-5</option>
							<option value="five_ten">5-10</option>
							<option value="ten_twenty">10-20</option>
							<option value="twenty_plus">20+</option>
						</select> 
					</div>
					<div class="life_select_tag">Cigarettes per day</div>
				</div>
			</div>
			<textarea form="lifestyle_form" name="smoking_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
			
			<div class="collat_div">
				<input type="button" onclick="addCollatSmoking()" class="pure-button lifestyle_button" value="Add Information from Collateral">
			
				<div id="collat_smoking" class="hide_div collat_life_div">
					<div class="lifestyle_vice_title pure-u-1-2">Do they smoke?</div>
					<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="smoke_check" value="smoking" onclick="showHiddenDiv(this, 'smoking_collat_qs')"></div>
					<div id="smoking_collat_qs" class="hide_div">
						<div class="pure-u-1-2 lifestyle_vice_subtitle">How much:</div>
						<div class="pure-u-1-2 life_select_box" id="smoke_div">
							<div style="display:inline-block">
								<select name="packets" class="hours_life">
									<option value="one_five">1-5</option>
									<option value="five_ten">5-10</option>
									<option value="ten_twenty">10-20</option>
									<option value="twenty_plus">20+</option>
								</select> 
							</div>
							<div class="life_select_tag">Cigarettes per day</div>
						</div>
					</div>
					<textarea form="lifestyle_form" name="smoking_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
				</div>
			</div>
		</div>
		<br><br>
		<legend>Drugs</legend>
		<div id="drugs" class="pure-g-u">
			<div class="lifestyle_vice_title pure-u-1-2">Any history of taking illicit substances?</div>
			<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="drug_check" value="drugs" onclick="showHiddenDiv(this, 'drugs_qs')"></div>
			<div id="drugs_qs"></div>
			<textarea form="lifestyle_form" name="drugs_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
			
			<div class="collat_div">
				<input type="button" onclick="addCollatDrugs()" class="pure-button lifestyle_button" value="Add Information from Collateral">
			
				<div id="collat_drugs" class="hide_div collat_life_div">
					<div class="lifestyle_vice_title pure-u-1-2">Any history of taking illicit substances?</div>
					<div class="check pure-u-1-2" style="margin-left:0px;"><input type="checkbox" name="drug_check" value="drugs" onclick="showHiddenDiv(this, 'drugs_qs')"></div>
					<div id="drugs_qs"></div>
					<textarea form="lifestyle_form" name="drugs_notes" rows="3" cols="40" style="margin-left:1%;"></textarea>
				</div>
			</div>
		</div>
	</fieldset>
</form>
<br><br>
<div class="footer">
	<a href="./living_form.html">Previous Page</a>
	<a href="./memory_test.html">Next Page</a>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/lifestyle.js"></script>
</body>
</html>