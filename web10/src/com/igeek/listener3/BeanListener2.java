package com.igeek.listener3;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class BeanListener2
 *
 *	HttpSessionActivationListener
 *	1).监听实现了该接口和Serializable接口的java类的对象随session钝化和活化事件
 *
 *	>活化：从磁盘中读取session对象
 *	
 *	>钝化：向磁盘中写入session对象
 *
 *	>session对象存储在tomcat服务器的work\Catalina\localhost\contextPath  目录下。
 *	SESSION.SER
 *
 *	2).该监听器不需要在web.xml文件中进行配置
 *
 *	3).//在活化之后被调用。public void sessionDidActivate(HttpSessionEvent se)
 *	
 *	//在钝化之前被调用 public void sessionWillPassivate(HttpSessionEvent se)
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
    	System.out.println("从磁盘写入到内存中");
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("从内存中写入到磁盘中");
    }
	
}
