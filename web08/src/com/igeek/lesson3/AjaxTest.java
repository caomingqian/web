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
		//取消同源策略的限制访问 。让我们的接口 可以被跨域访问到 。
		response.setHeader("Access-Control-Allow-Origin", "*");
		if(username.equals("tom")) {
			response.getWriter().write("注册失败!!!");
		}else {
			//服务器给浏览器响应的数据。
			response.getWriter().write("注册成功!!!");
			//response.getWriter().write("{\"msg\":\"注册成功!\"}");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
