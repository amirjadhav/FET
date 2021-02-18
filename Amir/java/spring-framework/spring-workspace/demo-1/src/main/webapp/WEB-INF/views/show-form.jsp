<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<frm:form modelAttribute="emp" method="post" 
		action="/submit-form">
		id: <frm:input path="id"/>
		<br>
		name: <frm:input path="name"/>
	 	<br>
	 	<input type="submit" value="Submit data...">
	</frm:form>
</body>
</html>
