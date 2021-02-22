<%@include file="member-head.jsp" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<hr>
	Welcome user
	<%
	out.print("user name is :" + request.getRemoteUser());
%>

<table border="1">
	<tr>
		<th>Plan id</th>
		<th>Plan name</th>
		<th>Sports</th>
		<th>Fees</th>
		<th>Duration</th>

	</tr>
	<c:forEach var="plan" items="${plans}">
		<tr>
			<td><c:out value="${plan.planid}" /></td>
			<td><c:out value="${plan.planname}" /></td>
			<td><c:out value="${plan.sportid}" /></td>
			<td><c:out value="${plan.fees}" /></td>
			<td><c:out value="${plan.duration}" /></td>
			<td><a
				href="<%=request.getContextPath()%>/MemberController/enroll?planid=${plan.planid}">Enroll</a></td>
		</tr>
	</c:forEach>
</table>

<hr>
<%@include file="member-footer.jsp" %>