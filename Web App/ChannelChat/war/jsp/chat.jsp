<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Pragma" content="no-cache">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" href="/css/style.css" type="text/css"/>
<script type="text/javascript" src="/_ah/channel/jsapi"></script>
<title>Chat Box</title>

</head>
<body>
<h1>Welcome to ChatBox, ${username}</h1>

<div id="messbox">
	<textarea readonly placeholder="No messages just yet, maybe you could fix that?" id="textbox"></textarea>
</div>

<input type="text" id="inputbox" placeholder="message">
<input type="button" id="send_button" value="Send" onclick="submitMessage()">
<form action="signout.do">
	<input type="text" name="name" value="${username}" style="display:none">
	<input type="text" name="chat" value="${chatname}" style="display:none">
	<input type="submit" id="logout" value="Leave">
</form>

<script>
var socket, username, chatname;
window.onbeforeunload = beforeExit;
$(document).ready(function() {
	var token = "<%=(String)request.getAttribute("channeltoken")%>";
	console.log(token);
	var channel = new goog.appengine.Channel(token);
	socket = channel.open();
	
	socket.onmessage = updateBox;
	
	username = "<%=(String)request.getAttribute("username")%>";
	chatname = "<%=(String)request.getAttribute("chatname")%>";
	console.log(username);
});

function updateBox(message){
	var current = $("#textbox").val();
	$("#textbox").val(current + "\n" + message.data);
}

function logout(){
	socket.close();
	$.ajax('/signout.do', {
		method:'POST',
		dataType:'text',
		data: {
			name:username,
			chat:chatname
		},
		success:function(response) {
			console.log(response);
		}
	});
}

function submitMessage() {
	$.ajax('/chat.do', {
		method:'POST',
		dataType:'text',
		data: {
			message:$('input').val(),
			name:username,
			chat:chatname
		},
		success:function(response) {
			console.log(response);
		}
	});
	$('#inputbox').val("");	
}

function beforeExit(){
	logout();
}

$('input').keypress(function (e) {
    if (e.which == 13) {
            submitMessage();
    }
});
</script>
</body>
</html>