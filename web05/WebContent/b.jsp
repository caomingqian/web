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
	<%
		String pageContextKey = (String)pageContext.getAttribute("pageContextKey");
		String requestKey = (String)request.getAttribute("requestKey");
		String sessionKey = (String)session.getAttribute("sessionKey");
		String applicationKey = (String)application.getAttribute("applicationKey");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
	%>
	<%=name%>
	<%=password%>
	</br>
	<%=pageContextKey + "我是pageContextKey域中的数据" %>
	<%=requestKey + "我是request域中的数据" %>
	<%=sessionKey  + "我是session域中的数据"%>
	<%=applicationKey + "我是application域中的数据" %>
</body>
</html>