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
</head>
<body>
<h1>Please insert memory test in here</h1>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')" class="current_page">Test Battery</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/> 
</div> 
</form>

<form id="memory_form" class="pure-form pure-form-aligned" method="POST" action="memory.do">
<fieldset id="hads_form">
	<legend>Hospital Anxiety and Depression Scale</legend>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I feel tense or wound up:</div>
		<div class="pure-u-1-2 h_select">
			<select name="wound_up" id="wound_up" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Most of the time</option>
				<option value="2">A lot of the time</option>
				<option value="1">Occasionally</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I still enjoy the things I used to:</div>
		<div class="pure-u-1-2 h_select">
			<select name="enjoy" id="enjoy" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Definitely as much</option>
				<option value="1">Not quite so much</option>
				<option value="2">Only a little</option>
				<option value="3">Hardly at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I get a sort of frightened feeling as if something awful is about to happen</div>
		<div class="pure-u-1-2 h_select">
			<select name="frightened" id="frightened" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very definitely and quite badly</option>
				<option value="2">Yes, but not too badly</option>
				<option value="1">A little, but it doesn't worry me</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I can laugh and see the funny side of things</div>
		<div class="pure-u-1-2 h_select">
			<select name="funny" id="funny" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">As much as I always could</option>
				<option value="1">Not quite so much now</option>
				<option value="2">Definitely not so much now</option>
				<option value="3">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">Worrying thoughts go through my mind</div>
		<div class="pure-u-1-2 h_select">
			<select name="worry" id="worry" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">A great deal of the time</option>
				<option value="2">A lot of the time</option>
				<option value="1">From time to time but not too often</option>
				<option value="0">Only occasionally</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I feel cheerful</div>
		<div class="pure-u-1-2 h_select">
			<select name="cheerful" id="cheerful" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Not at all</option>
				<option value="2">Not often</option>
				<option value="1">Sometimes</option>
				<option value="0">Most of the time</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I can sit at ease and feel relaxed</div>
		<div class="pure-u-1-2 h_select">
			<select name="relaxed" id="relaxed" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Definitely</option>
				<option value="1">Usually</option>
				<option value="2">Not often</option>
				<option value="3">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I feel as if I am slowed down</div>
		<div class="pure-u-1-2 h_select">
			<select name="slowed" id="slowed" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Nearly all the time</option>
				<option value="2">Very often</option>
				<option value="1">Sometimes</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I get a sort of frightened feeling like 'butterflies' in the stomach</div>
		<div class="pure-u-1-2 h_select">
			<select name="butterflies" id="butterflies" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Not at all</option>
				<option value="1">Occasionally</option>
				<option value="2">Quite often</option>
				<option value="3">Very often</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I have lost interest in my appearance</div>
		<div class="pure-u-1-2 h_select">
			<select name="appearance" id="appearance" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Definitely</option>
				<option value="2">I don't take so much care as I should</option>
				<option value="1">I may not take quite as much care</option>
				<option value="0">I take as much care as ever</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I feel restless as if I have to be on the move</div>
		<div class="pure-u-1-2 h_select">
			<select name="restless" id="restless" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very much indeed</option>
				<option value="2">Quite a lot</option>
				<option value="1">Not very much</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I look forward with enjoyment to things</div>
		<div class="pure-u-1-2 h_select">
			<select name="enjoyment" id="enjoyment" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">As much as I ever did</option>
				<option value="1">Rather less than I used to</option>
				<option value="2">Definitely less than I used to</option>
				<option value="3">Hardly at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I get sudden feelings of panic</div>
		<div class="pure-u-1-2 h_select">
			<select name="panic" id="panic" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="3">Very often indeed</option>
				<option value="2">Quite often</option>
				<option value="1">Not very often</option>
				<option value="0">Not at all</option>
			</select>
		</div>
	</div>
	
	<div class="q_div pure-g-r">
		<div class="mem_label pure-u-1-2">I can enjoy a good book or radio or TV programme</div>
		<div class="pure-u-1-2 h_select">
			<select name="pasttime" id="pasttime" class="hads_select" onchange="updateBorder(this)">
				<option value="na">-- --</option>
				<option value="0">Often</option>
				<option value="1">Sometimes</option>
				<option value="2">Not often</option>
				<option value="3">Very seldom</option>
			</select>
		</div>
	</div>
	<input type="button" value="Submit HADS Results" onclick="runHADSEvaluation()" style="margin-bottom:6px;"/>
	<div class="pure-g-r" id="result_hads_div">
		<div class="result_title pure-u-1-2">HADS Result</div>
		<input type="text" id="hads_result" style="width:3em; margin-top:-4px;" readonly>
		<span id="hads_result_text" class="pure-u-1-2"></span>
	</div>
</fieldset>

</form>

<div class="footer">
	<span onclick="spanClick('lifestyle')">Previous Page</span>
	<span onclick="spanClick('analysis')">Next Page</span>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/memory.js"></script>
</body>
</html>