<%@page import="java.util.ArrayList"%>
<%@page import="com.cybage.model.Batch"%>
<%@page import="java.util.List"%>
<%@page import="com.cybage.dao.MemberDao"%>
<%@include file="member-head.jsp" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<hr>
	Welcome user: <%	out.print("user name is :" + request.getRemoteUser());	%>	
	<h1>Enrollment</h1>
	<form action="<%=request.getContextPath()%>/MemberController/makeenrollment" method="post">
	Plan id: <input type="text" name = "planid" value="${planid }" readonly="readonly">
	
	<%
		MemberDao md = new MemberDao();
		List<Batch> batches =  md.getBatches();		
	%>
	<br>
	Choose Batch: 
	<select name="batchid">
	<% for(Batch batch :batches){ %>
		<option value="<%= batch.getBatchid()%>"><%=batch.getBatchname()+ " - time "+ batch.getBatchTime() %></option>
	<%} %>
	</select>
	<br>
	Start Date: <input type="date" name="startdate">
	<br>
	<input type="submit" value="Enroll">
	</form>
<hr>
<%@include file="member-footer.jsp" %>