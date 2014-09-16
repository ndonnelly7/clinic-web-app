/**
 * 
 */
var concernHeight, neuroHeight, livingHeight, lifeHeight;

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
	resetTabs();
	loadDetailsForm();
	$("#current_date").val($(".date-tabs li a").html());
	
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
		$("#assessment").val(d);
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
	var start = new Date();
	console.log("Requesting cloud data at: " + start.toTimeString());
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
				var now = new Date();
				console.log("Cloud Data Arrived at: " + now.toTimeString());
				console.log("Total Request Time: " + (now.getTime() - start.getTime()) + "ms")
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
	$("#det_form #hiddenID").val(id);
	$("#det_form #assessment").val($("#current_date").val());
	$("#det_form #linkedPage").val("update");
	getPatient(id, function(patient) {
		for(var key in patient){
			if(key == 'testing_reason'){
				if(patient[key] == 'wants_reassurance')
					$("#wants_reassurance").val("True");
				else if(patient[key] == 'wants_assessment')
					$("#wants_assessment").val("True");
				else if(patient[key] == 'wants_information')
					$("#wants_information").val("True");
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
	
	$("#det_form").on("submit", function(e){
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Details Submission");
			},
			success: function(data) {
				$("#det_message").html("Sent Patient Details Update");
			}
		})
	});
}

function loadHistory(json){
	var history = JSON.parse(json);
	console.log(history);
	$("#history_form #hiddenID").val($("#id_from_attr").val());
	$("#history_form #linkedPage").val("update");
	$("#history_form #assessment").val($("#current_date").val());
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
			$("#drug_row .sleep_col").eq(i).show();
			$("#drug_row div #sleep_med").eq(i).val((drugs[i]['sleep_med']).replace("_", " "));
		}
		else if(drugs[i]['drug'] == 'benzo'){
			$("#drug_row .benzo_col").eq(i).show();
			$("#drug_row div #benzo_med").eq(i).val((drugs[i]['benzo_med']).replace("_", " "));
		}
		
		
		$("#drug_row div #drug").eq(i).val((drugs[i]['drug']).replace("_", " "));
		$("#drug_row div #time").eq(i).val((drugs[i]['time']).replace("_", " "));
		$("#drug_row div #notes").eq(i).val((drugs[i]['notes']).replace("_", " "));
		$("#drug_row div #collat").eq(i).val((drugs[i]['collat']));
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
	
	$("#history_form").on("submit", function(e){
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending History Submission");
			},
			success: function(data) {
				$("#history_message").html("Sent Patient History Update");
			}
		})
	});
}

function loadGPInfo(json){
	var gp = JSON.parse(json);
	console.log(gp);
	$("#gp_form #hiddenID").val($("#id_from_attr").val());
	$("#gp_form #linkedPage").val("update");
	$("#gp_form #assessment").val($("#current_date").val());
	for(var key in gp){
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof gp[key] == "string")
				elem.value=(gp[key].replace("_", " ").replace("mon","months").replace("yr", "year"));
			else
				elem.value=gp[key];
	}	
	
	$("#gp_form").on("submit", function(e){
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending GP Submission");
			},
			success: function(data) {
				$("#gp_message").html("Sent GP Update");
			}
		})
	});
}

function loadConcerns(json){
	var con = JSON.parse(json);
	console.log(con);
	$("#concerns_form #hiddenID").val($("#id_from_attr").val());
	$("#concerns_form #linkedPage").val("update");
	$("#concerns_form #assessment").val($("#current_date").val());
	$(".concerns_check").hide();
	for(var key in con){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1){
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row_collat");
			}
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(con[key])){
				var jx = $(x);
				jx.hide();
				jx.find('input, textarea').prop('disabled', true);
				concernHeight = jx.height();
				jx.height(0)
				jx.style.margin= "0px 0px 0px 0px";
			}
		}
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof con[key] == "string")
				elem.value=(con[key].replace("_", " "));
			else
				elem.value=con[key];
	}
	
	$("#concerns_form").on("submit", function(e){
		$("#new_concern").prop("disabled", true);
		$("#new_concern_collat").prop("disabled", true);
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Concerns Submission");
			},
			success: function(data) {
				$("#concerns_message").html("Sent Concerns Update");
				$("#new_concern").prop("disabled", false);
				$("#new_concern_collat").prop("disabled", false);
			}
		})
	});
	
}

