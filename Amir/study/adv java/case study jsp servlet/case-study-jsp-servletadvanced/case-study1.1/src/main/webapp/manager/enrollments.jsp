<%@include file="manager-head.jsp" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<hr>
	Welcome user
	<%
	out.print("user name is :" + request.getRemoteUser());
%>

<table border="1">
	<tr>
		<th>Enrollment id</th>
		<th>Plan id</th>
		<th>Batch id </th>
		<th>Start Date</th>
		<th>Status</th>

	</tr>
	<c:forEach var="en" items="${enrollments}">
		<tr>
			<td><c:out value="${en.enrollid}" /></td>
			<td><c:out value="${en.planid}" /></td>
			<td><c:out value="${en.batchid}" /></td>
			<td><c:out value="${en.startdate}" /></td>
			<td><c:out value="${en.status}" /></td>
			 
		</tr>
	</c:forEach>
</table>

<hr>
<%@include file="manager-footer.jsp" %>