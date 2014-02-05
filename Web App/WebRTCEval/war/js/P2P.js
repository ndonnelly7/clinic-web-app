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
	
	peer.on('connection', connectionReceived);
}

function connectionReceived(connection) {
	if(connection.label === 'request') {
		$("#infotext").append("<div>Request from: "+ connection.peer + "</div>");
		var request = $.parseJSON(connection.metadata);
		var pIDRequested = request["patient"];
		$("#infotext").append("<div>Requested Patient ID: "+ pIDRequested + "</div>");
		activeConnections[connectection.peer] = connection;
		
		sendPatientInfo(connection, pIDRequested);
		
		connection.on('data', dataReceived);
		
		connection.on('close', function() {
			delete activeConnections[connection.peer];
		});
	}
	
	conn
}

function requestPatientFromPeer(peer, pID) {
	var connect = peer.connect(peer, {
		label : "request",
		serialization: 'none',
		reliable: "true",
		metadata: {patientKey: pID}
	});
	
	connect.on("open", function() {
		activeConnections[connect.peer] = connection;
		
		connect.on('data', dataReceived);
		
		connect.on('close', function() {
			delete activeConnections[connect.peer];
		});
	});
	
	connect.on("error", function(err) {
		$("#infotext").append("<div>Error connecting to peer: "+ err + "</div>");
	});
}

function sendPatientInfo(connection, pID) {
	if(db) {
		var transaction = db.transaction(["patients"], "readwrite");
		var objectStore = transaction.objectStore("patients");
		var request = objectStore.get(ppsn);
	
		request.onsuccess = function(e) {
			connection.send({patient:JSON.stringify(e.target.result)});
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