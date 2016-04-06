<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<p>.............Pending items............................</p>
		<tr>
			
			<td>item id</td>
			<td>item name</td>
			<td>Status</td>
			
		</tr>
		<c:forEach var="item" items="${todolistpending}">


			<tr>
				<td><c:out value="${item.listid}"></c:out></td>
				<td><c:out value="${item.item}"></c:out></td>
				<td><c:out value="${item.todoStatus.statusid}"></c:out></td>




			</tr>

		</c:forEach>




	</table>
	<br>
	<p>.............Completed items............................</p>
	<table border=1>
		<tr>
			
			<td>item id</td>
			<td>item name</td>
			<td>Status</td>
			
		</tr>
		<c:forEach var="item1" items="${todolistdone}">


			<tr>
				<td><c:out value="${item1.listid}"></c:out></td>
				<td><c:out value="${item1.item}"></c:out></td>
				<td><c:out value="${item1.todoStatus.statusid}"></c:out></td>




			</tr>

		</c:forEach>




	</table>

</body>
</html>