package com.igeek.login.action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	/**
	 * Servlet 生命周期的五个阶段
	 * 			加载
	 * 初始化: init()  该方法会在Servlet被加载并实例化的以后  执行  只会执行一次
	 * 
	 * 	服务: service()-> doGet() doPost
	 * 
	 * 销毁 :destroy(),Servlet被系统回收时执行  只会执行一次
	 * 		卸载
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("初始化方法");
		
		String userName = config.getInitParameter("username");
		String age = config.getInitParameter("age");
		ServletContext servletContext = config.getServletContext();
		String name = servletContext.getInitParameter("name");
		System.out.println(name + age + "我是TestServlet我也可以访问全局数据");
	}
	public void destory(){
		System.out.println("销毁方法");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("服务。。。方法");
	}
		
}
