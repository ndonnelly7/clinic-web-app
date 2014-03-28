var username, clinicname, channelToken;
var showingPatients = false, showingQuery = false;
$(document).ready(function() {
	username = $('#name_div').html();
	clinicname = $('#clinic_div').html();
	channelToken = $('#token').html();
	
	$("#infotext").append("<div>"+username+"</div>");
	$("#infotext").append("<div>"+clinicname+"</div>");
	$("#infotext").append("<div>"+channelToken+"</div>");
	
	var channel = new goog.appengine.Channel(channelToken);
	socket = channel.open();
	socket.onmessage = channelComm;
	
	IDBInit();
	P2PInit();
	
	//updateServer();
	//synchMe();
});

function CheckChannel() {
	$("#infotext").append("<div>Checking the Channel</div>");
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"ChannelCheck",
			user:username,
			clinic:clinicname
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function afterIDBInit(){
	updateServerInit();
	$("#infotext").append("<span>Signed In Fully At: "+getTimeString()+"</span><br>");
}

function updateServerInit(){
	getPatientKeysForServer();
}

function updateServer(pKeys){
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"UpdatePatientList",
			client:username,
			clinic:clinicname,
			keys:pKeys
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function syncMe() {
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"SyncMe",
			client:username,
			clinic:clinicname,
			peerID:p2pID
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function channelComm(message) {
	$("#infotext").append("<div>Google Channel:</div>");
	$("#infotext").append("<div>"+message.data+"</div>");
	
	//Don't forget the possibility of a ping message
	var resp = message.data.split(":");
	
	//PatientRequest
	if(resp[0] == "Request"){
		$("#infotext").append("<div>Request received for: " + resp[1] + "</div>");
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(resp[1]);
		
		request.onerror = function(e) {
			//TODO:Send AJAX to say can't find patient
			$("#infotext").append("<div>Can't find patient with ppsn of: " + resp[1] + "</div>");
		}
		
		request.onsuccess = function(e) {
			sendPatientFromPeer(resp[1],resp[3]);
		}
	} else if(resp[0] == "RETRIEVAL"){
		var toAppend = "";
		for(var i = 1; i < resp.length; i++){
			toAppend += resp[i];
		}
		$("#infotext").append("<div>"+toAppend+"</div>");
	} else if(resp[0] == "UPDATEREQUEST"){
		if(resp[1] == "TRUE"){
			var ppsn = resp[3];
			var peer = resp[5];
			requestPatientFromPeer(peer,ppsn);
		}
	} else if(resp[0] == "REMOVEPATIENT"){
		removePatient(resp[1]);
	} else if(resp[0] == "SENDREQUEST"){
		$("#infotext").append("<span>Sending Request for: "+resp[1]+"</span><br>");
		var request = resp[1];
		$.ajax('/webrtceval.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"RetrievePatient",
				ppsn:request,
				clinic:clinicname,
				client:p2pID
			},
			success:function(response) {
				if(response.indexOf("Error:") != -1)
					$("#infotext").append("<div>"+response+"</div>");
			}
		});
	}
	
}

function fillPatientInfo() {
	if(showingPatients){
		$("#patient_info").html("");
		$("#patient_info").append('<input type="button" value="See Patients" onclick="fillPatientInfo()">');
	} else {
		$("#patient_info").html("");
		showAllPatients();
		$("#patient_info").append('<input type="button" value="Hide Patients" onclick="fillPatientInfo()">')
	}
	showingPatients = !showingPatients;
}

function addPatient() {
	$("#pat_name").val("");
	$("#pat_address").val("");
	$("#pat_ppsn").val("");
	$("#pat_number").val("");
	$("#add_patient").slideDown(1000);
	
	$("#patDetailsButton").val("Hide Patient Form");
	$("#patDetailsButton").attr("onclick", "hidePatForm()");
}

function hidePatForm(){
	$("#patDetailsButton").val("Add Patient");
	$("#patDetailsButton").attr("onclick", "addPatient()");
	$("#add_patient").slideUp(500);
}

function retrievePatientDiv(){
	$("#get_ppsn").val("");
	$("#get_clinic").val("");
	$("#retrieve_patient").slideDown(500);
	
	$("#retrievePatButton").val("Hide Patient Retrieval Form");
	$("#retrievePatButton").attr("onclick", "hideRetrieveDiv()");
}

function hideRetrieveDiv() {
	$("#retrieve_patient").slideUp(500);
	
	$("#retrievePatButton").val("Find a Patient from Another Clinic");
	$("#retrievePatButton").attr("onclick", "retrievePatientDiv()");
}

function retrievePatient() {
	$("#infotext").append("<span>Asking for Patient: "+getTimeString()+"</span><br>");
	var ppsn_pat = $("#get_ppsn").val();
	var clinic_pat = $("#get_clinic").val();
	
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"RetrievePatient",
			ppsn:ppsn_pat,
			clinic:clinic_pat,
			client:p2pID
		},
		success:function(response) {
			if(response.indexOf("Error:") != -1)
				$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function addPatientDetails() {
	$("#infotext").append("<span>Adding Patient: "+getTimeString()+"</span><br>");
	var patName = $("#pat_name").val();
	var patAddress = $("#pat_address").val();
	var pat_ppsn = $("#pat_ppsn").val();
	var pat_number = $("#pat_number").val();
	var pat_weight = $("#weight").val();
	var alcohol_points = $("#alcohol_points").val();
	var stress_cause = $("#stress_cause").val();
	var sleep_hours = $("#sleep_hours").val();
	var mem_score = $("#mem_score").val();
	var dementia = $("#dementia_val").val();
	
	$("#infotext").append("<span>Details to be added: </span><br>");
	$("#infotext").append("<span>Name: " + patName + "</span><br>");
	$("#infotext").append("<span>Address: " + patAddress + "</span><br>");
	$("#infotext").append("<span>PPSN: " + pat_ppsn + "</span><br>");
	$("#infotext").append("<span>Number: " + pat_number + "</span><br>");
	$("#infotext").append("<span>Name: " + pat_weight + "</span><br>");
	$("#infotext").append("<span>Address: " + alcohol_points + "</span><br>");
	$("#infotext").append("<span>PPSN: " + stress_cause + "</span><br>");
	$("#infotext").append("<span>Number: " + sleep_hours + "</span><br>");
	$("#infotext").append("<span>PPSN: " + mem_score + "</span><br>");
	$("#infotext").append("<span>Dementia: " + dementia + "</span><br>");
	
	$("#patDetailsButton").val("Add Patient");
	$("#add_patient").slideUp(500);
	
	var pat = new Patient(patName, patAddress, pat_ppsn, pat_number, pat_ppsn);
	addPatientToDB(pat);
	
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"AddPatient",
			ppsn:pat_ppsn,
			client:username,
			clinic:clinicname,
			weight:pat_weight,
			points:alcohol_points,
			stress:stress_cause,
			sleep:sleep_hours,
			memory:mem_score,
			dementia:dementia
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
			$("#infotext").append("<span>Patient Added: "+getTimeString()+"</span><br>");
		}
	});
}

