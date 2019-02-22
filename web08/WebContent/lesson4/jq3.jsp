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
	$(function(){
		//点击button 提交给后台，所有选中的复选框的value的属性值
		$("button").click(function(){
			var checks=$("input:checked");//通过jquery选择器  拿到的一定是jQuery对象。只有jquery对象才能调用jquery方法。
			//把数据封装到数组中，然后把这个数组中的数据传输给后台
			var arrays=new Array();
			checks.each(function(i,n){
				//把需要的数值放入到数组中
				arrays.push(n.value);
			});
			//alert(arrays);回调函数中 m 代表了后台给你响应的数据。 out.write("...内容")
			var url = "http://localhost:8080/web08/Ajax?state=ajax2";
			var data={
					name:"汤姆",
					"array[]":arrays
			};//通过$.get()去发送ajax请求。data数据中  想要发送数组。 数组名称  必须用''""包裹起来  然后在名字后面加上一个[]
			$.get(url,data,function(m){
				$("#s1").append("<font color='red'>+m.msg+"</font>);
			},"json");
		});
	});
</script>
</head>
<body>
	<input type="checkbox" name="goods" value="p001"/>华为<br/>
	<input type="checkbox" name="goods" value="p002"/>小米<br/>
	<input type="checkbox" name="goods" value="p003"/>锤子<br/>
	<input type="checkbox" name="goods" value="p004"/>苹果<br/>
	<button>点我</button>
	<span id="s1"></span>
</body>
</html>