var p2p_id, peer, token;
var activeConnections = {};
var showThisPatient;
var supports_p2p;

var multistart;

function CommInit(){
	if(typeof(Storage) !== 'undefined'){
		//Create the peer object using the dev key provided by PeerJS and the urls to an ICE and TURN servers
			peer = new Peer({key: '52wkj9kt0t9ms4i',
				debug:3,
				config: {'iceServers': [
				{ url: 'stun:stun.l.google.com:19302' },
			    { url: 'turn:homeo@turn.bistri.com:80', credential: 'homeo' }
			]}});
			
			//If successful, then record the P2PID
			peer.on('open', function(id){
				p2p_id = id;
				console.log("P2P ID: " + p2p_id);
				$("#infotext").append("<div>My Peer ID: "+p2p_id+"</div>");
				//Inform the cloud of your entry into the peer network
				syncMe();
				//Store a flag to let the program know it has WebRTC capabilities
				sessionStorage.setItem("p2p", true);
			});	
			
			//If it doesn't work, set the P2P flag to false, set P2PID to na and sync with the cloud.
			//Will now be using Google Channel for communications
			peer.on('error', function(err){
				if(err.type = 'browser-incompatible'){
					sessionStorage.setItem("p2p", false);
					p2p_id = "na";
					syncMe();
				}
			});
			
			//Sets the callback function for when the client receives a WebRTC request
			peer.on('connection', receiveJSON);
	}
	
	//Stop the browser from leaving before we can leave the network correctly
	window.onbeforeunload = function(){
		signMeOut();
		//Make sure the user wants to do it and also buys time to successfully sign out
		var response = "Are you sure?";
		console.log(response);
		return response;
	}
}

//Sends an AJAX call to the cloud to sign in with P2PID
function syncMe() {
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"PEER_SIGN_IN",
			P2PID:p2p_id
		},
		success:function(response) {
			//If the index of Error is less than zero then the peer is successfully signed in
			if(response.indexOf("Error:") < 0){
				$("#infotext").append("<div>Response From Initialisation: "+response+"</div>");
				var arr = response.split(":");
				token = arr[1];
				var peerIDCheck = arr[3];
				$("#infotext").append("<div>Token: "+token+"</div>");
				$("#infotext").append("<div>Peer ID: "+peerIDCheck+"</div>");
				var channel = new goog.appengine.Channel(token);
				socket = channel.open();
				socket.onmessage = channelComm;
				if(typeof(Storage) !== 'undefined'){
					sessionStorage.setItem("p2p_id", p2p_id);
					sessionStorage.setItem("peer", peer);
					sessionStorage.setItem("token", token);					
				}
				//sendUpdateRequest();
			} else {
				var arr = response.split(":");
				console.error(arr[1]);
				$("#infotext").append("<div>Error: "+arr[1]+"</div>");
			}
		}
	});
}

