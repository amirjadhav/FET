<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<a href="<%=request.getContextPath()%>/manager/add-batch.jsp">Add
	Plan</a>
<table border="1">
	<tr>
		<th>Batchid </th>
		<th>Batchname</th>
		<th>Sportid </th>
		<th>Batch Start DAte</th>
		<th>Batch time</th>
		<th>Batch duration</th>		
		<th>Batch size</th>

	</tr>
	<c:forEach var="batches" items="${batches}">
		<tr>
			<td><c:out value="${batches.batchid}" /></td>
			<td><c:out value="${batches.batchname}" /></td>
			<td><c:out value="${batches.sportsid}" /></td>
			<td><c:out value="${batches.batchStartDate}" /></td>
			<td><c:out value="${batches.batchTime}" /></td>
			<td><c:out value="${batches.batchDuration}" /></td>
			<td><c:out value="${batches.batchSize}" /></td>
			<td><a
				href="<%=request.getContextPath()%>/ManagerController/deletebatch?batchid=${batches.batchid}">delete</a></td>
			<td><a
				href="<%=request.getContextPath()%>/ManagerController/editbatch?batchid=${batches.batchid}">update</a></td>
		</tr>
	</c:forEach>
</table>

<%@include file="manager-footer.jsp"%>
