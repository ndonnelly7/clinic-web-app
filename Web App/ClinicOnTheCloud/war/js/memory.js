/**
 * 
 */
var gds = false;
var hads = false;
var moca_blind = false;
var want_moca = false;
var want_mmse = false;

$(document).ready(function(){
	//check for depression and age
	setTimeout(addFormIfNeeded, 100);
});

function runHADSEvaluation(){
	var result = 0;
	var pass = true;
	$(".hads_select").each(function() {
		var v = $(this).val();
		if(v == 'na'){
			pass = false;
			$(this).css({"border": '#FF0000 1px solid'});
		} else {
			result += parseInt(v);
			$(this).css({"border": '#129FC0 1px solid'});
		}
	});
	
	if(!pass){
		alert("Please complete all entries for the HADS quoestionnaire");
	} else {
		$("#result_hads_div").show(500);
		$('#hads_result').val(result);
		if(result >= 21) {
			$('#hads_result_text').text("Severe case of depression/anxiety");
			$('#hads_result_text').css({"color":"red", "margin-left":"1%"});
		} else if(result >= 16) {
			$('#hads_result_text').text("Moderate case of depression/anxiety");
			$('#hads_result_text').css({"color":"orange", "margin-left":"1%"});
		} else if(result >= 11) {
			$('#hads_result_text').text("Mild case of depression/anxiety");
			$('#hads_result_text').css({"color":"yellow", "margin-left":"1%"});
		} else {
			$('#hads_result_text').text("No real signs of depression/anxiety");
			$('#hads_result_text').css({"color":"green", "margin-left":"1%"});
		}
	}
}

function runGDSEvaluation(){
	var result = 0;
	var pass = true;
	$(".gds_select").each(function() {
		var v = $(this).val();
		if(v == 'na'){
			pass = false;
			$(this).css({"border": '#FF0000 1px solid'});
		} else {
			result += parseInt(v);
			$(this).css({"border": '#129FC0 1px solid'});
		}
	});
	
	if(!pass){
		alert("Please complete all entries for the GDS quoestionnaire");
	} else {
		$("#result_gds_div").show(500);
		$('#gds_result').val(result);
		if(result >= 6) {
			$('#gds_result_text').text("Suggestion of depression");
			$('#gds_result_text').css({"color":"red", "margin-left":"1%"});
		} else {
			$('#gds_result_text').text("No real signs of depression");
			$('#gds_result_text').css({"color":"green", "margin-left":"1%"});
		}
	}
}

function updateBorder(elem){
	
	if($(elem).css("border-color") == "rgb(255, 0, 0)" && $(elem).val() != "na"){
		$(elem).css({"border": ''});
	} else if($(elem).val() == "na"){
		$(elem).css({"border": '#FF0000 1px solid'});
	}
}

function changeMOCAForm(x){
	if(x == 'general'){
		$("#moca_general").hide();
		$("#moca_blind").show();
		moca_blind = true;
	} else if(x == 'blind'){
		$("#moca_general").show();
		$("#moca_blind").hide();
		moca_blind = false;
	}
}

function addFormIfNeeded(){
	console.log("Entered function");
	var p_id = -1;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
	}
	console.log("set function");
	getPatientForm(p_id,function(pF){
		var depression = pF['events_activities']['depression'];
		if(depression){
			getPatient(p_id, function(p) {
				var year = p['dob'].split('/')[2];
				var thisYear = new Date().getFullYear();
				if((thisYear - year) > 65){
					$("#gds_form").show();
					gds = true;
				} else {
					$("#hads_form").show();
					hads = true;
				}
			});
		}
	});
}

function revealGDS(elem){
	if($("#gds_form").is(":visible")){
		$("#gds_form").hide(500);
		elem.value = "GDS Test";
		gds = false;
	} else {
		$("#gds_form").show(500);
		elem.value = "Remove GDS Test";
		gds = true;
	}
}

function revealHADS(elem){
	if($("#hads_form").is(":visible")){
		$("#hads_form").hide(500);
		elem.value = "HADS Test";
		hads = false;
	} else {
		$("#hads_form").show(500);
		elem.value = "Remove HADS Test";
		hads = true;
	}
}

function revealMMSE(elem){
	if($("#mmse").is(":visible")){
		$("#mmse").hide(500);
		elem.value = "MMSE Test";
		want_mmse = false;
	} else {
		$("#mmse").show(500);
		elem.value = "Remove MMSE Test";
		want_mmse = true;
	}
};

function revealMOCA(elem){
	if($("#moca").is(":visible")){
		$("#moca").hide(500);
		elem.value = "MOCA Test";
		want_moca = false;
	} else {
		$("#moca").show(500);
		elem.value = "Remove MOCA Test";
		want_moca = true;
	}
};

