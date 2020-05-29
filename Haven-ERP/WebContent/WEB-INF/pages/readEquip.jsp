<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Car details</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style>
body {
	padding: 1em
}

nav {
	margin-top: 2em
}
</style>

</head>

<body>

	

	<form class="pure-form pure-form-stacked"
		action="controller?action=savedequip" method="post">

		<legend>Enter equipment details:</legend>

		<label for="equipName">Model:</label> <input id="equipName" type="text"
			name="equipName"> <label for="equipPrice">Price:</label>
		<input id="equipPrice" type="text" name="equipPrice">
		
		
		

		<button class="pure-button pure-button-primary" type="submit">Submit</button>

	</form>
	
	<div id="demo"></div>
		
		

	<nav>
		<a href="<%= request.getContextPath() %>">Home</a>
	</nav>

</body>
</html>