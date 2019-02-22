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
		//��֤�û��������ݿ����Ƿ����
		String username = request.getParameter("username");
		User checkUser=registerService.checkUser(username);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(checkUser!=null){
			//������  ������������Ӧ
			out.write("�û����Ѿ������ˣ������뻻һ����������");
		}else{
			out.write("��ϲ�㣡���˺ſ���ʹ�ã�");
		}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
