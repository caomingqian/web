package com.igeek.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//创建一个  实现filter接口
public class TestFilter1 implements Filter {

	//销毁过滤器  只会执行一次
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器1被卸载");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletRequest resq = (HttpServletRequest)response;
		System.out.println("AAA过滤器被1执行了。");
		//做一些  权限处理  字符转码（转换中文乱码）
		
		//chain.foFilter方法  表示放行当前请求。如果有下一个过滤器  回去找下一个过滤器  如果没有直接放行
		chain.doFilter(request, response);
		System.out.println("过滤器1执行完毕");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器1被初始化");
	}

}
