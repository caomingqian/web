package com.igeek.lesson4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//url
	//localhost:8080/web08/Ajax?state=ajax1
	//localhost:8080/web08/Ajax?state=ajax2
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//状态分发
		String state=request.getParameter("state");
		if(state.equals("ajax1")){
			//根据状态不同调用不同的方法（好处，不用每次增加一个新的请求去写servlet）
			ajax1(request,response);
		}else if(state.equals("ajax2")){
			ajax2(request,response);
		}
	}


	protected void ajax1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//game
		String[] arrays = request.getParameterValues("arrays");
		String[] game = request.getParameterValues("game");
		String haha = request.getParameter("haha");
		System.out.println(haha);
		for(String string:game){
			System.out.println(string);
		}
		for(String string:arrays){
			System.out.println(string);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//{"msg":"你成功了!","age":"20"}
		out.write("{\"msg\":\"你成功了!\",\"age\":\"20\"}");//ajax用来异步的获取数据
		//只要是ajax的请求  记住都是通过out对象返回json数据
	}
	
	protected void ajax2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

}
