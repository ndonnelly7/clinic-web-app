var p2p_id, peer, token;
var activeConnections = {};
var showThisPatient;
var supports_p2p;

function CommInit(){
	if(typeof(Storage) !== 'undefined'){
			peer = new Peer({key: '52wkj9kt0t9ms4i',
				debug:3,
				config: {'iceServers': [
				{ url: 'stun:stun.l.google.com:19302' },
			    { url: 'turn:homeo@turn.bistri.com:80', credential: 'homeo' }
			]}});
			
			peer.on('open', function(id){
				p2p_id = id;
				console.log("P2P ID: " + p2p_id);
				$("#infotext").append("<div>My Peer ID: "+p2p_id+"</div>");
				syncMe();
				sessionStorage.setItem("p2p", true);
				//Send p2p_id to server
			});	
			
			peer.on('error', function(err){
				if(err.type = 'browser-incompatible'){
					sessionStorage.setItem("p2p", false);
					p2p_id = "na";
					syncMe();
				}
			});
			
			peer.on('connection', receiveJSON);
	}
	
	window.onbeforeunload = function(){
		signMeOut();
		var response = "Are you sure?";
		console.log(response);
		return response;
	}
}

function syncMe() {
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"PEER_SIGN_IN",
			P2PID:p2p_id
		},
		success:function(response) {
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
				sendUpdateRequest();
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

	$("#infotext").append("<div>Instruction:"+instruction[0]+"</div>");
	switch(instruction[0]){
	case 'PING':
		$("#infotext").append("<div>In PING section</div>");
		sendPingResponse(instruction[1]);
		break;
	case 'SEND_PATIENT':
		$("#infotext").append("<div>In SEND_PATIENT section</div>");
		sendPatient(instruction[4], instruction[2], instruction[6]);
		break;
	case 'UPDATE_PEER':
		$("#infotext").append("<div>In UPDATE_PEER section</div>");
		updatePeer(instruction[2], instruction[4]);
		break;
	case 'REMOVE_PATIENT':
		$("#infotext").append("<div>In REMOVE_PATIENT section</div>");
		removePatientInst(instruction[2]);
		break;
	case 'RECEIVE_PATIENTS':
		$("#infotext").append("<div>In RECEIVE_PATIENT section</div>");
		receiveJSON(instruction[2]);
		break;
	case 'JOB_POST':
		$("#infotext").append("<div>In JOB_POST section</div>");
		claimJob(instruction[2], instruction[4], instruction[6], instruction[8]);
		break;
	default:
		
	}
}

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
	}
}

function sendPatientRequest(patient_id){
	var mode = "NA";
	if(sessionStorage.p2p){
		mode = "P2P";
	} else if(!sessionStorage.p2p){
		mode = "CHANNEL";
	}
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
	if(sessionStorage.p2p){
		mode = "P2P";
	} else if(!sessionStorage.p2p){
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
				//Tell home.jsp to update its client space
				if(showThisPatient == arr[i]['p_id'])
					fillFindPatient(arr[i]);
			}			
		}
		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
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
						client:username,
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
					client:username,
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
		console.log(tosend);
		if(mode == "P2P"){
			try {
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
						client:username,
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
					client:username,
					peerID:peer_address
				},
				success:function(response) {
					$("#infotext").append("<div>"+response+"</div>");
				}
			});
		}
	})
}