<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 用来定义方法  全局变量 -->
	<%!
		String haha = "哈哈";
	
		public String getStr(){
			return haha;
		}
	%>
	
	<%
	//正常书写java代码
		String name = "helloJSP";
		Date date = new Date();
		String date1 = date.toString();
		
		String str = getStr();
	%>
	
	<%=str %>
	<%=date1 %>
	
	<!-- 可以书写java代码 
		< %	书写java代码 % >
		< % =变量名称 % > 用来输出变量的
		< %！ % >用来定义方法  或者全局变量
	-->
	<%
		for(int i = 0;i<10;i++){
		%>
		<h1 style = 'color:red'>登陆失败！！！</h1>
		<%
		}
	%>
	<input type="text" value="<%=name%>">
</body>
</html>