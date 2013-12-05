/**
 * 
 */
var collatSleep = false;
var collatExercise = false;
var collatDiet = false;
var collatAlcohol = false;
var collatSmoking = false;
var collatDrugs = false;

function addCollatSleep() {
	if(!collatSleep){
		$('#collat_sleep').slideDown(500);
		collatSleep = true;
	} else {
		$('#collat_sleep').slideUp(500);
		collatSleep = false;
	}
};

function addCollatExercise() {
	if(!collatExercise){
		$('#collat_exercise').slideDown(500);
		collatExercise = true;
	} else {
		$('#collat_exercise').slideUp(500);
		collatExercise = false;
	}
};

function addCollatDiet() {
	if(!collatDiet){
		$('#collat_diet').slideDown(500);
		collatDiet = true;
	} else {
		$('#collat_diet').slideUp(500);
		collatDiet = false;
	}
};

function addCollatAlcohol() {
	if(!collatAlcohol){
		$('#collat_alcohol').slideDown(500);
		collatAlcohol = true;
	} else {
		$('#collat_alcohol').slideUp(500);
		collatAlcohol = false;
	}
};

function addCollatSmoking() {
	if(!collatSmoking){
		$('#collat_smoking').slideDown(500);
		collatSmoking = true;
	} else {
		$('#collat_smoking').slideUp(500);
		collatSmoking = false;
	}
};

function addCollatDrugs() {
	if(!collatDrugs){
		$('#collat_drugs').slideDown(500);
		collatDrugs = true;
	} else {
		$('#collat_drugs').slideUp(500);
		collatDrugs = false;
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
	updateUnits();
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
	$(elem).children('.when_stopped').children('.time_stopped_input').prop('disabled', true);
	$(elem).children('.reason_notes').children('.reason_input').prop('disabled', false);
}

function showOngoing(elem) {
	$(elem).children('.current_hours').children('.current_hours_input').prop('disabled', false);
	$(elem).children('.previous_hours').children('.prev_hours_input').prop('disabled', true);
	$(elem).children('.when_stopped').children('.time_stopped_input').prop('disabled', true);
	$(elem).children('.reason_notes').children('.reason_input').prop('disabled', true);
}