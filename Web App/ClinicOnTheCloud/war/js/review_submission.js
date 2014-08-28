/**
 * 
 */


function updateDetails() {
	var address = $("#address").val();
	var home_number = $("#home_number").val();
	var mob_number = $("#mob_number").val();
	var email = $("#email").val();
	var gp_name = $("#gp_name").val();
	var gp_address = $("#gp_address").val();
	
	var p_id = $("#id_from_attr").val();
	
	if($("#who_present").val() == "Unknown")
		$("#family_present").val(false)
	else
		$("#family_present").val(true)
	
	getPatient(p_id, function(p) {
		if(p != null){
			p.address = address;
			p.home_number = home_number;
			p.mob_number = mob_number;
			p.email = email;
			p.gp_name = gp_name;
			p.gp_address;
			
			updatePatient(p_id, p);
		}
	});
	
	setTimeout(function() {
		$("#det_form").submit();
	}, 100);
	
}

function updateHistory() {
	var numMedCollats = $("#med_row .collat_col #collat").length;
	for(var m = 0; m < numMedCollats; m++){
		if($("#med_row .collat_col #collat:eq("+m+")").val() == 'true'){
			var cName = $("#med_row .cod_col #condition:eq("+m+")").attr('name').replace("med_", "med_collat_");
			$("#med_row .cod_col #condition:eq("+m+")").attr('name', cName);
			var tName = $("#med_row .time_col #time:eq("+m+")").attr('name').replace("med_", "med_collat_");
			$("#med_row .time_col #time:eq("+m+")").attr('name', tName);
			var nName = $("#med_row .notes_col #notes:eq("+m+")").attr('name').replace("medical_", "medical_collat_");
			$("#med_row .notes_col #notes:eq("+m+")").attr('name', nName);
		}
	}
	
	var numDrugCollats = $("#drug_row .collat_col #collat").length;
	for(var m = 0; m < numDrugCollats; m++){
		console.log($("#drug_row .collat_col #collat:eq("+m+")").val());
		if($("#drug_row .collat_col #collat:eq("+m+")").val() == 'true'){
			var cName = $("#drug_row .drug_col #drug:eq("+m+")").attr('name').replace("drug_", "drug_collat_");
			$("#drug_row .drug_col #drug:eq("+m+")").attr('name', cName);
			var tName = $("#drug_row .time_col #time:eq("+m+")").attr('name').replace("drug_", "drug_collat_");
			$("#drug_row .time_col #time:eq("+m+")").attr('name', tName);
			var nName = $("#drug_row .notes_col #notes:eq("+m+")").attr('name').replace("drug_", "drug_collat_");
			$("#drug_row .notes_col #notes:eq("+m+")").attr('name', nName);
			var sName = $("#drug_row .sleep_col #sleep_med:eq("+m+")").attr('name').replace("sleep_", "sleep_collat_");
			$("#drug_row .sleep_col #sleep_med:eq("+m+")").attr('name', sName);
			var bName = $("#drug_row .benzo_col #benzo_med:eq("+m+")").attr('name').replace("benzo_", "benzo_collat_");
			$("#drug_row .benzo_col #benzo_med:eq("+m+")").attr('name', bName);
		}
	}
	
	var numPsychCollats = $("#psych_row .collat_col #collat").length;
	for(var m = 0; m < numPsychCollats; m++){
		if($("#psych_row .collat_col #collat:eq("+m+")").val() == 'true'){
			var cName = $("#psych_row .psych_col #psych:eq("+m+")").attr('name').replace("psych_", "psych_collat_");
			$("#psych_row .psych_col #psych:eq("+m+")").attr('name', cName);
			var tName = $("#psych_row .time_col #time:eq("+m+")").attr('name').replace("psych_", "psych_collat_");
			$("#psych_row .time_col #time:eq("+m+")").attr('name', tName);
			var nName = $("#psych_row .notes_col #notes:eq("+m+")").attr('name').replace("psych_", "psych_collat_");
			$("#psych_row .notes_col #notes:eq("+m+")").attr('name', nName);
		}
	}
	
	setTimeout(function() {
		$("#history_form").submit();
	}, 100);
}

