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
<!-- 		action="cl?action=logstaff" method="post"> -->

<!-- 		<legend>LogIn:</legend> -->

<!-- 	<label for="LogMail">Mail:</label> <input id="LogMail" type="text" -->
<!-- 			name="LogMail"> <label for="LogPass">Password:</label> -->
<!-- 		<input id="LogPass" type="password" name="LogPass"> -->
<!-- 		<button class="pure-button pure-button-primary" type="submit">Submit</button> -->

<!-- 	</form> -->

<%
	bean.Login log = (bean.Login) request.getSession().getAttribute("login");
	if(log!=null)
	{
		
		
		response.sendRedirect("cl");
		
	}
%>

<div class="login-box">
	<h2>Login</h2>
	<form action="cl?action=logstaff" method="post">
    <div class="user-box">
      <input type="text" name="LogMail" required>
      <label>Username</label>
    </div>
    <div class="user-box">
      <input type="password" name="LogPass" required>
      <label>Password</label>
    </div>
    <button type="submit">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Submit
    </button>
  </form>
  <br>
  <div class="register-link"><a href="cl?action=read">Register</a></div>
  </div>
	
	

	
</body>
</html>