package com.igeek.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoginServlet(){
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGetִ����");
		//request ����  ���������  �ͷ�װ��  ������������ݹ�������������
		response.setHeader("content-Type", "text/html;charset=UTF-8");//������Ӧ����  ָ�����ص�����  Ϊ�ı�/html  �ַ���Ϊutf-8
		//request  �����оͷ�װ��  �����������Ϣ
		String header = request.getHeader("Accept-Language");
		String connection = request.getHeader("connection");
		System.out.println(connection);
		System.out.println(header);
		//������������е���Ϣ
		
		//�������get��������  tomcat 8����  Ĭ�ϱ����ʽutf-8  ������tomcat8���µı�����8859-1...
		//��ȡ���ݹ����Ĳ���
		//1.��tomcat�����ļ���  �޸Ķ˿ں�  �������´���  URIEncoding = "UTF-8"
		//URI  ͳһ��Դ������  URLͳһ��Դ��λ��
		//���Ƽ�����get����ķ�ʽ�� 2 .get,post  �ռ�ת��
		//3.����get����  �õ�net���µ�������  URLEncoder  ����  ��Ҫָ��Ҫת����ַ�����ԭʼ����  URLDecoder  ��Ҫָ����ĳ���ַ����������ô���ͣ�UTF-8��
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		System.out.println(loginName + "" + password);
		/*String newLoginName = new String(loginName.getBytes("iso-8859-1"),"utf-8");
		String newPassword = new String(password.getBytes("iso-8859-1"),"utf-8");
		System.out.println(newLoginName + "" + newPassword);*/
		//ָ���Ƕ����ݽ��б��룬ios-8859-1
		String encode = URLEncoder.encode(loginName,"iso-8859-1");
		String decode = URLDecoder.decode(encode,"UTF-8");
		System.out.println(decode);
		
		//PrintWriter
		
		PrintWriter out = response.getWriter();
		out.write("���յ�����������˺�����" + decode);
	}
	
	//������get����  ����post����  �������doGet����

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,request);
		//����post���������  ����1�� ʹ���ռ�ת��  String ת����֮����ַ���=new String(��Ҫת����ַ�����getBytes("ios-8859-1"),"utf-8");
		//���Ƽ��Ĵ���post����ķ�ʽ������post��������ķ�ʽ�����ڻ�ȡ����֮ǰ  ���д����һ�е�λ�á�����ǰ��������һ������
		//request.setCharacterEncoding("utf-8");һ����ڽ�������֮ǰ
		request.setCharacterEncoding("UTF-8");
		String header = request.getHeader("Accept-Language");
		String connection = request.getHeader("Connection");
		System.out.println(connection);
		System.out.println(header);
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		
		System.out.println(loginName+" " + password);
		//String newLoginName = new String(loginName.getBytes("iso-8859-1"),"utf-8");
		//String newPassword = new String(password.getBytes("iso-8859-1"),"utf-8");
		//System.out.println(newLoginName+" "+newPassword);
		
	}	
}

























