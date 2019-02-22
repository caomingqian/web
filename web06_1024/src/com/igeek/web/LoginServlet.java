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
	//servlet负责接受（从前页面接受）传递（把数据传递给前台  其实是放入到4个域对象中）数据
	//pageContext,request,session,application
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		//接收账号密码
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		//??? ???账号密码有了；判断的方法也有了？
		User user = longinService.checkLogin(loginName,password);
		//servlet中如何获取session对象
		//jsp中 的session对象  就是servlet中的HttpSession类的对象
		HttpSession session = request.getSession();//这个最好不要重写init  一旦重写了  就可能出现nullpointexception（空指针异常）
		//jsp中的application对象  其实就是ServletContext类的对象
		ServletContext application = this.getServletContext();//相当于jsp中的config对象
		//request session application 三个常用的域对象的获得方式（Servlet中的获取方式）
		if(user!=null){
			//在登陆成功之前  需要先将显示的数据，放入到某一个域中（pageContext,request,session,application）
			
			//List<Product> list;  把当前的list放入到请求域。？？？
			List<Product> productList = longinService.getProductList(0);
			
			//session
			//application.setAttribute(name,object);
			session.setAttribute("productList", productList);
			//登陆成功
			request.setAttribute("user", user);
			//只能请求转发可以到web-inf下  web-inf下的东西不能被浏览器直接访问
			request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
		}else{
			//向请求域中发送错误信息
			request.setAttribute("message", "账号密码有误!");
			//跳转到登陆页面。（请求转发  重定向）
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//...
		doGet(request, response);
	}

}
