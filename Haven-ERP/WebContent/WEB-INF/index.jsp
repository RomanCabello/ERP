<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <title>Home page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <h2>Home page</h2>
        
        <p>Available actions:</p>
        
        <ul>
            <li><a href="controller?action=liststaff">Show All Employees</a></li>
            <li><a href="controller?action=readbyid">Search Staff by ID</a></li>
            <li><a href="controller?action=readstaff">add new Hire</a></li>
            
        </ul>
        
        <br>
        
        <ul>
        	<li><a href="controller?action=listequip">List All equipment</a></li>
        	<li><a href="controller?action=readequip">Add equipment</a></li>
        </ul>

         
    </body>
</html>