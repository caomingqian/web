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
		//pageContext,application用的都比较少
		//request,session...
		pageContext.setAttribute("name","tom123");
		pageContext.getServletConfig();//获得config对象
		pageContext.getServletContext();//获得application对象
		pageContext.getPage();//page对象
		pageContext.getException();//获得异常对象。isErrorPage="true"
		pageContext.getSession();//拿到session对象
		pageContext.getRequest();//获得请求对象。
		pageContext.getResponse();//获得响应对象
		pageContext.getOut();//或者out对象
		
		//常量
		pageContext.setAttribute("name","jacklove",pageContext.SESSION_SCOPE);
	%>
	<!-- 1 2 3 4 -->
	<%=pageContext.PAGE_SCOPE%>
	<jsp:include page="header.jsp"/></br>
	我是主题内容。<%=pageContext.getAttribute("name")%>
	<%@include file="footer.jsp"%>
	<jsp:include page = "footer.jsp"/><br />
	<!-- 
		out.wrihte("<html>");
	 -->
	 <%
	 	request.getRequestDispatcher("index.jsp").forward(request, response);
	 %>
	 <jsp:forward page="index.jsp" /></jsp:forward>

</body>
</html>