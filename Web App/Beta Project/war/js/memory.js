/**
 * 
 */

function initMemory(){
	//check for depression and age
}

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

function updateBorder(elem){
	
	if($(elem).css("border-color") == "rgb(255, 0, 0)" && $(elem).val() != "na"){
		$(elem).css({"border": ''});
	} else if($(elem).val() == "na"){
		$(elem).css({"border": '#FF0000 1px solid'});
	}
}