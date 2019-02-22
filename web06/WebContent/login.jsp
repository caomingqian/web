<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script>
	function register(){
		//window.location.href可以跳转页面    get请求
		window.location.href="register.jsp";
	}
</script>
</head>
<body>
		<%
		String message = (String)request.getAttribute("message");
		%>
		<form action="/web06/LoginServlet" method = "post">
		<!-- 三目运算符   -->
		用户名:<input type="text" name="loginName" maxlength="15" placeholder="请输入用户名..." /><span style="color:red"><%=(message==null?"":message)%></span>
		</br>
		密	码:<input type="password" name="password"/>
		<!-- 浏览器的同源策略，一般这些带src的都可以跨越。跨项目，跨区域去访问数据 -->
		<img src="" alt="突变挂了，会显示alt属性中的文字。" title="这个验证码。" />
		<input type="submit" value="登陆"></input>
		<input type="button" onclick="register()" value="注册"/>
		</form>
</body>
</html>