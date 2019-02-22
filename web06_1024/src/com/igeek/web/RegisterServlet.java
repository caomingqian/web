package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.domain.Product;
import com.igeek.domain.User;
import com.igeek.service.LoginService;
import com.igeek.service.RegisterService;
import com.igeek.utils.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@SuppressWarnings("all")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterService registerService = new RegisterService();
    private LoginService longinService = new LoginService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//取数据  获得前台输入的数据
		String  username = request.getParameter("username");
		String  password = request.getParameter("password");
		String  phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		//System.out.println(username+password+phone);
		//插入之前  需要先判断当前用户名，在数据库中是否存在?如果存在返回到注册页面，给你提示消息，该用户已经存在。否则注册成功，成功的跳转到。登陆页面。
		User dbUser = registerService.checkUser(username);
		if(dbUser!=null){//数据库中有
			request.setAttribute("msg", "用户已存在!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else{
			//正常的插入到数据库
			User user = new User(StringUtils.getUUID(),username,password,Integer.parseInt(phone));
			registerService.inserUser(user);
			//跳转成功页面?
			//这个user要跟成功页中"user"一致
			session.setAttribute("user", user);
			//再放置商品
			List<Product> productList = longinService.getProductList(0);
			//name String"" value Object
			session.setAttribute("productList", productList);
			request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
