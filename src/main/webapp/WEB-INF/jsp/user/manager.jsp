<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台首页</title>
</head>
<body>
	<fieldset style="width: 200px">
		<legend>用户操作</legend>
		<a href="<%=basePath%>manager/user/list">用户列表</a> <a
			href="<%=basePath%>manager/user/toAdd">添加用户</a>
	</fieldset>


	<fieldset style="width: 200px">
		<legend>段子操作</legend>
		<a href="<%=basePath%>manager/funny/toAdd">添加段子</a>
	</fieldset>
</body>
</html>