//Handles all messages sent via the Google Channel API
function channelComm(message){
	$("#infotext").append("<div>Google Channel:</div>");
	$("#infotext").append("<div>"+message.data+"</div>");
	
	//Splits the data in the channel message into the parameters
	var instruction = message.data.split(":");

	//The first portion of the message is always the type of operation
	$("#infotext").append("<div>Instruction:"+instruction[0]+"</div>");
	switch(instruction[0]){
	case 'PING':
		//The PING command is used to test whether the Peer is still active
		$("#infotext").append("<div>In PING section</div>");
		sendPingResponse(instruction[1]);
		break;
	case 'SEND_PATIENT':
		//Sends the patient over AJAX to be sent to the other peer with Google Channel
		$("#infotext").append("<div>In SEND_PATIENT section</div>");
		sendPatient(instruction[4], instruction[2], instruction[6]);
		break;
	case 'UPDATE_PEER':
		//Sends all patient data over AJAX to be sent to the other peer with Google Channel
		$("#infotext").append("<div>In UPDATE_PEER section</div>");
		updatePeer(instruction[2], instruction[4]);
		break;
	case 'REMOVE_PATIENT':
		//Removes a patient from the local database (doesn't exist on the cloud anymore)
		$("#infotext").append("<div>In REMOVE_PATIENT section</div>");
		removePatientInst(instruction[2]);
		break;
	case 'RECEIVE_PATIENTS':
		//The cloud has sent patients from another peer over Google Channel so either theis client
		//or the other has no WebRTC
		$("#infotext").append("<div>In RECEIVE_PATIENT section</div>");
		//The JSON with the patients is at index 2 so take and reformat for parsing
		var parseString = instruction[2];
		//Goes through rest of instruction and adds it to a parseString and divides them with colons to be parsed
		//by the receiveJSONChannel function
		for(var i = 3; i < instruction.length; i++){
			parseString += ":" + instruction[i];
		}
		receiveJSONChannel(parseString);
		break;
	case 'SEND_MULTI':
		$("#infotext").append("<div>In RECEIVE_PATIENT section</div>");
		sendMultiplePatients(instruction[2]);
		break;
	case 'JOB_POST':
		//Cloud is informing the client of a job, so immediately try and claim it
		$("#infotext").append("<div>In JOB_POST section</div>");
		claimJob(instruction[2], instruction[4], instruction[6], instruction[8]);
		break;
	default:
		
	}
}

//Claims a job on the cloud
function claimJob(patientID, jobID, mode, type){
	if(type=="REQUEST"){
		getPatient(patientID, function(patient){
			if(patient == null){
				$("#infotext").append("<div>Patient is null: "+patient+"</div>");
				//TODO: Tell server you don't have it
				return;
			}
			
			if(mode == 'p2p' && !(sessionStorage.p2p)){
				return;
			}
			
			$.ajax('/cliniconthecloud.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"CLAIM_JOB",
					JobID:jobID
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
				}
			});
		});
	} else if(type=="UPDATE"){
		if(mode == 'p2p' && !(sessionStorage.p2p)){
			return;
		}
		
		$.ajax('/cliniconthecloud.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"CLAIM_JOB",
				JobID:jobID
			},
			success:function(response) {
				$("#infotext").append("<div>"+response+"</div>");
			}
		});
	} else if(type=="MULTI"){
		$.ajax('/cliniconthecloud.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"CLAIM_JOB",
				JobID:jobID
			},
			success:function(response) {
				$("#infotext").append("<div>"+response+"</div>");
			}
		});
	}
}

function sendMultiplePatients(peer_address){
	getAllPatients(function(patients){
		console.log(patients);
		var index = 0;
		var max = patients.length;
		var tosend = "[";
		for(var i = 0; i < 100; i++){
			if(i < 99)
				tosend += JSON.stringify(patients[index]) + ",";
			else
				tosend += JSON.stringify(patients[index]);
			index++;
			if(index == patients.length)
				index = 0;
		}
		
		tosend += "]";
		
		try {
			var sendTime = new Date();
			$("#infotext").append("<div>Sending Patient Time: "+sendTime.getHours() +":" + sendTime.getMinutes() + ":" + sendTime.getSeconds() +"</div>");
			var conn = peer.connect(peer_address, {
				label : "multi",
				serialization: 'none',
				reliable: "false",
				metadata: {patients:tosend}
			})
			
			conn.on("open", function() {
				activeConnections[conn.peer] = conn;
				conn.send(tosend);
				conn.on('data', function(mess){
					$("#infotext").append("<div>Message from Receiving Peer: "+mess+"</div>");
				});
				conn.on('close', function() {
					delete activeConnections[conn.peer];
				});
				conn.on('error', function() {
					throw "connection failed";
				})
			});
			
			conn.on('error', function() {
				throw "connection failed";
			});
			
		} catch(error) {
			$("#infotext").append("<div>Error: "+error+". Attempting to send via Server</div>");
			$.ajax('/cliniconthecloud.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"SEND_PATIENT_TO_PEER",
					patients:tosend,
					peerID:peer_address
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
				}
			});
		}
	})
}

