<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table border="1" align="center">
		<th>Id</th>
		<th>Name</th>
		<th>City</th>
		<th>percentage</th>
		<th>Action</th>
		<th>Edit</th>
		<c:forEach items="${studentlist}" var="s">
			<br>
			<tr style="align-items: center;">
				<td>${s.sid}</td>
				<td>${s.sname}</td>
				<td>${s.scity}</td>
				<td>${s.sper}</td>
				<td><a href="${pageContext.request.contextPath}/delete/${s.sid}">DELETE</a></td>
				<td><a href="${pageContext.request.contextPath}/edit/${s.sid}">EDIT</a></td>

			</tr>
		</c:forEach>

	</table>
	</center>
</body>
</html>