function getMoreInfoOn(pIDDiv){
	var pID = $(pIDDiv).attr('id').split("_")[1];
	$("#infotext").append("<span>Finding info for ID: " + pID + "</span><br>");
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"FindPatient",
			ppsn:pID,
			clinic:clinicname
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
			addMoreInfo(pID, $.parseJSON(response));
		}
	});
}

function addMoreInfo(pID, json){
	$("#infotext").append("<div>Attempting to add more info</div>");
	$("#button_" + pID).remove();
	
	var toAppend = "<div id='div_"+pID+"'><span>Stress: " + json["stress"] + " </span><br>";
	toAppend += "<span>Cause of Stress: " + json["stress_cause"] + " </span><br>";
	toAppend += "<span>Memory Problems: " + json["memory"] + " </span><br>";
	toAppend += "<span>Memory Test Score: " + json["mem_score"] + " </span><br>";
	toAppend += "<span>Alcohol: " + json["alcohol"] + " </span><br>";
	toAppend += "<span>Points per week: " + json["alcoPoints"] + " </span><br>";
	toAppend += "<span>Diet: " + json["diet"] + " </span><br>";
	toAppend += "<span>Weight: " + json["weight"] + " </span><br>";
	toAppend += "<span>Sleep: " + json["sleep"] + " </span><br>";
	toAppend += "<span>Sleep Hours: " + json["sleep_hours"] + " </span><br>";
	toAppend += "<span>Dementia: " + json["dementia"] + " </span><br>";
	toAppend += "<input type='button' value='Update Info' onclick='updatePatientInfo(this,\""+pID+"\")' id='updateBtn_"+pID+"'>";
	toAppend += "<input type='button' value='Delete Patient' onclick='deletePatientInfo(this,\""+pID+"\")' id='deleteBtn_"+pID+"'>";
	toAppend += "</div>"
	$("#patient_" + pID).append(toAppend);
}

