<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Staff</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
			integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
			crossorigin="anonymous">
		
		<style>
		body {
			padding: 1em
		}
		
		nav {
			margin-top: 2em
		}
		</style>
	</head>
	<body>
	
	<h2>All Staff</h2>
	

        <table class="pure-table pure-table-horizontal">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Salary</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <c:forEach items="${staffList}" var='staff'>
            
            	
            
                <tr>
                    <td>
                        <c:out value="${staff.id}"/>
                    </td>
                    <td>
                        <c:out value="${staff.fname}"/>
                    </td>
                    <td>
                        <c:out value="${staff.lname}"/>
                    </td>
                    <td>
                        $<c:out value="${staff.salary}"/>.00
                    </td>        
                    <td>
                        <a href="controller?action=deletestaff&del=${staff.id}">Delete</a>
                    </td>
                    <td>
                        <a href="controller?action=changestaff&upd=${staff.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>          

        </table>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>
	
	</body>
</html>