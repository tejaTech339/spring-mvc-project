<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${allusers}">
			<tr>
				<td>${user.userId }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				<td>${user.password }</td>
				<td>Button</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>