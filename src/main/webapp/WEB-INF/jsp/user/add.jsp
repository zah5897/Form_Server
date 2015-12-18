<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
</head>
<body>
	<c:if test="${user!=null}">
		<c:out value="添加成功"></c:out>
	</c:if>
	<form action="add" method="post">
		userName: <input type="text" name="name"><br /> nickName:<input
			type="text" name="nickName"><br /> <input type="submit"
			value="保存">
	</form>
</body>
</html>