/**
 * 
 */
var showingCollatEvents = false;
var showingCollatActivities = false;
var showingCollatAnxDep = false;
var showingCollatActivityDiv = false;

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
			var option_val=($(this).parent().parent().children('.title').html());
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
	var elem = $('#activity_entry').clone();
	$(elem).children(".pure-g-r").children("div").children("select").prop('disabled', false);
	$(elem).children(".pure-g-r").children("div").children("input").val("");
	elem.appendTo($('#social_div'));
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
		$('#showCollatActivitiesDiv').val("Remove Collateral Activities");
	} else {
		$('#social_collat_div').slideUp(500);
		showingCollatActivities = false;
		$('#showCollatActivitiesDiv').val("Add Activity from Collateral");
	}
};

function revealDepression(){
	if($("#feeling_down").val() == 'yes' || $("#no_interest").val() == 'yes'){
		$("#dep_advanced").slideDown(500);
	} else {
		$("#dep_advanced").slideUp(500);
	}
}

function revealSocial(elem) {
	if(elem.value === "yes"){
		$('#social_reveal').slideDown(1000);
		$("#activ_entry").prop("disabled", false);
	} else {
		$('#social_reveal').slideUp(1000);
		$("#activ_entry").prop("disabled", true);
		
	}
}

function revealSocialCollat(elem) {
	if(elem.value === "yes"){
		$('#social_reveal_collat').slideDown(1000);
		$("#collat_activ_entry").prop("disabled", false);
	} else {
		$('#social_reveal_collat').slideUp(1000);
		$("#collat_activ_entry").prop("disabled", true);
	}
}

function addActivityCollat() {
	if(!showingCollatActivityDiv){
		$("#full_social_collat").slideDown(1000);
		$("#addActivityCollatButton").val("Remove Collateral Version");
		showingCollatActivityDiv = true;
	} else {
		$("#full_social_collat").slideUp(1000);
		$("#addActivityCollatButton").val("Collateral Activities");
		showingCollatActivityDiv = false;
	}
}

function addNewActivityToCollat() {
	var elem = $('#activity_entry').clone();
	$(elem).children(".pure-g-r").children("div").children("input").val("");
	elem.appendTo($('#social_div_collat'));
};

function addNewCollatActivity() {
	$('#collat_activity_entry').clone().appendTo($('#social_collat_grid'));
}

function nextPage(page) {
	var p_id = -1;
	var collat = false;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
		collat = sessionStorage.collat;
	}
	
	var ea = {};
	if($("#feeling_down").val() == 'yes' || $("#no_interest").val() == 'yes'){
		if($("#worthless").val() == 'yes' || $("#concentration").val() == 'yes' || $("#death").val() == 'yes'){
			ea['depression'] = true;
		}
	}
	
	addEventsActivities(p_id, ea);
	spanClick(page);
}

function submitPage() {
	var p_id = -1;
	var collat = false;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
		collat = sessionStorage.collat;
	}
	
	var ea = {};
	if($("#feeling_down").val() == 'yes' || $("#no_interest").val() == 'yes'){
		if($("#worthless").val() == 'yes' || $("#concentration").val() == 'yes' || $("#death").val() == 'yes'){
			ea['depression'] = true;
		}
	}
	
	addEventsActivities(p_id, ea);
	$("#events_form").submit();
}