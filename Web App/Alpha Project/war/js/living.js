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

function addNewCollatHomeLife() {
	if(!showingCollatHome){
		$('#collat_home_life').slideDown(500);
		showingCollatHome = true;
	} else {
		$('#collat_home_life').slideUp(500);
		showingCollatHome = false;
	}
}

function addNewCollatDriving() {
	if(!showingCollatDriving){
		$('#collat_driving').slideDown(500);
		showingCollatDriving = true;
	} else {
		$('#collat_driving').slideUp(500);
		showingCollatDriving = false;
	}
}

function addNewCollatNotCooking() {
	if(!showingCollatNotCooking){
		$('#collat_not_cooking').slideDown(500);
		showingCollatNotCooking = true;
	} else {
		$('#collat_not_cooking').slideUp(500);
		showingCollatNotCooking = false;
	}
}

function addNewCollatCooking() {
	if(!showingCollatCooking){
		$('#collat_cooking').slideDown(500);
		showingCollatCooking = true;
	} else {
		$('#collat_cooking').slideUp(500);
		showingCollatCooking = false;
	}
}

function addNewCollatShopping() {
	if(!showingCollatShopping){
		$('#collat_shopping').slideDown(500);
		showingCollatShopping = true;
	} else {
		$('#collat_shopping').slideUp(500);
		showingCollatShopping = false;
	}
}

function addNewCollatNotShopping() {
	if(!showingCollatNotShopping){
		$('#collat_not_shopping').slideDown(500);
		showingCollatNotShopping = true;
	} else {
		$('#collat_not_shopping').slideUp(500);
		showingCollatNotShopping = false;
	}
}

function addNewCollatBills() {
	if(!showingCollatBills){
		$('#collat_bills').slideDown(500);
		showingCollatBills = true;
	} else {
		$('#collat_bills').slideUp(500);
		showingCollatBills = false;
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
	} else {
		showHiddenDiv(elem, id);
		$('#does_not_cook').slideDown(250);
	}
}

function shoppingCheckChanged(elem, id){
	if($(elem).prop('checked')) {
		$('#does_not_shop').slideUp(250);
		showHiddenDiv(elem, id);
	} else {
		showHiddenDiv(elem, id);
		$('#does_not_shop').slideDown(250);
	}
}