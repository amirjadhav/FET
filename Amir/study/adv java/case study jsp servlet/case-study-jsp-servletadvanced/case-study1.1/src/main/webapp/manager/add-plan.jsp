<%@page import="com.cybage.dao.ManagerDao"%>
<%@page import="com.cybage.model.Sports"%>
<%@page import="java.util.List"%>
<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<form action="<%=request.getContextPath()%>/ManagerController/addplan"
	method="post">
	Planname: <input type="text" name="planname"> <br> Sport:

		<%
			List<Sports> sports = new ManagerDao().getSports();
		%>
	<select name="sportsid">
		<% for(Sports sport : sports){ %>
			<option value="<%= sport.getSportsId()%>"><%= sport.getSportsName() %></option>
		<% } %>
	</select>
	
	<br> Fees: <input type="text" name="fees"> <br>
	Duration: <input type="text" name="duration"> <input
		type="submit" value="Add Plan">
</form>

<%@include file="manager-footer.jsp"%>