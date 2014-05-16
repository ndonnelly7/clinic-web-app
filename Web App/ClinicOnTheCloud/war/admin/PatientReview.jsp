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
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>

<ul class="vert-tabs">
	<c:forEach items="${dates}" var="date">
		<li><a href="#"><c:out value="${date}"/></a></li>
	</c:forEach>
</ul>

<div class="forms">
	<div>
		<ul class="hor-tabs">
			<li><a href="#">Details</a></li>
			<li><a href="#">History</a></li>
			<li><a href="#">GP Information</a></li>
			<li><a href="#">Concerns</a></li>
			<li><a href="#">Neurological</a></li>
			<li><a href="#">Events and Activities</a></li>
			<li><a href="#">Living Situation</a></li>
			<li><a href="#">Lifestyle</a></li>
			<li><a href="#">Test Results</a></li>
			<li><a href="#">Analysis</a></li>
		</ul>
	</div>
	
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script src="/js/review.js"></script>
</body>
</html>