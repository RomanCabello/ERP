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
	
		<a href="controller?action=getbroken">Show only broken equipment</a>
		<a href="controller?action=listequip">Show all</a>
        <table class="pure-table pure-table-horizontal">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Acquisition Date</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <c:forEach items="${equipList}" var='equip'>
            
            	
            
                <tr>
                    <td>
                        <c:out value="${equip.id}"/>
                    </td>
                    <td>
                        <c:out value="${equip.name}"/>
                    </td>
                    <td>
                        <c:out value="${equip.bdate}"/>
                    </td>
                    <td>
                        <c:out value="${equip.price}"/>
                    </td>
                    <td>
                        <c:out value="${equip.status}"/>
                    </td>         
                    <td>
                        <a href="controller?action=isbroken&id=${equip.id}">Report as broken</a>
                    </td>
                    <td>
                        <a href="controller?action=checkout&id=${equip.id}">Use</a>
                    </td>
                </tr>
            </c:forEach>          

        </table>

        <nav>
            <a href="<%= request.getContextPath() %>">Home</a>
        </nav>
	
	</body>
</html>