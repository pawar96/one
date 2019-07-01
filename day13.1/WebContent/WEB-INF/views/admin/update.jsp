<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Your Assigned Ref ID (R)</td>
				<td><sf:input  path="id" readonly="true"/></td>
			</tr>
			<tr>
				<td>Your Email (R)</td>
				<td><sf:input  path="email" readonly="true"/></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><sf:input  path="name" /></td>
			</tr>
			<tr>
				<td>Enter City</td>
				<td><sf:input  path="city" /></td>
			</tr>
			<tr>
				<td>Enter Phone No</td>
				<td><sf:input  path="phoneNo" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" showPassword="true"/></td>
			</tr>
			<tr>
				<td>Choose Role</td>
				<td><sf:radiobutton path="role" value="admin" />Admin</td>
				<td><sf:radiobutton path="role" value="vendor" />Vendor</td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><sf:input  type="number" path="regAmount" /></td>
			</tr>
			<tr>
				<td>Choose Reg Date</td>
				<td><sf:input type="date" path="regDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Details" /></td>


			</tr>
		</table>
	</sf:form>

</body>
</html>