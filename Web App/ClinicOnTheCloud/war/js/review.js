/**
 * 
 */

$(function () {
	$("ul.form-tabs").tabs($("div.sections > div"));
	
	
});

$(document).ready(function() {
	var $window = $(window);
	
	function updateWidth() {
		var size = $window.width();
		if(size < 1360) {
			$("ul.tabs li a").addClass("s");
		} else {
			$("ul.tabs li a").removeClass("s");
		}
	}
	
	updateWidth();
	$(window).resize(updateWidth);
	$("#current_date").val($("#date-tabs li a").html());
	resetTabs();
	loadDetailsForm();
	
});

function resetTabs(){
	$("#his-tab").one("click",function() {
		loadHistoryForm();
	});
	$("#gpi-tab").one("click", function() {
		loadGPForm();
	});
	$("#con-tab").one("click", function() {
		loadConcernsForm();
	});
	$("#neu-tab").one("click", function() {
		loadNeuroForm();
	});
	$("#eve-tab").one("click", function() {
		loadEventsForm();
	});
	$("#liv-tab").one("click", function() {
		loadLivingForm();
	});
	$("#lif-tab").one("click", function() {
		loadLifestyleForm();
	});
	$("#tes-tab").one("click", function() {
		loadTestsForm();
	});
	$("#ana-tab").one("click", function() {
		loadAnalysisForm();
	});
}

function printNullPatient(){
	alert("Null Patient");
}

function printNullForm(){
	alert("Null Form");
}

function loadNewDate(item){
	var d = $(item).children().html();
	console.log(d);
	if(d != $("#current_date").val()){
		resetTabs();
		$("#current_date").val(d);
		loadDetailsForm();
		$("ul.form-tabs").data("tabs").click(0);
	} 	
}

function initNewDate(){
	
}

function loadDetailsForm(){
	$("#details").load("../admin/review-files/details.html #det_form", function(){
		$("#det_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"DETAILS",
			id:id,
			date:date
		},
		success:function(response) {
			console.log(response);
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadDetails(response, id);
			}
		}
	});
}

function loadHistoryForm(){
	$("#history").load("../admin/review-files/history.html #history_form", function(){
		$("#history_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"HISTORY",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadHistory(response);
			}
		}
	});
}

function loadGPForm(){
	$("#gp").load("../admin/review-files/gp.html #gp_form", function(){
		$("#gp_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"GP_INFO",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadGPInfo(response);
			}
		}
	});
}

function loadConcernsForm(){
	$("#concerns").load("../admin/review-files/concerns.html #concerns_form", function(){
		$("#concerns_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"CONCERNS",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadConcerns(response);
			}
		}
	});
}

function loadNeuroForm(){
	$("#neuro").load("../admin/review-files/neuro.html #neuro_form", function(){
		$("#neuro_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"NEURO",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadNeuro(response);
			}
		}
	});
}

function loadEventsForm(){
	$("#events").load("../admin/review-files/events.html #events_form", function(){
		$("#events_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"EVENTS",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadEvents(response);
			}
		}
	});
}

function loadLivingForm(){
	$("#living").load("../admin/review-files/living.html #living_form", function(){
		$("#living_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"LIVING",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadLiving(response);
			}
		}
	});
}

function loadLifestyleForm(){
	$("#lifestyle").load("../admin/review-files/lifestyle.html #lifestyle_form", function(){
		$("#lifestyle_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"LIFESTYLE",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadLifestyle(response);
			}
		}
	});
}

function loadTestsForm(){
	$("#tests").load("../admin/review-files/tests.html #tests_form", function(){
		$("#tests_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"TESTS",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadTests(response);
			}
		}
	});
}

function loadAnalysisForm(){
	$("#analysis").load("../admin/review-files/analysis.html #analysis_form", function(){
		$("#analysis_form").show();
	});
	var id = $("#id_from_attr").val();
	var date = $("#current_date").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"ANALYSIS",
			id:id,
			date:date
		},
		success:function(response) {
			if(response == 'null_patient')
				printNullPatient();
			else if(response == 'null_form')
				printNullForm();
			else {
				loadAnalysis(response);
			}
		}
	});
}

