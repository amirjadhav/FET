<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!//code inside declaration tag goes out of _jspService()
	public int add() {
		return 10 + 20;
	}%>
	<%
		String name = request.getParameter("username");
		System.out.println(name);
	%>

	<%="welcome " + name%>
	<%
		out.print("welcome1  " + name);
	%>
	//line above and this is same
</body>
</html>