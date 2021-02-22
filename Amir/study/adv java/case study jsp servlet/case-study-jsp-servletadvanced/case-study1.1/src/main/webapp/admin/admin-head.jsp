  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/admin-home.jsp">Home</a></li>
		<li><a href="<%=request.getContextPath()%>/AdminController/list">User Management</a></li>
		<li><a href="<%=request.getContextPath()%>/logout.jsp">Logout</a></li>
		
	</ul>
</nav>