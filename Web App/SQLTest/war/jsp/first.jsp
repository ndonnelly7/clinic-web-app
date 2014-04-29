<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Page</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<form id="book_form" class="pure-form pure-form-aligned" method="POST" action="book.do">
	<fieldset id="book_field">
	<legend>Book Form</legend>
	<div class="pure-control-group">
	<label for="title">Title </label>
	<input name="title" type="text" id="title">
	</div>
	<div class="pure-control-group">
	<label for="release">Release </label>
	<input name="release" placeholder="dd/mm/yyyy" type="text" class="book_form" id="pickdate">
	</div>
	<div class="pure-control-group">
	<label for="author">Author </label>
	<input name="author" type="text" id="author">
	</div>
	<div class="pure-control-group">
	<label for="publisher">Publisher </label>
	<input name="publisher" type="text" id="publisher">
	</div>
	<input type="submit" value="Submit">
	
	</fieldset>
</form>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
</body>
</html>