function someFunction(){
	$("#infotext").append("<div>Woop</div>");
}

function updatePatientInfo(updateDiv, id){
	$("#div_" + id).remove();
	var pcgStr = '<div class="pure-control-group">';
	var endDiv = '</div>';
	
	var toAppend = "<div id='div_"+id+"'>";
	//Stress
	toAppend += '<span>Stress: ' + json["stress"] + ' </span><br>';
	toAppend += pcgStr + '<label for="stress_cause">Stress Cause:</label><select id="stress_cause">';
    toAppend +=	'<option value="none">None</option><option value="family">Family</option>';
    toAppend += '<option value="work">Work</option><option value="loss">Loss</option>';
    toAppend += '<option value="health">Health</option></select>' + endDiv;
    
    //Memory
    toAppend += "<span>Memory Problems: " + json["memory"] + " </span><br>";
    toAppend += pcgStr + '<label for="mem_score">Memory Score:</label>';
    toAppend += '<input type="text" id="mem_score" name="mem_score" style="width:48px;">' + endDiv;
    
    //Alcohol
	toAppend += "<span>Alcohol: " + json["alcohol"] + " </span><br>";
	toAppend += pcgStr + '<label for="alcohol_points">Alcohol Points:</label>';
	toAppend += '<input type="text" id="alcohol_points" name="alcohol_points" style="width:48px;">' + endDiv;

	//Diet
	toAppend += "<span>Diet: " + json["diet"] + " </span><br>";
	toAppend += pcgStr + '<label for="weight">Weight (kg):</label><input type="text" id="weight" name="weight" style="width:48px;">' + endDiv;
	
	//Sleep
	toAppend += "<span>Sleep: " + json["sleep"] + " </span><br>";
	toAppend += pcgStr + '<label for="sleep_hours">Sleep Hours:</label>';
	toAppend += '<input type="text" id="sleep_hours" name="sleep_hours" style="width:48px;">' + endDiv;
	
	//Dementia
	toAppend += "<span>Dementia: " + json["dementia"] + " </span><br>";
	
	
	toAppend += "<input type='button' value='Update' onclick='sendUpdateInfo(this)' id='updateBtn_"+id+"'>";
	toAppend += "<input type='button' value='Delete Patient' onclick='deletePatientInfo(this)' id='deleteBtn_"+id+"'>";
	toAppend += "</div>"
	$("#patient_" + id).append(toAppend);
}

function deletePatientInfo(deleteDiv, id){
	
}

function SignOut() {
	/*
	 * Disable All input
	 * Do DOM unloaded stuff for P2P
	 * Put client name and clinic name in form
	 * Submit form
	 */
	$("#pat_name").prop("disabled", true);
	$("#pat_address").prop("disabled", true);
	$("#pat_ppsn").prop("disabled", true);
	$("#pat_number").prop("disabled", true);
	$("#get_ppsn").prop("disabled", true);
	$("#get_clinic").prop("disabled", true);
	
	p2pUnload();
	
	$("#general_form").submit();
}

window.onunload = window.onbeforeunload = function(e) {
	p2pUnload();
	
	$.ajax('/signout.do', {
		method:'GET',
		dataType:'text',
		data: {
			name:username,
			clinic:clinicname,
			mode:"ajax"
		},
	});
};

function resetDataStore(){
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"RESETPEER"
		},
		success:function(response) {
			resetFinish();
		}
	});
}

function resetFinish(){
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"RESETPATIENT"
		},
		success:function(response) {
			clearObjectStore();
			SignOut();
		}
	});
}

