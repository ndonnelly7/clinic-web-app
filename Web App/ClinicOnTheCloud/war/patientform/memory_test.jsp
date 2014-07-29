<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Memory Test</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/> 
<link rel="stylesheet" href="/css/memory.css" type="text/css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
</head>
<body>
<span onclick="homeFromForm()" id="home_link_span">Return to Homepage</span>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
  <span onclick="linkClick('personal_details')">Patient Information</span>
  <span onclick="linkClick('history')">Patient History</span>
  <span onclick="linkClick('medical')">GP Information</span>
  <span onclick="linkClick('concerns')">Patient Concerns</span>
  <span onclick="linkClick('neuro')">Neuro History</span>
  <span onclick="linkClick('events_activities')">Events and Activities</span>
  <span onclick="linkClick('living')">Living Situation</span>
  <span onclick="linkClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="linkClick('memory_test')" class="current_page">Test Battery</span>
  <span onclick="linkClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/> 
</div> 
</form>

<form id="memory_form" class="pure-form pure-form-aligned" method="POST" action="memory.do">

<input type="button" value="HADS Test" onclick="revealHADS(this)" class="test_button"/>
<fieldset id="hads_form" class="hide_div">
	<legend>Hospital Anxiety and Depression Scale</legend>
	
	<div class="q_div pure-g-r">	
		<div class="mem_num pure-u-1-8">1. </div>
		<div class="mem_label pure-u-1-2">I feel tense or wound up:</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_wound_up" id="wound_up" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Most of the time</option>
				<option value="2">A lot of the time</option>
				<option value="1">Occasionally</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">2. </div>
		<div class="mem_label pure-u-1-2">I still enjoy the things I used to:</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_enjoy" id="enjoy" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Definitely as much</option>
				<option value="1">Not quite so much</option>
				<option value="2">Only a little</option>
				<option value="3">Hardly at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">3. </div>
		<div class="mem_label pure-u-1-2">I get a sort of frightened feeling as if something awful is about to happen</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_frightened" id="frightened" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very definitely and quite badly</option>
				<option value="2">Yes, but not too badly</option>
				<option value="1">A little, but it doesn't worry me</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">4. </div>
		<div class="mem_label pure-u-1-2">I can laugh and see the funny side of things</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_funny" id="funny" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">As much as I always could</option>
				<option value="1">Not quite so much now</option>
				<option value="2">Definitely not so much now</option>
				<option value="3">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">5. </div>
		<div class="mem_label pure-u-1-2">Worrying thoughts go through my mind</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_worry" id="worry" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">A great deal of the time</option>
				<option value="2">A lot of the time</option>
				<option value="1">From time to time but not too often</option>
				<option value="0">Only occasionally</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">6. </div>
		<div class="mem_label pure-u-1-2">I feel cheerful</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_cheerful" id="cheerful" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Not at all</option>
				<option value="2">Not often</option>
				<option value="1">Sometimes</option>
				<option value="0">Most of the time</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">7. </div>
		<div class="mem_label pure-u-1-2">I can sit at ease and feel relaxed</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_relaxed" id="relaxed" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Definitely</option>
				<option value="1">Usually</option>
				<option value="2">Not often</option>
				<option value="3">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">8. </div>
		<div class="mem_label pure-u-1-2">I feel as if I am slowed down</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_slowed" id="slowed" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Nearly all the time</option>
				<option value="2">Very often</option>
				<option value="1">Sometimes</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">9. </div>
		<div class="mem_label pure-u-1-2">I get a sort of frightened feeling like 'butterflies' in the stomach</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_butterflies" id="butterflies" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Not at all</option>
				<option value="1">Occasionally</option>
				<option value="2">Quite often</option>
				<option value="3">Very often</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">10. </div>
		<div class="mem_label pure-u-1-2">I have lost interest in my appearance</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_appearance" id="appearance" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Definitely</option>
				<option value="2">I don't take so much care as I should</option>
				<option value="1">I may not take quite as much care</option>
				<option value="0">I take as much care as ever</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">11. </div>
		<div class="mem_label pure-u-1-2">I feel restless as if I have to be on the move</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_restless" id="restless" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very much indeed</option>
				<option value="2">Quite a lot</option>
				<option value="1">Not very much</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">12. </div>
		<div class="mem_label pure-u-1-2">I look forward with enjoyment to things</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_enjoyment" id="enjoyment" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">As much as I ever did</option>
				<option value="1">Rather less than I used to</option>
				<option value="2">Definitely less than I used to</option>
				<option value="3">Hardly at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">13. </div>
		<div class="mem_label pure-u-1-2">I get sudden feelings of panic</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_panic" id="panic" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very often indeed</option>
				<option value="2">Quite often</option>
				<option value="1">Not very often</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">14. </div>
		<div class="mem_label pure-u-1-2">I can enjoy a good book or radio or TV programme</div>
		<div class="pure-u-1-2 h_select">
			<select name="hads_pasttime" id="pasttime" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Often</option>
				<option value="1">Sometimes</option>
				<option value="2">Not often</option>
				<option value="3">Very seldom</option>
			</select>
		</div>
	</div>
	<input type="button" value="Submit HADS Results" onclick="runHADSEvaluation()" style="margin-bottom:6px;"/>
	<div class="pure-g-r" id="result_hads_div" class="hide_div">
		<div class="result_title pure-u-1-2">HADS Result</div>
		<input type="text" id="hads_result" name="hads_total" style="width:3em; margin-top:-4px;" readonly>
		<span id="hads_result_text" class="pure-u-1-2"></span>
	</div>
