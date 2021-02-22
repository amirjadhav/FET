<%@page import="com.cybage.dao.ManagerDao"%>
<%@page import="com.cybage.model.Sports"%>
<%@page import="java.util.List"%>
<%@include file="manager-head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<form action="<%=request.getContextPath()%>/ManagerController/updatebatch"
	method="post">
	Batchid: <input type="text" name="batchid" value="${batch.batchid}"> 
	<br> 
	Batchname: <input type="text" name="batchname" value="${batch.batchname}"> 
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
	Batch Start Date: <input type="date" name="batchstartdate" value="${batch.batchStartDate }">
	<br>
	Batch Time: <input type="time" name="batchtime" value="${batch.batchTime }">	
	<br>
	
	Duration: <input type="text" name="batchduration" value="${batch.batchDuration }">
	
	<br>
	
	Batch Size:  <input type="text" name="batchsize" value="${batch.batchSize }">
	<input	type="submit" value="Update Batch">
</form>

<%@include file="manager-footer.jsp"%>