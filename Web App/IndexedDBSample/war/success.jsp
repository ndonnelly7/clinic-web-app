<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/> 
<link rel="stylesheet" href="/css/main.css" type="text/css"/> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
Customer added:
<div class="pure-control-group">
<label for="old_id">Old ID</label>
<input id="old_id" name="old_id" type="text" value="${id}" disabled>
</div>
<div class="pure-control-group">
<label for="new_id">New ID</label>
<input id="new_id" name="new_id" type="text" value="${key}" disabled>
</div>


<input type="button" onclick="UpdateCustomer()" value="Update Customer"> 
<input type="button" onclick="ShowAll()" value="Show All Customers">
<input type="button" onclick="clearStore()" value="Clear Store">
<a href="./index.html"></a>

<div id="infotext"></div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src = "http://axemclion.github.com/IndexedDBShim/dist/IndexedDBShim.min.js"></script>
<script src="main.js"></script>
<!-- <script type="text/javascript" src="Polyfill/indexedDB.polyfill.js"></script> -->

<script>
function UpdateCustomer() {
	//getCustomer($('#old_id').val());
	updateCustomer($('#old_id').val(),$('#new_id').val());
};

function ShowAll() {
	showAllCustomers();
}
</script>
</body>
</html>