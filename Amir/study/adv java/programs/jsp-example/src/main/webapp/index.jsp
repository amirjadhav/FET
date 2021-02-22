<%@page import="com.cybage.Util"%>
<%@page import="java.sql.Date"%>
 <%-- <%@page errorPage="error.jsp" %> --%>
<html>
<body>
<h2>Hello World!</h2>
<form action="process.jsp">
	Username: <input type="text" name="username">
	<input type="submit" value="submit">
</form>
<% 
//you can add any java code in this...
int a = 10;
String name = "dmj";
System.out.print("hi"  + a + name);
System.out.print(new Util().add());
System.out.print(config.getInitParameter("name"));
System.out.print(application.getInitParameter("orgname"));
session.setAttribute("address", "Katraj, Pune");


%>
</body>
</html>