function sendPatientRequest(patient_id){
	var mode = "NA";
	if(sessionStorage.p2p == 'true'){
		mode = "P2P";
	} else if(sessionStorage.p2p == 'false'){
		mode = "CHANNEL";
	}
	var start = new Date();
	$("#infotext").append("<div>Sending Request: " + start.toTimeString() + "</div>");
	jobsInProgress[patient_id] = new JobTime(patient_id, new Date());
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"REQUEST_PATIENT",
			pid:patient_id,
			mode:mode
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function sendUpdateRequest(){
	var mode = "NA";
	if(sessionStorage.p2p == 'true'){
		mode = "P2P";
	} else if(sessionStorage.p2p == 'false'){
		mode = "CHANNEL";
	}
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"REQUEST_UPDATE",
			mode:mode
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function removePatientInst(patient_id){
	removePatient(patient_id);
	//TODO: Tell server you've removed it
}

function sendPingResponse(ping_id) {
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"PING_RESPONSE",
			ping:ping_id
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function receiveJSON(connection){
	$("#infotext").append("<div>Received Patient from: "+ connection.peer + "</div>");
	if(connection.label === "patient") {
		$("#infotext").append("<div>Received Data: "+ connection.metadata + "</div>");
		var patientJSON = connection.metadata["patients"];
		
		if(patientJSON != null){
			var arr = $.parseJSON(patientJSON);
			$("#infotext").append("<div>Info under \"patients\""+arr+"</div>");
			for(var i = 0; i < arr.length; i++){
				//TODO: When this works, then add the patient
				addPatientToDB(arr[i]);
				//Just saying that the user has received a patient
				var end = new Date();
				$("#infotext").append("<div>Received Patient at: " + end.toTimeString() + "</div>");
				if(jobsInProgress[arr[i]['p_id']]){
					//var now = end.getTime();
					$("#infotext").append("<div>Time to find Patient: " + (end.getTime() - jobsInProgress[arr[i]['p_id']].start.getTime()) + "ms</div>");
					jobsInProgress[arr[i]['p_id']] = null;
				}
				//Tell home.jsp to update its client space
				if(showThisPatient == arr[i]['p_id']){
					fillFindPatient(arr[i]);
				}
			}			
		}
		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
	} else if(connection.label === "multi") {
		$("#infotext").append("<div>Received Data: "+ connection.metadata + "</div>");
		var patientJSON = connection.metadata["patients"];
		
		if(patientJSON != null){
			var arr = $.parseJSON(patientJSON);
			$("#infotext").append("<div>Info under \"patients\""+arr+"</div>");
			$("#multiple_data").html("");
			
			var end = new Date();
			$("#infotext").append("<div>Received Private Patient at: " + end.toTimeString() + "</div>");
			$("#infotext").append("<div>Time to get Multiple Patients: " + (end.getTime() - multiStart.getTime()) + "ms</div>");
			
			for(var i = 0; i < arr.length; i++){
				 $("#multiple_data").append("<div>" + i + ": " + arr[i]['p_id'] + "</div>");
				
				//Tell home.jsp to update its client space
				if(showThisPatient == arr[i]['p_id']){
					fillFindPatient(arr[i]);
				}
			}			
		}
		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
	}
}

function receiveJSONChannel(patientJSON){
	$("#infotext").append("<div>Channel json"+patientJSON+"</div>");
	if(patientJSON != null){
		var arr = $.parseJSON(patientJSON);
		$("#infotext").append("<div>Info under \"patients\""+arr+"</div>");
		for(var i = 0; i < arr.length; i++){
			//TODO: When this works, then add the patient
			addPatientToDB(arr[i]);			
		}			
	}
}

function parsePatientJSON(json){
	if(json != null){
		var arr = $.parseJSON(json);
		for(var i = 0; i < arr.length; i++){
			//TODO: When this works, then add the patient
			addPatientToDB(arr[i]);
			//$("#infotext").append("<div>"+arr[i]+"</div>");
		}		
	}
}

function requestMultiplePatients(){
	var start = new Date();
	multiStart = start;
	 $("#infotext").append("<div>Send request for multiple patients: "+start.toTimeString()+"</div>");
	 $.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"MULTIPLE_P2P"
		},
		success:function(response) {
			$("#infotext").append("<div>" + response + "</div>");
		}
	});
}

