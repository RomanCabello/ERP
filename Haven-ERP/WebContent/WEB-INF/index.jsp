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
            <li><a href="controller?action=liststaff">Show all</a></li>
            <li><a href="controller?action=readbyid">Show Staff by ID</a></li>
            <li><a href="controller?action=readstaff">Add new Staff</a></li>
        </ul>
         
    </body>
</html>