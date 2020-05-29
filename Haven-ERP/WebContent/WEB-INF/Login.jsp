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
		action="cl?action=logstaff" method="post">

		<legend>LogIn:</legend>

	<label for="LogMail">Mail:</label> <input id="LogMail" type="text"
			name="LogMail"> <label for="LogPass">Password:</label>
		<input id="LogPass" type="password" name="LogPass">
		<button class="pure-button pure-button-primary" type="submit">Submit</button>

	</form>
	
	<br>
	Don't hava an account? <a href="cl?action=read">Register</a>
	
	
</body>
</html>