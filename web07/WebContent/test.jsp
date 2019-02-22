<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.apache.jasper.runtime.PageContextImpl"%>
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
	pageContext.setAttribute("name", "丽丽",2);
	pageContext.setAttribute("name", "西西",1);
	pageContext.setAttribute("name", "蓝蓝",3);
	pageContext.setAttribute("name", "肥肥",4);
	session.setAttribute("key1","哈哈我是session中的key1的value值");
%>
<%=pageContext.APPLICATION_SCOPE%>
<%=pageContext.SESSION_SCOPE%>
<%=pageContext.REQUEST_SCOPE%>
<%=PageContext.PAGE_SCOPE%>

	<%=pageContext.getSession().getAttribute("name")%>
	<%=session.getAttribute("name")%>
	<!-- el的内置对象。不用你去创建  直接拿来用。 -->
	<!-- 使用el表达式  可以很方便的去拿你想要的数据。 -->
	<br>
	${pageScope.name}
	${sessionScope.name}
	${requestScope.name}
	${applicationScope.name}
	<!-- 如果不指定区域的话  那么默认会从四个域中查找 查找到的话就会返回value，拿不到不会显示任何内容"" -->
	${key2}
	<hr>
	<!-- 查找顺序 1，2，3，4当四个域中都有name属性的之后，只会找到第一个。 -->
	${name}
</body>
</html>