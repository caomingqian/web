package com.igeek.listener3;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class BeanListener2
 *
 *	HttpSessionActivationListener
 *	1).����ʵ���˸ýӿں�Serializable�ӿڵ�java��Ķ�����session�ۻ��ͻ�¼�
 *
 *	>����Ӵ����ж�ȡsession����
 *	
 *	>�ۻ����������д��session����
 *
 *	>session����洢��tomcat��������work\Catalina\localhost\contextPath  Ŀ¼�¡�
 *	SESSION.SER
 *
 *	2).�ü���������Ҫ��web.xml�ļ��н�������
 *
 *	3).//�ڻ֮�󱻵��á�public void sessionDidActivate(HttpSessionEvent se)
 *	
 *	//�ڶۻ�֮ǰ������ public void sessionWillPassivate(HttpSessionEvent se)
 *
 *	HttpSessionEvent:getSession()
 */
public class BeanListener2 implements HttpSessionActivationListener ,Serializable{

    /**
     * Default constructor. 
     */
    public BeanListener2() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("�Ӵ���д�뵽�ڴ���");
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("���ڴ���д�뵽������");
    }
	
}