function loadDetails(json, id){
	var details = JSON.parse(json);
	console.log(details);
	getPatient(id, function(patient) {
		for(var key in patient){
			if(key == 'testing_reason'){
				if(patient[key] == 'want_reassurance')
					$("#want_reassurance").val("True");
				else if(patient[key] == 'want_assessment')
					$("#want_assessment").val("True");
				else if(patient[key] == 'want_information')
					$("#want_information").val("True");
			}
			
			if(patient.hasOwnProperty(key)){
				var elem = document.getElementById(key);
				if(elem != null)
					elem.value=patient[key];
			}
		}
	});
	for(var key in details){
		var elem = document.getElementById(key);
		if(elem != null)
			elem.value=details[key];
	}
}

function loadHistory(json){
	var history = JSON.parse(json);
	console.log(history);
	for(var key in history){
		var elem = document.getElementById(key);
		if(elem != null)
			elem.value=history[key];
	}
	
	var meds = history["med_histories"];
	for(var i = 0; i < meds.length; i++){
		if(i > 0) {
			var note = $("#med_row .notes_col #notes").val();
			$("#med_row").clone().appendTo($("#med_history")).hide().show();
			$("#med_row .notes_col #notes").eq(i).val(note);
		}
		
		for(var k in meds[i]){
			var elem = document.getElementById(k);
			if(elem != null){
				if(typeof meds[i][k] == "string")
					elem.value=(meds[i][k]).replace("_", " ");
				else
					elem.value = meds[i][k];
			}
		}
	}
	
	var drugs = history["drug_histories"];
	for(var i = 0; i < drugs.length; i++){
		$("#drug_row .benzo_col").hide();
		$("#drug_row .sleep_col").hide();
		if(i > 0) {
			var note = $("#drug_row .notes_col #notes").val();
			$("#drug_row").clone().appendTo($("#drug_history")).hide().show();
			$("#drug_row .notes_col #notes").eq(i).val(note);
			$("#drug_row .benzo_col").hide();
			$("#drug_row .sleep_col").hide();
		}
		
		if(drugs[i]['drug'] == 'sleeping'){
			$("#drug_row .sleep_col").show();
			$("#drug_row div #sleep_med").val((drugs[i]['sleep_med']).replace("_", " "));
		}
		else if(drugs[i]['drug'] == 'benzo'){
			$("#drug_row .benzo_col").show();
			$("#drug_row div #benzo_med").val((drugs[i]['benzo_med']).replace("_", " "));
		}
		
		
		$("#drug_row div #drug").val((drugs[i]['drug']).replace("_", " "));
		$("#drug_row div #time").val((drugs[i]['time']).replace("_", " "));
		$("#drug_row div #notes").val((drugs[i]['notes']).replace("_", " "));
		$("#drug_row div #collat").val((drugs[i]['collat']));
	}
	
	var psychs = history["psych_histories"];
	for(var i = 0; i < psychs.length; i++){
		if(i > 0) {
			var note = $("#psych_row .notes_col #notes").val();
			$("#psych_row").clone().appendTo($("#psych_history")).hide().show();
			$("#psych_row .notes_col #notes").eq(i).val(note);
		}
		
		$("#psych_row div #psych").val((psychs[i]['psych']).replace("_", " "));
		$("#psych_row div #time").val((psychs[i]['time']).replace("_", " "));
		$("#psych_row div #notes").val((psychs[i]['notes']).replace("_", " "));
		$("#psych_row div #collat").val((psychs[i]['collat']));
	}
}

function loadGPInfo(json){
	var gp = JSON.parse(json);
	console.log(gp);
	for(var key in gp){
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof gp[key] == "string")
				elem.value=(gp[key].replace("_", " ").replace("mon","months").replace("yr", "year"));
			else
				elem.value=gp[key];
	}	
}

function loadConcerns(json){
	var con = JSON.parse(json);
	console.log(con);
	for(var key in con){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(con[key]))
				x.parentNode.removeChild(x);
		}
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof con[key] == "string")
				elem.value=(con[key].replace("_", " "));
			else
				elem.value=con[key];
	}
}

function loadNeuro(json){
	var neu = JSON.parse(json);
	console.log(neu);
	for(var key in neu){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(neu[key]))
				x.parentNode.removeChild(x);
		}
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof neu[key] == "string")
				elem.value=(neu[key].replace("_", " "));
			else
				elem.value=neu[key];
	}
}

