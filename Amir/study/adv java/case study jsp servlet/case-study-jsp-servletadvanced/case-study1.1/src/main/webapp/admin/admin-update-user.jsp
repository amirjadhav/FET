<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AdminController/update"
		method="post">
		Username: <input type="text" name="username" value="${user.username }" readonly="readonly">
		<br>
		 Password: <input type="password" name="password" value="${user.username }"> 
			<br> userrole: <input
			type="text" name="userrole" value="${user.role }"> <br>
		<input type="submit" value="Update">
	</form>
</body>
</html>