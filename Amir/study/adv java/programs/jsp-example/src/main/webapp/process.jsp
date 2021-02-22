<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page errorPage="error.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	//code inside declaration tag goes outside _jspService()
	public int add(){
		return 10+ 20;
	}
%>
<%
	String name = request.getParameter("username");
	System.out.println("username is : "+ name + add());
%>
<%="<h1>welcome: "+ name  + "</h1>"%>
<% out.print("<h1>welcome: "+ name  + "</h1>"); %>

<%  System.out.print("value from session: "+ session.getAttribute("address")); %>
<%
	System.out.println(10123/0);
%>
</body>
</html>