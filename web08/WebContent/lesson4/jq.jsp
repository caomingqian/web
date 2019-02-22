<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jq/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			//发送一个ajax请求 。  
			//http://localhost:8989/web08/lesson4/jq.jsp
			$.ajax({
				type : "POST",
				url : "http://localhost:8989/web08/AjaxTest",
				data : "username=tom&location=Boston&age=20",
				//成功之后回调函数 。 request.readyState==4&&request.status==200
				// 
				success : function(msg) {
					//msg就表示服务器给你响应的内容。
					//alert("Data Saved: " + msg);
					$("#span1").append(msg);
				}
			});
		})
	});
</script>
</head>
<body>
	<button>点我</button>
	<span id="span1"> </span>
</body>
</html>