function updateGPInfo() {
	$("#gp_form").submit();
}

function updateConcern() {
	$("#concerns_form").submit();
}

function updateNeuro() {
	$("#neuro_form").submit();
}

function updateEvents() {
	var numCollats = $("#soc_row .collat_col #collat").length;
	for(var m = 0; m < numCollats; m++) {
		console.log($("#soc_row .collat_col #collat:eq("+m+")").val());
		if($("#soc_row .collat_col #collat:eq("+m+")").val() == 'true'){
			
			var aName = $("#soc_row .collat_col #type:eq("+m+")").attr('name').replace("type", "type_collat");
			$("#soc_row .collat_col #type:eq("+m+")").attr('name', aName);
			
			var iName = $("#soc_row .collat_col #involvement:eq("+m+")").attr('name').replace("involvement", "involvement_collat");
			$("#soc_row .collat_col #involvement:eq("+m+")").attr('name', iName);
			
			var cName = $("#soc_row .collat_col #current_hours:eq("+m+")").attr('name').replace("current_hours", "current_hours_collat");
			$("#soc_row .collat_col #current_hours:eq("+m+")").attr('name', cName);
			
			var pName = $("#soc_row .collat_col #prev_hours:eq("+m+")").attr('name').replace("prev_hours", "prev_hours_collat");
			$("#soc_row .collat_col #prev_hours:eq("+m+")").attr('name', pName);
			
			var tName = $("#soc_row .collat_col #time_changed:eq("+m+")").attr('name').replace("time_changed", "time_changed_collat");
			$("#soc_row .collat_col #time_changed:eq("+m+")").attr('name', tName);
			
			var nName = $("#soc_row .collat_col #notes:eq("+m+")").attr('name').replace("notes", "notes_collat");
			$("#soc_row .collat_col #notes:eq("+m+")").attr('name', nName);
		}
	}
	
	setTimeout(function() {
		$("#events_form").submit();
	}, 100);
}

function updateLiving() {
	$("#living_form").submit();
}

function updateLifestyle() {
	$("#lifestyle_form").submit();
}

function updateAnalysis() {
	$("#analysis_form").submit();
}

function addMedHistory() {
	$("#med_row").clone().appendTo($("#med_history")).hide().show();
	
	$("#med_row:last-child .cod_col #condition").val("");
	$("#med_row:last-child .time_col #time").val("");
	$("#med_row:last-child .collat_col #collat").val("");
	$("#med_row:last-child .notes_col #notes").val("");	
	
}

function addDrugHistory() {
	$("#drug_row").clone().appendTo($("#drug_history")).hide().show();
	
	$("#drug_row:last-child .drug_col #drug").val("");
	$("#drug_row:last-child .time_col #time").val("");
	$("#drug_row:last-child .collat_col #collat").val("");
	$("#drug_row:last-child .notes_col #notes").val("");
	
	$("#drug_row:last-child .sleep_col #sleep_med").val("");
	$("#drug_row:last-child .sleep_col").show();
	
	$("#drug_row:last-child .benzo_col #benzo_med").val("");
	$("#drug_row:last-child .benzo_col").show();
}

function addPsychHistory() {
	$("#psych_row").clone().appendTo($("#psych_history")).hide().show();
	
	$("#psych_row:last-child .psych_col #psych").val("");
	$("#psych_row:last-child .time_col #time").val("");
	$("#psych_row:last-child .collat_col #collat").val("");
	$("#psych_row:last-child .notes_col #notes").val("");		
}

function removeMedHistory() {
	$("#med_row:last-child").remove();
}

function removeDrugHistory() {
	$("#drug_row:last-child").remove();
}

function removePsychHistory() {
	$("#psych_row:last-child").remove();
}

