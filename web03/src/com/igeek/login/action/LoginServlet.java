package com.igeek.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoginServlet(){
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet执行了");
		//request 请求  请求对象中  就封装了  关于浏览器传递过来的所有数据
		response.setHeader("content-Type", "text/html;charset=UTF-8");//处理响应乱码  指定返回的内容  为文本/html  字符集为utf-8
		//request  对象中就封装了  浏览器所有信息
		String header = request.getHeader("Accept-Language");
		String connection = request.getHeader("connection");
		System.out.println(connection);
		System.out.println(header);
		//获得请求中所有的信息
		
		//如果处理get请求乱码  tomcat 8以上  默认编码格式utf-8  。。。tomcat8以下的编码是8859-1...
		//获取传递过来的参数
		//1.在tomcat配置文件中  修改端口号  加入以下代码  URIEncoding = "UTF-8"
		//URI  统一资源描述符  URL统一资源定位符
		//（推荐处理get乱码的方式） 2 .get,post  终极转码
		//3.处理get乱码  用到net包下的两个类  URLEncoder  编码  需要指定要转码的字符串的原始编码  URLDecoder  需要指定将某个字符串节码成生么类型（UTF-8）
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		System.out.println(loginName + "" + password);
		/*String newLoginName = new String(loginName.getBytes("iso-8859-1"),"utf-8");
		String newPassword = new String(password.getBytes("iso-8859-1"),"utf-8");
		System.out.println(newLoginName + "" + newPassword);*/
		//指的是对数据进行编码，ios-8859-1
		String encode = URLEncoder.encode(loginName,"iso-8859-1");
		String decode = URLDecoder.decode(encode,"UTF-8");
		System.out.println(decode);
		
		//PrintWriter
		
		PrintWriter out = response.getWriter();
		out.write("我收到了你输入的账号密码" + decode);
	}
	
	//不论是get请求  还是post请求  都会访问doGet方法

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,request);
		//处理post请求的乱码  方法1： 使用终极转码  String 转完码之后的字符串=new String(需要转码的字符串。getBytes("ios-8859-1"),"utf-8");
		//（推荐的处理post乱码的方式）处理post请求乱码的方式二，在获取参数之前  最好写道第一行的位置。给当前请求设置一个编码
		//request.setCharacterEncoding("utf-8");一般放在接收数据之前
		request.setCharacterEncoding("UTF-8");
		String header = request.getHeader("Accept-Language");
		String connection = request.getHeader("Connection");
		System.out.println(connection);
		System.out.println(header);
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		System.out.println(loginName+" " + password);
		//String newLoginName = new String(loginName.getBytes("iso-8859-1"),"utf-8");
		//String newPassword = new String(password.getBytes("iso-8859-1"),"utf-8");
		//System.out.println(newLoginName+" "+newPassword);
		
	}	
}

