function loadEvents(json){
	var events = JSON.parse(json);
	console.log(events);
	for(var key in events){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_collat_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(events[key]) && x != null && !(typeof x === 'undefined'))
				x.parentNode.removeChild(x);
		} else if(key == "other_text" || key == "other_collat_text"){
			if(events[key] == ""){
				document.getElementById(key).parentNode.removeChild(document.getElementById(key));
			}
				
		}
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof events[key] == "string")
				elem.value=events[key].replace("_", " ").replace("mon", "months").replace("yr", "years");
			else
				elem.value=events[key];
		}
	}
	
	var activities = events["activities"];
	for(var i = 0; i < activities.length; i++){
		if(i > 0) {
			var note = $("#soc_row .notes_col #notes").val();
			$("#soc_row").clone().appendTo($("#activities")).hide().show();
			$("#soc_row .notes_col #notes").eq(i).val(note);
		}
		
		for(var k in activities[i]){
			var elem = document.getElementById(k);
			if(elem != null){
				if(typeof activities[i][k] == "string")
					elem.value=(activities[i][k]).replace("_", " ").replace("mon", "months").replace("yr", "years");
				else
					elem.value = activities[i][k];
			}
		}
	}
}

function loadLiving(json){
	var liv = JSON.parse(json);
	console.log(liv);
	for(var key in liv){
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof liv[key] == "string")
				elem.value=(liv[key].replace("_", " ").replace("mon","months").replace("yr", "year"));
			else
				elem.value=liv[key];
		}			
	}
	
	filterLiving(liv);
	
	if(liv['collat_drive'] == 'hidden'){
		$("collateral_driving").remove();
	} else {
		$("collateral_driving").show();
	}
	
	if(liv['collat_shop'] == 'hidden'){
		$("collateral_shopping").remove();
	} else {
		$("collateral_shopping").show();
	}
	
	
	if(liv['collat_cook'] == 'hidden'){
		$("collateral_cook").remove();
	} else {
		$("collateral_cook").show();
	}
	
	if(liv['collat_bills'] == 'hidden'){
		$("collateral_bills").remove();
	} else {
		$("collateral_bills").show();
	}
	
}

function loadLifestyle(json){
	var life = JSON.parse(json);
	console.log(life);
	for(var key in life){
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof life[key] == "string")
				elem.value=(life[key].replace("_", " "));
			else
				elem.value=life[key];
		}			
	}
	
	var activities = life["activities"];
	for(var i = 0; i < activities.length; i++){
		if(i > 0) {
			var note = $("#exe_row .notes_col #notes").val();
			$("#exe_row").clone().appendTo($("#exer_grid")).hide().show();
			$("#exe_row .notes_col #notes").eq(i).val(note);
		}
		
		for(var k in activities[i]){
			var elem = document.getElementById(k);
			if(elem != null){
				if(typeof activities[i][k] == "string")
					elem.value=(activities[i][k]).replace("_", " ").replace("mon", "months").replace("yr", "years");
				else
					elem.value = activities[i][k];
			}
		}
	}
	
	if(!(life['difficulty_sleep'])) $("#diff_").remove();
	if(!(life['night_waking'])) $("#night_").remove();
	if(!(life['early_waking'])) $("#early_").remove();
	if(!(life['meds_check'])) $("#med_").remove();
	if(!(life['nap_check'])) $("#nap_").remove();
	
	if(!(life['difficulty_sleep_collat'])) $("#diff_c").remove();
	if(!(life['night_waking_collat'])) $("#night_c").remove();
	if(!(life['early_waking_collat'])) $("#early_c").remove();
	if(!(life['meds_check_collat'])) $("#med_c").remove();
	if(!(life['nap_check_collat'])) $("#nap_c").remove();
	
	if(life['collat_sleep'] == 'hidden') $("#collat_sleep").remove();
	if(life['collat_exercise'] == 'hidden') $("#collat_exercise").remove();
	if(life['collat_diet'] == 'hidden') $("#collat_diet").remove();
	if(life['alcohol_collat'] == 'hidden') $("#collat_alcohol").remove();
	if(life['smoking_collat'] == 'hidden') $("#collat_smoking").remove();
	if(life['drug_collat'] == 'hidden') $("#collat_drugs").remove();
	
	if(!(life['miss_meals'])) $("#miss_meals_t").remove();
	if(!(life['sweets'])) $("#sweets_t").remove();
	if(!(life['fried'])) $("#fried_t").remove();
	if(!(life['takeaway'])) $("#takeaway_t").remove();
	if(!(life['cakes'])) $("#cakes_t").remove();
	if(!(life['weight'])) $("#weight_t").remove();
	
	if(!(life['miss_meals_collat'])) $("#miss_meals_t_collat").remove();
	if(!(life['sweets_collat'])) $("#sweets_t_collat").remove();
	if(!(life['fried_collat'])) $("#fried_t_collat").remove();
	if(!(life['takeaway_collat'])) $("#takeaway_t_collat").remove();
	if(!(life['cakes_collat'])) $("#cakes_t_collat").remove();
	if(!(life['weight_collat'])) $("#weight_t_collat").remove();
	
	var smokingObj = {
			one_five:"One to Five",
			five_ten:"Five to Ten",
			ten_twenty:"Ten to Twenty",
			twenty_plus:"More than Twenty"
	}
	
	$("#packets").val(smokingObj[life['packets']]);
	$("#packets_collat").val(smokingObj[life['packets_collat']]);
	
	if(life['alcohol'] == 'no') $("#alcohol_grid").remove();
	if(life['smoking'] == 'no') $("#smoking_grid").remove();
	if(life['alcohol_collat_yn'] == 'no') $("#alcohol_grid_collat").remove();
	if(life['smoking_collat_yn'] == 'no') $("#smoking_grid_collat").remove();
}

