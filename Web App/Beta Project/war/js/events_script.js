/**
 * 
 */
var showingCollatEvents = false;
var showingCollatActivities = false;
var showingCollatAnxDep = false;

$(document).ready(function() {
	$('.current_hours_input').prop('disabled', true);
});

function showReactiveList(select, showId){
	if(select.value != 'threep_yr'){
		populateReactiveList(showId);
		$(showId + " .reactive_list").slideDown(500);
	} else {
		$(showId + " .reactive_list").slideUp(500);
	}
};

function populateReactiveList(div_id){
	$(div_id+' .reactive_list select').html("<option value='other'>Other</option>")
	$('.event_check').each(function() {
		if($(this).prop("checked")){
			var option_name=$(this).parent().parent().prop("id");
			var option_val=($(this).parent().parent().children('.title').children("span").html());
			$(div_id+' .reactive_list select').append('<option value='+option_name+'>'+option_val+'</option>');
		}
	});
};

function addToReactive() {
		populateReactiveList('#anxiety_div')
		populateReactiveList('#depression_div');
};

function showHiddenRowEA(box, rowId) {
	if(box.checked){
		$(rowId + " select").prop("disabled",false);
	} else {
		$(rowId + " select").prop("disabled",true);
	}
	addToReactive();
};

function addNewActivity() {
	$('#activity_entry').clone().appendTo($('#social_div'));
};

function changeActivity(elem) {
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

function addNewCollatEvents() {
	if(!showingCollatEvents){
		$('#events_collat_grid').slideDown(500);
		showingCollatEvents = true;
	} else {
		$('#events_collat_grid').slideUp(500);
		showingCollatEvents = false;
	}
};

function showCollatActivities() {
	if(!showingCollatActivities){
		$('#social_collat_div').slideDown(500);
		showingCollatActivities = true;
	} else {
		$('#social_collat_div').slideUp(500);
		showingCollatActivities = false;
	}
};

function addNewCollatActivity() {
	$('#collat_activity_entry').clone().appendTo($('#social_collat_grid'));
}