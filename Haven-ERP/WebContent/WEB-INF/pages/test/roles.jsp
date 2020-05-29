<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ page import="java.util.ArrayList"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
			padding: 1em
		}
		
		nav {
			margin-top: 2em
		}
		</style>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
			href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
			integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
			crossorigin="anonymous">
<title>Roles</title>
</head>
<body>

	<h2>Roles</h2>
	
	<table class="pure-table pure-table-horizontal">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Area</th>
			</tr>
		</thead>
		
		<c:forEach items="${roles}" var='role'>
			<tr>
				<td>
					<c:out value="${role.id}"/>
				</td>
				<td>
					<c:out value="${role.name}"/>
				</td>
				<td>
					<c:out value="${role.aid}"/>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>

</body>
</html>