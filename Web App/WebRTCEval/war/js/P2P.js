var p2pID, peer;
var activeConnections = {};
function P2PInit(){
	peer = new Peer({key: '52wkj9kt0t9ms4i',
		debug:3,
		config: {'iceServers': [
		{ url: 'stun:stun.l.google.com:19302' },
	    { url: 'turn:homeo@turn.bistri.com:80', credential: 'homeo' }
	]}});
	
	peer.on('open', function(id){
		p2pID = id;
		$("#infotext").append("<div>P2P ID: "+ p2pID + "</div>");
	});	
	
	peer.on('connection', requestReceived);
}

function requestReceived(connection){
	$("#infotext").append("<div>Response from: "+ connection.peer + "</div>");
	if(connection.label === "request") {
		$("#infotext").append("<div>Contains: "+ connection.metadata + "</div>");
		activeConnections[connection.peer] = connection;
		console.log(connection.metadata);
		
		var cData = connection.metadata["patientKey"];
		if(cData != null){
			var p = $.parseJSON(cData)
			addPatientToDB(p);
			showPatient(getPatient(p["ppsn"]));
			//TODO: Send update to Server
			
		}
		
		connection.on('data', dataReceived);		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
	}
}

function connectionReceived(connection) {
	if(connection.label === 'request') {
		$("#infotext").append("<div>Request from: "+ connection.peer + "</div>");
		$("#infotext").append("<div>Request for: "+ connection.metadata + "</div>");
		var request = connection.metadata;
		var pIDRequested = request["patientKey"];
		$("#infotext").append("<div>Requested Patient ID: "+ pIDRequested + "</div>");
		activeConnections[connection.peer] = connection;
		connection.on('data', dataReceived);		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
		sendPatientInfo(connection, pIDRequested);
	} else {
		$("#infotext").append("<div>Other connection from: "+ connection.peer + "</div>");
		console.log(connection)
		activeConnections[connection.peer] = connection;
		
		connection.on('data', function(data){
			$("#infotext").append("<div>Received Data: "+ data + "</div>");
			var json = $.parseJSON(data);
			if(json["patient"]){
				
				var p = $.parseJSON["patient"];
				addPatientToDB(p);
				
				sendThanks(connection);
				closeConnection(connection);
				
			} else if(json["thanks"]) {
				$("#infotext").append("<div>Peer (" + json["thanks"] + ") Received patient</div>");
			}
		});
		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});

	}
}

function connectionStarted(connection) {
	$("#infotext").append("<div>Other connection from: "+ connection.peer + "</div>");
	console.log(connection)
	connection.on('data', dataReceived);
	
	connection.on('close', function() {
		delete activeConnections[connection.peer];
	});
}

function requestPatientFromPeer(host, pID) {
	$("#infotext").append("<div>Sending Request</div>");
	var connect = peer.connect(host, {
		label : "request",
		serialization: 'none',
		reliable: "true",
		metadata: {patientKey: pID}
	});
	$("#infotext").append("<div>Request sent with: "+pID+"</div>");
	connect.on("open", function() {
		activeConnections[connect.peer] = connect;
		
		connectionStarted(connect)
	});
	
	connect.on('data', function(data){
		$("#infotext").append("<div>Received Data: "+ data + "</div>");
		var json = $.parseJSON(data);
		if(json["patient"]){
			
			var p = $.parseJSON["patient"];
			addPatientToDB(p);
			
			sendThanks(connection);
			closeConnection(connection);
			
		} else if(json["thanks"]) {
			$("#infotext").append("<div>Peer (" + json["thanks"] + ") Received patient</div>");
		}
	});
	
	connect.on("error", function(err) {
		$("#infotext").append("<div>Error connecting to peer: "+ err + "</div>");
	});
}

function sendPatientFromPeer(ppsn, peerRequest){
	if(db) {
		$("#infotext").append("<div>Attempting to Retrieve data from database</div>");
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(ppsn);
	
		request.onsuccess = function(e) {
			$("#infotext").append("<div>Sending the patient: "+JSON.stringify(e.target.result)+"</div>");
			
			var conn = peer.connect(peerRequest, {
				label : "request",
				serialization: 'none',
				reliable: "false",
				metadata: {patientKey:JSON.stringify(e.target.result)}
			})
			
			conn.on("open", function() {
				activeConnections[connect.peer] = connect;
				
				conn.send("{'patient':"+JSON.stringify(e.target.result)+"}");
				conn.on('data', dataReceived);
				connection.on('close', function() {
					delete activeConnections[connection.peer];
				});
			});
			
			$("#infotext").append("<div>Should have send: "+"{'patient':"+JSON.stringify(e.target.result)+"}"+"</div>");
		}
		
		request.onerror = function(e) {
			$("#infotext").append("<div>Error retrieving patient: "+e.target.result+"</div>");
		}
	}
}

function sendPatientInfo(connection, pID) {
	if(db) {
		$("#infotext").append("<div>Attempting to Retrieve data from database</div>");
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(pID);
	
		request.onsuccess = function(e) {
			$("#infotext").append("<div>Sending the patient: "+JSON.stringify(e.target.result)+"</div>");
			connection.send("Howdy partner");
			connection.send("{'patient':"+JSON.stringify(e.target.result)+"}");
			$("#infotext").append("<div>Should have send: "+"{'patient':"+JSON.stringify(e.target.result)+"}"+"</div>");
		}
		
		request.onerror = function(e) {
			$("#infotext").append("<div>Error retrieving patient: "+e.target.result+"</div>");
		}
	}
}

function sendThanks(connection) {
	connection.send({thanks:p2pID});
}

function closeConnection(connection) {
	delete activeConnections[connection.peer];
	connection.close();
}

function dataReceived(data) {
	$("#infotext").append("<div>Received Data: "+ data + "</div>");
	var json = $.parseJSON(data);
	if(json["patient"]){
		
		var p = $.parseJSON["patient"];
		addPatientToDB(p);
		
		sendThanks(connection);
		closeConnection(connection);
		
	} else if(json["thanks"]) {
		$("#infotext").append("<div>Peer (" + json["thanks"] + ") Received patient</div>");
	}
}

function p2pUnload(){
	if(!!peer && !peer.destroyed) {
		peer.destroy();
	}
}