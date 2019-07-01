<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
 <div>		
	<form action="register" method="post">


 	<div>
      <label >First Name</label>
      <input type="text" name="fname" required>
    </div>

	<div>
      <label>Last Name</label>
      	<input type="text"  name="lastname" required/>
    	    </div>

	<div>
      <label>Enter Email ID</label>
      	<input type="text" name="email">
    </div>

	
	<div>
      <label>Enter Subject</label>
      	<input type="text" name="subject" required>
    </div>
    
    <div>
      <label>Enter Date</label> 
      	<input type="text" name="date">
    </div>

<button type="submit" name="btn">Register Me</button>
<form>
</body>
</html>