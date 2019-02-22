package com.igeek.listener3;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 两个特殊的监听器 接口：
 * 	HttpeServletBindingListener 绑定的（实现接口的javabean对象可以感知到自己被绑定到session中和session中删除的事件）
 * 	HttpSessionActivationListener
 * 	用来帮助JavaBean对象了解自己在session域中的这些状态
 * 	 注意：实现这两个接口的类不需要在web.xml中进行注册。
 * （相当于 这两个监听器是绑定到对象身上的  不需要在web.xml中注册）
 * 
 * getSession()
 * getValue()
 * getName()
 * 
 * 需要跳转一个jsp页面然后将当前类对象放入到session中。即可触发valueBound方法，将对象从session中移除即可触发valueUnbound方法
 */
public class BeanListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent hbe) {
		// TODO Auto-generated method stub
		//当前对象被绑定到session中的时候 会调用当前方法
		HttpSession session = hbe.getSession();//获取session对象
		Object object = hbe.getValue();//获取放入到session中的对象本身
		System.out.println(object==this);//获取存入的值本身  其实就是this...当前类对象
		String name = hbe.getName();//获取session中的对象的name的值（name:value对中的name）
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		//当对象从session中解除绑定调用的当前方法。
	}

}
