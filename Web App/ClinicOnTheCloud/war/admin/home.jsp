<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinic on the Cloud</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/> 
<link rel="stylesheet" href="/css/home.css"/> 
</head>
<body>
<div id="navbar">
<h2>Welcome to Clinic on the Cloud</h2>
</div>

<div id="content">

	<div id="open_message">Would you like to...</div>
	
	<a href="/patientform/personal_details.jsp">Add A Patient</a>
	<a href="/admin/SeeAllPatients.jsp">View Your Stored Patients</a>
	<a href="/admin/FindPatient.jsp">Find a Patient</a>
	<a href="/admin/ChangeClinic.jsp">Change Clinic</a>
	<input type="button" value="Review Patient" onclick="revealReviewDiv()">
	<form class="hide_div pure-form pure-form-aligned" id="review" method="GET" action="/review.do">
		<div class="pure-control-group">
			<label for="name">Patient Name:</label>
			<input type="text" id="name">
		</div>
		<div class="pure-control-group">
			<label for="dob">Patient DOB: </label>
		<input name="dob" placeholder="dd/mm/yyyy" type="text" id="pickdate">
		</div>
		<div class="pure-control-group">
			<input type="button" value="Submit" onclick="sendReview()">
		</div>
		<input type="hidden" id="id" name="id"/>
		<input type="hidden" name="page" value="SETUP"/>
	</form>
	
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/home.js"></script>
</body>
</html>