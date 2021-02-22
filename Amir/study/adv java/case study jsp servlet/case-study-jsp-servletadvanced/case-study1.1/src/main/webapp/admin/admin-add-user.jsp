<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AdminController/add" method="post">
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br>
		userrole:
		<select name="userrole">
			<option >Select role</option>
			<option value="admin">Admin</option>
			<option value="manager">Manager</option>
			<option value="member">Member</option>
		</select> 
		 <br> 
		 <input	type="submit" value="Register">
	</form>
</body>
</html>