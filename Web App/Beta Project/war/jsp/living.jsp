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
</head>
<body>
<h2>Living Circumstances</h2>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
    
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')" class="current_page">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')" class="current_page">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Memory Test</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
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
						<option value="alone" selected="selected">Alone</option>
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
						<option value="single">Single Storey House</option>
						<option value="two_storey">Two Storey House</option>
						<option value="apartment">Apartment</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="housetype_note" form="living_form"></textarea>
				</div>
			</div>	
			
			<div id="house_location" class="pure-g-u">
				<div class="pure-u-1-3 title">
					<span>Where is your house located?</span>
				</div>
				<div class="pure-u-1-3 homelife_select">
					<select name="house_location">
						<option value="urban">Urban</option>
						<option value="suburban">Suburban</option>
						<option value="country">Countryside</option>
					</select>
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="houselocation_note" form="living_form"></textarea>
				</div>
			</div>
	
			<div id="carer" class="pure-g-u">
				<div class="pure-u-1-3 title" style="margin-top:2px;">
					<span>Are you currently caring for a loved one or someone incapacitated?</span>
				</div>
				<div class="pure-u-1-3 check homelife_check">
					<input type="checkbox" name="carer_check">
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
					<input type="checkbox" name="home_help_check" onchange="homeHelpChanged(this)">
				</div>
				<div class="pure-u-1-3 notes_column">
					<textarea name="home_help_note" form="living_form"></textarea>
				</div>
			</div>
		</div>
		
		<div class="collat_div">
			<input type="button" onclick="addNewCollatHomeLife()" class="pure-button living-button" value="Add Information from Collateral">
			<div class="hide_div" id="collat_home_life">
				<div id="home_life_grid">
					<div id="housemates" class="pure-g-u">
						<div class="pure-u-1-3 title">
							<span>Who is currently living with them at home?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="housemates">
								<option value="alone" selected="selected">Alone</option>
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
							<span>What type of home do they live in?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="house_type">
								<option value="single">Single Storey House</option>
								<option value="two_storey">Two Storey House</option>
								<option value="apartment">Apartment</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="housetype_note" form="living_form"></textarea>
						</div>
					</div>	
					
					<div id="house_location" class="pure-g-u">
						<div class="pure-u-1-3 title">
							<span>Where is their house located?</span>
						</div>
						<div class="pure-u-1-3 homelife_select">
							<select name="house_location">
								<option value="urban">Urban</option>
								<option value="suburban">Suburban</option>
								<option value="country">Countryside</option>
							</select>
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="houselocation_note" form="living_form"></textarea>
						</div>
					</div>
			
					<div id="carer" class="pure-g-u">
						<div class="pure-u-1-3 title" style="margin-top:2px;">
							<span>Are they currently caring for a loved one or someone incapacitated?</span>
						</div>
						<div class="pure-u-1-3 check homelife_check">
							<input type="checkbox" name="carer_check">
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="carer_note" form="living_form"></textarea>
						</div>
					</div>
					
					<div id="home_help" class="pure-g-u">
						<div class="pure-u-1-3 title" style="margin-top:8px;">
							<span>Are they receiving Home Help?</span>
						</div>
						<div class="pure-u-1-3 check homelife_check">
							<input type="checkbox" name="home_help_check" onchange="homeHelpChanged(this)">
						</div>
						<div class="pure-u-1-3 notes_column">
							<textarea name="home_help_note" form="living_form"></textarea>
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
			<input type="checkbox" id="init_driving_check" onchange="showHiddenDiv(this, 'does_drive')">
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
								<input type="checkbox" name="unknown_arrival_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_severity">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_freq">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<div id="get_lost" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Getting Lost</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="lost_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_severity">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_freq">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<div id="tips_scrapes" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Involved in tips and scrapes</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="tips_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_severity">
									<option value="minor">Minor</option>
									<option value="moderate">Moderate</option>
									<option value="badly">Dangerous</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_freq">
									<option value="frequently">Frequently</option>
									<option value="semi_freq">Every So Often</option>
									<option value="rarely">Rarely</option>
									<option value="once">Once Off</option>
									<option value="never" selected="selected">Never</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
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
								<input type="checkbox" name="park_big_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="day_drive_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="known_places_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="take_friend_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="dry_run_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="use_map_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
									<option value="unsuccessful">Not successful</option>
									<option value="little_helpful">Little Helpful</option>
									<option value="helpful">Helpful</option>
									<option value="v_helpful">Very Helpful</option>
								</select>
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<textarea form="living_form" class="reason_input" name="use_map_notes" rows="2" cols="24"></textarea>
							</div>
						</div>
						<!-- Phone for Help -->
						<div id="take_phone" class="pure-g-r">
							<div class="pure-u-1-5 grid_entry grid_entry_type">Take a phone and call if you need help</div>
							<div class="pure-u-1-5 grid_entry grid_check_div">
								<input type="checkbox" name="take_phone_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
			
				<div class="collat_div">
					<input type="button" onclick="addNewCollatDriving()" class="pure-button living-button" value="Add Information from Collateral">
					<div id="collat_driving" class="hide_div">
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
									<input type="checkbox" name="unknown_arrival_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_severity">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_freq">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
								</div>
							</div>
							<div id="get_lost" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Getting Lost</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="lost_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_severity">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_freq">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
								</div>
							</div>
							<div id="tips_scrapes" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Involved in tips and scrapes</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="tips_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_severity">
										<option value="minor">Minor</option>
										<option value="moderate">Moderate</option>
										<option value="badly">Dangerous</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_freq">
										<option value="frequently">Frequently</option>
										<option value="semi_freq">Every So Often</option>
										<option value="rarely">Rarely</option>
										<option value="once">Once Off</option>
										<option value="never" selected="selected">Never</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="activity_notes" rows="2" cols="24"></textarea>
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
									<input type="checkbox" name="park_big_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
									<input type="checkbox" name="day_drive_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
								<div class="pure-u-1-5 grid_entry grid_entry_type">Only drive to places they know</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="known_places_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
								<div class="pure-u-1-5 grid_entry grid_entry_type">Takes a friend with them</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="take_friend_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
									<input type="checkbox" name="dry_run_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
									<input type="checkbox" name="use_map_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
										<option value="unsuccessful">Not successful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="use_map_notes" rows="2" cols="24"></textarea>
								</div>
							</div>
							<!-- Phone for Help -->
							<div id="take_phone" class="pure-g-r">
								<div class="pure-u-1-5 grid_entry grid_entry_type">Take a phone and call if they need help</div>
								<div class="pure-u-1-5 grid_entry grid_check_div">
									<input type="checkbox" name="take_phone_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
					</div>
				</div>
			</div><!-- Does Drive -->
		</div> <!-- Driving Grid -->
	</fieldset>
	
	<fieldset id="cooking_field">
		<legend>Cooking</legend>
		
		<div id="cooking init_grid" class="pure-form-aligned">
			<div class="routine_q_check">Do you cook for yourself?</div>
			<input type="checkbox" id="init_cooking_check" onchange="cookingCheckChanged(this, 'does_cook')">
			<br>
			<div id="does_not_cook">
				<div class="subtitle_q">Who cooks for you?</div>
				<div class="bills_select">
					<select name="cook_help" id="cook_help_select">
						<option value="family">Family</option>
						<option value="friend">Friend</option>
						<option value="takeaway">Takeaway</option>
						<option value="out">Go Out</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="cook_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			
				<div class="collat_div">
					<input type="button" onclick="addNewCollatNotCooking()" class="pure-button living-button" value="Add Information from Collateral">
					
					<div id="collat_not_cooking" class="hide_div">
						<div class="subtitle_q">Who cooks for you?</div>
						<div class="bills_select">
							<select name="cook_help" id="cook_help_select">
								<option value="family">Family</option>
								<option value="friend">Friend</option>
								<option value="takeaway">Takeaway</option>
								<option value="out">Go Out</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="cook_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					
					</div>
				</div>
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
								<input type="checkbox" name="forgot_cooking_check" class="grid_check">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="grid_freq">
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
								<input type="checkbox" name="burnt_food_check" class="grid_check">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="grid_freq">
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
								<input type="checkbox" name="started_fire_check" class="grid_check">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="grid_freq">
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
								<input type="checkbox" name="smoke_alarm_check" class="grid_check">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="grid_freq">
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
								<input type="checkbox" name="undercooked_check" class="grid_check">
							</div>
							<div class="pure-u-1-4 grid_entry grid_entry_select">
								<select name="grid_freq">
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
								<input type="checkbox" name="timer_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="reminders_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="simple_cooking_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="salad_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="go_out_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
								<input type="checkbox" name="get_help_check" class="grid_check">
							</div>
							<div class="pure-u-1-5 grid_entry grid_entry_select">
								<select name="grid_success">
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
				
				<div class="collat_div">
					<input type="button" onclick="addNewCollatCooking()" class="pure-button living-button" value="Add Information from Collateral">
					
					<div id="collat_cooking" class="hide_div">
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
										<input type="checkbox" name="forgot_cooking_check" class="grid_check">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="grid_freq">
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
										<input type="checkbox" name="burnt_food_check" class="grid_check">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="grid_freq">
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
										<input type="checkbox" name="started_fire_check" class="grid_check">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="grid_freq">
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
										<input type="checkbox" name="smoke_alarm_check" class="grid_check">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="grid_freq">
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
										<input type="checkbox" name="undercooked_check" class="grid_check">
									</div>
									<div class="pure-u-1-4 grid_entry grid_entry_select">
										<select name="grid_freq">
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
										<input type="checkbox" name="timer_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
										<input type="checkbox" name="reminders_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
										<input type="checkbox" name="simple_cooking_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
										<input type="checkbox" name="salad_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
										<input type="checkbox" name="go_out_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
										<input type="checkbox" name="get_help_check" class="grid_check">
									</div>
									<div class="pure-u-1-5 grid_entry grid_entry_select">
										<select name="grid_success">
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
				</div>
			</div>
		</div>
	</fieldset>
	
	<fieldset id="shopping_field">
		<legend>Shopping</legend>
		
		<div id="shopping init_grid" class="pure-form-aligned">
			<div class="routine_q_check">Do you shop for yourself?</div>
			<input type="checkbox" id="init_shopping_check" onchange="shoppingCheckChanged(this, 'does_shop')">
			<div id="does_not_shop">
				<div id="help_shopping">
					<div class="subtitle_q">Who helps you with your shopping?</div>
					<div class="bills_select">
						<select name="shop_help" id="shop_help_select">
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
						<option value="three_mon">3 months</option>
						<option value="six_mon">6 months</option>
						<option value="one_yr">1 year</option>
						<option value="two_yr">2 years</option>
						<option value="threep_yr">3+ years</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="shop_time_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
				<div class="collat_div">
					<input type="button" onclick="addNewCollatNotShopping()" class="pure-button living-button" value="Add Information from Collateral">
					
					<div id="collat_not_shopping" class="hide_div">
						<div id="help_shopping">
							<div class="subtitle_q">Who helps them with your shopping?</div>
							<div class="bills_select">
								<select name="shop_help" id="shop_help_select">
									<option value="family">Family</option>
									<option value="friend">Friend</option>
								</select>
							</div>
							<div class="note_area"><textarea form="living_form" name="shop_help_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
						</div>
						<div id="how_long_needed_help_shopping"></div>
						<div class="subtitle_q">How long have they had help?</div>
						<div class="bills_select">
							<select name="shop_help_time" id="shop_help_time_select">
								<option value="three_mon">3 months</option>
								<option value="six_mon">6 months</option>
								<option value="one_yr">1 year</option>
								<option value="two_yr">2 years</option>
								<option value="threep_yr">3+ years</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="shop_time_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
						
					</div>
				</div>
			</div>
			
			<div id="does_shop" class="hide_div">
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
							<input type="checkbox" name="list_check" class="grid_check">
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<select name="grid_success">
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
							<input type="checkbox" name="small_shopping_check" class="grid_check">
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<select name="grid_success">
								<option value="unsuccessful">Not Helpful</option>
								<option value="little_helpful">Little Helpful</option>
								<option value="helpful">Helpful</option>
								<option value="v_helpful">Very Helpful</option>
							</select>
						</div>
						<div class="pure-u-1-5 grid_entry grid_entry_select">
							<textarea form="living_form" class="reason_input" name="small_shopping_notes" rows="2" cols="24"></textarea>
						</div>
					</div>
				</div>
				
				<div class="collat_div">
					<input type="button" onclick="addNewCollatShopping()" class="pure-button living-button" value="Add Information from Collateral">
					
					<div id="collat_shopping" class="hide_div">
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
									<input type="checkbox" name="list_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
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
									<input type="checkbox" name="small_shopping_check" class="grid_check">
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<select name="grid_success">
										<option value="unsuccessful">Not Helpful</option>
										<option value="little_helpful">Little Helpful</option>
										<option value="helpful">Helpful</option>
										<option value="v_helpful">Very Helpful</option>
									</select>
								</div>
								<div class="pure-u-1-5 grid_entry grid_entry_select">
									<textarea form="living_form" class="reason_input" name="small_shopping_notes" rows="2" cols="24"></textarea>
								</div>
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
					<select name="bills_problem">
						<option value="forgot_payment">Forgot to Pay</option>
						<option value="income_issue">Not enough money</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="note_area"><textarea form="living_form" name="bill_problem_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
			</div>
		</div>
		
		<div class="collat_div">
			<input type="button" onclick="addNewCollatBills()" class="pure-button living-button" value="Add Information from Collateral">
			
			<div id="collat_bills" class="hide_div">
				<div id="paying_bills init_grid" class="pure-form-aligned">
					<div id="bills_method">
						<div class="subtitle_q">How do you pay your bills?</div>
						<div class="bills_select">
							<select name="bills_method">
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
							<select name="bills_problem">
								<option value="forgot_payment">Forgot to Pay</option>
								<option value="income_issue">Not enough money</option>
								<option value="other">Other</option>
							</select>
						</div>
						<div class="note_area"><textarea form="living_form" name="bill_problem_notes" rows="2" cols="24" style="margin-top: 2px;"></textarea></div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
</form>
<div class="footer">
	<a href="./events_activities.html">Previous Page</a>
	<a href="./lifestyle.html">Next Page</a>
</div>
<script src="/js/living.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>