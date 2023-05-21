<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Edit Student</h1>
	<hr>
	
	<form action="${pageContext.request.contextPath}/update">
	ID:<input type="text" name="sid" value="${s.sid }"/><br>
	<br>
	Name:<input type="text" name="sname" value="${s.sname}" /><br>
	 <br>
	  City:<input type="text" name="scity" value="${s.scity }"/><br>
	   <br>
	    %:<input type="text" name="sper" value="${s.sper }" /><br> <br>
	<input type="submit" value="update"/>
	</form>
	</center>
</body>
</html>