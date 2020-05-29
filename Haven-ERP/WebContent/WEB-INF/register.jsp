<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		action="cl?action=register" method="post">

		<legend>Enter Staff details:</legend>

		<label for="Name">Name:</label> <input id="Name" type="text"
			name="Name"> <label for="Lname">Last Name:</label>
		<input id="Lname" type="text" name="Lname"> 
		<label for="Mail">Mail:</label> 
		<input id="Mail" type="text"name="Mail">
		<label for="Pass">Password:</label> 
		<input id="Pass" type="password"name="Pass">  
		<label for="CC">Credit Card Number:</label> 
		<input id="CC" type="password" name="CC">  
			
			
		
		
		

		<button class="pure-button pure-button-primary" type="submit">Submit</button>

	</form>
</body>
</html>