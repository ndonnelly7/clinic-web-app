/**
 * 
 */

var pat;

var days = new Array("0", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st");
var months = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

$(document).ready(function(){
	//check for depression and age
	setTimeout(initAnalysis, 100);
});

function initAnalysis(){
	var p_id = -1;
	var collat = false;
	if(typeof(Storage) !== "undefined"){
		p_id = sessionStorage.p_id;
		collat = sessionStorage.collat;
	}
	
	if(typeof p_id == 'undefined'){
		p_id = 631355661;
	}
	
	getPatient(p_id, function(p){
		pat = p;
	});
	
	getPatientForm(p_id, fillAnalysis)
}

function fillAnalysis(p){
	if(typeof p['battery'] != 'undefined'){
		
		if(typeof p['battery']['mmse'] != 'undefined'){
			$("#mmse_result").val(p['battery']['mmse']['total']);
		} else {
			$("#mmse_div").hide();
		}
		if(typeof p['battery']['moca'] != 'undefined'){
			$("#moca_result").val(p['battery']['moca']['total']);
		} else {
			$("#moca_div").hide();
		}
		if(typeof p['battery']['gds'] != 'undefined'){
			$("#gds_result").val(p['battery']['gds']);
		} else {
			$("#gds_div").hide();
		}
		if(typeof p['battery']['hads'] != 'undefined'){
			$("#hads_result").val(p['battery']['hads']);
		} else {
			$("#hads_div").hide();
		}
		
	} else {
		$("#mmse_div").hide();
		$("#moca_div").hide();
		$("#gds_div").hide();
		$("#hads_div").hide();
		$("#mem_results_field").hide();
	}
	
	createLetter(p, pat);
}

function createLetter(pForm, patient){
	console.log(patient);
	console.log(pForm);
	
	var letterString = "";
	
	var gp_name = patient['gp_name'];
	var drAtStart = false;
	if(gp_name.indexOf("Dr. ") == 0 || gp_name.indexOf("Dr ") == 0){
		letterString += gp_name + "\n";
		drAtStart = true;
	} else {
		letterString += "Dr. " + gp_name + "\n";
	}
	
	letterString += "\n" + patient["dob"] + "\n";
	letterString += "\nRE:" + patient['name'] + "\n";
	letterString += "DOB: " + patient['dob'] + "; ";
	
	//Address
	var address = patient['address'].split("\n");
	
	letterString += address[0];
	for(var i = 1; i < address.length; i++){
		letterString += ", " + address[i];
	}
	letterString += ".\n\n\n";
	
	//Letter
	letterString += "Dear ";
	if(!drAtStart){
		letterString += "Dr. ";
	}
	var gp_name_arr = gp_name.split(" ");
	letterString += gp_name_arr[gp_name_arr.length-1];
	letterString += ",\n\nPatient, "+patient['name']+", attended for assessment of their memory on the ";
	var d = new Date();
	letterString += days[d.getDate()] + " of " + months[d.getMonth()] + ", " + d.getFullYear();
	letterString += ". Please find below results of psychometric testing from the assessment: \n\n";
	
	//Results
	if(jQuery.isEmptyObject(pForm['battery']['mmse'])){
		letterString += "- MMSE: " + "N/A\n";
	} else {
		letterString += "- MMSE: " + pForm['battery']['mmse']['total'] + "/30\n";
		letterString += "\t - Orientation: " + pForm['battery']['mmse']['orientation'] + "/10";
		letterString += "\n\t - Registration: " + pForm['battery']['mmse']['registration'] + "/3";
		letterString += "\n\t - Attention: " + pForm['battery']['mmse']['attention'] + "/5";
		letterString += "\n\t - Recall: " + pForm['battery']['mmse']['recall'] + "/3";
		letterString += "\n\t - Language: " + pForm['battery']['mmse']['language'] + "/9";
		letterString += "\n\t - Copying: " + pForm['battery']['mmse']['copying'] + "/1\n";
	}	
	
	if(jQuery.isEmptyObject(pForm['battery']['moca'])){
		letterString += "- MOCA: " + "N/A\n";
	} else {
		if(pForm['battery']['moca']['blind']){
			letterString += "- MOCA: " + pForm['battery']['moca']['total'] + "/22\n";
			letterString += "\t - Attention: " + pForm['battery']['moca']['attention'] + "/6\n";
			letterString += "\t - Language: " + pForm['battery']['moca']['language'] + "/3\n";
			letterString += "\t - Abstraction: " + pForm['battery']['moca']['abstract'] + "/2\n";
			letterString += "\t - Delayed Recall: " + pForm['battery']['moca']['recall'] + "/5\n";
			letterString += "\t - Orientation: " + pForm['battery']['moca']['orientation'] + "/6\n";
		} else {
			letterString += "- MOCA: " + pForm['battery']['moca']['total'] + "/22\n";
			letterString += "\t - Visuospatial: " + pForm['battery']['moca']['attention'] + "/5\n";
			letterString += "\t - Naming: " + pForm['battery']['moca']['language'] + "/3\n";
			letterString += "\t - Attention: " + pForm['battery']['moca']['attention'] + "/6\n";
			letterString += "\t - Language: " + pForm['battery']['moca']['language'] + "/3\n";
			letterString += "\t - Abstraction: " + pForm['battery']['moca']['abstract'] + "/2\n";
			letterString += "\t - Delayed Recall: " + pForm['battery']['moca']['recall'] + "/5\n";
			letterString += "\t - Orientation: " + pForm['battery']['moca']['orientation'] + "/6\n";
		}
	}
	
	if(jQuery.isEmptyObject(pForm['battery']['gds'])){
		letterString += "- GDS: " + "N/A\n";
	} else {
		letterString += "- GDS: " + pForm['battery']['gds'] + "\n";
	}
	
	if(jQuery.isEmptyObject(pForm['battery']['hads'])){
		letterString += "- HADS: " + "N/A\n";
	} else {
		letterString += "- HADS: " + pForm['battery']['hads'] + "\n";
	}
	
	//Memory concerns
	letterString += "\nPresentation:\nPatient presented with concerns over their memory. Patient stated they have had memory problems for ";
	var concerns = pForm['concerns'];
	
	var concernsTimeArr = new Array();
	concernsTimeArr[0] = "three months";
	concernsTimeArr[1] = "six months";
	concernsTimeArr[2] = "one year";
	concernsTimeArr[3] = "two years";
	concernsTimeArr[4] = "over three years";
	
	var concernsTime = {};
	concernsTime['three_mon'] = 0;
	concernsTime['six_mon'] = 1;
	concernsTime['one_yr'] = 2;
	concernsTime['two_yr'] = 3;
	concernsTime['threep_yr'] = 4;
	var currentLatestTime = 0;
	
	var concernString = "";
	var remember = false;
	var trouble = false;
	var concerns = pForm['concerns'];
	if(concerns[0].checked){
		concernString += "problems remembering ";
		concernString += "recent events";
		remember = true;
		
		if(concernsTime[concerns[0]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[0]['time']];
	}
	
	if(concerns[1].checked){
		if(!remember) 
			concernString += "problems remembering ";
		else if(!(concerns[2].checked))
			concernString += " and ";
		else concernString += ", ";
		concernString += "faces,";
		remember = true;
		
		if(concernsTime[concerns[1]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[1]['time']];
	}
	
	if(concerns[2].checked){
		if(!remember) 
			concernString += "problems remembering ";
		else 
			concernString += " and ";
		concernString += "names, ";
		remember = true;
		
		if(concernsTime[concerns[2]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[2]['time']];
	}
	
	if(concerns[3].checked){
		concernString += "losing things, ";
		
		if(concernsTime[concerns[3]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[3]['time']];
	}
	
	if(concerns[4].checked){
		concernString += "trouble with following conversations, ";
		trouble = true;
		
		if(concernsTime[concerns[4]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[4]['time']];
	}
	
	if(concerns[5].checked){
		if(!trouble)
			concernString += "trouble with ";
		else if(!(concerns[6].checked))
			concernString += "and ";
		else concernString += ", ";
		concernString += " finding the right words, ";
		
		if(concernsTime[concerns[5]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[5]['time']];
	}
	
	if(concerns[6].checked){
		if(!trouble)
			concernString += "trouble with";
		else 
			concernString += "and ";
		concernString += "making decisions, ";
		
		if(concernsTime[concerns[6]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[6]['time']];
	}
	
	if(concerns[7].checked){
		concernString += "problems with making calculations, ";
		
		if(concernsTime[concerns[7]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[7]['time']];
	}
	
	if(concerns[8].checked){
		concernString += "issues with prospective memory, ";
		
		if(concernsTime[concerns[8]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[8]['time']];
	}
	
	if(concerns[9].checked){
		concernString += "anxiety with their memory, ";
		
		if(concernsTime[concerns[9]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[9]['time']];
	}
	
	if(concerns[10].checked){
		concernString += "people have been commenting on their memory, ";
		
		if(concernsTime[concerns[10]['time']] > currentLatestTime)
			currentLatestTime = concernsTime[concerns[10]['time']];
	}
	letterString += concernsTimeArr[currentLatestTime];
	letterString += ", which consists of: ";
	
	concernString = concernString.replace(", and ", " and ");
	concernString = concernString.substring(0, concernString.lastIndexOf(", "));
	var otherString = concernString.substring(concernString.lastIndexOf(", "));
	otherString = otherString.replace(", ", ", and ");
	concernString = concernString.substring(0, concernString.lastIndexOf(", ")) + otherString;
	letterString += concernString + ".";
	
	//Impression
	letterString += "\n\nImpression:\n";
	
	//Outcome
	letterString += "\n\nOutcome:\n";
	
	//Ending
	letterString += "\n\nPlease do not hesitate to contact us on: xxxxxxxx if you require anymore information.\n\n";
	letterString += "Yours sincerely,\n";
	
	$("#letter").val(letterString);
}

function submitPage(){
	$("#analysis_form").submit();
}