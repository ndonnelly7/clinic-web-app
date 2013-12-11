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
	} else {
		$('#collat_home_life').slideUp(500);
		showingCollatHome = false;
		$('#home_collat_pressed').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatDriving(button) {
	if(!showingCollatDriving){
		$('#collat_driving').slideDown(500);
		showingCollatDriving = true;
		$('#driving_collat_pressed').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_driving').slideUp(500);
		showingCollatDriving = false;
		$('#driving_collat_pressed').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatNotCooking(button) {
	if(!showingCollatNotCooking){
		$('#collat_not_cooking').slideDown(500);
		showingCollatNotCooking = true;
		$('#cooking_not_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_not_cooking').slideUp(500);
		showingCollatNotCooking = false;
		$('#cooking_not_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatCooking(button) {
	if(!showingCollatCooking){
		$('#collat_cooking').slideDown(500);
		showingCollatCooking = true;
		$('#cooking_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_cooking').slideUp(500);
		showingCollatCooking = false;
		$('#cooking_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatShopping(button) {
	if(!showingCollatShopping){
		$('#collat_shopping').slideDown(500);
		showingCollatShopping = true;
		$('#shopping_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_shopping').slideUp(500);
		showingCollatShopping = false;
		$('#shopping_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatNotShopping(button) {
	if(!showingCollatNotShopping){
		$('#collat_not_shopping').slideDown(500);
		showingCollatNotShopping = true;
		$('#shopping_not_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_not_shopping').slideUp(500);
		showingCollatNotShopping = false;
		$('#shopping_not_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function addNewCollatBills(button) {
	if(!showingCollatBills){
		$('#collat_bills').slideDown(500);
		showingCollatBills = true;
		$('#bills_collat').val("shown");
		$(button).val("Remove Information from Collateral");
	} else {
		$('#collat_bills').slideUp(500);
		showingCollatBills = false;
		$('#bills_collat').val("hidden");
		$(button).val("Add Information from Collateral");
	}
}

function homeHelpChanged(elem) {
	$(elem).prop('checked') ? $('#cook_help_select').append("<option value='home_help'>Home Help</option>") : $("#cook_help_select option[value='home_help']").remove();
	$(elem).prop('checked') ? $('#shop_help_select').append("<option value='home_help'>Home Help</option>") : $("#shop_help_select option[value='home_help']").remove();
}

function cookingCheckChanged(elem, id){
	if($(elem).prop('checked')) {
		$('#does_not_cook').slideUp(250);
		showHiddenDiv(elem, id);
		$('.hide_select').prop('disabled', true);
	} else {
		showHiddenDiv(elem, id);
		$('#does_not_cook').slideDown(250);
	}
}

function shoppingCheckChanged(elem, id){
	if($(elem).prop('checked')) {
		$('#does_not_shop').slideUp(250);
		showHiddenDiv(elem, id);
		$('.hide_select').prop('disabled', true);
	} else {
		showHiddenDiv(elem, id);
		$('#does_not_shop').slideDown(250);
	}
}

function revealDrive(){
	if($('#init_driving_check').prop('checked')){
		$('#does_drive').slideDown(1000);
		$('.hide_select').prop('disabled', true);
	} else {
		$('#does_drive').slideUp(1000);
	}
}

function enableRow(check) {
	if($(check).prop('checked')) {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', false);
	} else {
		$(check).parent().parent().children('.grid_entry_select').children('select').prop('disabled', true);
	}
}