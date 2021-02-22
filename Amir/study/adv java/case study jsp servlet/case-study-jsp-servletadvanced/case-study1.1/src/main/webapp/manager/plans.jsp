<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<a href="<%=request.getContextPath()%>/manager/add-plan.jsp">Add
	Plan</a>
<table border="1">
	<tr>
		<th>Plan id</th>
		<th>Plan name</th>
		<th>Sports</th>
		<th>Fees</th>
		<th>Duration</th>

	</tr>
	<c:forEach var="table" items="${plans}">
		<tr>
			<td><c:out value="${table.planid}" /></td>
			<td><c:out value="${table.planname}" /></td>
			<td><c:out value="${table.sportid}" /></td>
			<td><c:out value="${table.fees}" /></td>
			<td><c:out value="${table.duration}" /></td>
			<td><a
				href="<%=request.getContextPath()%>/ManagerController/deleteplan?planid=${table.planid}">delete</a></td>
			<td><a
				href="<%=request.getContextPath()%>/ManagerController/editplan?planid=${table.planid}">update</a></td>
		</tr>
	</c:forEach>
</table>

<%@include file="manager-footer.jsp"%>
