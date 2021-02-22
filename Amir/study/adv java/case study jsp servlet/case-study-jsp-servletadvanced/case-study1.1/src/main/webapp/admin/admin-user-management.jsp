<%@include file="admin-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<a href="<%=request.getContextPath()%>/admin/admin-add-user.jsp">Add user</a>
<table border="1">
	<tr>
		<th>Username</th>
		<th>User role</th>
	</tr>
	<c:forEach var="table" items="${users}">
		<tr>
			<td><c:out value="${table.username}" /></td>
			<td><c:out value="${table.role}" /></td>
			<td><a href="<%=request.getContextPath()%>/AdminController/delete?un=${table.username}">delete</a></td>
			<td><a href="<%=request.getContextPath()%>/AdminController/edit?un=${table.username}">update</a></td>
		</tr>
	</c:forEach>
</table>

<%@include file="admin-footer.jsp"%>
