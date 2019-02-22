package com.igeek.login.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		public RegisterServlet(){
			
		}
		/**
		 * 不管get请求  还是post请求  都会调用service方法
		 */
		protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			request.setCharacterEncoding("utf-8");
			System.out.println("nmsl");
			//根据表单的name属性值  来获得value值  getParameter（String name）
			String loginName = request.getParameter("loginName");
			//getParamenteValues(String name) 当你要获得元素  有很多的时候  字符串数组
			String[] fruit = request.getParameterValues("fruit");
			String password = request.getParameter("password");
			
			String sex = request.getParameter("sex");
			
			String [] sel = request.getParameterValues("sel");
			
			String textArea = request.getParameter("textarea");
			
			//getParameter
			
			System.out.println(sex);
			
			System.out.println(loginName);
			//注意数组:数组不能直接操作  需要你去遍历  或者调用数组工具类中的方法  去操作
			System.out.println(Arrays.toString(fruit));
			System.out.println(Arrays.toString(sel));
			//拿到的是你传递表单的所有数据的键值对的集合
			
			Map<String, String[]> parameterMap = request.getParameterMap();
			//如何遍历map
			Set<String> keySet = parameterMap.keySet();
			Iterator it = keySet.iterator();
			while(it.hasNext()){
				String key = (String) it.next();
				String[] values = parameterMap.get(key);
				System.out.println("key的值:" + key + "\tvalue值:" + Arrays.toString(values));
			}
			
			//通过枚举类的方式获得所有的输入内容  不太常用
			Enumeration<String> parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
				//拿到表单中的每一个name属性值
				String name = parameterNames.nextElement();
				String [] values = request.getParameterValues(name);
				System.out.println(Arrays.toString(values));
			}
		}
}
