<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>省市页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jq/jquery-1.8.3.js"></script>
<script type="text/javascript">
	//init方法。查询所有的省以及直辖市。然后将查询到的结果 放到第一个下拉框中。province...省
	$(function(){
		var url="http://localhost:8080/web06_1024/LinkageServlet?state=init";
		$.post(url,function(data){
			$.each(data,function(){
				$("#province").append("<option value='"+this.id+"'>" + this.area_name + "</option>");
			})
		},"json");
	});
	$(function(){
		$("#province").change(function(){
			//alert(this.value);
			var url2="http://localhost:8080/web06_1024/LinkageServlet?state=city&pid="+this.value;
			$.post(url2,function(data){
				$("#city").empty();
				$.each(data,function(){
					$("#city").append("<option value='"+this.id+"'>"+this.area_name+"</option>");
				});
			},"json");
		});
	});
	$(function(){
		$("$city").change(function(){
			//alert(this.value);
			var url3="http://localhost:8080/web06_1024/LinkageServlet?state=area&cid="+this.value;
			$.post(url3,function(data){
				$("#area").empty();//变空之后  会产生一个小bug当查询直辖市的时候，由于清空之后只添加了一个option所有值改变不了
				$.each(data,function(){
					$("#area").append("<option value='"+this.id+"'>"+this.area_name+"</option>");
				});
			},"json");
		});
	});
</script>
</head>
<body>
	<center>
		<select id="province" name="province">
			<option value="none">--请选择省--</option>
		</select>
		<select id="province" name="province">
			<option value="none">--请选择市--</option>
		</select>
		<select id="province" name="province">
			<option value="none">--请选择县或者区--</option>
		</select>
	</center>

</body>
</html>