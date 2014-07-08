var p2p_id, peer, token;
var activeConnections = {};

function CommInit(){
	if(typeof(Storage) !== 'undefined'){
		if(sessionStorage.peer) {
			peer = sessionStorage.peer;
			p2p_id = sessionStorage.p2p_id;
			token = sessionStorage.token;
		} else {
			peer = new Peer({key: '52wkj9kt0t9ms4i',
				debug:3,
				config: {'iceServers': [
				{ url: 'stun:stun.l.google.com:19302' },
			    { url: 'turn:homeo@turn.bistri.com:80', credential: 'homeo' }
			]}});
			
			peer.on('open', function(id){
				p2p_id = id;
				console.log("P2P ID: " + p2p_id);
				syncMe();
				//Send p2p_id to server
			});	
			
			peer.on('connection', requestReceived);
		}
	}
	
}

function syncMe() {
	$.ajax('/cliniconthecloud.do', {
		method:'GET',
		dataType:'text',
		data: {
			type:"INIT_PEER",
			P2PID:p2p_id
		},
		success:function(response) {
			if(response.indexOf("Error:") < 0){
				var arr = response.split(":");
				token = arr[1];
				var channel = new goog.appengine.Channel(token);
				socket = channel.open();
				socket.onmessage = channelComm;
				if(typeof(Storage) !== 'undefined'){
					sessionStorage.setItem("p2p_id", p2p_id);
					sessionStorage.setItem("peer", peer);
					sessionStorage.setItem("token", token);
					
					console.log("Assigned session storage stuff");
					console.log(peer);
					console.log(p2p_id);
					console.log(token);
				}
			}
		}
	});
}

function channelComm(message){
	
}

function requestReceived(){
	
}