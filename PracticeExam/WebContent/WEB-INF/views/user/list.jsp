<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
<table >

<c:forEach var="v" items="${requestScope.listofstudent}">

)
			<tr>
			
			<td>${v.id}</td>
			
				
				<td>${v.name}</td>
				<td>${v.lastname}</td>
				<td>${v.subject}</td>
				<td>${v.email}</td>
				
				<td>${v.date}</td>
				

</c:forEach>
</table>


</body>
</html>