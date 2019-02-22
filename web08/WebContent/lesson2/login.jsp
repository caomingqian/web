<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<!-- 增加验证码防止恶意的表单提交。 -->
	<font color="red">
		${message==null?"":message}
	</font>
	<form action="<%= request.getContextPath() %>/CheckCodeServlet" method="post">
		name: <input type="text" name="name"/>
		checkCode: <input type="text" name="checkCode"/><!-- 手动输入验证码。 -->
		<img alt="" src="<%= request.getContextPath() %>/ValidateColorServlet"> 
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>