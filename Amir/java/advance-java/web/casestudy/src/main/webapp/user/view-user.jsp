<%@page import="com.cybage.model.User"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="<%=request.getContextPath()%>/user/add-user.jsp">Add User</a>
<br>
<table border="1">
	<tr>
		<td>Sr No</td>
		<td>User id</td>
		<td>Username</td>
		<td>Address</td>
		<td>Delete</td>
		<td>Update</td>

	</tr>

	<c:forEach var="u" items="${users}">
		<tr>
			<td>Sr No</td>
			<td><c:out value="${u.id}"></c:out></td>
			<td><c:out value="${u.name}"></c:out></td>
			<td><c:out value="${u.address}"></c:out></td>
			<td><a href="<%=request.getContextPath()%>/UserController/delete">delete</a></td>
			<td><a href="<%=request.getContextPath()%>/UserController/edit">update</a></td>

		</tr>
	</c:forEach>
<%-- 
	<%
		List<User> users = (List) request.getAttribute("users");
		int i = 0;
		for (User u : users) {
			out.print("<tr>");
			out.print("<td> " + ++i + "</td>");
			out.print("<td>" + u.getId() + "</td>");
			out.print("<td>" + u.getName() + "</td>");
			out.print("<td>" + u.getAddress() + "</td>");
			out.print("<td> <a href='delete?id=22303'>Delete</a>  </td>");
			out.print("<td> <a href='edit?id=36922'>Update</a>  </td>");

			out.print("</tr>");
		}
	%> --%>

</table>

<%@include file="footer.jsp"%>