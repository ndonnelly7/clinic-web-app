/**
 * 
 */

$(function () {
	$("ul.form-tabs").tabs($("div.sections > div"));
	$("ul.date-tabs").tabs($("div.forms > div"));
	
	
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
	resetTabs();
});

function resetTabs(){
	$("#det-tab").one("click", function() {
		loadDetailsForm();
	});
	$("#his-tab").click(function() {
		loadHistoryForm();
	});
	$("#gpi-tab").click(function() {
		loadGPForm();
	});
	$("#con-tab").click(function() {
		loadConcernsForm();
	});
	$("#neu-tab").click(function() {
		loadNeuroForm();
	});
	$("#eve-tab").click(function() {
		loadEventsForm();
	});
	$("#liv-tab").click(function() {
		loadLivingForm();
	});
	$("#lif-tab").click(function() {
		loadLifestyleForm();
	});
	$("#tes-tab").click(function() {
		loadTestsForm();
	});
	$("#ana-tab").click(function() {
		loadAnalysisForm();
	});
}

function printNullPatient(){
	
}

function printNullForm(){
	
}

function loadDetailsForm(){
	$("#details").load("../admin/review-files/details.html #det_form", function(){
		$("#det_form").show();
	});
	var id = $("#id_from_attr").val();
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"DETAILS",
			id:id
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"HISTORY",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"GP_INFO",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"CONCERNS",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"NEURO",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"EVENTS",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"LIVING",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"LIFESTYLE",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"TESTS",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	$.ajax('/review.do', {
		method:'GET',
		dataType:'text',
		data: {
			page:"ANALYSIS",
			id:id
		},
		success:function(response) {
			console.log(response);
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
	getPatient(id, function(patient) {
		for(var key in patient){
			if(patient.hasOwnProperty(key)){
				var elem = document.getElementById(key);
				if(elem != null)
					elem.value=patient[key];
			}
		}
	});
	console.log(details);
	for(var key in details){
		console.log(key);
		var elem = document.getElementById(key);
		if(elem != null)
			elem.value=details[key];
	}
}

function loadHistory(json){
	var history = JSON.parse(json);
	console.log(history);
	for(var key in history){
		console.log(key);
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
		console.log(key);
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
		console.log(key);
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
		console.log(key);
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
		console.log(key);
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_collat_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(events[key]))
				x.parentNode.removeChild(x);
		} else if(key == "other_text" || key == "other_collat_text"){
			if(events[key] == ""){
				document.getElementById(key).parentNode.removeChild(document.getElementById(key));
			}
				
		}
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof events[key] == "string")
				elem.value=events[key].replace("_", " ");
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
	
}

function loadLifestyle(json){
	
}

function loadTests(json){
	
}

function loadAnalysis(json){
	
}