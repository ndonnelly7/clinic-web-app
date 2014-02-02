/**
 * 
 */

var localStream, localPeerConnection, remotePeerConnection;

var localVideo = document.getElementById("localVideo");
var remoteVideo = document.getElementById("remoteVideo");

var startButton = document.getElementById("startButton");
var callButton = document.getElementById("callButton");
var hangupButton = document.getElementById("hangupButton");
startButton.disabled = false;
callButton.disabled = true;
hangupButton.disabled = true;
startButton.onclick = start;
callButton.onclick = call;
hangupButton.onclick = hangup;

function trace(text) {
	console.log((performance.now()/1000).toFixed(3) + ": " + text);
}

function gotStream(stream) {
	trace("Received local stream");
	localVideo.src = URL.createObjectURL(stream);
	localStream = stream;
	callButton.disabled = false;
}

function start() {
	trace("Requesting local stream");
	startButton.disabled = true;
	navigator.getUserMedia =  navigator.getUserMedia = navigator.getUserMedia ||
    	navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
	
	//getUserMedia(constraints, successCallback, errorCallback)
	navigator.getUserMedia({audio:true, video:true}, gotStream,
		function(error) {
			trace("navigator.getUserMedia error: ", error);
	});
}

function call() {
	callButton.disabled = false;
}