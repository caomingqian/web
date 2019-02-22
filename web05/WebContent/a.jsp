<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<!-- 
		JSP九大内置对象  也是域对象  JSP的四大作用域
			pageContext
			request
			session
			application
		page
		out
		response
		config
		exception
		
		request.getRequestDispatcher("/b.jsp").forward(request,response);
		地址栏不会发生变化
	 -->
	 <%
	 	pageContext.setAttribute("pageContextKey","pageContext");
	 	request.setAttribute("requestKey","request");
	 	session.setAttribute("sessionKey", "session");
	 	application.setAttribute("applicationKey", "application");
	 %>
	 <%
	 	//重定向。  response.sendRedirect("");  后面的就是你要转发的路径或者请求的地址
	 	//response.sendRedirect("http://www.baidu.com?name=tom&password=123");
	 	request.getRequestDispatcher("b.jsp?name=tom&password=123").forward(request,response);
	 	
	 	//请求 JSP  9  4大作用域  请求转发  重定向的区别
	 	//1.请求转发的时候，地址栏不会发生改变，重定向的地址栏会发生改变
	 	//2.请求转发是服务器行为。重定向是浏览器（客户端）行为
	 	//3.请求转发只发送一次请求，使用的是一个request对象。重定向发送两次请求，使用的不是同一个request对象
	 	//4.使用请求转发，可以访问到请求域中的数据，使用重定向是无法访问到请求域中的数据的
	 	//5.其实后面都可以跟？传递参数。后面就可以用request.getParameter去接受
	 	//6.请求转发的效率要高一些，重定向的效率稍低
	 	//7.请求转发只能（当前服务器下） 重定向可以定位到任意项目（包括跳转一些网页）
	 	
	 	/**
	 	Forward是在服务器端的跳转，就是客户端一个请求发给服务器，服务器直接将请求相关的参数的信息原封不动的
	 	传递到该服务器的其它jsp或servlet去处理  而sendredirect是在客户端的跳转，服务器会返回给客户端一个
	 	响应报头和新的URL地址，原来的参数什么的信息如果服务器端没有特别处理就不存在了，浏览器会访问新的URL所指向
	 	的servlet活或JSP
	 	*/	 	
	 %>

</body>
</html>