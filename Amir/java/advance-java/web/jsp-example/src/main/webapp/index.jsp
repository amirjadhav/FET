<%-- <%@page errorPage="/error.jsp"%> --%>
<html>
<body>
	<h2>Hello World!</h2>
	<form action="process.jsp">
		<input type="text" name="username"> <br> <input
			type="submit" value="submit">
	</form>
	<%
		// You can add java code here...
		int a = 10;
		String name = "Amir";
		System.out.println("Hi " + name);
	//	System.out.print(12 / 0);
	%>
</body>
</html>