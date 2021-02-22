<%@page import="com.cybage.dao.ManagerDao"%>
<%@page import="com.cybage.model.Sports"%>
<%@page import="java.util.List"%>
<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<form action="<%=request.getContextPath()%>/ManagerController/addbatch"
	method="post">
	
	Batchname: <input type="text" name="batchname"> 
	<br> 
	
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
	Batch Start Date: <input type="date" name="batchstartdate">
	<br>
	Batch Time: <input type="time" name="batchtime">	
	<br>
	
	Duration: <input type="text" name="batchduration">
	
	<br>
	
	Batch Size:  <input type="text" name="batchsize">
	<input	type="submit" value="Add Batch">
</form>

<%@include file="manager-footer.jsp"%>