function loadTests(json){
	var test = JSON.parse(json);
	console.log(test);
	for(var key in test){
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof test[key] == "string")
				elem.value=(test[key].replace("_", " ").replace("mon","months").replace("yr", "year"));
			else
				elem.value=test[key];
		}			
	}
	if(test['hads_total'] == "")
		$("#hads").remove();
	if(test['gds_total'] == "")
		$("#gds").remove();
	if(test['moca_total'] == "")
		$("#standard_moca").remove();
	if(test['mmse_total'] == "")
		$("#mmse").remove();
	if(test['b_moca_total'] == "")
		$("#blind_moca").remove();
}

function loadAnalysis(json){
	var ana = JSON.parse(json);
	console.log(ana);
	for(var key in ana){
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof ana[key] == "string")
				elem.value=(ana[key].replace("_", " "));
			else
				elem.value=ana[key];
		}			
	}
	
	var impressions = ana["impressions"];
	var imps = {
		norm_neg:"Normal Negative",
		ab_neg:"Abnormal Negative",
		dementia:"Possible for Dementia",
		stress:"Possible for Stress",
		mood:"Possible Mood Problem",
		acopia:"Acopia",
		bereavement:"Bereavement",
		reactive:"Reactvie Stress",
		social:"Social Adjustment"		
	}
	for(var i = 0; i < impressions.length; i++){
		if(i > 0) {
			var note = $("#imp_row .notes_col #impression_notes").val();
			$("#imp_row").clone().appendTo($("#impressions")).hide().show();
			$("#imp_row .notes_col #impression_notes").eq(i).val(note);
		}
		
		$("#impression").val(imps[impressions[i]['impression']]);
		$("#impression_notes").val(impressions[i]['impression_notes']);
	}

	var outcomes = ana["outcomes"];
	for(var i = 0; i < outcomes.length; i++){
		if(i > 0) {
			var note = $("#out_row .notes_col #outcome_notes").val();
			$("#out_row").clone().appendTo($("#outcomes")).hide().show();
			$("#out_row .notes_col #outcome_notes").eq(i).val(note);
		}
		
		$("#outcome").val((outcomes[i]['outcome']).replace("_", " "));
		$("#outcome_notes").val(outcomes[i]['outcome_notes']);
	}
}

