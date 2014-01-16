<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MovieExchange</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
  	<div class="pure-control-group">
  	<label for="title_search">Search for: </label>
	<input type="text" name="title_search" placeholder="Movie Title"/>
	<input type="button" name="search" value="Search For Title" onclick="searchTitle()">
	</div>
	
	<div class="pure-control-group" style="margin-top:24px;">
	<input type="button" name="add" value="Add Title" onclick="addTitle()">
	</div>
	
	<div class="pure-control-group" style="margin-top:24px;">
	<input type="button" name="view" value="View Local Titles" onclick="viewTitles()">
	</div>
	
	<div id="infotext"></div>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	<script src = "http://axemclion.github.com/IndexedDBShim/dist/IndexedDBShim.min.js"></script>
</body>
</html>