function AddMultiPatient(index,limit){
	if(index <= limit){
		$("#infotext").append("<div>Adding Patient "+(index)+" of " + limit + "</div>");
		$("#infotext").append("<span>Time of Add: "+getTimeString()+"</span><br>");
		var patName = getName();
		var patAddress = getAddress();
		var pat_ppsn = getPPSN();
		var pat_number = getPhoneNumber();
		
		var weight = getWeight();
		var alcohol_points = getAlcoPoints();
		var stress = getStress();
		var sleep_hours = getHours();
		var mem_score = getMemory();
		var dementia = getDementia();
		
		var pat = new Patient(patName, patAddress, pat_ppsn, pat_number, pat_ppsn);
		addPatientToDB(pat);
		
		$.ajax('/webrtceval.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"AddPatient",
				ppsn:pat_ppsn,
				client:username,
				clinic:clinicname,
				weight:weight,
				points:alcohol_points,
				stress:stress,
				sleep:sleep_hours,
				memory:mem_score,
				dementia:dementia
			},
			success:function(response) {
				$("#infotext").append("<div>"+response+"</div>");
				AddMultiPatient(index+1,limit);
			}
		});
	} else {
		$("#infotext").append("<div>Multiple Patients Added</div>");
		$("#infotext").append("<span>Time at final Add: "+getTimeString()+"</span><br>");
	}
}

function getTimeString(){
	var currentdate = new Date(); 
	var datetime = "Time: " 
	                + currentdate.getHours() + ":"  
	                + currentdate.getMinutes() + ":" 
	                + currentdate.getSeconds() + ":"
	                + currentdate.getMilliseconds();
	return datetime;
}

function openQueryBox(){
	if(!showingQuery){
		$("#query_box").show();
		$("#sql_button").prop("value","Close Query");
		showingQuery = true;
	} else {
		$("#query_box").hide();
		$("#sql_button").prop("value","Open Query");
		showingQuery = false;
	}
}

function sendQuery(){
	request = "SELECT ";
	request += $("#selectSelect").val();
	request += " FROM ";
	request += $("#selectFrom").val();
	request += " WHERE ";
	if($("#ppsn_query").val() != ""){
		request += "ppsn='" + $("#ppsn_query").val() + "'";
	} else {
		prevEntered = false;
		//DEMENTIA
		if($("#dementia_q").val() != ("irrelevant")){
			if($("#dementia_q").val() == "yes") {
				request += "`DEMENTIA`=" + "TRUE";
			} else if($("#dementia_q").val() == "no") {
				request += "`DEMENTIA`=" + "FALSE";
			}
			prevEntered = true;
		}
		
		//MEMORY
		if($("#memory_q").val() != ("irrelevant")){
			if(prevEntered)
				request += " AND ";
			if($("#memory_q").val() == "yes")
				request += "`MEMORY`=" + "TRUE";
			else if($("#memory_q").val() == "no")
				request += "`MEMORY`=" + "FALSE";
			
			prevEntered = true;
		}
		if($("#memory_s").val() != ""){
			if(prevEntered)
				request += " AND ";
			request += "`SCORE`" + getQueryOperator($("#memory_s_select").val())
				+ $("#memory_s").val();
			prevEntered = true;
		}
		
		//ALCOHOL
		if($("#alcohol_q").prop("checked")){
			if(prevEntered)
				request += " AND ";
			if($("#alcohol_q").val() == "yes")
				request += "`ALCOHOL`=" + "TRUE";
			else if($("#memory_q").val() == "no")
				request += "`ALCOHOL`=" + "FALSE";
			
			prevEntered = true;
		}
		if($("#alcohol_p").val() != ""){
			if(prevEntered)
				request += " AND ";
			request += "`POINTS`" + getQueryOperator($("#alcohol_p_select").val())
				+ $("#alcohol_p").val();
			prevEntered = true;
		}
		
		//DIET
		if($("#diet_q").prop("checked")){
			if(prevEntered)
				request += " AND ";
			if($("#diet_q").val() == "yes")
				request += "`DIET`=" + "TRUE";
			else if($("#alcohol_q").val() == "no")
				request += "`DIET`=" + "FALSE";
			
			prevEntered = true;
		}
		if($("#weight_kg").val() != ""){
			if(prevEntered)
				request += " AND ";
			request += "`WEIGHT`" + getQueryOperator($("#weight_kg_select").val())
				+ $("#weight_kg").val();
			prevEntered = true;
		}
		
		//SLEEP
		if($("#sleep_q").prop("checked")){
			if(prevEntered)
				request += " AND ";
			if($("#sleep_q").val() == "yes")
				request += "`SLEEP`=" + "TRUE";
			else if($("#sleep_q").val() == "no")
				request += "`SLEEP`=" + "FALSE";
			prevEntered = true;
		}
		if($("#sleep_h").val() != ""){
			if(prevEntered)
				request += " AND ";
			request += "`HOURS`" + getQueryOperator($("#sleep_h_select").val())
				+ $("#sleep_h").val();
			prevEntered = true;
		}
		
		//STRESS
		if($("#stress_q").prop("checked")){
			if(prevEntered)
				request += " AND ";
			if($("#sleep_q").val() == "yes")
				request += "`STRESS`=" + "TRUE";
			else if($("#sleep_q").val() == "no")
				request += "`STRESS`=" + "FALSE";
		}
		if($("#stress_c").val() != ""){
			if(prevEntered)
				request += " AND ";
			request += "`CAUSE`=" + $("#stress_c").val();
			prevEntered = true;
		}
	}
	$("#infotext").append("<div>Sending SQL query "+request+"</div>");
	$("#patientQueryDisplay").html("");
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"SQLRequest",
			query:request
		},
		success:function(response) {
			parseQueryResponse(response);
		}
	});
}