function addActivityRow() {
	$("#soc_row").clone().appendTo($("#activities")).hide().show();
	
	$("#soc_row:last-child .act_col #type").val("");
	$("#soc_row:last-child .cur_col #current_hours").val("");
	$("#soc_row:last-child .pre_col #prev_hours").val("");
	$("#soc_row:last-child .tim_col #time_changed").val("");
	$("#soc_row:last-child .collat_col #collat").val("");
	$("#soc_row:last-child .notes_col #notes").val("");
	
	$("#soc_row:last-child .inv_col #involvement").remove();
	$("#soc_row:last-child .inv_col").append("<select name='involvement' id='invSel' onclick='changeInvolvement(this)'></select>");
	$("#soc_row:last-child .inv_col #invSel").append("<option value='no'>No Longer</option>");
	$("#soc_row:last-child .inv_col #invSel").append("<option value='ongoing'>Ongoing</option>");
	$("#soc_row:last-child .inv_col #invSel").append("<option value='decrease'>Decrease</option>");
	changeInvolvement($("#soc_row:last-child .inv_col #invSel").get(0));
}

function removeActivityRow() {
	$("#soc_row:last-child").remove();
}

function addExerciseRow() {
	$("#exe_row").clone().appendTo($("#exer_grid")).hide().show();
	
	$("#exe_row:last-child .act_col #type").val("");
	$("#exe_row:last-child .cur_col #current_hours").val("");
	$("#exe_row:last-child .pre_col #prev_hours").val("");
	$("#exe_row:last-child .tim_col #time_changed").val("");
	$("#exe_row:last-child .collat_col #collat").val("");
	$("#exe_row:last-child .notes_col #notes").val("");
	
	$("#exe_row:last-child .inv_col #involvement").remove();
	$("#exe_row:last-child .inv_col").append("<select name='involvement' id='invSel' onclick='changeInvolvement(this)'></select>");
	$("#exe_row:last-child .inv_col #invSel").append("<option value='no'>No Longer</option>");
	$("#exe_row:last-child .inv_col #invSel").append("<option value='ongoing'>Ongoing</option>");
	$("#exe_row:last-child .inv_col #invSel").append("<option value='decrease'>Decrease</option>");
	changeInvolvement($("#exe_row:last-child .inv_col #invSel").get(0));
}

function addImpression(){
	$("#imp_row").clone().appendTo($("#impressions")).hide().show();
	$("#imp_row:last-child .imp_col #impression").val("");
	$("#imp_row:last-child .imp_col #impression_notes").val("");
}

function removeImppression() {
	$("#imp_row:last-child").remove();
}

function addOutcome() {
	$("#out_row").clone().appendTo($("#outcomes")).hide().show();
	$("#out_row:last-child .out_col #outcome").val("");
	$("#out_row:last-child .out_col #outcome_notes").val("");
}

function removeOutcome() {
	$("#out_row:last-child").remove();
}

function removeExerciseRow() {
	$("#exe_row:last-child").remove();
}

function changeInvolvement(elem) {
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
}

function changeInvolvementOld(elem) {
	var test = elem.value;
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
		showUnknown(elem.parentNode.parentNode);
	}
}

function showOnNo(elem) {
	$(elem).children('.cur_col').children('#current_hours').prop('disabled', true);
	$(elem).children('.pre_col').children('#prev_hours').prop('disabled', false);
	$(elem).children('.tim_col').children('#time_changed').prop('disabled', false);
	$(elem).children('.notes_col').children('#notes').prop('disabled', false);

}
function showOnDecrease(elem) {
	$(elem).children('.cur_col').children('#current_hours').prop('disabled', false);
	$(elem).children('.pre_col').children('#prev_hours').prop('disabled', false);
	$(elem).children('.tim_col').children('#time_changed').prop('disabled', false);
	$(elem).children('.notes_col').children('#notes').prop('disabled', false);
}

function showOngoing(elem) {
	$(elem).children('.cur_col').children('#current_hours').prop('disabled', false);
	$(elem).children('.pre_col').children('#prev_hours').prop('disabled', true);
	$(elem).children('.tim_col').children('#time_changed').prop('disabled', true);
	$(elem).children('.notes_col').children('#notes').prop('disabled', true);
}

function showUnknown(elem) {
	$(elem).children('.cur_col').children('#current_hours').prop('disabled', true);
	$(elem).children('.pre_col').children('#prev_hours').prop('disabled', true);
	$(elem).children('.tim_col').children('#time_changed').prop('disabled', true);
	$(elem).children('.notes_col').children('#notes').prop('disabled', true);
}

