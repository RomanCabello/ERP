<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ticket</title>
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div class="login-box">
	<h2>Ticket</h2>
	<form action="controller?action=ticket" method="post">
    <div class="user-box">
      <input type="text" name="SID" required>
      <label>Staff ID</label>
    </div>
    <div class="user-box">
      <input type="text" name="Note" required>
      <label>Notes</label>
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
  </div>
</body>
</html>