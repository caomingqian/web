package com.igeek.lesson3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest
 */
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		response.setContentType("text/html;charset=utf-8");
		//ȡ��ͬԴ���Ե����Ʒ��� �������ǵĽӿ� ���Ա�������ʵ� ��
		response.setHeader("Access-Control-Allow-Origin", "*");
		if(username.equals("tom")) {
			response.getWriter().write("ע��ʧ��!!!");
		}else {
			//���������������Ӧ�����ݡ�
			response.getWriter().write("ע��ɹ�!!!");
			//response.getWriter().write("{\"msg\":\"ע��ɹ�!\"}");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
