var concernsTicked = 0;
var totalAlcoUnits = 0;
var collatPresent = true;
var patient;

$(document).ready(function() {
	$('.hide_div').hide();
	
	$('.want_counties').load("../reuse.html #counties_select");
	$('.want_time_frame').load("../reuse.html #timeframe_1m_3pyr");
	$('.want_frequency').load("../reuse.html #frequency_daily_yearly");
	$('.want_time_frame_hide').load("../reuse.html #timeframe_1m_3pyr").hide();
	$('.want_frequency_hide').load("../reuse.html #frequency_daily_yearly").hide();
	$('.want_time_frame_dis').load("../reuse.html #timeframe_1m_3pyr_dis");
	$('.want_frequency_dis').load("../reuse.html #frequency_daily_yearly_dis");
	$('.want_informal_freq').load("../reuse.html #informal_frequency");
	$('.want_informal_freq_hide').load("../reuse.html #informal_frequency").hide();
	
	collatAdd();
	//initDB and initFormDB
	IDBInit();
	//hideCollat();
});

function spanClick(page){
	$('#text_form').val(page);
	$('#test_form').submit();
};

function linkClick(page){
	$( "#dialog-confirm" ).dialog({
        resizable: false,
        width:360,
        modal: true,
        buttons: {
          "Submit": function() {
        	  $("#linkedPage").val(page);
      		  submitPage();
              $( this ).dialog( "close" );
          },
          "Do not Submit": function() {
        	  spanClick(page);
              $( this ).dialog( "close" );
          },
          Cancel: function() {
        	  $( this ).dialog( "close" );
          }
        }
     });
}

function printPForm(p){
	console.log(p);
}

function collatAdd(){
	var collat = checkCollateral();
	
	if(collat == 'false'){
		console.log("Collateral turned off");
		$('.collat_div').hide();
	};
}

function removeAddition(elem){
	$(elem).parent().parent().remove();
}

function showHiddenDiv(box,id) 
{
     var elm = document.getElementById(id)
     box.checked? $(elm).slideDown(1000):$(elm).slideUp(1000);
}

function showHiddenDivSelect(select,id, displayT,desiredVal)
{
	var elm = document.getElementById(id)
    elm.style.display = select.options[select.selectedIndex].value === desiredVal? displayT:"none"
}

function showHiddenTableSelect(select,divID,desiredVal) {
	if(select.options[select.selectedIndex].value === desiredVal ){
		$(divID).show('clip',{},500);
	}
}

function showHiddenRowText(text, rowId) {
	if(text.value === ''){
		$(rowId + " select").prop("disabled",true);
	} else {
		$(rowId + " select").prop("disabled",false);
	}
}

function showHiddenDivFromText(text, divId) {
	if(text.value === '') {
		$('#'+divId).hide();
	} else {
		var test = parseFloat(text.value);
		if(isNaN(test)){
			text.value = '';
			alert("Must input a number");
		} else {
			$('#'+divId).show();
		}
	}
}

function showHiddenRow(box, rowId) {
	if(box.checked){
		$(rowId + " select").prop("disabled",false);
	} else {
		$(rowId + " select").prop("disabled",true);
	}
	addToReactive();
}

function checkCollateral() {
	if(typeof(sessionStorage) != 'undefined'){
		return sessionStorage.collatPresent;
	}
}

function hideCollat() {
	
	$(".collat_div").hide();
	$(".collat_button").hide();

}

function homeFromForm() {
	if(confirm('Are you sure you want to return to homepage? The form is incomplete')){
		window.location.href = "/admin/home.jsp";
	}
}