</fieldset>

<input type="button" value="GDS Test" onclick="revealGDS(this)" class="test_button"/>
<fieldset id="gds_form" class="hide_div">
	<legend>Geriatric Depression Scale</legend>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">1. </div>
		<div class="mem_label pure-u-1-2">Are you basically satisfied with your life?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_satisfied" id="satisfied" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">2. </div>
		<div class="mem_label pure-u-1-2">Have you dropped many of your activities and interests?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_dropping_interests" id="dropped_interests" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">3. </div>
		<div class="mem_label pure-u-1-2">Do you feel that your life is empty?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_life_empty" id="life_empty" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">4. </div>
		<div class="mem_label pure-u-1-2">Do you often get bored?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_bored" id="bored" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">5. </div>
		<div class="mem_label pure-u-1-2">Are you hopeful about the future?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_future" id="future" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">6. </div>
		<div class="mem_label pure-u-1-2">Are you bothered by thoughts you can't get out of your head?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_thoughts" id="thoughts" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">7. </div>
		<div class="mem_label pure-u-1-2">Are you in good spirits most of the time?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_spirits" id="spirits" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">8. </div>
		<div class="mem_label pure-u-1-2">Are you afraid that something bad is going to happen to you?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_afraid" id="afraid" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">9. </div>
		<div class="mem_label pure-u-1-2">Do you feel happy most of the time?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_happy" id="happy" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">10. </div>
		<div class="mem_label pure-u-1-2">Do you often feel helpless?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_helpless" id="helpless" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">11. </div>
		<div class="mem_label pure-u-1-2">Do you often get restless and figdety?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_fidgety" id="figdety" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">12. </div>
		<div class="mem_label pure-u-1-2">Do you prefer to stay at home, rather than going out and doing new things?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_stay_home" id="stay_home" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">13. </div>
		<div class="mem_label pure-u-1-2">Do you frequently worry about the future?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_future_worry" id="future_worry" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">14. </div>
		<div class="mem_label pure-u-1-2">Do you feel you have more problems with memory that most people?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_mem_problems" id="mem_problems" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">15. </div>
		<div class="mem_label pure-u-1-2">Do you think it is wonderful to be alive?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_alive" id="alive" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">16. </div>
		<div class="mem_label pure-u-1-2">Do you feel downhearted and blue?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_blue" id="blue" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">17. </div>
		<div class="mem_label pure-u-1-2">Do you feel pretty worthless the way you are now?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_worthless" id="worthless" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">18. </div>
		<div class="mem_label pure-u-1-2">Do you worry a lot about the past?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_past_worry" id="past_worry" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">19. </div>
		<div class="mem_label pure-u-1-2">Do you find life very exciting?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_exciting" id="exciting" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">20. </div>
		<div class="mem_label pure-u-1-2">Is it hard for you to get started on new projects?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_new_projects" id="new_projects" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">21. </div>
		<div class="mem_label pure-u-1-2">Do you feel full of energy?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_energy" id="energy" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">22. </div>
		<div class="mem_label pure-u-1-2">Do you feel that your situation is hopeless?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_hopeless" id="hopeless" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">23. </div>
		<div class="mem_label pure-u-1-2">Do you think that most people are better off then you are?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_better_off" id="better_off" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">24. </div>
		<div class="mem_label pure-u-1-2">Do you frequently get upset over little things?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_little_things" id="little_things" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">25. </div>
		<div class="mem_label pure-u-1-2">Do you frequently feel like crying?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_crying" id="crying" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">26. </div>
		<div class="mem_label pure-u-1-2">Do you have trouble concentrating?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_concentrating" id="concentrating" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">27. </div>
		<div class="mem_label pure-u-1-2">Do you enjoy getting up in the morning?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_morning" id="morning" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">28. </div>
		<div class="mem_label pure-u-1-2">Do you prefer to to avoid social occasions?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_social_occasions" id="social_occasions" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="1">Yes</option>
				<option value="0">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">29. </div>
		<div class="mem_label pure-u-1-2">Is it easy for you to make decisions?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_decisions" id="decisions" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_num pure-u-1-8">30. </div>
		<div class="mem_label pure-u-1-2">Is your mind as clear as it used to be?</div>
		<div class="pure-u-1-2 g_select">
			<select name="gds_clear_mind" id="clear_mind" class="gds_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Yes</option>
				<option value="1">No</option>
			</select>
		</div>
	</div>
	
	<input type="button" value="Submit GDS Results" onclick="runGDSEvaluation()" style="margin-bottom:6px;"/>
	<div class="pure-g-r" id="result_gds_div" class="hide_div">
		<div class="result_title pure-u-1-2">GDS Result</div>
		<input type="text" id="gds_result" name="gds_total" style="width:3em; margin-top:-4px;" readonly>
		<span id="gds_result_text" class="pure-u-1-2"></span>
	</div>
