<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing Return Values</title>
</head>
<body>
<%
	String n = (String)request.getAttribute("name");
	String d = (String)request.getAttribute("dob");
	String a = (String)request.getAttribute("age");
	
	out.println("<br><b>Name:<b> " + n);
	out.println("<br><b>Date of Birth:<b> " + d);
	out.println("<br><b>Age:<b> " + a);
%>
</body>
</html>