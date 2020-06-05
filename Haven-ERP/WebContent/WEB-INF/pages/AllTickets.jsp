<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ page import="java.util.ArrayList"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Tickets</title>
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
	 <table class="pure-table pure-table-horizontal">
            <thead>
                <tr>
                    <th>TID</th>
                    <th>SID</th>
                    <th>EID</th>
                    <th>Notes</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th></th>
                </tr>
            </thead>

            <c:forEach items="${ticketlist}" var='ticket'>
            
            	
            
                <tr>
                    <td>
                        <c:out value="${ticket.tid}"/>
                    </td>
                    <td>
                        <c:out value="${ticket.sid}"/>
                    </td>
                    <td>
                        <c:out value="${ticket.eid}"/>
                    </td>
                    <td>
                        <c:out value="${ticket.note}"/>
                    </td>
                    <td>
                        <c:out value="${ticket.sdate}"/>
                    </td>
                    <td>
                        <c:out value="${ticket.edate}"/>
                    </td>               
                    <td>
                        <a href="controller?action=endticket&tid=${ticket.tid}&eid=${ticket.eid}">Finish</a>
                    </td>
                    
                </tr>
            </c:forEach>          

        </table>
        
        <nav>
            <a href="i1">Home</a>
        </nav>
</body>
</html>