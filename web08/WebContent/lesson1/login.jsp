<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		//token   令牌  标记 。21321654654
		String token = new Date().getTime()+"";
		session.setAttribute("token",token);//21321654654
		// 解决
	%>
	<form action="${pageContext.request.contextPath}/TokenServlet" method="post">
		<input type="hidden" name="token" value="<%=token%>"/>
		<input type="text" name="username"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>