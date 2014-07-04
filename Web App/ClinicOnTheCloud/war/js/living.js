/**
 * 
 */
var showingCollatHome = false;
var showingCollatDriving = false;
var showingCollatCooking = false;
var showingCollatNotCooking = false;
var showingCollatShopping = false;
var showingCollatNotShopping = false;
var showingCollatBills = false;

function addNewCollatHomeLife(button) {
	if(!showingCollatHome){
		$('#collat_home_life').slideDown(500);
		showingCollatHome = true;
		$(button).val("Remove Information from Collateral");
		$('#home_collat_pressed').val("shown");
		$("#collat_homelife").val("shown");
	} else {
		$('#collat_home_life').slideUp(500);
		showingCollatHome = false;
		$('#home_collat_pressed').val("hidden");
		$(button).val("Add Information from Collateral");
		$("#collat_homelife").val("hidden");		
	}
}

function addNewCollatDriving(button) {
	if(!showingCollatDriving){
		$('#collat_driving').slideDown(500);
		showingCollatDriving = true;
		$('#driving_collat_pressed').val("shown");
		$(button).val("Remove Information from Collateral");
		$("#collat_drive").val("shown");
	} else {
		$('#collat_driving').slideUp(500);
		showingCollatDriving = false;
		$('#driving_collat_pressed').val("hidden");
		$(button).val("Add Information from Collateral");
		$("#collat_drive").val("hidden");
	}
}

function addNewCollatCooking(button) {
	if(!showingCollatCooking){
		$('#collat_cooking_div').slideDown(500);
		showingCollatCooking = true;
		$('#cooking_collat').val("shown");
		$(button).val("Remove Information from Collateral");
		$("#collat_cook").val("shown");
	} else {
		$('#collat_cooking_div').slideUp(500);
		showingCollatCooking = false;
		$('#cooking_collat').val("hidden");
		$(button).val("Add Information from Collateral");
		$("#collat_cook").val("hidden");
	}
}

function cookingCheckChangedCollat(elem) {
	if(elem.value === 'yes') {
		$('#does_not_cook_collat').slideUp(1000);
		$('#does_cook_collat').slideDown(1000);
	} else {
		$('#does_cook_collat').slideUp(1000);
		$('#does_not_cook_collat').slideDown(1000);
	}
}

function addCollatShopping(button) {
	if(!showingCollatShopping){
		$('#shopping_collat_grid').slideDown(500);
		showingCollatShopping = true;
		$('#shopping_collat').val("shown");
		$(button).val("Remove Information from Collateral");
		$("#collat_shop").val("shown");
	} else {
		$('#shopping_collat_grid').slideUp(500);
		showingCollatShopping = false;
		$('#shopping_collat').val("hidden");
		$(button).val("Add Information from Collateral");
		$("#collat_shop").val("hidden");
	}
}

function addNewCollatBills(button) {
	if(!showingCollatBills){
		$('#collat_bill').slideDown(500);
		showingCollatBills = true;
		$('#bills_collat').val("shown");
		$(button).val("Remove Information from Collateral");
		$("#collat_bills").val("shown");
	} else {
		$('#collat_bill').slideUp(500);
		showingCollatBills = false;
		$('#bills_collat').val("hidden");
		$(button).val("Add Information from Collateral");
		$("#collat_bills").val("hidden");
	}
}

function homeHelpChanged(elem) {
	$(elem).prop('checked') ? $('#cook_help_select').append("<option value='home_help'>Home Help</option>") : $("#cook_help_select option[value='home_help']").remove();
	$(elem).prop('checked') ? $('#shop_help_select').append("<option value='home_help'>Home Help</option>") : $("#shop_help_select option[value='home_help']").remove();
}

function cookingCheckChanged(elem, id){
	if(elem.value === 'yes') {
		$('#does_not_cook').slideUp(1000);
		$('#does_cook').slideDown(1000);
		$('.hide_select').prop('disabled', false);
	} else {
		showHiddenDiv(elem, id);
		$('#does_cook').slideUp(1000);
		$('#does_not_cook').slideDown(1000);
		$('.hide_select').prop('disabled', true);
	}
}

function shoppingCheckChanged(elem, id){
	if(elem.value === 'yes') {
		$('#does_not_shop').slideUp(1000);
		$('#does_shop').slideDown(1000);
		$('.hide_select').prop('disabled', false);
	} else {
		showHiddenDiv(elem, id);
		$('#does_shop').slideUp(1000);
		$('#does_not_shop').slideDown(1000);
		$('.hide_select').prop('disabled', true);
	}
}

function shoppingCheckChangedCollat(elem){
	if(elem.value === 'yes') {
		$('#does_not_shop_collat').slideUp(1000);
		$('#does_shop_collat').slideDown(1000);
		$('.hide_select').prop('disabled', false);
	} else {
		
		$('#does_shop_collat').slideUp(1000);
		$('#does_not_shop_collat').slideDown(1000);
		$('.hide_select').prop('disabled', true);
	}
}

function revealDrive(elem){
	if(elem.value === "yes"){
		$('#does_drive').slideDown(1000);
		$('.hide_select').prop('disabled', false);
		$("#driving_notes").slideUp(1000);
	} else {
		$('#does_drive').slideUp(1000);
		$("#driving_notes").slideDown(1000);
		$('.hide_select').prop('disabled', true);
	}
}

function revealDriveCollat(elem){
	if(elem.value === "yes"){
		$('#does_drive_collat').slideDown(1000);
		$('.hide_select').prop('disabled', false);
		$("#driving_notes_collat").slideUp(1000);
	} else {
		$('#does_drive_collat').slideUp(1000);
		$("#driving_notes_collat").slideDown(1000);
		$('.hide_select').prop('disabled', true);
	}
}

function enableRow(check) {
	if($(check).prop('checked')) {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', false);
	} else {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', true);
	}
}

function enableRowText(check) {
	if($(check).val() != '') {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', false);
	} else {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', true);
	}
}