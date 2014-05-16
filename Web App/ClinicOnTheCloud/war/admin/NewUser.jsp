<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinic on the Cloud</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<div id="navbar">
<h2>Sign Up</h2>
</div>
<form id="personal_form" class="pure-form pure-form-aligned" method="GET" action="cliniconthecloud.do">
	<div class="pure-control-group">
		<label for="name">Name</label>
		<input name="name" type="text" id="name" value="${name}">
	</div>
	<div class="pure-control-group">
		<label for="clinics">Name</label>
		<select name="clinic" type="text" id="clinics">
			<c:forEach items="${clinicsList}" var="clinic">
				<option value="${clinic}"><c:out value="${clinic }" /></option>
			</c:forEach>
		</select>
	</div>
	<div class="pure-control-group">
		<label for="pass">Password</label>
		<input name="pass" type="password" id="pass">
	</div>
	<div class="pure-control-group">
		<input type="Submit" value="Submit">
	</div>
	<input type="hidden" name="type" value="NEW_CLINICIAN">
</form>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script>
	function submitNewUser(){
		var name = $("#name").val();
		var clinic = $("#clinics").val();
		var pass = $("#pass").val();
		$.ajax('cliniconthecloud.do', {
			method:'GET',
			dataType:'text',
			data: {
				type:"NEW_CLINICIAN",
				name:name,
				clinic:clinic,
				pass:pass
			},
			success:function(response) {
				console.log(response);
			}
		});
	}
</script>
</html>