function sendPatient(peer_address, patient_id, mode){
	getPatient(patient_id, function(patient){
		$("#infotext").append("<div>Finished getPatientFunction: "+patient+"</div>");
		if(patient == null){
			$("#infotext").append("<div>Patient is null: "+patient+"</div>");
			//TODO: Tell server you don't have it
			return;
		}
		var tosend = "["+JSON.stringify(patient)+"]";
		$("#infotext").append("<div>Retrieved patient and sending: "+tosend+"</div>");
		if(mode == "P2P"){
			try {
				var sendTime = new Date();
				$("#infotext").append("<div>Sending Patient Time: "+sendTime.getHours() +":" + sendTime.getMinutes() + ":" + sendTime.getSeconds() +"</div>");
				var conn = peer.connect(peer_address, {
					label : "patient",
					serialization: 'none',
					reliable: "false",
					metadata: {patients:tosend}
				})
				
				conn.on("open", function() {
					activeConnections[conn.peer] = conn;
					conn.send(tosend);
					conn.on('data', function(mess){
						$("#infotext").append("<div>Message from Receiving Peer: "+mess+"</div>");
					});
					conn.on('close', function() {
						delete activeConnections[conn.peer];
					});
					conn.on('error', function() {
						throw "connection failed";
					})
				});
				
				conn.on('error', function() {
					throw "connection failed";
				});
				
			} catch(error) {
				$("#infotext").append("<div>Error: "+error+". Attempting to send via Server</div>");
				$.ajax('/cliniconthecloud.do', {
					method:'GET',
					dataType:'text',
					data: {
						type:"SEND_PATIENT_TO_PEER",
						patients:tosend,
						peerID:peer_address
					},
					success:function(response) {
						$("#infotext").append("<div>"+response+"</div>");
					}
				});
			}
		} else if(mode == "CHANNEL"){
			$.ajax('/cliniconthecloud.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"SEND_PATIENT_TO_PEER",
					patients:tosend,
					peerID:peer_address
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
				}
			});
		}
	});
}

function signMeOut(){
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"PEER_SIGN_OUT"
		},
		success:function(response) {
			$("#infotext").append("<div>"+response+"</div>");
		}
	});
}

function updatePeer(peer_address, mode){
	getAllPatients(function(patients){
		var tosend = JSON.stringify(patients);
		$("#infotext").append("<div>Patients to be sent: " + tosend + "</div>");
		if(mode == "P2P"){
			try {
				$("#infotext").append("<div>Trying to send via P2P</div>");
				var conn = peer.connect(peer_address, {
					label : "patient",
					serialization: 'none',
					reliable: "false",
					metadata: {patients:tosend}
				});
				
				conn.on("open", function() {
					activeConnections[conn.peer] = conn;
					conn.send(tosend);
					conn.on('data', function(mess){
						$("#infotext").append("<div>Message from Receiving Peer: "+mess+"</div>");
					});
					conn.on('close', function() {
						delete activeConnections[conn.peer];
					});
					conn.on('error', function() {
						throw "connection failed";
					})
				});
				
				conn.on('error', function() {
					throw "connection failed";
				});
				
			} catch (error) {
				$("#infotext").append("<div>Error: "+error+". Attempting to send via Server</div>");
				$.ajax('/cliniconthecloud.do', {
					method:'GET',
					dataType:'text',
					data: {
						type:"SEND_PATIENT_TO_PEER",
						patients:tosend,
						peerID:peer_address
					},
					success:function(response) {
						$("#infotext").append("<div>"+response+"</div>");
					}
				});
			}
		} else if(mode == "CHANNEL"){
			$.ajax('/cliniconthecloud.do', {
				method:'GET',
				dataType:'text',
				data: {
					type:"SEND_PATIENT_TO_PEER",
					patients:tosend,
					peerID:peer_address
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
				}
			});
		}
	})
}