package com.igeek.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.domain.User;
import com.igeek.service.RegisterService;

public class CheckAjaxUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterService registerService=new RegisterService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证用户名在数据库中是否存在
		String username = request.getParameter("username");
		User checkUser=registerService.checkUser(username);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(checkUser!=null){
			//有数据  服务器给你响应
			out.write("用户名已经存在了！！！请换一个。。。。");
		}else{
			out.write("恭喜你！此账号可以使用！");
		}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
