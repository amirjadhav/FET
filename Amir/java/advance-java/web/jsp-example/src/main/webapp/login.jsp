<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("address", "pune");
		response.addCookie(cookie);
	%>

	<%
		out.print("using out.print");
	%>
	<br>

	<%="using expression tag"%>
	<br>
	<c:out value="using jstl"></c:out>
	<form action="authenticate.jsp">
		username: <input type="text" name="username"> <br>
		password: <input type="password" name="password"> <br> <input
			type="submit" value="submit">
	</form>


	<c:forEach var="i" begin="10" end="20">
		<br> Number: ${i}
	</c:forEach>
</body>
</html>