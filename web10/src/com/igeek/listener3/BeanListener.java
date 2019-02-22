package com.igeek.listener3;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * ��������ļ����� �ӿڣ�
 * 	HttpeServletBindingListener �󶨵ģ�ʵ�ֽӿڵ�javabean������Ը�֪���Լ����󶨵�session�к�session��ɾ�����¼���
 * 	HttpSessionActivationListener
 * 	��������JavaBean�����˽��Լ���session���е���Щ״̬
 * 	 ע�⣺ʵ���������ӿڵ��಻��Ҫ��web.xml�н���ע�ᡣ
 * ���൱�� �������������ǰ󶨵��������ϵ�  ����Ҫ��web.xml��ע�ᣩ
 * 
 * getSession()
 * getValue()
 * getName()
 * 
 * ��Ҫ��תһ��jspҳ��Ȼ�󽫵�ǰ�������뵽session�С����ɴ���valueBound�������������session���Ƴ����ɴ���valueUnbound����
 */
public class BeanListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent hbe) {
		// TODO Auto-generated method stub
		//��ǰ���󱻰󶨵�session�е�ʱ�� ����õ�ǰ����
		HttpSession session = hbe.getSession();//��ȡsession����
		Object object = hbe.getValue();//��ȡ���뵽session�еĶ�����
		System.out.println(object==this);//��ȡ�����ֵ����  ��ʵ����this...��ǰ�����
		String name = hbe.getName();//��ȡsession�еĶ����name��ֵ��name:value���е�name��
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//�������session�н���󶨵��õĵ�ǰ������
	}

}
