package com.igeek.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		
		request.setCharacterEncoding("utf-8");
		//������Ӧͷ�������Ӧ��������
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		String userName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		ServletContext servletContext = request.getServletContext();
		String name = servletContext.getInitParameter("username");
		String pwd = servletContext.getInitParameter("password");
		PrintWriter out = response.getWriter();//JSP
		//equals����
		if(userName.equals(name)&&password.equals(pwd)){
			out.write("��½�ɹ�:" + userName);
		}else{
			//����������Ӧ��ʱ����Ҫһ��һ�е���out  �����ȥ  
			//JSP java server page������
		/*	out.write("<html>");
			out.write("<head>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1 style='color:red'>��½ʧ��  ����������");
			out.write("</body>");
			out.write("</html>");*/
			
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
