<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Returned car</title>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <h2>Staff details</h2>
        
        <ul>
            <li>ID: <c:out value="${returnedStaff.id}"/></li>
            <li>Name: <c:out value="${returnedStaff.fname}"/></li>
            <li>Last Name: <c:out value="${returnedStaff.lname}"/></li>
            <li>Salary: <c:out value="${returnedStaff.salary}"/></li>
        </ul>
        
        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>        
        
    </body>
</html>