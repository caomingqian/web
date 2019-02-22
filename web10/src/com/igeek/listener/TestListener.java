package com.igeek.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * 使用最多的Listener监听application对象的创建与销毁
 * 
 * 可以在当前的web应用被加载的时候做初始化操作。
 * 
 * 比如 1.创建数据库连接池 2.创建springIOC容器  3.读取当前web应用的初始化参数
 * 
 * 跟当前监听器类似的（这三个域对象是监听器生命周期的。）
 * ServletContextListener  监听  ServletContext 对象的创建和销毁
 * ServletRequestListener  监听 ServletRequest 对象的创建和销毁
 * HttpSessionListener 监听HttpSession 对象的创建和销毁
 * 
 * 可以演示一个类同时实现这三个接口
 * 
 * session的生命周期回顾
 * 1.首页session的创建，第一次访问jsp或者servlet的时候（JSP中session="false"没有设置，servlet中没有rquest.getsession（false）,但是使用了request.getSession()或者request.getSession(true)）
 * 	的时候会创建一个session的对象
 * 2.session的销毁，session过期，直接调用session的invalidate方法，当前web应用被卸载（session可以被持久化。可以在服务器中查看session信息的文件）
 * 3.关闭浏览器，并不意味着session被销毁，可以通过JSESSIONID找到服务器中的session对象。
 * 			http://localhost:8080/web10/index.jsp;jsessionid=值
 * 			这种写法称为URL重写。（前面拼接的是请求的路径）;jsessionid=值
 * 
 * application对象的生命周期贯穿于web应用。
 */
public class TestListener implements ServletContextListener {


    public TestListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("application对象被销毁");
    	ServletContext servletContext = sce.getServletContext();
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("application对象创建了。");
    }
	
}
