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
		 * ����get����  ����post����  �������service����
		 */
		protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			request.setCharacterEncoding("utf-8");
			System.out.println("nmsl");
			//���ݱ���name����ֵ  �����valueֵ  getParameter��String name��
			String loginName = request.getParameter("loginName");
			//getParamenteValues(String name) ����Ҫ���Ԫ��  �кܶ��ʱ��  �ַ�������
			String[] fruit = request.getParameterValues("fruit");
			String password = request.getParameter("password");
			
			String sex = request.getParameter("sex");
			
			String [] sel = request.getParameterValues("sel");
			
			String textArea = request.getParameter("textarea");
			
			//getParameter
			
			System.out.println(sex);
			
			System.out.println(loginName);
			//ע������:���鲻��ֱ�Ӳ���  ��Ҫ��ȥ����  ���ߵ������鹤�����еķ���  ȥ����
			System.out.println(Arrays.toString(fruit));
			System.out.println(Arrays.toString(sel));
			//�õ������㴫�ݱ����������ݵļ�ֵ�Եļ���
			
			Map<String, String[]> parameterMap = request.getParameterMap();
			//��α���map
			Set<String> keySet = parameterMap.keySet();
			Iterator it = keySet.iterator();
			while(it.hasNext()){
				String key = (String) it.next();
				String[] values = parameterMap.get(key);
				System.out.println("key��ֵ:" + key + "\tvalueֵ:" + Arrays.toString(values));
			}
			
			//ͨ��ö����ķ�ʽ������е���������  ��̫����
			Enumeration<String> parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
				//�õ����е�ÿһ��name����ֵ
				String name = parameterNames.nextElement();
				String [] values = request.getParameterValues(name);
				System.out.println(Arrays.toString(values));
			}
		}
}
