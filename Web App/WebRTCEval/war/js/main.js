var username, clinicname, channelToken;
var showingPatients = false;
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

function channelComm(message) {
	$("#infotext").append("<div>Google Channel:</div>");
	$("#infotext").append("<div>"+message.data+"</div>");
	
	//Don't forget the possibility of a ping message
	var resp = message.data.split(":");
	
	//PatientRequest
	if(resp[0] == "Request"){
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(resp[1]);
		
		request.onerror = function(e) {
			//TODO:Send AJAX to say can't find patient
			$("#infotext").append("<div>Can't find patient with ppsn of: " + resp[1] + "</div>");
		}
		
		request.onsuccess = function(e) {
			$.ajax('/webrtceval.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"PatientFound",
					ppsn:resp[1],
					peerID:p2pID
				},
				success:function(response) {
					$("#infotext").append("<div>PatientFound Response: "+response+"</div>");
				}
			});
		}
	} else if(resp[0] == "RETRIEVAL"){
		var toAppend = "";
		for(int i = 1; i < toAppend.length; i++){
			toAppend += resp[i];
		}
		$("#infotext").append("<div>"+toAppend+"</div>");
	} else if(resp[0] == "UPDATEREQUEST"){
		if(resp[1] == "TRUE"){
			var ppsn = resp[3];
			var peer = resp[5];
			requestPatientFromPeer(peer,ppsn);
		}
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
	var ppsn_pat = $("#get_ppsn").val();
	var clinic_pat = $("#get_clinic").val();
	
	$.ajax('/webrtceval.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"RetrievePatient",
			ppsn:ppsn_pat,
			clinic:clinic_pat,
			client:username
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function addPatientDetails() {
	var patName = $("#pat_name").val();
	var patAddress = $("#pat_address").val();
	var pat_ppsn = $("#pat_ppsn").val();
	var pat_number = $("#pat_number").val();
	
	$("#infotext").append("<span>Details to be added: </span><br>");
	$("#infotext").append("<span>Name: " + patName + "</span><br>");
	$("#infotext").append("<span>Address: " + patAddress + "</span><br>");
	$("#infotext").append("<span>PPSN: " + pat_ppsn + "</span><br>");
	$("#infotext").append("<span>Number: " + pat_number + "</span><br>");
	
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
			clinic:clinicname
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
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
	
	var toAppend = "<span>Stress: " + json["stress"] + " </span><br>";
	toAppend += "<span>Memory Problems: " + json["memory"] + " </span><br>";
	toAppend += "<span>Alcohol: " + json["alcohol"] + " </span><br>";
	toAppend += "<span>Diet: " + json["diet"] + " </span><br>";
	toAppend += "<span>Sleep: " + json["sleep"] + " </span><br>";
	toAppend += "<span>Dementia: " + json["dementia"] + " </span><br>";
	
	$("#patient_" + pID).append(toAppend);
}

function SignOut() {
	/*
	 * Disable All input
	 * Do DOM unloaded stuff for P2P
	 * Put client name and clinic name in form
	 * Submit form
	 */
}