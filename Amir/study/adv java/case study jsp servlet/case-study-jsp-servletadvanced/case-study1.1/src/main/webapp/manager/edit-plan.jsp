<%@page import="com.cybage.dao.ManagerDao"%>
<%@page import="com.cybage.model.Sports"%>
<%@page import="java.util.List"%>
<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<form action="<%=request.getContextPath()%>/ManagerController/updateplan"
	method="post">
	Planid :  <input type="text" name="planid" value="${plan.planid }"> <br>
	Planname: <input type="text" name="planname" value="${plan.planname }"> <br> 
	
	Sport:
		<%
			List<Sports> sports = new ManagerDao().getSports();
		%>
	<select name="sportsid">
		<% for(Sports sport : sports){ %>
			<option value="<%= sport.getSportsId()%>"><%= sport.getSportsName() %></option>
		<% } %>
	</select>
	
	<br> 
	Fees: <input type="text" name="fees" value="${plan.fees }"> 
	<br>
	Duration: <input type="text" name="duration" value="${plan.duration }"> 
	<input	type="submit" value="Edit Plan">
</form>

<%@include file="manager-footer.jsp"%>