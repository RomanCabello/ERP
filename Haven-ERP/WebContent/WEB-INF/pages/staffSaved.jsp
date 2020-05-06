<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Car saved</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <p>
            Successfully saved  <c:out value="${sessionScope.staffFname}"/>
            Successfully saved  <c:out value="${sessionScope.staffLname}"/>
            Staff Salary <c:out value="${sessionScope.staffSalary}"/>
            ID: <c:out value="${sessionScope.id}"/>
        </p>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>  
    </body>
</html>