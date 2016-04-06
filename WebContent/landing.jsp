<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo landing</title>
</head>
<body>

	<form action="LandingPageServlet" method="post">
		item id:<br> <input type="text" name="itemid"
			value=${param.itemid}> <br> item name:<br> <input
			type="text" name="itemname" value=${param.itemname}> <br>
		item date:<br> <input type="date" name="itemdate" min="2015-12-31" max="2016-12-31"><br> 
		item status:<br> <input type="text" name="itemstatus" value=${param.itemstatus}> <br>
		<br> <input type="submit" value="add">

	</form>
	
	<form action="UpdateDateServlet" method="post">
	<p>..........Update task..............</p>
		Enter item id:<br> <input type="text" name="itemid" value=${param.itemid}> <br> item name:<br>
		Enter item date:<br> <input type="date" name="itemdatechange" min="2015-12-31" max="2016-12-31"><br> 
		
		<br> <input type="submit" value="update">

	</form>
	<table border=1>
		<tr>
			
			<td>item id</td>
			<td>item name</td>
			<td>Status</td>
			<td>Date</td> 
			
		</tr>
		<c:forEach var="item" items="${todolist}">


			<tr>
				<td><c:out value="${item.listid}"></c:out></td>
				<td><c:out value="${item.item}"></c:out></td>
				<td><c:out value="${item.todoStatus.statusid}"></c:out></td>
				<td><c:out value="${item.tododate}"></c:out></td>




			</tr>

		</c:forEach>




	</table>


</body>
</html>