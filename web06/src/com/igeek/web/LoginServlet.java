package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.domain.Product;
import com.igeek.domain.User;
import com.igeek.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService longinService = new LoginService();
	//servlet������ܣ���ǰҳ����ܣ����ݣ������ݴ��ݸ�ǰ̨  ��ʵ�Ƿ��뵽4��������У�����
	//pageContext,request,session,application
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("utf-8");
		//�����˺�����
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		//??? ???�˺��������ˣ��жϵķ���Ҳ���ˣ�
		User user = longinService.checkLogin(loginName,password);
		//servlet����λ�ȡsession����
		//jsp�� ��session����  ����servlet�е�HttpSession��Ķ���
		HttpSession session = request.getSession();//�����ò�Ҫ��дinit  һ����д��  �Ϳ��ܳ���nullpointexception����ָ���쳣��
		//jsp�е�application����  ��ʵ����ServletContext��Ķ���
		ServletContext application = this.getServletContext();//�൱��jsp�е�config����
		//request session application �������õ������Ļ�÷�ʽ��Servlet�еĻ�ȡ��ʽ��
		if(user!=null){
			//�ڵ�½�ɹ�֮ǰ  ��Ҫ�Ƚ���ʾ�����ݣ����뵽ĳһ�����У�pageContext,request,session,application��
			
			//List<Product> list;  �ѵ�ǰ��list���뵽�����򡣣�����
			List<Product> productList = longinService.getProductList(0);
			
			//session
			//application.setAttribute(name,object);
			session.setAttribute("productList", productList);
			//��½�ɹ�
			request.setAttribute("user", user);
			//ֻ������ת�����Ե�web-inf��  web-inf�µĶ������ܱ������ֱ�ӷ���
			request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
		}else{
			//���������з��ʹ�����Ϣ
			request.setAttribute("message", "�˺���������!");
			//��ת����½ҳ�档������ת��  �ض���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//...
		doGet(request, response);
	}

}
