/**
 * 
 */
var collatSleep = false;
var collatExercise = false;
var collatDiet = false;
var collatAlcohol = false;
var collatSmoking = false;
var collatDrugs = false;

$(document).ready(function() {
	console.log("Working");
	setTimeout(retrieveSleepInfo, 100);
});

function addCollatSleep(button) {
	if(!collatSleep){
		$('#collat_sleep').slideDown(500);
		collatSleep = true;
		$('#sleep_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_sleep').slideUp(500);
		collatSleep = false;
		$('#sleep_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

function addCollatExercise(button) {
	if(!collatExercise){
		$('#collat_exercise').slideDown(500);
		collatExercise = true;
		$('#exercise_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_exercise').slideUp(500);
		collatExercise = false;
		$('#exercise_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

function revealExercise(elem){
	if(elem.value === 'yes'){
		$("#does_exercise").slideDown(1000);
	} else {
		$("#does_exercise").slideUp(1000);
	}
}

function revealExerciseCollat(elem){
	if(elem.value === 'yes'){
		$("#collat_does_exercise").slideDown(1000);
	} else {
		$("#collat_does_exercise").slideUp(1000);
	}
}

function revealAlcohol(elem){
	if(elem.value === 'yes'){
		$("#alcohol_qs").slideDown(1000);
	} else {
		$("#alcohol_qs").slideUp(1000);
	}
}

function revealAlcoholCollat(elem){
	if(elem.value === 'yes'){
		$("#alcohol_collat_qs").slideDown(1000);
	} else {
		$("#alcohol_collat_qs").slideUp(1000);
	}
}

function revealSmoking(elem){
	if(elem.value === 'yes'){
		$("#smoking_qs").slideDown(1000);
	} else {
		$("#smoking_qs").slideUp(1000);
	}
}

function revealSmokingCollat(elem){
	if(elem.value === 'yes'){
		$("#smoking_collat_qs").slideDown(1000);
	} else {
		$("#smoking_collat_qs").slideUp(1000);
	}
}

function addCollatDiet(button) {
	if(!collatDiet){
		$('#collat_diet').slideDown(500);
		collatDiet = true;
		$('#diet_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_diet').slideUp(500);
		collatDiet = false;
		$('#diet_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

function addCollatAlcohol(button) {
	if(!collatAlcohol){
		$('#collat_alcohol').slideDown(500);
		collatAlcohol = true;
		$('#alcohol_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_alcohol').slideUp(500);
		collatAlcohol = false;
		$('#alcohol_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

function addCollatSmoking(button) {
	if(!collatSmoking){
		$('#collat_smoking').slideDown(500);
		collatSmoking = true;
		$('#smoking_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_smoking').slideUp(500);
		collatSmoking = false;
		$('#smoking_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

function addCollatDrugs(button) {
	if(!collatDrugs){
		$('#collat_drugs').slideDown(500);
		collatDrugs = true;
		$('#drugs_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_drugs').slideUp(500);
		collatDrugs = false;
		$('#drugs_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
};

$(document).ready(function() {
	$('.current_hours_input').prop('disabled', true);
});

function updateUnits() {
	var totalUnits = 0;
	$('.units_box').each(function () {
		var temp = parseFloat($(this).val());
		if(temp > 0 ){
			totalUnits += temp;
		}
	});
	document.getElementsByName("total_units")[0].value=totalUnits;
	
	if(typeof(Storage) !== "undefined"){
		
		if((sessionStorage == "female" && totalUnits > 14) || totalUnits > 21){
			$("#total_units").css({'border': '2px solid #FF0000'});
			$("#total .warning_span").remove();
			$("#total").append("<div class='warning_span' >Warning: Exceeding recommended weekly alcohol intake</div>")
			sessionStorage.alcohol_problem = true;
		} else {
			$("#total_units").removeAttr('style');
			$("#total .warning_span").remove();
			sessionStorage.alcohol_problem = false;
		}
	}
}

function updateUnitsCollat() {
	var totalUnits = 0;
	$('.units_box').each(function () {
		var temp = parseFloat($(this).val());
		if(temp > 0 ){
			totalUnits += temp;
		}
	});
	document.getElementsByName("total_units_collat")[0].value=totalUnits;
	
	if(typeof(Storage) !== "undefined"){
		
		if((sessionStorage == "female" && totalUnits > 14) || totalUnits > 21){
			$("#total_units_collat").css({'border': '2px solid #FF0000'});
			$("#total_collat .warning_span").remove();
			$("#total_collat").append("<div class='warning_span' >Warning: Exceeding recommended weekly alcohol intake</div>")
			sessionStorage.alcohol_problem = true;
		} else {
			$("#total_units_collat").removeAttr('style');
			$("#total_collat .warning_span").remove();
			sessionStorage.alcohol_problem = false;
		}
	}
}

function updateThisUnit(text, name) {
	var val=parseFloat(text.value);
	var units = 0;
	console.log(val);
	switch (name) {
	case 'wine_glass_units':
		units = 2.2*val;
		break;
	case 'spirit_units':
		units = 1.3*val;
		break;
	case 'beer_bottle_units':
		units = 1.6*val;
		break;
	case 'beer_pint_units':
		units = 2.8*val;
		break;
	case 'pop_units':
		units = 1.3*val;
		break;
	}
	units = units.toFixed(1);
	document.getElementsByName(name)[0].value=units;
	if(name.indexOf("collat") < 0) {
		updateUnits();
	} else {
		updateUnitsCollat();
	}
}

function addNewExercise() {
	$('#exercise_entry').clone().appendTo($('#exercise_grid'));
};

function addNewCollatExercise() {
	$('#exercise_entry').clone().appendTo($('#collat_exercise_grid'));
}

function changeExercise(elem) {
	switch(elem.value){
	case 'no':
		showOnNo(elem.parentNode.parentNode);
		break;
	case 'decrease':
		showOnDecrease(elem.parentNode.parentNode);
		break;
	case 'ongoing':
		showOngoing(elem.parentNode.parentNode);
		break;
	default:
		console.log("Wuh oh");
	}
};

function showOnNo(elem) {
	$(elem).children('.current_hours').children('.current_hours_input').prop('disabled', true);
	$(elem).children('.previous_hours').children('.prev_hours_input').prop('disabled', false);
	$(elem).children('.when_stopped').children('.time_stopped_input').prop('disabled', false);
	$(elem).children('.reason_notes').children('.reason_input').prop('disabled', false);

}
function showOnDecrease(elem) {
	$(elem).children('.current_hours').children('.current_hours_input').prop('disabled', false);
	$(elem).children('.previous_hours').children('.prev_hours_input').prop('disabled', false);
	$(elem).children('.when_stopped').children('.time_stopped_input').prop('disabled', false);
	$(elem).children('.reason_notes').children('.reason_input').prop('disabled', false);
}

function showOngoing(elem) {
	$(elem).children('.current_hours').children('.current_hours_input').prop('disabled', false);
	$(elem).children('.previous_hours').children('.prev_hours_input').prop('disabled', true);
	$(elem).children('.when_stopped').children('.time_stopped_input').prop('disabled', true);
	$(elem).children('.reason_notes').children('.reason_input').prop('disabled', true);
}

function retrieveSleepInfo() {
	console.log("Entered function");
	var p_id = -1;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
	}
	console.log("set function");
	getPatientForm(p_id,updatePageWithLocal);
	
}

function updatePageWithLocal(pF) {
	console.log("Entered getpForm function");
	console.log(pF);
	var drugs = pF['history']['drugs'];
	console.log(drugs[0]['drug']);
	if(drugs[0]['drug']=='sleeping'){
		$("#sleep_meds_check").prop("checked", "true");
		showHiddenDiv($("#sleep_meds_check").get(0), 'meds_sleep_qs');
		$("#sleep_meds_s").val(drugs[0]['sleep_med']);
	}
}