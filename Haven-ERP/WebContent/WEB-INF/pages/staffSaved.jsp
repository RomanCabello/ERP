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
            Successfully saved  <c:out value="${sessionScope.staffFname}"/><c:out value="${sessionScope.staffLname}"/>
            <br>
            Staff Salary <c:out value="${sessionScope.staffSalary}"/>
            <br>
            ID: <c:out value="${sessionScope.id}"/>
            <br>
            Password: <c:out value="${sessionScope.pass}"/>
        </p>

        <nav>
            <a href="i1">Home</a>
        </nav>  
       
    </body>
</html>