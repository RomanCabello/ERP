<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/login.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


</head>
<body>
<!-- 	<form class="pure-form pure-form-stacked" -->
<!-- 		action="cl?action=register" method="post"> -->

<!-- 		<legend>Enter Staff details:</legend> -->

<!-- 		<label for="Name">Name:</label> <input id="Name" type="text" -->
<!-- 			name="Name"> <label for="Lname">Last Name:</label> -->
<!-- 		<input id="Lname" type="text" name="Lname">  -->
<!-- 		<label for="Mail">Mail:</label>  -->
<!-- 		<input id="Mail" type="text"name="Mail"> -->
<!-- 		<label for="Pass">Password:</label>  -->
<!-- 		<input id="Pass" type="password"name="Pass">   -->
<!-- 		<label for="CC">Credit Card Number:</label>  -->
<!-- 		<input id="CC" type="password" name="CC">   -->
			
			
		
		
		

<!-- 		<button class="pure-button pure-button-primary" type="submit">Submit</button> -->

<!-- 	</form> -->


<div class="login-box">
	<h2>Register</h2>
	
	<form action="cl?action=register" method="post">
	
    <div class="user-box">
      <input type="text" name="Name" required>
      <label>First Name</label>
    </div>
    <div class="user-box">
      <input type="text" name="Lname" required>
      <label>Last Name</label>
    </div>
    <div class="user-box">
      <input type="text" name="Mail" required>
      <label>Mail</label>
    </div>
    <div class="user-box">
      <input type="password" name="Pass" required>
      <label>Password</label>
    </div>
    <div class="user-box">
      <input type="password" name="CC" required>
      <label>Credit Card</label>
    </div>
    <button type="submit">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Register
    </button>
  </form>
  </div>


</body>
</html>