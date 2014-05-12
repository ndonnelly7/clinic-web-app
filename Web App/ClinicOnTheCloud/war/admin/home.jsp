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
	
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/home.js"></script>
</body>
</html>