function addConcernRow() {
	var c = $("#new_concern").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(concernHeight);
	row.css("margin-bottom", "10px");
}

function addConcernRowCollat() {
	var c = $("#new_concern_collat").val()
	var row = $("#" + c + "_row_collat");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(concernHeight);
	row.css("margin-bottom", "10px");
}

function loadNeuro(json){
	var neu = JSON.parse(json);
	console.log(neu);
	$("#neuro_form #hiddenID").val($("#id_from_attr").val());
	$("#neuro_form #linkedPage").val("update");
	$("#neuro_form #assessment").val($("#current_date").val());
	$(".neuro_check").hide();
	for(var key in neu){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(neu[key])){
				var jx = $(x);
				jx.hide();
				jx.find('input, textarea').prop('disabled', true);
				neuroHeight = jx.height();
				jx.height(0)
				x.style.margin= "0px 0px 0px 0px";
			}
		}
		var elem = document.getElementById(key);
		if(elem != null)
			if(typeof neu[key] == "string")
				elem.value=(neu[key].replace("_", " "));
			else
				elem.value=neu[key];
	}
	
	$("#neuro_form").on("submit", function(e){
		$("#new_neuro").prop("disabled", true);
		$("#new_neuro_collat").prop("disabled", true);
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Neurological Submission");
			},
			success: function(data) {
				$("#neuro_message").html("Sent Neurological Update");
				$("#new_neuro").prop("disabled", false);
				$("#new_neuro_collat").prop("disabled", false);
			}
		})
	});
}

function addNeuroRow(){
	var c = $("#new_neuro").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addNeuroRowCollat() {
	var c = $("#new_neuro_collat").val()
	var row = $("#" + c + "_row_collat");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function loadEvents(json){
	var events = JSON.parse(json);
	$("#events_form #hiddenID").val($("#id_from_attr").val());
	$("#events_form #linkedPage").val("update");
	$("#events_form #assessment").val($("#current_date").val());
	$(".events_check").hide();
	console.log(events);
	
	//Hide Row for Other Text
	var jx = $("#other_row");
	jx.hide();
	jx.find('input, textarea').prop('disabled', true);
	eventsHeight = jx.height();
	jx.height(0)
	jx.css("margin-bottom", "0px 0px 0px 0px");
	//Hide row for Collateral text
	jx = $("#other_row_collat");
	jx.hide();
	jx.find('input, textarea').prop('disabled', true);
	eventsHeight = jx.height();
	jx.height(0)
	jx.css("margin-bottom", "0px 0px 0px 0px");
	
	for(var key in events){
		if(key.indexOf("_check") > -1){
			if(key.indexOf("_collat") > -1)
				var x = document.getElementById(key.substring(0, key.indexOf("_collat_check")) + "_row_collat");
			else
				var x = document.getElementById(key.substring(0, key.indexOf("_check")) + "_row");
			if(!(events[key]) && x != null && !(typeof x === 'undefined')) {
				var jx = $(x);
				jx.hide();
				jx.find('input, textarea').prop('disabled', true);
				neuroHeight = jx.height();
				jx.height(0)
				x.style.margin= "0px 0px 0px 0px";				
			}
		} else if(key == "other_text" || key == "other_collat_text"){
			if(events[key] != ""){
				if(key == "other_text"){
					$("#other_text").val(events[key]);
				}else {
					$("#other_collat_text").val(events[key]);
				}
			} 
				
		}
		var elem = document.getElementById(key);
		if(elem != null){
			if(typeof events[key] == "string")
				elem.value=events[key].replace("_mon", "_months").replace("_yr", "_years").replace("_", " ");
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
					elem.value=(activities[i][k]).replace("_mon", "_months").replace("_yr", "_years").replace("_", " ");
				else
					elem.value = activities[i][k];
			}
		}
		changeInvolvementOld($("#soc_row .inv_col #involvement").get(0));
	}
	
	$("#events_form").on("submit", function(e){
		$("#new_events").prop("disabled", true);
		$("#new_events_collat").prop("disabled", true);
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Events and Submission Submission");
			},
			success: function(data) {
				$("#events_message").html("Sent Event Update");
				$("#new_events").prop("disabled", false);
				$("#new_events_collat").prop("disabled", false);
			}
		})
	});
}

