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
			type:"RESET"
		},
	});
	clearObjectStore();
	SignOut();
}

function AddMultiPatient(index,limit){
	if(index <= limit){
		$("#infotext").append("<div>Adding Patient "+(index)+" of " + limit + "</div>");
		$("#infotext").append("<span>Time of Add: "+getTimeString()+"</span><br>");
		var patName = getName();
		var patAddress = getAddress();
		var pat_ppsn = getPPSN();
		var pat_number = getPhoneNumber();
		
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