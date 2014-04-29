<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Film Page</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<form id="film__form" class="pure-form pure-form-aligned" method="POST" action="film.do">
	<fieldset id="film_field">
	<legend>Film Form</legend>
	
	<div class="pure-control-group">
	<label for="title">Title </label>
	<input name="title" type="text" id="title">
	</div>
	<div class="pure-control-group">
	<label for="release">Release </label>
	<input name="release" placeholder="dd/mm/yyyy" type="text" class="form" id="pickdate">
	</div>
	<div class="pure-control-group">
	<label for="driector">Director </label>
	<input name="director" type="text" id="director">
	</div>
	<div class="pure-control-group">
	<label for="production">Production Company </label>
	<input name="production" type="text" id="production">
	</div>
	
	<div id="actors_div">
		<h3>Actors</h3>
		<div id="actor_row">
			<div class="pure-control-group">
				<label for="actor_firstname">First Name:</label>
				<input type="text" name="actor_firstname" id="actor_firstname">
				<label for="actor_surname">Surname:</label>
				<input type="text" name="actor_surname" id="actor_surname">
			</div>
		</div>
	</div>
	<div><input type="button" value="Add Actor" onclick="addActor()"></div>
	
	<input name="id" type="hidden" value="${id}">
	<input type="submit" value="Submit">
	
	</fieldset>
</form>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script>
function addActor(){
	$("#actors_div").append($("#actor_row").clone());
}
</script>
</body>
</html>