</fieldset>

<input type="button" value="MOCA Test" onclick="revealMOCA(this)" class="test_button"/>
<fieldset id="moca" class="hide_div">
	<legend>The Montreal Cognitive Assessment (MOCA)</legend>
	<a href="/tests/MOCA_1.pdf" class="dl_link" download="MOCA1.pdf">MOCA Version 1</a>
	<a href="/tests/MOCA_2.pdf" class="dl_link" download="MOCA2.pdf">MOCA Version 2</a>
	<a href="/tests/MOCA_3.pdf" class="dl_link" download="MOCA3.pdf">MOCA Version 3</a>
	<a href="/tests/MOCA_Blind.pdf" class="dl_link" download="MOCAB.pdf">MOCA Version for Blind</a>
	
	<div id="moca_general">
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Visuospatial/Executive Score</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="visuo" name="moca_visuo" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/5</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Naming</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="naming" name="moca_naming" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/3</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Attention</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="attention" name="moca_attention" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/6</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Language</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="language" name="moca_language" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/3</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Abstraction</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="abstract" name="moca_abstraction" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/2</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Delayed Recall</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="recall" name="moca_recall" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/5</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Orientation</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="orientation" name="moca_orientation" class="moca_input" onchange="moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/6</span>
		</div>
		<hr width="20%" Align="Left" NOSHADE>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Total</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="moca_total" name="moca_total" class="moca_input" readonly>
			</div>
			<span class="post_input pure-u-1-8">/30</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Upload Test Sheet</div>
			<div class="pure-u-1-2">
				<input type="file" name="MOCA_Upload" accept="image/*|application/pdf">
			</div>
		</div>
		<div class="m_div pure-g-r">
			<input type="button" onclick="changeMOCAForm('general')" value="Form for Blind Patients">
		</div>
	</div>
	
	<div id="moca_blind" class="hide_div">
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Attention</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_attention" name="b_attention" class="moca_input" onchange="b_moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/6</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Language</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_language" name="b_language" class="moca_input" onchange="b_moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/3</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Abstraction</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_abstract" name="b_abstract" class="moca_input" onchange="b_moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/2</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Delayed Recall</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_recall" name="b_recall" class="moca_input" onchange="b_moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/5</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Orientation</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_orientation" name="b_orientation" class="moca_input" onchange="b_moca_change(this)">
			</div>
			<span class="post_input pure-u-1-8">/6</span>
		</div>
		<hr width="20%" Align="Left" NOSHADE>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Total</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="b_moca_total" name="b_moca_total" class="moca_input" readonly>
			</div>
			<span class="post_input pure-u-1-8">/22</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Upload Test Sheet</div>
			<div class="pure-u-1-2">
				<input type="file" name="b_MOCA_Upload" accept="image/*|application/pdf">
			</div>
		</div>
		<div class="m_div pure-g-r">
			<input type="button" onclick="changeMOCAForm('blind')" value="Form for General Patients">
		</div>
	</div>
	
</fieldset>

<input type="button" value="MMSE Test" onclick="revealMMSE(this)" class="test_button"/>
<fieldset id="mmse" class="hide_div">
	<legend>Mini-Mental State Examination (MMSE)</legend>
	<a href="/tests/MMSE_1.pdf" class="dl_link" download="MMSE.pdf">MMSE</a>
	
	<div id="moca_general">
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Orientation</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_orientation" name="mmse_orientation" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/10</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Registration</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_registration" name="mmse_registration" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/3</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Attention and Calculation</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_attention" name="mmse_attention" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/5</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Recall</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_recall" name="mmse_recall" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/3</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Language</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_language" name="mmse_language" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/8</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Copying</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_copying" name="mmse_copying" class="moca_input" onchange="mmse_change()">
			</div>
			<span class="post_input pure-u-1-8">/1</span>
		</div>
		<hr width="20%" Align="Left" NOSHADE>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Total</div>
			<div class="pure-u-1-2 moca_input">
				<input type="text" id="mmse_total" name="mmse_total" class="moca_input" readonly>
			</div>
			<span class="post_input pure-u-1-8">/30</span>
		</div>
		<div class="m_div pure-g-r">
			<div class="moca_label pure-u-1-3">Upload Test Sheet</div>
			<div class="pure-u-1-2">
				<input type="file" name="MMSE_Upload" accept="image/*|application/pdf">
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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/memory.js"></script>
<script>
$(document).ready(function() {
	if("${id}" != "")
		$("#hiddenID").val("${id}");
	else if(typeof(Storage) !== "undefined"){
		$("#hiddenID").val(sessionStorage.p_id);
	} else {
		$("#hiddenID").val("0");
	}
});
</script>
</body>
</html>