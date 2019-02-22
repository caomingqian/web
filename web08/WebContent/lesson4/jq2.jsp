<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jq/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			//发送给一个ajax请求
			//http://localhost:8080/web08/lesson4/jq.jsp
			var arrs = [10,20,430,354,54,23];
			var names = ["wow","lol","cs","wzry"];
			$.ajax({
				//类型。get post
				type:"POST",
				url:"http://localhost:8080/web08/Ajax?state=ajax1",
				traditional:true,//防止深度序列化。如果说不加这句话，后台无法接收数据
				//要给后台传递数据
				data:{
					"arrays":arrs,
					"game":names,
					"haha":"我是发送的字符串"
					//name值  带不带双引号都可以
				},
			//成功之后回调函数，request.readyState==4&&request.ststys==200
			//text表示
			dataType:"json",
			success:function(data) {
				//msg就表示服务器给你响应的内容
				//alert("Data Saved:" + msg);
				//$("#span1".append(msg));
				alert(data.msg);
				alert(data.age);
				}
			});
		})
	});
	</script>
</head>
<body>
	<button>点我</button>
	<span id="span1"></span>
</body>
</html>