function nextPage(page) {
	
	var p_id = -1;
	var collat = false;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
		collat = sessionStorage.collat;
	}
	
	var memory = {};
	if(gds){
		memory['gds'] = $("#gds_result").val();
		
	} else {
		memory['gds'] = {};
	}
	if(hads) {
		memory['hads'] = $("#hads_result").val();
	}else {
		memory['gds'] = {};		
	}
	
	var moca = {};
	if(want_moca){
		if(moca_blind){
			moca['blind'] = true;
			
			moca['attention'] = $("#b_attention").val();
			moca['language'] = $("#b_language").val();
			moca['abstract'] = $("#b_abstract").val();
			moca['recall'] = $("#b_recall").val();
			moca['orientation'] = $("#b_orientation").val();
			moca['total'] = $("#b_moca_total").val();
		} else {
			moca['blind'] = false;
			moca['visuo'] = $("#visuo").val();
			moca['naming'] = $("#naming").val();
			moca['attention'] = $("#attention").val();
			moca['language'] = $("#language").val();
			moca['abstract'] = $("#abstract").val();
			moca['recall'] = $("#recall").val();
			moca['orientation'] = $("#orientation").val();
			moca['total'] = $("#moca_total").val();
		}
	}	
	memory['moca'] = moca;
	
	var mmse = {};
	if(want_mmse){
		mmse['orientation'] = $("#mmse_orientation").val();
		mmse['registration'] = $("#mmse_registration").val();
		mmse['attention'] = $("#mmse_attention").val();
		mmse['recall'] = $("#mmse_recall").val();
		mmse['language'] = $("#mmse_language").val();
		mmse['copying'] = $("#mmse_copying").val();
		mmse['total'] = $("#mmse_total").val();
	}
	memory['mmse'] = mmse;
	
	addBattery(p_id, memory);	
	spanClick(page);
}

function submitPage() {
	var p_id = -1;
	var collat = false;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
		collat = sessionStorage.collat;
	}
	
	var memory = {};
	if(gds){
		memory['gds'] = $("#gds_result").val();
		memory['hads'] = {};
	} else if(hads) {
		memory['hads'] = $("#hads_result").val();
		memory['gds'] = {};
	} else {
		memory['gds'] = {};
		memory['hads'] = {};
	}
	
	var moca = {};
	if(want_moca){
		if(moca_blind){
			moca['blind'] = true;
			
			moca['attention'] = $("#b_attention").val();
			moca['language'] = $("#b_language").val();
			moca['abstract'] = $("#b_abstract").val();
			moca['recall'] = $("#b_recall").val();
			moca['orientation'] = $("#b_orientation").val();
			moca['total'] = $("#b_moca_total").val();
		} else {
			moca['blind'] = false;
			moca['visuo'] = $("#visuo").val();
			moca['naming'] = $("#naming").val();
			moca['attention'] = $("#attention").val();
			moca['language'] = $("#language").val();
			moca['abstract'] = $("#abstract").val();
			moca['recall'] = $("#recall").val();
			moca['orientation'] = $("#orientation").val();
			moca['total'] = $("#moca_total").val();
		}
	}	
	memory['moca'] = moca;
	
	var mmse = {};
	if(want_mmse){
		mmse['orientation'] = $("#mmse_orientation").val();
		mmse['registration'] = $("#mmse_registration").val();
		mmse['attention'] = $("#mmse_attention").val();
		mmse['recall'] = $("#mmse_recall").val();
		mmse['language'] = $("#mmse_language").val();
		mmse['copying'] = $("#mmse_copying").val();
		mmse['total'] = $("#mmse_total").val();
	}
	memory['mmse'] = mmse;
	
	addBattery(p_id, memory);
	setTimeout(function() {
		$("#memory_form").submit();
	}, 100);
}

function mmse_change(){
	var total = 0;
	if($("#mmse_orientation").val() != "")
		total += parseInt($("#mmse_orientation").val());
	if($("#mmse_registration").val() != "")
		total += parseInt($("#mmse_registration").val());
	if($("#mmse_attention").val() != "")
		total += parseInt($("#mmse_attention").val());
	if($("#mmse_recall").val() != "")
		total += parseInt($("#mmse_recall").val());
	if($("#mmse_language").val() != "")
		total += parseInt($("#mmse_language").val());
	if($("#mmse_copying").val() != "")
		total += parseInt($("#mmse_copying").val());
	$("#mmse_total").val(total);
}

function moca_change(elem){
	var total = 0;
	if($("#visuo").val() != "")
		total += parseInt($("#visuo").val());
	if($("#naming").val() != "")
		total += parseInt($("#naming").val());
	if($("#attention").val() != "")
		total += parseInt($("#attention").val());
	if($("#abstract").val() != "")
		total += parseInt($("#abstract").val());
	if($("#language").val() != "")
		total += parseInt($("#language").val());
	if($("#recall").val() != "")
		total += parseInt($("#recall").val());
	if($("#orientation").val() != "")
		total += parseInt($("#orientation").val());
	$("#moca_total").val(total);
}

function b_moca_change(elem){
	var total = 0;
	if($("#b_attention").val() != "")
		total += parseInt($("#b_attention").val());
	if($("#b_abstract").val() != "")
		total += parseInt($("#b_abstract").val());
	if($("#b_language").val() != "")
		total += parseInt($("#b_language").val());
	if($("#b_recall").val() != "")
		total += parseInt($("#b_recall").val());
	if($("#b_orientation").val() != "")
		total += parseInt($("#b_orientation").val());
	$("#b_moca_total").val(total);
}

