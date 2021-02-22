<%@include file="admin-head.jsp" %>
	Welcome admin:
	<%
	out.print("user name is :" + request.getRemoteUser());
%>
	 

<%@include file="admin-footer.jsp" %>
