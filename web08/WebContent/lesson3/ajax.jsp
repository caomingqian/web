<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<script>
	function on(){
			var request;
			if(window.XMLHttpRequest){
				request = new XMLHttpRequest();
			}else{
				request = new ActiveXObject("Microsoft.XMLHTTP")
			}
			//callback 回调     回调函数  。    1.你定义的   2.你没有调用   3.它执行了。
			//如何接收服务器响应的数据 。onreadystatechange 当请求状态发生改变时会触发当前方法。
			request.onreadystatechange=function(){
				//readyState=4 表示服务接收到请求，并且处理完成发送响应给浏览器。
				//status=200表示请求ok 被处理 没有任何问题。
				//request.readyState==4&&request.status==200 请求发送成功并且收到了服务器的响应 。
				if(request.readyState==4&&request.status==200){
					//request.responseText 表示拿到服务器给你的响应数据 。responseText表示服务器给你响应的内容。
					var data = request.responseText;
					alert(data);//  注册成功!!!
				}
			}
			request.open("POST","http://localhost:8989/web08/AjaxTest?username=tom123",true);
			//模拟form表单提交 。只有form 才能发送post请求 。
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//使用ajax发送 post请求 。application/x-www-form-urlencoded 模拟表单提交 。
			request.send("name=toms&age=12");//注意 如果是get请求 。send()方法中无法传递数据的。
			//区别  post请求的提交方式   send(可以传递参数 )  get方式  send() 不能传递参数 。。。
	}
</script>
<body>
	<form action="${pageContext.request.contextPath}/AjaxTest" method="post">
		<input type="text" name="username" onblur="on()" ><span id="s1"></span>
		<input type="submit" value="注册"/> 
	</form>

</body>
</html>