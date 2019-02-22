package com.igeek.lesson1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String hiddenToken = request.getParameter("token");//123456789   123456789
		String sessionToken = (String) session.getAttribute("token");//123456789   null
		String username = request.getParameter("username"); //abc
		System.out.println(username);
		System.out.println(sessionToken+"session中的");
		System.out.println(hiddenToken+"隐藏域中的");
		//true&&true   true
		if(sessionToken!=null&&sessionToken.equals(hiddenToken)) {
			session.removeAttribute("token");
			request.getRequestDispatcher("/lesson1/success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/lesson1/token.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("/lesson1/success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
