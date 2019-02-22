<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import=" web07.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		List list=new ArrayList();
		list.add("白米饭");
		list.add("周黑鸭");
		list.add("牛肉汤");
		pageContext.setAttribute("tom",list);
		
		Map map = new HashMap();
		map.put("sj1","诺基亚");
		map.put("sj2","诺基亚");
		map.put("sj3","诺基亚");
		map.put("sj4","诺基亚");
		map.put("aa.bb.cc","波导手机中的战斗机");//推荐key值中不要加入.点
		pageContext.setAttribute("map",map);
		int [] arrays={12,34,43,743,23,213};
		pageContext.setAttribute("arr",arrays,2);
		
		Person p = new Person("tom",12);
		pageContext.setAttribute("person",p,2);
		
		pageContext.setAttribute("x","123abc");
	%>
	${arr[0]}
	<br>
	${tom[2]}
	<br>
	${map.sj4}<!-- 推荐写法。 -->
	${mae["sj4"]}<!-- 两种写法都行   第二种写法  可以在key值中包含很多.的场景 -->
	${map["aa.bb.cc"]}
	<br>
	${person.name}
	
	${person.age}
	<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
	${empty person}
	${10+20}
	${person!=null?person.name:""}
	
	<%-- ${x+123}--%><!-- 产生  数字格式异常  x=123abc  不能转化成基本数据类型-->
</body>
</html>