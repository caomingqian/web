package com.igeek.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * ʹ������Listener����application����Ĵ���������
 * 
 * �����ڵ�ǰ��webӦ�ñ����ص�ʱ������ʼ��������
 * 
 * ���� 1.�������ݿ����ӳ� 2.����springIOC����  3.��ȡ��ǰwebӦ�õĳ�ʼ������
 * 
 * ����ǰ���������Ƶģ�������������Ǽ������������ڵġ���
 * ServletContextListener  ����  ServletContext ����Ĵ���������
 * ServletRequestListener  ���� ServletRequest ����Ĵ���������
 * HttpSessionListener ����HttpSession ����Ĵ���������
 * 
 * ������ʾһ����ͬʱʵ���������ӿ�
 * 
 * session���������ڻع�
 * 1.��ҳsession�Ĵ�������һ�η���jsp����servlet��ʱ��JSP��session="false"û�����ã�servlet��û��rquest.getsession��false��,����ʹ����request.getSession()����request.getSession(true)��
 * 	��ʱ��ᴴ��һ��session�Ķ���
 * 2.session�����٣�session���ڣ�ֱ�ӵ���session��invalidate��������ǰwebӦ�ñ�ж�أ�session���Ա��־û��������ڷ������в鿴session��Ϣ���ļ���
 * 3.�ر��������������ζ��session�����٣�����ͨ��JSESSIONID�ҵ��������е�session����
 * 			http://localhost:8080/web10/index.jsp;jsessionid=ֵ
 * 			����д����ΪURL��д����ǰ��ƴ�ӵ��������·����;jsessionid=ֵ
 * 
 * application������������ڹᴩ��webӦ�á�
 */
public class TestListener implements ServletContextListener {


    public TestListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("application��������");
    	ServletContext servletContext = sce.getServletContext();
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("application���󴴽��ˡ�");
    }
	
}
