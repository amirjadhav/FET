<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome admin: <% out.print("user name is :"+ request.getRemoteUser()); %>
<a href="admin1.jsp">page 1</a>
<br>
<a href="admin2.jsp">page 2</a>
<br>

<a href="../logout.jsp">logout</a>
</body>
</html>