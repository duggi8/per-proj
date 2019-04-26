<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/api/alien" modelAttribute="alien">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<form:label path="id">Id</form:label>
		<form:input path="id" />
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>