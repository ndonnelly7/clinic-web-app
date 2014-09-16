<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Review</title>
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
	<li><a href="/admin/SeeAllPatients.jsp">View Your Stored Patients</a></li>
	<li><a href="/admin/FindPatient.jsp">Find a Patient</a></li>
</ul>
  
</div> 

<div id="content">
<input type="hidden" id="id_from_attr" value="${id}">
<input type="hidden" id="current_date">
<ul class="tabs date-tabs">
	<c:forEach items="${dates}" var="date">
		<li onclick="loadNewDate(this);"><a href="#"><c:out value="${date}"/></a></li>
	</c:forEach>
</ul>

<div class="forms">
	<div>
		<div>
			<ul class="tabs form-tabs">
				<li id="det-tab"><a href="#details">Details</a></li>
				<li id="his-tab"><a href="#history">History</a></li>
				<li id="gpi-tab"><a href="#gp">GP Information</a></li>
				<li id="con-tab"><a href="#concerns">Concerns</a></li>
				<li id="neu-tab"><a href="#neuro">Neurological</a></li>
				<li id="eve-tab"><a href="#events">Events and Activities</a></li>
				<li id="liv-tab"><a href="#living">Living Situation</a></li>
				<li id="lif-tab"><a href="#lifestyle">Lifestyle</a></li>
				<li id="tes-tab"><a href="#tests">Test Results</a></li>
				<li id="ana-tab"><a href="#analysis">Analysis</a></li>
			</ul>
		</div>
		<div class="sections">
			<!-- DETAILS -->
			<div class="sec" id="details">
				
			</div>
			
			<!-- History -->
			<div class="sec" id="history">
			
			</div>
			
			<!-- GP INFO -->
			<div class="sec" id="gp">
			
			</div>
			
			<!-- CONCERNS -->
			<div class="sec" id="concerns">
				
			</div>
			
			<!-- NEURO -->
			<div class="sec" id="neuro">
			
			</div>
			
			<!-- EVACT -->
			<div class="sec" id="events">
			
			</div>
			
			<!-- LIVING -->
			<div class="sec" id="living">
				
			</div>
			
			<!-- LIFESTYLE -->
			<div class="sec" id="lifestyle">
			
			</div>
			
			<!-- TEST -->
			<div class="sec" id="tests">
			
			</div>
			
			<!-- ANALYSIS -->
			<div class="sec" id="analysis">
			
			</div>
		</div>
	</div>
</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/jquery-tools.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/review.js"></script>
<script src="/js/review_submission.js"></script>
<script src="/js/Comm.js"></script>
</body>
</html>