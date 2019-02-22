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
	test...
	<!--  演示效1:
		1.如果先访问 test.jsp页面，此时test.jsp去跳转到login的话是不会触发过滤器的
			直接访问  前面有过滤器
			通过转发  之前已经过滤了
		2.可以在filter mapping中配置dispatcher
			<dispatcher>FORWARD</dispatcher>
			设置在第二个过滤器上的时候第二个过滤器只对转发工作
			再次访问login.jsp则只有过滤器1工作，过滤器2不再工作
		3.可以让过滤器2对请求也工作
			继续加入即可
			<dispatcher>REQUEST</dispatcher>
		
		演示效果2（使用较少）
			1.在当前页面中加入jsp:include page="/lesson1/login.jsp"标签。注释到跳转
			2.<dispatcher>INCLUDE</dispatcher>加入到过滤器2中
			访问test.jsp发现过滤器2同样可以被执行
			
		演示效果3
			（第一部分）
			指定错误页面的方式。（注释掉include）
			1.<@page errorPage="/leeeon1/login.jsp">
			2.加入 int i = 100/0;
			3.当访问test.jsp的时候会报错500其实响应给客户的是login.jsp
			4.由于错误页面是由服务器转发过去的所以会执行过滤器2.
			（第二部分）
			1.注释第一部分的内容
			2.web。xml中加入如下配置
				<error-page>
				<exception-type>java.lang.ArithmetciException</excepyion-type>
				<location>/test.jsp</location>
				</error-page>
			3.在filter2的filter mapping中加入
				<dispatcher>ERROR</dispatcher>
			4.访问test.jsp发现过滤器同样被执行
	 -->
	 <%-- <jsp:forward page="/lesson1/login.jsp"></jsp:forword> --%>
	 <%-- <jsp:include page="/lesson1/login.jsp"></jsp:include> --%>
	 <!-- 页面错误的第一种配置方式。在当前页面的page标签中  加入属性errorPage="指定的错误页面。"//ArithmenticException数学运算异常 0 -->
	 <%int i = 100/0;%>
</body>
</html>