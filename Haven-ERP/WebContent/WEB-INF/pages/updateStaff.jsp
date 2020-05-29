<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Car details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
              integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
              crossorigin="anonymous">      
        <style>
            body { padding:1em }
            nav { margin-top: 2em }
        </style>

    </head>

    <body>

        <form class="pure-form pure-form-stacked" action="controller?action=updatestaff&id=${returnedStaff.id}&jid=${returnedJob.id}" method="post">

            <legend>Enter Staff details:</legend>

			<label for="sid">ID:</label>
			<input id="sid" type="text" name="sid" value="${returnedStaff.id}" disabled>
			
			
			
            <label for="staffName">Name:</label>
            <input id="staffName" type="text" name="staffName" value="${returnedStaff.fname}">
            
            <label for="staffLname">Last Name:</label>
            <input id="staffLname" type="text" name="staffLname" value="${returnedStaff.lname}">

            <label for="staffSalary">Salary:</label>
            <input id ="staffSalary" type="text" name="staffSalary" value="${returnedJob.salary}">

            <button class="pure-button pure-button-primary" type="submit">Update</button>

        </form>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>               

    </body>
</html>