<%@include file="member-head.jsp" %>
<hr>
	Welcome user
	<%
	out.print("user name is :" + request.getRemoteUser());
%>


<hr>
<%@include file="member-footer.jsp" %>