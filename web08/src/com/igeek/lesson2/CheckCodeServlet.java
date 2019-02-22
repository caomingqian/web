package com.igeek.lesson2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String checkCode = request.getParameter("checkCode");
		String sessionCode = (String) request.getSession().getAttribute("CHECK_CODE_KEY");//拿到session中存储的验证码。
		System.out.println(name);
		System.out.println(checkCode);
		System.out.println(sessionCode);
		if(sessionCode!=null&&checkCode.equalsIgnoreCase(sessionCode)) {
			//从session把你的验证码  移除掉 。
			request.getSession().removeAttribute("CHECK_CODE_KEY");
			request.getRequestDispatcher("/lesson2/success.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "验证码输入错误!");
			request.getRequestDispatcher("/lesson2/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