function filterLiving(liv){
	//DRIVING
	if(liv['unknown_arrival'] == false) $("#driving #do_drive #unknown_arrival_row").remove();
	if(liv['lost'] == false) $("#driving #do_drive #lost_row").remove();
	if(liv['tips'] == false) $("#driving #do_drive #tips_row").remove();	
	
	if(liv['unknown_arrival_collat'] == false) $("#collateral_driving #do_drive #unknown_arrival_row").remove();
	if(liv['lost_collat'] == false) $("#collateral_driving #do_drive #lost_row").remove();
	if(liv['tips_collat'] == false) $("#collateral_driving #do_drive #tips_row").remove();
	
	if(liv['park_big'] == false) $("#driving #do_drive #park_big_row").remove();	
	if(liv['day_drive'] == false) $("#driving #do_drive #day_drive_row").remove();	
	if(liv['known_places'] == false) $("#driving #do_drive #known_places_row").remove();	
	if(liv['take_friend'] == false) $("#driving #do_drive #take_friend_row").remove();	
	if(liv['dry_run'] == false) $("#driving #do_drive #dry_run_row").remove();	
	if(liv['use_map'] == false) $("#driving #do_drive #use_map_row").remove();	
	if(liv['take_phone'] == false) $("#driving #do_drive #take_phone_row").remove();	
	
	if(liv['park_big_collat'] == false) $("#collateral_driving #do_drive #park_big_row").remove();	
	if(liv['day_drive_collat'] == false) $("#collateral_driving #do_drive #day_drive_row").remove();	
	if(liv['known_places_collat'] == false) $("#collateral_driving #do_drive #known_places_row").remove();	
	if(liv['take_friend_collat'] == false) $("#collateral_driving #do_drive #take_friend_row").remove();	
	if(liv['dry_run_collat'] == false) $("#collateral_driving #do_drive #dry_run_row").remove();	
	if(liv['use_map_collat'] == false) $("#collateral_driving #do_drive #use_map_row").remove();	
	if(liv['take_phone_collat'] == false) $("#collateral_driving #do_drive #take_phone_row").remove();

	//COOKING
	if(!(liv['forgot_cooking'])) $("#cooking #do_cook #forgot_cooking_row").remove();
	if(!(liv['burnt_food'])) $("#cooking #do_cook #burnt_food_row").remove();
	if(!(liv['started_fire'])) $("#cooking #do_cook #started_fire_row").remove();
	if(!(liv['smoke_alarm'])) $("#cooking #do_cook #smoke_alarm_row").remove();
	if(!(liv['undercooked'])) $("#cooking #do_cook #undercooked_row").remove();
	
	if(!(liv['forgot_cooking_collat'])) $("#cooking #do_cook #forgot_cooking_row_collat").remove();
	if(!(liv['burnt_food_collat'])) $("#cooking #do_cook #burnt_food_row_collat").remove();
	if(!(liv['started_fire_collat'])) $("#cooking #do_cook #started_fire_row_collat").remove();
	if(!(liv['smoke_alarm_collat'])) $("#cooking #do_cook #smoke_alarm_row_collat").remove();
	if(!(liv['undercooked_collat'])) $("#cooking #do_cook #undercooked_row_collat").remove();
	
	if(!(liv['timer'])) $("#cooking #do_cook #timer_row").remove();
	if(!(liv['reminders'])) $("#cooking #do_cook #reminders_row").remove();
	if(!(liv['simple_cooking'])) $("#cooking #do_cook #simple_cooking_row").remove();
	if(!(liv['salad'])) $("#cooking #do_cook #salad_row").remove();
	if(!(liv['go_out'])) $("#cooking #do_cook #go_out_row").remove();
	if(!(liv['get_help'])) $("#cooking #do_cook #get_help_row").remove();

	if(!(liv['timer_collat'])) $("#cooking #do_cook #timer_row_collat").remove();
	if(!(liv['reminders_collat'])) $("#cooking #do_cook #reminders_row_collat").remove();
	if(!(liv['simple_cooking_collat'])) $("#cooking #do_cook #simple_cooking_row_collat").remove();
	if(!(liv['salad_collat'])) $("#cooking #do_cook #salad_row_collat").remove();
	if(!(liv['go_out_collat'])) $("#cooking #do_cook #go_out_row_collat").remove();
	if(!(liv['get_help_collat'])) $("#cooking #do_cook #get_help_row_collat").remove();
	
	//SHOPPING
	if(!(liv['list_check'])) $("#shopping #do_shop #list_row").remove();
	if(!(liv['small_shop_check'])) $("#shopping #do_shop #small_shop_row").remove();
	if(!(liv['list_check_collat'])) $("#shopping #do_shop #list_row_collat").remove();
	if(!(liv['small_shop_check_collat'])) $("#shopping #do_shop #small_shop_row_collat").remove();
}