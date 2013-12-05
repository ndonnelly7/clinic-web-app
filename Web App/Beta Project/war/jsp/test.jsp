<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing Return Values</title>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/> 
</head>
<body onload="initPatient($(patient))">
<%@ page import="project.beta.model.Patient, com.google.appengine.labs.repackaged.org.json.JSONObject,
					java.util.Iterator, com.google.appengine.labs.repackaged.org.json.JSONException;" %>
<%
	/*String n = (String)request.getAttribute("name");
	String d = (String)request.getAttribute("dob");
	String a = (String)request.getAttribute("gender");
	
	String address = (String)request.getAttribute("address");
	String home_tel = (String)request.getAttribute("home_tel");
	String mob_tel = (String)request.getAttribute("mob_tel");
	String email = (String)request.getAttribute("email");
	
	out.println("<br><b>Name:<b> " + n);
	out.println("<br><b>Date of Birth:<b> " + d);
	out.println("<br><b>Gender:<b> " + a);
	
	out.println("<br><b>Address:<b> " + address);
	out.println("<br><b>Home Tel:<b> " + home_tel);
	out.println("<br><b>Mobile Tel:<b> " + mob_tel);
	out.println("<br><b>Email:<b> " + email);*/
	
	out.println(iterate((JSONObject)request.getAttribute("patient"), ""));
%>

<%!
public String iterate(JSONObject obj, String str){
	Iterator<String> keys = obj.keys();
	while(keys.hasNext()){
		String key = keys.next();
		String val = null;
		try{
			JSONObject value = obj.getJSONObject(key);
			str = iterate(value, str);
		}catch(Exception e){
			try {
			val = obj.getString(key);
			str += (key+": " + val);
			} catch(JSONException ex) {
				ex.printStackTrace();
			}
		}
	}
	return str;
}
%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script>
var patient;
function initPatient(jsonPatient){
	
	var foo = <%= request.getAttribute("patient").toString() %>
	console.log(foo["name"]);
	for (var k in foo) {
		if(foo.hasOwnProperty(k)) {
			console.log(k + ": " + foo[k]);
		}
	}
}
</script>
</body>
</html>