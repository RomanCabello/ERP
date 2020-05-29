<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="pure-form pure-form-stacked"
		action="controller?action=register" method="post">

		<legend>Enter Staff details:</legend>

		<label for="Name">Name:</label> <input id="Name" type="text"
			name="Name"> <label for="Lname">Last Name:</label>
		<input id="Lname" type="text" name="Lname"> 
		<label for="Mail">Mail:</label> 
		<input id="Mail" type="text"name="Mail">
		<label for="CC">Mail:</label> 
		<input id="CC" type="password"name="CC">  
			
			
		
		
		

		<button class="pure-button pure-button-primary" type="submit">Submit</button>

	</form>
</body>
</html>