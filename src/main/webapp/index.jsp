<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		if ("-1".equals(param)) {
			out.print("登录失败");
		}
	%>
	<form action="manager/user/login" method="post">
		username:<input type="text" name="userName"><br /> password:<input
			type="password" name="password"> <br /> <input type="submit"
			value="login">
	</form>
</body>
</html>