function addEventsRow() {
	var c = $("#new_events").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addEventsRowCollat() {
	var c = $("#new_events_collat").val()
	var row = $("#" + c + "_row_collat");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function loadLiving(json){
	var liv = JSON.parse(json);
	console.log(liv);
	$("#living_form #hiddenID").val($("#id_from_attr").val());
	$("#living_form #linkedPage").val("update");
	$("#living_form #assessment").val($("#current_date").val());
	$(".living_check").hide();
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
		$("#collateral_driving").hide();
		$("#collateral_driving").find('input, textarea').prop('disabled', true)
		$("#collateral_driving").css("margin-bottom", "10px");
	} else {
		$("collateral_driving").show();
	}
	
	if(liv['collat_shop'] == 'hidden'){
		$("#collateral_shopping").hide();
		$("#collateral_shopping").find('input, textarea').prop('disabled', true)
		$("#collateral_shopping").css("margin-bottom", "10px");
	} else {
		$("collateral_shopping").show();
	}
	
	
	if(liv['collat_cook'] == 'hidden'){
		$("#collateral_cooking").hide();
		$("#collateral_cooking").find('input, textarea').prop('disabled', true)
		$("#collateral_cooking").css("margin-bottom", "10px");
	} else {
		$("collateral_cook").show();
	}
	
	if(liv['collat_bills'] == 'hidden'){
		$("collateral_bills").remove();
	} else {
		$("collateral_bills").show();
	}
	
	if(liv['driving_other_incident'] != ''){
		$("#driving_other_subheader").html(liv['driving_other_incident']);
	} else {
		$("#driving_other_row").hide();
		$("#driving_other_row").find('input, textarea').prop('disabled', true)
		$("#driving_other_row").css("margin-bottom", "10px");
	}
	
	if(liv['collat_driving_other_incident'] != ''){
		$("#collat_driving_other_subheader").html(liv['collat_driving_other_incident']);
	} else {
		$("#collat_driving_other_row").hide();
		$("#collat_driving_other_row").find('input, textarea').prop('disabled', true)
		$("#collat_driving_other_row").css("margin-bottom", "10px");
	}
	
	if(liv['cooking_other_incident'] != ''){
		$("#cooking_other_subheader").html(liv['cooking_other_incident']);
	} else {
		$("#cooking_other_row").hide();
		$("#cooking_other_row").find('input, textarea').prop('disabled', true)
		$("#cooking_other_row").css("margin-bottom", "10px");
	}
	
	if(liv['collat_cooking_other_incident'] != ''){
		$("#collat_cooking_other_subheader").html(liv['collat_cooking_other_incident']);
	} else {
		$("#collat_cooking_other_row").hide();
		$("#collat_cooking_other_row").find('input, textarea').prop('disabled', true)
		$("#collat_cooking_other_row").css("margin-bottom", "10px");
	}
	
	changeCookBool();
	changeDriveBool();
	changeShopBool();
	
	$("#living_form").on("submit", function(e){
		$("#new_incident").prop("disabled", true);
		$("#new_incident_collat").prop("disabled", true);
		$("#new_strat").prop("disabled", true);
		$("#new_strat_collat").prop("disabled", true);
		
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Living Submission");
			},
			success: function(data) {
				$("#living_message").html("Sent Living Update");
				$("#new_incident").prop("disabled", false);
				$("#new_incident_collat").prop("disabled", false);
				$("#new_strat").prop("disabled", false);
				$("#new_strat_collat").prop("disabled", false);
			}
		})
	});
}

