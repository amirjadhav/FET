<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>

<%-- <%@page errorPage="error.jsp" %>
<%@page import="com.cybage.Util"%>
 --%>
 
<!-- it indicates this page is useful to report exception -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Error page...</h1>
	Reason for error:
	<%=exception.getMessage()%>
</body>
</html>