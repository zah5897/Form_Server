<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>段子添加</title>
</head>
<body>

     <form action="<%=basePath %>manager/funny/add" method="post">
     
        标题：<input type="text" name="title"><br/> 
        内容：<input type="text" name="content"><br/> 
     <input type="submit" value="添加">
     </form>


</body>
</html>