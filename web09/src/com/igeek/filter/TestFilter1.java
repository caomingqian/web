package com.igeek.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//����һ��  ʵ��filter�ӿ�
public class TestFilter1 implements Filter {

	//���ٹ�����  ֻ��ִ��һ��
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("������1��ж��");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletRequest resq = (HttpServletRequest)response;
		System.out.println("AAA��������1ִ���ˡ�");
		//��һЩ  Ȩ�޴���  �ַ�ת�루ת���������룩
		
		//chain.foFilter����  ��ʾ���е�ǰ�����������һ��������  ��ȥ����һ��������  ���û��ֱ�ӷ���
		chain.doFilter(request, response);
		System.out.println("������1ִ�����");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("������1����ʼ��");
	}

}