function addDrivingIncident() {
	var c = $("#new_incident").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addDrivingIncidentCollat() {
	var c = $("#new_incident_collat").val()
	var row = $("#" + c + "_row_collat");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addDrivingStrat() {
	var c = $("#new_strat").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addDrivingStratCollat() {
	var c = $("#new_strat_collat").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function changeDriveBool() {
	if($("#drive").val() == "No" || $("#drive").val() == "no"){
		var div = $("#do_drive");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
	} else {
		var div = $("#do_drive");
		div.show();
		div.find('select, .drive_button').prop("disabled", false);
	}
}

function changeDriveBoolCollat() {
	if($("#drive_collat").val() == "No" || $("#drive_collat").val() == "no"){
		var div = $("#do_drive_collat");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
	} else {
		var div = $("#do_drive_collat");
		div.show();
		div.find('select, .drive_button').prop("disabled", false);
	}
}

function changeCookBool() {
	if($("#cook").val() == "No" || $("#cook").val() == "no"){
		var div = $("#do_cook");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
		
		var div2 = $("#do_not_cook");
		div2.show();
		div2.find('input, textarea').prop("disabled", false);
	} else {
		var div = $("#do_cook");
		div.show();
		div.find('select, .cooking_button').prop("disabled", false);
		
		var div2 = $("#do_not_cook");
		div2.hide();
		div2.find('input, textarea').prop("disabled", true);
	}
}

function changeCookBoolCollat() {
	if($("#cooking_collat").val() == "No" || $("#cooking_collat").val() == "no"){
		var div = $("#do_cook_collat");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
		
		var div2 = $("#do_not_cook_collat");
		div2.show();
		div2.find('input, textarea').prop("disabled", false);
	} else {
		var div = $("#do_cook_collat");
		div.show();
		div.find('select, .cooking_button').prop("disabled", false);
		
		var div2 = $("#do_not_cook_collat");
		div2.hide();
		div2.find('input, textarea').prop("disabled", true);
	}
}

function addCookingIncident() {
	var c = $("#cook_incident").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addCookingStrat() {
	var c = $("#cook_strategy").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addCookingIncidentCollat() {
	var c = $("#cook_incident_collat").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addCookingStratCollat() {
	var c = $("#cook_strategy_collat").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function changeShopBool() {
	if($("#shop").val() == "No" || $("#shop").val() == "no"){
		var div = $("#do_shop");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
		
		var div2 = $("#do_not_shop");
		div2.show();
		div2.find('input, textarea').prop("disabled", false);
	} else {
		var div = $("#do_shop");
		div.show();
		div.find('select, .shopping_button').prop("disabled", false);
		div.find('input, textarea').prop("disabled", false);
		div.find('.row input, .row textarea').prop("disabled", true);
		
		var div2 = $("#do_not_shop");
		div2.hide();
		div2.find('input, textarea').prop("disabled", true);
	}
}

function changeShopBoolCollat() {
	if($("#shopping_collat").val() == "No" || $("#shopping_collat").val() == "no"){
		var div = $("#do_shop_collat");
		div.hide();
		div.find('input, textarea').prop("disabled", true);
		
		var div2 = $("#do_not_shop_collat");
		div2.show();
		div2.find('input, textarea').prop("disabled", false);
	} else {
		var div = $("#do_shop_collat");
		div.show();
		div.find('select, .shopping_button').prop("disabled", false);
		div.find('input, textarea').prop("disabled", false);
		div.find('.row input, .row textarea').prop("disabled", true);
		
		var div2 = $("#do_not_shop_collat");
		div2.hide();
		div2.find('input, textarea').prop("disabled", true);
	}
}

function addShoppingStrat() {
	var c = $("#shop_strategy").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}

function addShoppingStratCollat() {
	var c = $("#shop_strategy_collat").val()
	var row = $("#" + c + "_row");
	row.show();
	row.find('input, textarea').prop("disabled", false);
	row.height(neuroHeight);
	row.css("margin-bottom", "10px");
}