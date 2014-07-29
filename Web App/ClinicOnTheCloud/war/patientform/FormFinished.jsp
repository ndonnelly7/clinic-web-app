<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Results</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/>  
<link rel="stylesheet" href="/css/pure-min.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>

<style>
#pNameDiv{
	margin-left: 2%;
	font-size: 24px;
	margin-top: 42px;
}

#pNameDiv div{
	margin-top: 16px;
}
</style>

</head>
<body>
<h1>Finished Form</h1>
<form id="test_form" action="form.do" method="GET">
<div id="navbar"> 
  <span onclick="spanClick('personal_details')">Patient Information</span>
  <span onclick="spanClick('history')">Patient History</span>
  <span onclick="spanClick('medical')">GP Information</span>
  <span onclick="spanClick('concerns')">Patient Concerns</span>
  <span onclick="spanClick('neuro')">Neuro History</span>
  <span onclick="spanClick('events_activities')">Events and Activities</span>
  <span onclick="spanClick('living')">Living Situation</span>
  <span onclick="spanClick('lifestyle')">Patient Lifestyle</span>
  <span onclick="spanClick('memory_test')">Test Battery</span>
  <span onclick="spanClick('analysis')">Summary and Analysis</span> 
  
  <input type="hidden" id="text_form" name="page"/> 
</div> 
</form>

<div class="pure-control-group" id="pNameDiv">
<label for="name">Patient Information successfuly added for: </label>
</div>

<div class="pure-control-group">
	<div>Would you now like to:</div>
	<a href="/admin/home.jsp">Return to the Homepage</a>
</div>

<div class="footer">
	
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/IDB.js"></script>
<script src="/js/IDBForm.js"></script>
<script>
var patient;
$(document).ready(function () {
	window.setTimeout(function(){getPatient('${id}', printpForm);}, 500);
	
	if(typeof(Storage)){
		sessionStorage.newpatient = "${id}";
	}
});

function printpForm(p) {
	$("#pNameDiv").append("<div>"+p['name']+"</div>");
}

</script>
</body>
</html>