function loadLifestyle(json){
	var life = JSON.parse(json);
	console.log(life);
	$("#lifestyle_form #hiddenID").val($("#id_from_attr").val());
	$("#lifestyle_form #linkedPage").val("update");
	$("#lifestyle_form #assessment").val($("#current_date").val());
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
		
		changeInvolvementOld($("#exe_row .inv_col #involvement").get(0));
	}
	
	if((life['sleep_difficulty']).toUpperCase() == "NO") $("#diff_").hide();
	if((life['waking_during_night']).toUpperCase() == "NO") $("#night_").hide();
	if((life['waking_early']).toUpperCase() == "NO") $("#early_").hide();
	if((life['taking_sleep_meds']).toUpperCase() == "NO") $("#med_").hide();
	if((life['takes_naps']).toUpperCase() == "NO") $("#nap_").hide();
	
	if((life['sleep_difficulty_collat']).toUpperCase() == "NO") $("#diff_c").hide();
	if((life['waking_during_night_collat']).toUpperCase() == "NO") $("#night_c").hide();
	if((life['waking_early_collat']).toUpperCase() == "NO") $("#early_c").hide();
	if((life['taking_sleep_meds_collat']).toUpperCase() == "NO") $("#med_c").hide();
	if((life['takes_naps_collat']).toUpperCase() == "NO") $("#nap_c").hide();
	
	if(life['collat_sleep'] != 'shown') {
		$("#collat_sleep").hide();
		$("#collat_sleep").val("hidden");
	} else {
		$("#collat_sleep").val("shown");
	}
	if(life['collat_exercise'] != 'shown') {
		$("#collat_exercise").hide();
		$("#collat_exercise").val("hidden");
	} else {
		$("#collat_exercise").val("shown");
	}
	if(life['collat_diet'] != 'shown'){
		$("#collat_diet").hide();
		$("#collat_diet").val("hidden");
	} else {
		$("#collat_diet").val("shown");		
	}
	if(life['alcohol_collat'] != 'shown'){
		$("#collat_alcohol").hide();
		$("#alcohol_collat").val("hidden");
	} else {
		$("#alcohol_diet").val("shown");	
	}
	if(life['smoking_collat'] != 'shown'){
		$("#collat_smoking").hide();
		$("#smoking_collat").val("hidden");
	} else {
		$("#smoking_collat").val("shown");
	}
	if(life['drug_collat'] != 'shown'){
		$("#collat_drugs").hide();
		$("#drug_collat").val("hidden");
	} else {
		$("#drug_collat").val("shown");
	}
	
	if((life['missing_meals']).toUpperCase() == "NO") $("#miss_meals_t").hide();
	if((life['sweet_tooth']).toUpperCase() == "NO") $("#sweets_t").hide();
	if((life['fried_food']).toUpperCase() == "NO") $("#fried_t").hide();
	if((life['takeaways']).toUpperCase() == "NO") $("#takeaway_t").hide();
	if((life['cakes_biscuits']).toUpperCase() == "NO") $("#cakes_t").hide();
	if((life['weight_suggestion']).toUpperCase() == "NO") $("#weight_t").hide();
	
	if((life['missing_meals_collat']).toUpperCase() == "NO") $("#miss_meals_t_collat").hide();
	if((life['sweet_tooth_collat']).toUpperCase() == "NO") $("#sweets_t_collat").hide();
	if((life['fried_food_collat']).toUpperCase() == "NO") $("#fried_t_collat").hide();
	if((life['takeaways_collat']).toUpperCase() == "NO") $("#takeaway_t_collat").hide();
	if((life['cakes_biscuits_collat']).toUpperCase() == "NO") $("#cakes_t_collat").hide();
	if((life['weight_suggestion_collat']).toUpperCase() == "NO") $("#weight_t_collat").hide();
	
	var smokingObj = {
			one_five:"One to Five",
			five_ten:"Five to Ten",
			ten_twenty:"Ten to Twenty",
			twenty_plus:"More than Twenty"
	}
	
	$("#packets").val(smokingObj[life['packets']]);
	$("#packets_collat").val(smokingObj[life['packets_collat']]);
	
	if(life['alcohol'].toUpperCase() == 'NO') $("#alcohol_grid").hide();
	if(life['smoking'].toUpperCase() == 'NO') $("#smoking_grid").hide();
	if(life['alcohol_collat_yn'].toUpperCase() == 'NO') $("#alcohol_grid_collat").hide();
	if(life['smoking_collat_yn'].toUpperCase() == 'NO') $("#smoking_grid_collat").hide();
	
	$("#lifestyle_form").on("submit", function(e){		
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Lifestyle Update");
			},
			success: function(data) {
				$("#lifestyle_message").html("Sent Lifestyle Update");
			}
		})
	});
}

