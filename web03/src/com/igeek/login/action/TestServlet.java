package com.igeek.login.action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	private ServletConfig config;
	
	public TestServlet(){
		System.out.println("构造器被执行了");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("初始化方法，第一次请求访问的时候会调用该方法");
	}
	
	public void destory(){
		System.out.println("销毁方法.当服务器停止的时候会调用destroy方法。");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletName = config.getInitParameter("name");
		String servletAge = config.getInitParameter("age");
		//获取当前Servlet自己的初始化参数
		System.out.println(servletName + servletAge);
		
		//ServletContext Servlet上下文对象   
		ServletContext servletContext = request.getServletContext();
		String initParameter = servletContext.getInitParameter("adminUser");
		String initParameter2 = servletContext.getInitParameter("adminPassword");
		//获取全局（上下文）的servlet初始参数
		System.out.println(initParameter + initParameter2);
	}
		
}
