<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patients</title>
<link rel="stylesheet" href="/css/review.css" type="text/css"/> 
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>

<div id="navbar"> 
   
<ul>
	<li><a href="/admin/home.jsp">Home</a></li>
	<li><a href="/patientform/personal_details.jsp">Add A Patient</a></li>
	<li><a href="/admin/FindPatient.jsp">Find a Patient</a></li>
</ul>
  
</div>

<h3 style="margin-left:3%">Patients Stored by You</h3>

<div id="see_all_div">
<div id="search_bar">
	<form class="pure-form pure-form-stacked">
		<div class="pure-control-group">
			Search for Patient by Name:
		</div>
		<div class="pure-control-group">
			<label for="search_name">Name:</label>
			<input type="text" id="search_name">
		</div>
		<input type="button" value="Search" onclick="searchPatient()" id="search_seeall_btn">
	</form>
</div>

<div id="patient_grid">

</div>

<div id="patient_entry" style="display:none">
	<form class="pure-form pure-form-stacked" id="review" method="GET" action="/review.do">
		<div class="pure-control-group">
			<label for="name">Name:</label>
			<input type="text" id="name" readonly>
		</div>
		<div class="pure-control-group">
			<label for="dob">Date of Birth:</label>
			<input type="text" id="dob" readonly>
		</div>
		<div class="pure-control-group">
			<input type="Submit" value="Get More Info">
		</div>
		<input type="hidden" id="id" name="id"/>
		<input type="hidden" name="page" value="SETUP"/>			
	</form>
</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/jquery-tools.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/seeall.js"></script>
</body>
</html>