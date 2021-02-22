<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome manager
	<%
	out.print("user name is :" + request.getRemoteUser());
%>

	<ul>
		<li><a href="<%=request.getContextPath()%>/ManagerController/planlist">Plans</a></li>
		<li><a href="<%=request.getContextPath()%>/ManagerController/batchlist">Batches</a></li>
		<li><a href="<%=request.getContextPath()%>/ManagerController/enrollments">Enrollments</a></li>
		<li><a href="<%=request.getContextPath()%>/logout.jsp">logout</a></li>
	</ul>
	