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
	 * Servlet �������ڵ�����׶�
	 * 			����
	 * ��ʼ��: init()  �÷�������Servlet�����ز�ʵ�������Ժ�  ִ��  ֻ��ִ��һ��
	 * 
	 * 	����: service()-> doGet() doPost
	 * 
	 * ���� :destroy(),Servlet��ϵͳ����ʱִ��  ֻ��ִ��һ��
	 * 		ж��
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("��ʼ������");
		
		String userName = config.getInitParameter("username");
		String age = config.getInitParameter("age");
		ServletContext servletContext = config.getServletContext();
		String name = servletContext.getInitParameter("name");
		System.out.println(name + age + "����TestServlet��Ҳ���Է���ȫ������");
	}
	public void destory(){
		System.out.println("���ٷ���");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("���񡣡�������");
	}
		
}
