<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.igeek.domain.*"%>
    <%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%-- <%
	User user = (User)session.getAttribute("user");
	String name = user.getUsername();
	//从请求域中拿到productList
	//EL （expression） JSTL...
	List<Product> productList = (List<Product>)session.getAttribute("productList");
%> --%>
登陆成功  欢迎:<br><h1 style="color:red">${user==null?"":user.username}</h1><br>
<%-- <%
	for(Product p:productList){
		String category = p.getCategory_id();
		int id = p.getPid();
		String pname = p.getPname();
		double price = p.getPrice();
		//把html代码写到循环内部
		%>
		<!-- categoryid  是我们自定义的数据 -->
		<a href = "#" title="<%=pname%>的价格:<%=price %>" categoryid="<%=id%>"><%=pname%></a>
		<a href = '#' title='${p.pname}价格是:${p.price}'categroy='${p.pid}'>${p.name}</a>
		<%
	}
%> --%>
<c:forEach items="${productList}" var="p">
	<c:if test="${p.price>3000}">
		<c:out value="<a href = '#' title='${p.pname}价格是:${p.price}'categroy='${p.pid}'>${p.name}</a>" escapeXml="false"></c:out>
	</c:if>
</c:forEach>

</body>
</html>