function toggleDiv(elem, divStr){
	var d = $("#" + divStr);
	if(elem.value.toUpperCase() == "YES"){
		d.show();
		d.find('input, textarea').prop("disabled", false);
	} else {
		d.hide();
		d.find('input, textarea').prop("disabled", true);
	}
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
	$("#analysis_form #hiddenID").val($("#id_from_attr").val());
	$("#analysis_form #linkedPage").val("update");
	$("#analysis_form #assessment").val($("#current_date").val());
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
	for(var i = 0; i < impressions.length; i++){
		if(i > 0) {
			var note = $("#imp_row .notes_col #impression_notes").val();
			$("#imp_row").clone().appendTo($("#impressions")).hide().show();
			$("#imp_row .notes_col #impression_notes").eq(i).val(note);
		}
		
		$("#impression").val((impressions[i]['impression']).split("_").join(" "));
		$("#impression_notes").val(impressions[i]['impression_notes']);
	}

	var outcomes = ana["outcomes"];
	for(var i = 0; i < outcomes.length; i++){
		if(i > 0) {
			var note = $("#out_row .notes_col #outcome_notes").val();
			$("#out_row").clone().appendTo($("#outcomes")).hide().show();
			$("#out_row .notes_col #outcome_notes").eq(i).val(note);
		}
		
		$("#outcome").val((outcomes[i]['outcome']).split("_").join(" "));
		$("#outcome_notes").val(outcomes[i]['outcome_notes']);
	}
	
	$("#analysis_form").on("submit", function(e){		
		e.preventDefault();
		$.ajax({
			url: $(this).attr("action"),
			type: 'POST',
			data: $(this).serialize(),
			beforeSend: function() {
				console.log("Sending Lifestyle Update");
			},
			success: function(data) {
				$("#analysis_message").html("Sent Analysis Update");
			}
		})
	});
}

