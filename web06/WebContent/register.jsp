<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script>
	function check(val){
		var url = "http://localhost:8080/web06/CheckAjaxUser?username="+val;
		//alert(url);
		var request;
		if(window.XMLHttpRequest){
			request = new XMLHttpRequest();
		}else{
			request=new ActiveXObject("Microsoft.XMLHTTP")
		}
		//如何接收服务器响应的数据。onreadystatechange当前请求状态发生改变时会触发当前方法
		request.onreadystatechange=function(){
			//readyState=4表示服务接受请求，并且处理完成发送响应给浏览器
			//status=200表示请求ok被处理没有任何问题。
			if(request.readySate==4&&request.status==200){
				//request.responseText表示拿到服务器给你的响应数据
				var data = request.responseText;
				//alert(sata);
				var span=document.getElementById("s1");
				span.innerHTML=data;
			}
		}
		request.open("GET",url,true);
		request.send(); //注意  如果是get请求  send()方法中无法传递数据的
	}
</script>
</head>
<body>
	<form action="/web06/RegisterServlet" method="post">
		用  户  名:<input type="text" name = "username" onblur="check(this.value)"/><span id="s1" style = "color:red">${msg==null?"":msg}</span>
		密        码:<input type="password" name = "password"/>
		电	  话:<input type="text" name = "phone"/>
		<input type = "submit" value = "注册"/>
		<input type="reset" value="重置"/>
	</form>

</body>
</html>