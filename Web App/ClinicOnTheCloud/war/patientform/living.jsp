<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Living Circumstances</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/living.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure-min.css"/> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
</head>
<body>
<h2>Living Circumstances</h2>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')">Patient Concerns</span>
  <span onclick="linkClick('neuro')">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')" class="current_page">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')">Test Battery</span>
  <span onclick="linkClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/>
</div> 
</form>
<form id="living_form" class="pure-form pure-form-aligned" method="POST" action="living.do">
	<fieldset id="home_field">
		<legend>Life at Home</legend>
		
		<div id="home_life_grid">
			<div id="housemates" class="pure-g-u">
				<div class="pure-u-1-3 title">
					<span>Who is currently living with you at home?</span>
				</div>
				<div class="pure-u-1-3 homelife_select">
					<select name="housemates">
						<option value="unknown">Unknown</option>
						<option value="alone">Alone</option>
						<option value="spouse">Spouse</option>
						<option value="children">Children</option>
						<option value="family">Family</option>
						<option value="sibling">Sibling</option>
						<option value="friend">Friend</option>
						<option value="other">Other...</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="housemates_note" form="living_form"></textarea>
				</div>
			</div>	
			
			<div id="housetype" class="pure-g-u">
				<div class="pure-u-1-3 title">
					<span>What type of home do you live in?</span>
				</div>
				<div class="pure-u-1-3 homelife_select">
					<select name="house_type">
						<option value="unknown">Unknown</option>
						<option value="single">Single Storey House</option>
						<option value="two_storey">Two Storey House</option>
						<option value="apartment">Apartment</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="house_type_note" form="living_form"></textarea>
				</div>
			</div>	
			
			<div id="house_location" class="pure-g-u">
				<div class="pure-u-1-3 title">
					<span>Where is your house located?</span>
				</div>
				<div class="pure-u-1-3 homelife_select">
					<select name="house_location">
						<option value="unknown">Unknown</option>
						<option value="urban">Urban</option>
						<option value="suburban">Suburban</option>
						<option value="country">Countryside</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="house_location_note" form="living_form"></textarea>
				</div>
			</div>
	
			<div id="carer" class="pure-g-u">
				<div class="pure-u-1-3 title" style="margin-top:2px;">
					<span>Are you currently caring for a loved one or someone incapacitated?</span>
				</div>
				<div class="pure-u-1-3 check homelife_select">
					<!-- <input type="checkbox" name="carer"> -->
					<select name="is_carer" id="is_carer">
						<option value="unknown">Unknown</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="carer_note" form="living_form"></textarea>
				</div>
			</div>
			
			<div id="home_help" class="pure-g-u">
				<div class="pure-u-1-3 title" style="margin-top:8px;">
					<span>Are you receiving Home Help?</span>
				</div>
				<div class="pure-u-1-3 check homelife_check">
					<!-- <input type="checkbox" name="home_help" onchange="homeHelpChanged(this)"> -->
					<select name="getting_homehelp" id="getting_homehelp">
						<option value="unknown">Unknown</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="home_help_note" form="living_form"></textarea>
				</div>
			</div>
		</div>
		
		<div class="collat_div">
			<input type="hidden" value="hidden" id="home_collat_pressed" name="home_collat_pressed">
			<input type="button" onclick="addNewCollatHomeLife()" class="pure-button living-button" value="Add Information from Collateral">
			<div class="hide_div" id="collat_home_life">
				<div id="home_life_grid">
					<div id="housemates" class="pure-g-u">
						<div class="pure-u-1-3 title">
							<span>Who is currently living with them at home?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="housemates_collat">
						<option value="unknown">Unknown</option>
								<option value="alone">Alone</option>
								<option value="spouse">Spouse</option>
								<option value="children">Children</option>
								<option value="family">Family</option>
								<option value="sibling">Sibling</option>
								<option value="friend">Friend</option>
								<option value="other">Other...</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="housemates_note_collat" form="living_form"></textarea>
						</div>
					</div>	
					
					<div id="housetype" class="pure-g-u">
						<div class="pure-u-1-3 title">
							<span>What type of home do they live in?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="house_type_collat">
								<option value="unknown">Unknown</option>
								<option value="single">Single Storey House</option>
								<option value="two_storey">Two Storey House</option>
								<option value="apartment">Apartment</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="house_type_note_collat" form="living_form"></textarea>
						</div>
					</div>	
					
					<div id="house_location" class="pure-g-u">
						<div class="pure-u-1-3 title">
							<span>Where is their house located?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="house_location_collat">
								<option value="unknown">Unknown</option>
								<option value="urban">Urban</option>
								<option value="suburban">Suburban</option>
								<option value="country">Countryside</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="house_location_note_collat" form="living_form"></textarea>
						</div>
					</div>
			
					<div id="carer" class="pure-g-u">
						<div class="pure-u-1-3 title" style="margin-top:2px;">
							<span>Are they currently caring for a loved one or someone incapacitated?</span>
						</div>
						<div class="pure-u-1-3 check homelife_check">
							<!-- <input type="checkbox" name="carer_collat"> -->
							<select name="collat_is_carer" id="collat_is_carer">
								<option value="unknown">Unknown</option>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="carer_collat" form="living_form"></textarea>
						</div>
					</div>
					
					<div id="home_help" class="pure-g-u">
						<div class="pure-u-1-3 title" style="margin-top:8px;">
							<span>Are they receiving Home Help?</span>
						</div>
						<div class="pure-u-1-3 check homelife_check">
							<!-- <input type="checkbox" name="home_help_collat" onchange="homeHelpChanged(this)"> -->
							<select name="collat_getting_homehelp" id="collat_getting_homehelp">
								<option value="unknown">Unknown</option>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="home_help_note_collat" form="living_form"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	
	<div id="routine_title">Routines</div>

	<fieldset id="driving_field">
		<legend>Driving</legend>
		
		<div id="driving init_grid" class="pure-form-aligned">
			<div class="routine_q_check">Do you drive?</div>
			<!-- <input type="checkbox" id="init_driving_check" name="driving_check" onchange="revealDrive()"> -->
			<select name="drive" onchange="revealDrive(this)">
				<option value="unknown">unknown</option>
				<option value="no">No</option>
				<option value="yes">Yes</option>
			</select>
			
			<div id="does_drive"class="hide_div">
				<div id="driving_problems">
					<div class="routine_q">Do you ever have the following problems while driving?</div>
					<div  class="living_grid">
						<div id="driving_headers" class="pure-g-r">
							<div class="pure-u-1-5 header grid_entry_type">Incidents</div>
							<div class="pure-u-1-5 header grid_check_div"></div>
							<div class="pure-u-1-5 header grid_entry_select">Severity</div>
							<div class="pure-u-1-5 header grid_entry_select">Frequency</div>
							<div class="pure-u-1-5 header">Notes</div>
						</div>
						<div id="unknown_arrival" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Not knowing how you arrived somewhere</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="unknown_arrival" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="unknown_arrival_severity" class="hide_select">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="unknown_arrival_freq" class="hide_select">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="unknown_arrival_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<div id="get_lost" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Getting Lost</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="lost" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="lost_severity" class="hide_select">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="lost_freq" class="hide_select">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="lost_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<div id="tips_scrapes" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Involved in tips and scrapes</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="tips" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="tips_severity" class="hide_select">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="tips_freq" class="hide_select">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="tips_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="other_incidents" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Other</div>
							<div class="pure-u-1-5 grid_entry grid_other_text">
								<input type="text" name="driving_other_incident" onchange="enableRowText(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="driving_other_severity" class="hide_select">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Badly</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="driving_other_freq" class="hide_select">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="driving_other_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Driving Grid -->
				</div> <!-- Driving Problems -->
				
				<div id="driving_coping">
					<div class="routine_q">Have you tried any of the following coping Strategies?</div>
					<div class="living_grid">
						<div id="driving_c_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Success</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						<!-- Park Big Spaces Row -->
						<div id="park_big" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only park in large spaces</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="park_big" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="park_big_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="park_big_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Daytime Driving -->
						<div id="day_driving" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only drive during the day</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="day_drive" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="day_drive_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="day_drive_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Known Places -->
						<div id="known_places" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only drive to places you know</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="known_places" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="known_places_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="known_places_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Take Friend -->
						<div id="take_friend" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Take a friend with you</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="take_friend" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="take_friend_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="take_friend_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Dry Run -->
						<div id="dry_run" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Try dry runs to new places</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="dry_run" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="dry_run_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="dry_run_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Use Map -->
						<div id="use_map" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Use a map</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="map" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="use_map_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="map_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Phone for Help -->
						<div id="take_phone" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Take a phone and call if you need help</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="take_phone" class="grid_check" onclick="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="take_phone_success" class="hide_select">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="take_phone_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Living Grid Coping -->
				</div><!-- Coping Strategies Driving -->	
			</div><!-- Does Drive -->
					
			<div style="margin-top:6px">
				<textarea form="living_form" name="driving_notes" id="driving_notes" rows="3" cols="40"></textarea>
			</div>
			
			<div class="collat_div">
				<input type="hidden" value="hidden" id="collat_drive" name="collat_drive">
				<input type="button" onclick="addNewCollatDriving(this)" class="pure-button living-button" value="Add Information from Collateral">
				<div id="collat_driving" class="hide_div">
					<div class="routine_q_check">Do they drive?</div>
					<select name="drive_collat" onchange="revealDriveCollat(this)">
						<option value="no">No</option>
						<option value="yes">Yes</option>
					</select>
				
				<div id="does_drive_collat"class="hide_div">
					<div id="driving_problems">
						<div class="routine_q">Do they ever have the following problems while driving?</div>
						<div  class="living_grid">
							<div id="driving_headers" class="pure-g-r">
								<div class="pure-u-1-5 header grid_entry_type">Incidents</div>
								<div class="pure-u-1-5 header grid_check_div"></div>
								<div class="pure-u-1-5 header grid_entry_select">Severity</div>
								<div class="pure-u-1-5 header grid_entry_select">Frequency</div>
								<div class="pure-u-1-5 header">Notes</div>
							</div>
							<div id="unknown_arrival" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Not knowing how they arrived somewhere</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="unknown_arrival_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="unknown_arrival_severity_collat" class="hide_select">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="unknown_arrival_freq_collat" class="hide_select">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="unknown_arrival_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<div id="get_lost" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Getting Lost</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="lost_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="lost_severity_collat" class="hide_select">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="lost_freq_collat" class="hide_select">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="lost_notes" rows="2" cols="24"></textarea>
								</div>
							</div>
							<div id="tips_scrapes" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Involved in tips and scrapes</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="tips_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="tips_severity_collat" class="hide_select">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="tips_freq_collat" class="hide_select">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="tips_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<div id="other_incidents" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Other</div>
								<div class="pure-u-1-5 grid_entry grid_other_text">
									<input type="text" name="collat_driving_other_incident" onchange="enableRowText(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="colalt_driving_other_severity" class="hide_select">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Badly</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="collat_driving_other_freq" class="hide_select">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="collat_driving_other_notes" rows="2" cols="24"></textarea>
								</div>
							</div>
						</div> <!-- Driving Grid -->
					</div> <!-- Driving Problems -->
					
					<div id="driving_coping">
						<div class="routine_q">Have they tried any of the following coping Strategies?</div>
						<div class="living_grid">
							<div id="driving_c_headers" class="pure-g-r">
								<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
								<div class="pure-u-1-4 header grid_check_div"></div>
								<div class="pure-u-1-4 header grid_entry_select">Success</div>
								<div class="pure-u-1-4 header">Notes</div>
							</div>
							<!-- Park Big Spaces Row -->
							<div id="park_big" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Only park in large spaces</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="park_big_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="park_big_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="park_big_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Daytime Driving -->
							<div id="day_driving" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Only drive during the day</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="day_drive_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="day_drive_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="day_drive_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Known Places -->
							<div id="known_places" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Only drive to places they know</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="known_places_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="known_places_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="known_places_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Take Friend -->
							<div id="take_friend" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Takes a friend with them</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="take_friend_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="take_friend_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="take_friend_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Dry Run -->
							<div id="dry_run" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Try dry runs to new places</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="dry_run_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="dry_run_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="dry_run_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Use Map -->
							<div id="use_map" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Use a map</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="map_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="use_map_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="map_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Phone for Help -->
							<div id="take_phone" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Take a phone and call if they need help</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="take_phone_collat" class="grid_check" onclick="enableRow(this)">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="take_phone_success_collat" class="hide_select">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="take_phone_notes_collat" rows="2" cols="24"></textarea>
								</div>
							</div>
						</div> <!-- Living Grid Coping -->
					</div><!-- Coping Strategies Driving -->	
				</div>
				
				<div style="margin-top:6px">
					<textarea form="living_form" name="driving_notes_collat" id="driving_notes_collat" rows="3" cols="40"></textarea>
				</div>
				</div>
					
			</div> <!-- Driving Grid -->
	
		</div>
	</fieldset>
	
	<fieldset id="cooking_field">
		<legend>Cooking</legend>
		
		<div id="cooking init_grid" class="pure-form-aligned">
			<div class="routine_q_check">Do you cook for yourself?</div>
			<!-- <input type="checkbox" id="init_cooking_check" onchange="cookingCheckChanged(this, 'does_cook')"> -->
			<select name="cook" onchange="cookingCheckChanged(this, 'does_cook')">
				<option value="unknown">Unknown</option>
				<option value="no">No</option>
				<option value="yes">Yes</option>
			</select>
			<br>
			<div id="does_not_cook">
				<div class="subtitle_q">Who cooks for you?</div>
				<div class="bills_select">
					<select name="cook_help" id="cook_help_select">
						<option value="unknown">Unknown</option>
						<option value="family">Family</option>
						<option value="friend">Friend</option>
						<option value="takeaway">Takeaway</option>
						<option value="out">Go Out</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="cook_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
			
			<div id="does_cook" class="hide_div">
				
				<div id="cooking_problems">
					<div class="routine_q">Do you ever have the following problems with cooking?</div>
					<div  class="living_grid">
						<div id="driving_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Incidents</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Frequency</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						
						<div id="forgot_cooking" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Put something on and forgotten about it</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="forgot_cooking" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="forgot_cooking_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="forgot_cooking_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="burnt_food" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Burnt something</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="burnt_food" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="burnt_food_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="burnt_food_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="started_fire" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Set something on fire</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="started_fire" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="started_fire_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="started_fire_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="smoke_alarm" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Set off smoke alarm</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="smoke_alarm" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="smoke_alarm_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="smoke_alarm_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="undercooked" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Undercooked food</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="undercooked" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="undercooked_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="undercooked_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="other_incidents" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Other</div>
							<div class="pure-u-1-5 grid_entry grid_other_text">
								<input type="text" name="cooking_other_incident" onchange="enableRowText(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="cooking_other_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="cooking_other_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Cooking Grid -->
				</div> <!-- Cooking Problems -->
				<div id="cooking_coping">
					<div class="routine_q">Have you tried any of the following coping Strategies?</div>
					<div class="living_grid">
						<div id="driving_c_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Success</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						<!-- Use Timer -->
						<div id="timer" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Use a timer</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="timer" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="timer_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="timer_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Someone Reminds them -->
						<div id="reminders" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone remind you</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="reminders" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="reminders_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="reminders_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Keep Cooking Simple -->
						<div id="simple_cooking" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Keep cooking simple</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="simple_cooking" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="simple_cooking_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="simple_cooking_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Only Salad -->
						<div id="salad" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only eat food that does not require cooking</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="salad" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="salad_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="salad_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Go Out -->
						<div id="go_out" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Go out for food</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="go_out" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="go_out_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="go_out_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Get Help -->
						<div id="get_help" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone help you</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="get_help" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="get_help_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="get_help_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Coping Grid -->
				</div><!-- Coping Strategies for Cooking -->
			</div>
			<div><textarea form="living_form" name="cooking_notes" rows="3" cols="40" style="margin-top: 2px;margin-left:2%;"></textarea></div>
		</div>
		
		<input type="button" onclick="addNewCollatCooking(this)" class="pure-button living-button collat_button" value="Add Information from Collateral">
		<div id="collat_cooking_div" class="hide_div">
			<div class="routine_q_check">Do they cook for themselves?</div>
			<!-- <input type="checkbox" id="init_cooking_check" onchange="cookingCheckChanged(this, 'does_cook')"> -->
			<select name="cooking_collat" onchange="cookingCheckChangedCollat(this)">
				<option value="no">No</option>
				<option value="yes">Yes</option>
			</select>
			<br>
			<div id="does_not_cook_collat">
				<div class="subtitle_q">Who cooks for them?</div>
				<div class="bills_select">
					<select name="cook_help_collat" id="cook_help_select_collat">
						<option value="family">Family</option>
						<option value="friend">Friend</option>
						<option value="takeaway">Takeaway</option>
						<option value="out">Go Out</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="cook_help_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
				<div><textarea form="living_form" name="cooking_notes_collat" rows="3" cols="40" style="margin-top: 2px;margin-left:2%;"></textarea></div>
			</div>
			
			<div id="does_cook_collat" class="hide_div">
				
				<div id="cooking_problems">
					<div class="routine_q">Do they ever have the following problems with cooking?</div>
					<div  class="living_grid">
						<div id="driving_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Incidents</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Frequency</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						
						<div id="forgot_cooking" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Put something on and forgotten about it</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="forgot_cooking" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="forgot_cooking_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="forgot_cooking_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="burnt_food" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Burnt something</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="burnt_food" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="burnt_food_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="burnt_food_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="started_fire" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Set something on fire</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="started_fire" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="started_fire_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="started_fire_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="smoke_alarm" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Set off smoke alarm</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="smoke_alarm" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="smoke_alarm_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="smoke_alarm_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="undercooked" class="pure-g-r">
							<div class="pure-u-1-4 grid_entry grid_entry_type">Undercooked food</div>
							<div class="pure-u-1-4 grid_entry grid_check_div">
								<input type="checkbox" name="undercooked" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="undercooked_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="undercooked_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<div id="other_incidents" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Other</div>
							<div class="pure-u-1-5 grid_entry grid_other_text">
								<input type="text" name="collat_cooking_other_incident" onchange="enableRowText(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="collat_cooking_other_freq" class="hide_select">
									<option value="frequently">Quite Often</option>
									<option value="semi_freq">Few Times</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="collat_cooking_other_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Cooking Grid -->
				</div> <!-- Cooking Problems -->
				<div id="cooking_coping">
					<div class="routine_q">Have they tried any of the following coping Strategies?</div>
					<div class="living_grid">
						<div id="driving_c_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Success</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						<!-- Use Timer -->
						<div id="timer" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Use a timer</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="timer" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="timer_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="timer_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Someone Reminds them -->
						<div id="reminders" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone remind them</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="reminders" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="reminders_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="reminders_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Keep Cooking Simple -->
						<div id="simple_cooking" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Keep cooking simple</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="simple_cooking" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="simple_cooking_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="simple_cooking_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Only Salad -->
						<div id="salad" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only eat food that does not require cooking</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="salad" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="salad_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="salad_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Go Out -->
						<div id="go_out" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Go out for food</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="go_out" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="go_out_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="go_out_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Get Help -->
						<div id="get_help" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone help them</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="get_help" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="get_help_success" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="get_help_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div> <!-- Coping Grid -->
				</div><!-- Coping Strategies for Cooking -->
					<div id="collat_cooking" class="hide_div">
						<input type="hidden" value="hidden" id="collat_cook" name="collat_cook">
						<div id="cooking_problems">
							<div class="routine_q">Do you ever have the following problems with cooking?</div>
							<div  class="living_grid">
								<div id="driving_headers" class="pure-g-r">
									<div class="pure-u-1-4 header grid_entry_type">Incidents</div>
									<div class="pure-u-1-4 header grid_check_div"></div>
									<div class="pure-u-1-4 header grid_entry_select">Frequency</div>
									<div class="pure-u-1-4 header">Notes</div>
								</div>
								
								<div id="forgot_cooking" class="pure-g-r">
									<div class="pure-u-1-4 grid_entry grid_entry_type">Put something on and forgotten about it</div>
									<div class="pure-u-1-4 grid_entry grid_check_div">
										<input type="checkbox" name="forgot_cooking_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="forgot_cooking_freq_collat" class="hide_select">
											<option value="frequently">Quite Often</option>
											<option value="semi_freq">Few Times</option>
											<option value="rarely">Rarely</option>
											<option value="once">Once Off</option>
										</select>
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="forgot_cooking_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<div id="burnt_food" class="pure-g-r">
									<div class="pure-u-1-4 grid_entry grid_entry_type">Burnt something</div>
									<div class="pure-u-1-4 grid_entry grid_check_div">
										<input type="checkbox" name="burnt_food_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="burnt_food_freq_collat" class="hide_select">
											<option value="frequently">Quite Often</option>
											<option value="semi_freq">Few Times</option>
											<option value="rarely">Rarely</option>
											<option value="once">Once Off</option>
										</select>
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="burnt_food_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<div id="started_fire" class="pure-g-r">
									<div class="pure-u-1-4 grid_entry grid_entry_type">Set something on fire</div>
									<div class="pure-u-1-4 grid_entry grid_check_div">
										<input type="checkbox" name="started_fire_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="started_fire_freq_collat" class="hide_select">
											<option value="frequently">Quite Often</option>
											<option value="semi_freq">Few Times</option>
											<option value="rarely">Rarely</option>
											<option value="once">Once Off</option>
										</select>
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="started_fire_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<div id="smoke_alarm" class="pure-g-r">
									<div class="pure-u-1-4 grid_entry grid_entry_type">Set off smoke alarm</div>
									<div class="pure-u-1-4 grid_entry grid_check_div">
										<input type="checkbox" name="smoke_alarm_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="smoke_alarm_freq_collat" class="hide_select">
											<option value="frequently">Quite Often</option>
											<option value="semi_freq">Few Times</option>
											<option value="rarely">Rarely</option>
											<option value="once">Once Off</option>
										</select>
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="smoke_alarm_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<div id="undercooked" class="pure-g-r">
									<div class="pure-u-1-4 grid_entry grid_entry_type">Undercooked food</div>
									<div class="pure-u-1-4 grid_entry grid_check_div">
										<input type="checkbox" name="undercooked_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="undercooked_freq_collat" class="hide_select">
											<option value="frequently">Quite Often</option>
											<option value="semi_freq">Few Times</option>
											<option value="rarely">Rarely</option>
											<option value="once">Once Off</option>
										</select>
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="undercooked_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
							</div> <!-- Cooking Grid -->
						</div> <!-- Cooking Problems -->
						<div id="cooking_coping">
							<div class="routine_q">Have you tried any of the following coping Strategies?</div>
							<div class="living_grid">
								<div id="driving_c_headers" class="pure-g-r">
									<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
									<div class="pure-u-1-4 header grid_check_div"></div>
									<div class="pure-u-1-4 header grid_entry_select">Success</div>
									<div class="pure-u-1-4 header">Notes</div>
								</div>
								<!-- Use Timer -->
								<div id="timer" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Use a timer</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="timer_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="timer_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="timer_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<!-- Someone Reminds them -->
								<div id="reminders" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone remind you</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="reminders_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="reminders_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="reminders_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<!-- Keep Cooking Simple -->
								<div id="simple_cooking" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Keep cooking simple</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="simple_cooking_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="simple_cooking_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="simple_cooking_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<!-- Only Salad -->
								<div id="salad" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Only eat food that does not require cooking</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="salad_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="salad_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="salad_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<!-- Go Out -->
								<div id="go_out" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Go out for food</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="go_out_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="go_out_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="go_out_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
								
								<!-- Get Help -->
								<div id="get_help" class="pure-g-r">
									<div class="pure-u-1-5 grid_entry grid_entry_type">Have someone help you</div>
									<div class="pure-u-1-5 grid_entry grid_check_div">
										<input type="checkbox" name="get_help_collat" class="grid_check" onchange="enableRow(this)">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="get_help_success_collat" class="hide_select">
											<option value="unsuccessful">Not Helpful</option>
											<option value="little_helpful">Little Helpful</option>
											<option value="helpful">Helpful</option>
											<option value="v_helpful">Very Helpful</option>
										</select>
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<textarea form="living_form" class="reason_input" name="get_help_notes_collat" rows="2" cols="24"></textarea>
									</div>
								</div>
							</div> <!-- Coping Grid -->
						</div><!-- Coping Strategies for Cooking -->
					</div>
				</div>
			</div>
	</fieldset>
	
	<fieldset id="shopping_field">
		<legend>Shopping</legend>
		
		<div id="shopping init_grid" class="pure-form-aligned">
			<div class="routine_q_check">Do you shop for yourself?</div>
			<!-- <input type="checkbox" id="init_shopping_check" onchange="shoppingCheckChanged(this, 'does_shop')"> -->
			
			<select name="shop" onchange="shoppingCheckChanged(this, 'does_shop')">
				<option value="unknown">Unknown</option>
				<option value="no">No</option>
				<option value="yes">Yes</option>
			</select>
			
			<div id="does_not_shop">
				<div id="help_shopping">
					<div class="subtitle_q">Who helps you with your shopping?</div>
					<div class="bills_select">
						<select name="shop_help" id="shop_help_select">
							<option value="unknown">Unknown</option>
							<option value="family">Family</option>
							<option value="friend">Friend</option>
						</select>
					</div>
					<div class="note_area"><textarea form="living_form" name="shop_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
				</div>
				<div id="how_long_needed_help_shopping"></div>
				<div class="subtitle_q">How long have you had help?</div>
				<div class="bills_select">
					<select name="shop_help_time" id="shop_help_time_select">
						<option value="unknown">Unknown</option>
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_yr">2 years</option>
						<option value="threep_yr">3+ years</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="shop_time_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
			
			<div id="does_shop" class="hide_div">
				<div class="subtitle_q">Have you been finding it tougher to cook recently?</div>
				<div class="bills_select">
					<select name="shopping_tougher" id="shop_tough_select">
						<option value="unknown">Unknown</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="shop_tough_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
				
				<div class="routine_q">Do you use any of the following coping Strategies?</div>
				<div class="living_grid">
					<div id="shopping_c_headers" class="pure-g-r">
						<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
						<div class="pure-u-1-4 header grid_check_div"></div>
						<div class="pure-u-1-4 header grid_entry_select">Success</div>
						<div class="pure-u-1-4 header">Notes</div>
					</div>
					<!-- List -->
					<div id="list" class="pure-g-r">
						<div class="pure-u-1-5 grid_entry grid_entry_type">Use a List</div>
						<div class="pure-u-1-5 grid_entry grid_check_div">
							<input type="checkbox" name="list_check" class="grid_check" onchange="enableRow(this)">
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<select name="list_success" class="hide_select">
								<option value="unsuccessful">Not Helpful</option>
								<option value="little_helpful">Little Helpful</option>
								<option value="helpful">Helpful</option>
								<option value="v_helpful">Very Helpful</option>
							</select>
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<textarea form="living_form" class="reason_input" name="list_notes" rows="2" cols="24"></textarea>
						</div>
					</div>					
					<!-- Small Shopping -->
					<div id="small_shopping" class="pure-g-r">
						<div class="pure-u-1-5 grid_entry grid_entry_type">Only do day to day shopping</div>
						<div class="pure-u-1-5 grid_entry grid_check_div">
							<input type="checkbox" name="small_shop_check" class="grid_check" onchange="enableRow(this)">
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<select name="small_shop_success" class="hide_select">
								<option value="unsuccessful">Not Helpful</option>
								<option value="little_helpful">Little Helpful</option>
								<option value="helpful">Helpful</option>
								<option value="v_helpful">Very Helpful</option>
							</select>
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<textarea form="living_form" class="reason_input" name="small_shop_notes" rows="2" cols="24"></textarea>
						</div>
					</div>
				</div>
			</div>			
		</div>
		
		<div class="collat_div">
			<input type="hidden" value="hidden" id="collat_shop" name="collat_shop">
			<input type="hidden" id="shopping_not_collat" name="shopping_not_collat" value="hidden">
			<input type="button" onclick="addCollatShopping(this)" class="pure-button living-button" value="Add Information from Collateral">
					
			<div id="shopping_collat_grid" class="hide_div">
				<div class="routine_q_check">Do they shop for themselves?</div>
				<select name="shopping_collat" onchange="shoppingCheckChangedCollat(this)">
					<option value="unknown">Unknown</option>
					<option value="no">No</option>
					<option value="yes">Yes</option>
				</select>
				
				<div id="does_not_shop_collat">
					<div id="help_shopping">
						<div class="subtitle_q">Who helps them with their shopping?</div>
						<div class="bills_select">
							<select name="shop_help_collat" id="shop_help_select">
								<option value="family">Family</option>
								<option value="friend">Friend</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="shop_help_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					</div>
					<div id="how_long_needed_help_shopping"></div>
					<div class="subtitle_q">How long have they had help?</div>
					<div class="bills_select">
						<select name="shop_help_time_collat" id="shop_help_time_select">
							<option value="three_mon">3 months</option>
							<option value="six_mon">6 months</option>
							<option value="one_yr">1 year</option>
							<option value="two_yr">2 years</option>
							<option value="threep_yr">3+ years</option>
						</select>
					</div>
					<div class="note_area"><textarea form="living_form" name="shop_time_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					
				</div>
				
				<div id="does_shop_collat" class="hide_div">
					<div class="subtitle_q">Have they been finding it tougher to cook recently?</div>
					<div class="bills_select">
						<select name="shopping_tougher_collat" id="shop_tough_select">
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
					<div class="note_area"><textarea form="living_form" name="shop_tough_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					
					<div class="routine_q">Do they use any of the following coping Strategies?</div>
					<div class="living_grid">
						<div id="shopping_c_headers" class="pure-g-r">
							<div class="pure-u-1-4 header grid_entry_type">Strategy</div>
							<div class="pure-u-1-4 header grid_check_div"></div>
							<div class="pure-u-1-4 header grid_entry_select">Success</div>
							<div class="pure-u-1-4 header">Notes</div>
						</div>
						<!-- List -->
						<div id="list" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Use a List</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="list_check_collat" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="list_success_collat" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="list_notes_collat" rows="2" cols="24"></textarea>
							</div>
						</div>
						
						<!-- Small Shopping -->
						<div id="small_shopping" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Only do day to day shopping</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="small_shop_check_collat" class="grid_check" onchange="enableRow(this)">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="small_shop_success_collat" class="hide_select">
									<option value="unsuccessful">Not Helpful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="small_shop_notes_collat" rows="2" cols="24"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset id="bills_field">
		<legend>Paying Bills</legend>
		
		<div id="paying_bills init_grid" class="pure-form-aligned">
			<div id="bills_method">
				<div class="subtitle_q">How do you pay your bills?</div>
				<div class="bills_select">
					<select name="bills_method">
						<option value="unknown">Unknown</option>
						<option value="direct_debit">Direct Debit</option>
						<option value="post_office">Post Office</option>
						<option value="bank">Bank</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="bill_method_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
			
			<div id="bills_help">
				<div class="subtitle_q">Does anybody help you?</div>
				<div class="bills_select">
					<select name="bills_help">
						<option value="unknown">Unknown</option>
						<option value="nobody">No</option>
						<option value="family">Family Member</option>
						<option value="friend">Friend</option>
						<option value="home_help">Home Help</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="bill_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
			
			<div id="bills_problem">
				<div class="subtitle_q">Have you ever had trouble with bills?</div>
				<div class="bills_select">
					<select name="bill_problems">
						<option value="unknown">Unknown</option>
						<option value="forgot_payment">Forgot to Pay</option>
						<option value="income_issue">Not enough money</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="bill_problem_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
		</div>
		
		<div class="collat_div">
			<input type="hidden" value="hidden" id="collat_bills" name="collat_bills">
			<input type="hidden" id="bills_collat" name="bills_collat" value="hidden">
			<input type="button" onclick="addNewCollatBills(this)" class="pure-button living-button" value="Add Information from Collateral">
			
			<div id="collat_bill" class="hide_div">
				<div id="paying_bills init_grid" class="pure-form-aligned">
					<div id="bills_method">
						<div class="subtitle_q">How do you pay your bills?</div>
						<div class="bills_select">
							<select name="bills_method_collat">
								<option value="not_sure">Not Sure</option>
								<option value="direct_debit">Direct Debit</option>
								<option value="post_office">Post Office</option>
								<option value="bank">Bank</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="bills_method_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					</div>
					
					<div id="bills_help">
						<div class="subtitle_q">Does anybody help you?</div>
						<div class="bills_select">
							<select name="bills_help_collat">
								<option value="nobody">No</option>
								<option value="family">Family Member</option>
								<option value="friend">Friend</option>
								<option value="home_help">Home Help</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="bills_help_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					</div>
					
					<div id="bills_problem">
						<div class="subtitle_q">Have you ever had trouble with bills?</div>
						<div class="bills_select">
							<select name="bill_problems_collat">
								<option value="no_problems">No Problems</option>
								<option value="forgot_payment">Forgot to Pay</option>
								<option value="income_issue">Not enough money</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="bill_problems_notes_collat" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<input type="hidden" id="hiddenID" name="hiddenID"/>
</form>
<div class="footer">
	<span onclick="submitPage()">Submit and Continue</span>
</div>
<div id="dialog-confirm" title="Submit Page?" style="display:none">
  <p><span class="ui-icon" style="float:left; margin:0 7px 20px 0;"></span>Do you want to submit this page? (If you leave, the page will need to be filled in again)</p>
</div>

<script src="/js/living.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script>
	function submitPage() {
		$("#living_form").submit();
	}
	
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
</script>
</body>
</html>