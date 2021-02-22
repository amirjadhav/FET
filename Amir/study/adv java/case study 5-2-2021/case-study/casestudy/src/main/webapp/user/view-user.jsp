<%@page import="java.security.Principal"%>
<%@page import="com.cybage.model.User"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<h1>welcome <%= request.getRemoteUser() %></h1>

<a href="<%=request.getContextPath()%>/user/add-user.jsp">Add User</a>
<br>
<table border="1">
	<tr>
		<td>Sr No</td>
		<td>User id</td>
		<td>Username</td>
		<td>Address</td>
		<td>Role</td>
		<td>Delete</td>
		<td>Update</td>
	</tr>
	<c:forEach var="u" items="${users}">
		<tr>
			<td>Sr No</td>
			<td><c:out value="${u.id }"></c:out></td>
			<td><c:out value="${u.name }"></c:out></td>
			<td><c:out value="${u.address }"></c:out></td>
			<td><c:out value="${u.role }"></c:out></td>
			<td> <a href="<%=request.getContextPath()%>/UserController/delete?id=${u.id}">Delete</a> </td>
			<td> <a href="<%=request.getContextPath()%>/UserController/edit?id=${u.id}">Update</a> </td>			
		</tr>
	</c:forEach>

</table>

<%@include file="footer.jsp" %>