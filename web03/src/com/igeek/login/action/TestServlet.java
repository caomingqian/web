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
		System.out.println("��������ִ����");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("��ʼ����������һ��������ʵ�ʱ�����ø÷���");
	}
	
	public void destory(){
		System.out.println("���ٷ���.��������ֹͣ��ʱ������destroy������");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletName = config.getInitParameter("name");
		String servletAge = config.getInitParameter("age");
		//��ȡ��ǰServlet�Լ��ĳ�ʼ������
		System.out.println(servletName + servletAge);
		
		//ServletContext Servlet�����Ķ���   
		ServletContext servletContext = request.getServletContext();
		String initParameter = servletContext.getInitParameter("adminUser");
		String initParameter2 = servletContext.getInitParameter("adminPassword");
		//��ȡȫ�֣������ģ���servlet��ʼ����
		System.out.println(initParameter + initParameter2);
	}
		
}
