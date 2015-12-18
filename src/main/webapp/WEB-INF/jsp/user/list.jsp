<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<fieldset style="width: 300px">
		<legend>管理员列表</legend>
		<table border="1">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>operate</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.nickName}</td>
					<td><a href="del?id=${user.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>