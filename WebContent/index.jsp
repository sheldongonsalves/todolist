<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="LoginServlet" method="post">
	<p>${message}</p>
		user name:<br> <input type="text" name="username"
			value="${param.username}"> <br> password:<br> <input
			type="text" name="password" value=${param.password}> <br>
		<br> <input type="submit" value="Login">
	</form>

</body>
</html>