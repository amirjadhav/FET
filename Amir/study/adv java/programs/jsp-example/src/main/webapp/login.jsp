<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login form</h1>

<% out.print("using out.print"); %>
<br>

<%= "using expression tag"%>
<br>
<% int a = 10; %>
<c:out value="this is jstl way " ></c:out>
<br>

<c:forEach var="i" begin="10" end="20">
	<br> Number: <c:out value="${i}"></c:out> 
</c:forEach>

<%
	for(int i = 10; i < 20; i++){
		out.print("<div>" + i + "</div>");
	}
%>

<%
	Cookie cookie = new Cookie("address", "pune");
	response.addCookie(cookie);
%>
<a href="authenticate.jsp">go to authenticate.jsp page</a>
<form action="authenticate.jsp" method="post">
	username: <input type="text" name="username">
	<br>
	password: <input type="password" name="password">
	<br>
	<input type="submit" value="Login">
</form>
</body>
</html>