function filterLiving(liv){	
	//DRIVING
	if(liv['unknown_arrival'] == false){
		$("#driving #do_drive #unknown_arrival_row").hide();
		$("#driving #do_drive #unknown_arrival_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #unknown_arrival_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #unknown_arrival_row #unknown_arrival").prop("checked", false);
	}
	if(liv['lost'] == false){
		$("#driving #do_drive #lost_row").hide();
		$("#driving #do_drive #lost_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #lost_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #lost_row #lost").prop("checked", false);
	}
	if(liv['tips'] == false){
		$("#driving #do_drive #tips_row").hide();
		$("#driving #do_drive #tips_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #tips_row").css("margin-bottom", "10px");	
		//$("#driving #do_drive #tips_row #tips").prop("checked", false);
	}
	
	if(liv['unknown_arrival_collat'] == false){
		$("#collateral_driving #do_drive #unknown_arrival_row").hide();
		$("#collateral_driving #do_drive #unknown_arrival_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #unknown_arrival_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #unknown_arrival_row #unknown_arrival_collat").prop("checked", false);
	}
	if(liv['lost_collat'] == false){
		$("#collateral_driving #do_drive #lost_row").hide();
		$("#collateral_driving #do_drive #lost_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #lost_row").css("margin-bottom", "10px");		
		//$("#collateral_driving #do_drive #lost_row #lost_collat").prop("checked", false);
	}
	if(liv['tips_collat'] == false){
		$("#collateral_driving #do_drive #tips_row").hide();
		$("#collateral_driving #do_drive #tips_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #tips_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #tips_row #tips_collat").prop("checked", false);	
	}
	
	//STRATS
	if(liv['park_big'] == false){
		$("#driving #do_drive #park_big_row").hide();	
		$("#driving #do_drive #park_big_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #park_big_row").css("margin-bottom", "10px");	
		//$("#driving #do_drive #park_big_row #park_big").prop("checked", false);
	}
	if(liv['day_drive'] == false){
		$("#driving #do_drive #day_drive_row").hide();	
		$("#driving #do_drive #day_drive_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #day_drive_row").css("margin-bottom", "10px");	
		//$("#driving #do_drive #day_drive_row #day_drive").prop("checked", false);
	}
	if(liv['known_places'] == false){
		$("#driving #do_drive #known_places_row").hide();	
		$("#driving #do_drive #known_places_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #known_places_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #known_places_row #known_places").prop("checked", false);	
	}
	if(liv['take_friend'] == false){
		$("#driving #do_drive #take_friend_row").hide();
		$("#driving #do_drive #take_friend_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #take_friend_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #take_friend_row #take_friend").prop("checked", false);		
	}
	if(liv['dry_run'] == false){
		$("#driving #do_drive #dry_run_row").hide();
		$("#driving #do_drive #dry_run_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #dry_run_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #dry_run_row #dry_run").prop("checked", false);		
	}
	if(liv['use_map'] == false){
		$("#driving #do_drive #use_map_row").hide();
		$("#driving #do_drive #use_map_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #use_map_row").css("margin-bottom", "10px");
		//$("#driving #do_drive #use_map_row #use_map").prop("checked", false);		
	}
	if(liv['take_phone'] == false){
		$("#driving #do_drive #take_phone_row").hide();	
		$("#driving #do_drive #take_phone_row").find('input, textarea').prop('disabled', true)
		$("#driving #do_drive #take_phone_row").css("margin-bottom", "10px");	
		//$("#driving #do_drive #take_phone_row #take_phone").prop("checked", false);
	}
	
	if(liv['park_big_collat'] == false){
		$("#collateral_driving #do_drive #park_big_row").hide();
		$("#collateral_driving #do_drive #park_big_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #park_big_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #park_big_row #park_big_collat").prop("checked", false);	
	}
	if(liv['day_drive_collat'] == false){
		$("#collateral_driving #do_drive #day_drive_row").hide();	
		$("#collateral_driving #do_drive #day_drive_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #day_drive_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #day_drive_row #day_drive_collat").prop("checked", false);
	}
	if(liv['known_places_collat'] == false){
		$("#collateral_driving #do_drive #known_places_row").hide();
		$("#collateral_driving #do_drive #known_places_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #known_places_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #known_places_row #known_places_collat").prop("checked", false);	
	}
	if(liv['take_friend_collat'] == false){
		$("#collateral_driving #do_drive #take_friend_row").hide();	
		$("#collateral_driving #do_drive #take_friend_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #take_friend_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #take_friend_row #take_friend_collat").prop("checked", false);
	}
	if(liv['dry_run_collat'] == false){
		$("#collateral_driving #do_drive #dry_run_row").hide();	
		$("#collateral_driving #do_drive #dry_run_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #dry_run_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #dry_run_row #dry_run_collat").prop("checked", false);
	}
	if(liv['use_map_collat'] == false){
		$("#collateral_driving #do_drive #use_map_row").hide();	
		$("#collateral_driving #do_drive #use_map_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #use_map_row").css("margin-bottom", "10px");	
		//$("#collateral_driving #do_drive #use_map_row #use_map_collat").prop("checked", false);
	}
	if(liv['take_phone_collat'] == false){
		$("#collateral_driving #do_drive #take_phone_row").hide();
		$("#collateral_driving #do_drive #take_phone_row").find('input, textarea').prop('disabled', true)
		$("#collateral_driving #do_drive #take_phone_row").css("margin-bottom", "10px");
		//$("#collateral_driving #do_drive #take_phone_row #take_phone_collat").prop("checked", false);	
	}

	//COOKING
	if(!(liv['forgot_cooking'])){
		$("#cooking #do_cook #forgot_cooking_row").hide();
		$("#cooking #do_cook #forgot_cooking_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #forgot_cooking_row").css("margin-bottom", "10px");
	}
	if(!(liv['burnt_food'])){
		$("#cooking #do_cook #burnt_food_row").hide();
		$("#cooking #do_cook #burnt_food_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #burnt_food_row").css("margin-bottom", "10px");
	}
	if(!(liv['started_fire'])){
		$("#cooking #do_cook #started_fire_row").hide();
		$("#cooking #do_cook #started_fire_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #started_fire_row").css("margin-bottom", "10px");
	}
	if(!(liv['smoke_alarm'])){
		$("#cooking #do_cook #smoke_alarm_row").hide();
		$("#cooking #do_cook #smoke_alarm_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #smoke_alarm_row").css("margin-bottom", "10px");
	}
	if(!(liv['undercooked'])){
		$("#cooking #do_cook #undercooked_row").hide();
		$("#cooking #do_cook #undercooked_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #undercooked_row").css("margin-bottom", "10px");
	}
	
	if(!(liv['forgot_cooking_collat'])){
		$("#cooking #do_cook #forgot_cooking_row_collat").hide();
		$("#cooking #do_cook #forgot_cooking_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #forgot_cooking_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['burnt_food_collat'])){
		$("#cooking #do_cook #burnt_food_row_collat").hide();
		$("#cooking #do_cook #burnt_food_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #burnt_food_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['started_fire_collat'])){
		$("#cooking #do_cook #started_fire_row_collat").hide();
		$("#cooking #do_cook #started_fire_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #started_fire_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['smoke_alarm_collat'])){
		$("#cooking #do_cook #smoke_alarm_row_collat").hide();
		$("#cooking #do_cook #smoke_alarm_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #smoke_alarm_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['undercooked_collat'])){
		$("#cooking #do_cook #undercooked_row_collat").hide();
		$("#cooking #do_cook #undercooked_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #undercooked_row_collat").css("margin-bottom", "10px");
	}
	
	if(!(liv['timer'])){
		$("#cooking #do_cook #timer_row").hide();
		$("#cooking #do_cook #timer_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #timer_row").css("margin-bottom", "10px");
	}
	if(!(liv['reminders'])){
		$("#cooking #do_cook #reminders_row").hide();
		$("#cooking #do_cook #reminders_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #reminders_row").css("margin-bottom", "10px");
	}
	if(!(liv['simple_cooking'])){
		$("#cooking #do_cook #simple_cooking_row").hide();
		$("#cooking #do_cook #simple_cooking_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #simple_cooking_row").css("margin-bottom", "10px");
	}
	if(!(liv['salad'])){
		$("#cooking #do_cook #salad_row").hide();
		$("#cooking #do_cook #salad_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #salad_row").css("margin-bottom", "10px");
	}
	if(!(liv['go_out'])){
		$("#cooking #do_cook #go_out_row").hide();
		$("#cooking #do_cook #go_out_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #go_out_row").css("margin-bottom", "10px");
	}
	if(!(liv['get_help'])){
		$("#cooking #do_cook #get_help_row").hide();
		$("#cooking #do_cook #get_help_row").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #get_help_row").css("margin-bottom", "10px");
	}

	if(!(liv['timer_collat'])){
		$("#cooking #do_cook #timer_row_collat").hide();
		$("#cooking #do_cook #timer_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #timer_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['reminders_collat'])){
		$("#cooking #do_cook #reminders_row_collat").hide();
		$("#cooking #do_cook #reminders_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #reminders_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['simple_cooking_collat'])){
		$("#cooking #do_cook #simple_cooking_row_collat").hide();
		$("#cooking #do_cook #simple_cooking_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #simple_cooking_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['salad_collat'])){
		$("#cooking #do_cook #salad_row_collat").hide();
		$("#cooking #do_cook #salad_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #salad_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['go_out_collat'])){
		$("#cooking #do_cook #go_out_row_collat").hide();
		$("#cooking #do_cook #go_out_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #go_out_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['get_help_collat'])){
		$("#cooking #do_cook #get_help_row_collat").hide();
		$("#cooking #do_cook #get_help_row_collat").find('input, textarea').prop('disabled', true)
		$("#cooking #do_cook #get_help_row_collat").css("margin-bottom", "10px");
	}
	
	//SHOPPING
	if(!(liv['list_check'])){
		$("#shopping #do_shop #list_row").hide();
		$("#shopping #do_shop #list_row").find('input, textarea').prop('disabled', true)
		$("#shopping #do_shop #list_row").css("margin-bottom", "10px");
	}
	if(!(liv['small_shop_check'])){
		$("#shopping #do_shop #small_shop_row").hide();
		$("#shopping #do_shop #small_shop_row").find('input, textarea').prop('disabled', true)
		$("#shopping #do_shop #small_shop_row").css("margin-bottom", "10px");
	}
	if(!(liv['list_check_collat'])){
		$("#shopping #do_shop #list_row_collat").hide();
		$("#shopping #do_shop #list_row_collat").find('input, textarea').prop('disabled', true)
		$("#shopping #do_shop #list_row_collat").css("margin-bottom", "10px");
	}
	if(!(liv['small_shop_check_collat'])){
		$("#shopping #do_shop #small_shop_row_collat").hide();
		$("#shopping #do_shop #small_shop_row_collat").find('input, textarea').prop('disabled', true)
		$("#shopping #do_shop #small_shop_row_collat").css("margin-bottom", "10px");
	}
}