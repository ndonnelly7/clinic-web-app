<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Film Page</title>
</head>
<body>
<form id="film__form" class="pure-form pure-form-aligned" method="POST" action="film.do">
	<fieldset id="film_field">
	<legend>Film Form</legend>
	
	<div class="pure-control-group">
	<label for="film_title">Title </label>
	<input name="film_title" type="text" id="film_title">
	</div>
	<div class="pure-control-group">
	<label for="film_release">Release </label>
	<input name="film_release" placeholder="dd/mm/yyyy" type="text" class="film__form" id="pickdate">
	</div>
	<div class="pure-control-group">
	<label for="film_author">Director </label>
	<input name="film_author" type="text" id="film_author">
	</div>
	<div class="pure-control-group">
	<label for="film_production">Production Company </label>
	<input name="film_production" type="text" id="film_production">
	</div>
	<input type="submit" value="Submit">
	
	</fieldset>
</form>
</body>
</html>