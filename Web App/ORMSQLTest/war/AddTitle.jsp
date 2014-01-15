<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Title</title>
<link rel="stylesheet" href="/css/page-style.css" type="text/css"/>
<link rel="stylesheet" href="/css/pure_grid.css" type="text/css"/> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> 
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css"/>
</head>
<body>
<h3>Add Book</h3>
<form id="film_form" class="pure-form pure-form-aligned" method="POST" action="add_title.do">
	<fieldset id="movie_field">
		<legend>Book Info</legend>
		<div class="pure-control-group">
		<label for="title">Title </label>
		<input id="title" name="title" type="text">
		</div>
		<div class="pure-control-group">
		<label for="director">Director </label>
		<input id="director" name="director" type="text">
		</div>
		<div class="pure-control-group">
		<label for="tag">Tagline </label>
		<input id="tag" name="tag" type="text">
		</div>
		<div class="pure-control-group">
		<label for="release_date">Release Date </label>
		<input name="release_date" placeholder="dd/mm/yyyy" type="text" class="suggest_form" id="pickdate">
		</div>
		<div id="actorarea">
			<div id="actorform" style="margin-bottom:16px">
				<h4>Actor</h4>
				<label for="actor_name">Name </label>
				<input id="actor_name" name="actor_name" type="text">
				<label for="actor_dob">Date of Birth</label>
				<input name="actor_dob" placeholder="dd/mm/yyyy" type="text" class="suggest_form" id="pickdate">
			</div>
		</div>
		<input type="button" onclick="addNewActor()" class="pure-button history_button" value="Add Actor" style="margin-bottom:12px;">
		<br>
		<input type="submit" class="pure-button history_button" value="Add Title">
	</fieldset>
	<div id="infotext"></div>
</form>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script>
function addNewActor(){
	$('#actorform').clone().appendTo($('#actorarea')).hide().show(500);
}

$(function() {
	$( "#pickdate" ).datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: "1900:" + (new Date()).getFullYear(),
		dateFormat: "dd/MM/yy"
	});
});
</script>
</body>
</html>