function getQueryOperator(op){
	switch(op){
	case "gte":
		return ">";
		break;
	case "lte":
		return "<";
		break;
	case "eq":
		return "=";
		break;
	default:
		$("#infotext").append("<div>Error in operator: Received '" + op + "'</div>");
	}
}

function parseQueryResponse(resp){
	if(resp.indexOf("ERROR") == 0){
		$("#infotext").append("<div>"+resp+"</div>");
	} else if(resp.indexOf("Multiple:") == 0){
		var arr = JSON.parse(resp.substring(("Multiple:").length));
		console.log(arr);
		for(var i = 0; i < arr.length; i++){
			showQueryPatient(arr[i]);
		}
	} else if(resp.indexOf("Single:")==0){
		$("#infotext").append("<div>Received single patient: "+resp+"</div>");
		var p = JSON.parse(resp.substring(("Single:").length));
		console.log(p)
		showQueryPatient(p);
	} else {
		$("#infotext").append("<div>Received private patient: "+resp+"</div>");
		var p = JSON.parse(resp);
		console.log(p);
		shoqQueryPatient(p);
	}
}

function showQueryPatient(p){
	var toAppend = "<div class='patient_info' id='patient_"+p.ppsn+"' style='background-color:"+color[colorIndex]+"'>";
	toAppend += "<span>PPSN: " + p.ppsn + " </span><br>";
	toAppend += "<span>Dementia: " + p.dementia + " </span><br>";
	toAppend += "<span>Memory: " + p.memory + " </span><br>";
	toAppend += "<span>Memory Score:" + p.mem_score + "</span><br>"
	toAppend += "<span>Alcohol: " + p.alcohol + " </span><br>";
	toAppend += "<span>Alcohol Points: " + p.alcoPoints + "</span><br>";
	toAppend += "<span>Stress: " + p.stress + " </span><br>";
	toAppend += "<span>Stress Cause: " + p.stress_cause + " </span><br>";
	toAppend += "<span>Diet: " + p.diet + " </span><br>";
	toAppend += "<span>Weight: " + p.weight + " </span><br>";
	toAppend += "<span>Sleep: " + p.sleep + " </span><br>";
	toAppend += "<span>Sleep Hours: " + p.sleep_hours + " </span><br>";
	toAppend += ("<input type='button' value='More Info' onclick='getMoreInfoOnQuery(this)' id='button_"+p.ppsn+"'><br>");
	toAppend += ("</div>");
	
	$("#patientQueryDisplay").append(toAppend);
	
	colorIndex =  colorIndex == 0 ? 1 : 0; 
}

function getMoreInfoOnQuery(div){
	
}

function RunTestQuery() {
	request = "SELECT public FROM `DCU Clinic` WHERE ppsn='11234373'";
	$("#infotext").append("<div>Sending SQL query "+request+"</div>");
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"SQLRequest",
			query:request
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}