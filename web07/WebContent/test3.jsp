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
	String path = request.getContextPath();
%>
<%=path%>
<!-- 两种获取项目路径的方式。在实际开发中  我们的请求路径  都要求写成绝对路径。-->
${pageContext.request.contextPath}
<!-- 
	test3.jsp 访问test2.jsp
	关于相对路径
		1.要访问的资源跟当前所编辑的页面在同一级目录下  直接输入名称即可访问
		2.当你要访问的资源，在一个内层的文件夹中
			href="a/b/test4.jsp"
		3.当你要访问的资源，在你当前所编辑的文件夹外部
		.../跳出文件  ../../../
		写绝对路径
 -->
 <a href="a/b/test4.jsp">点我</a>

</body>
</html>