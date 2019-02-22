package com.igeek.filter3;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//HttpServletRequestWrapper  装了3层  搞定了
public class MyRequest extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;
	//定义一个标记，标记编码的次数，只执行一次
	private boolean flag=false;//转码的时候  只需要转换一次。false表示还没有转码
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request=request;
	}
	//有了继承关系  这类中就有了父类所有的属性跟方法
	@Override
	public Map<String,String[]> getParameterMap(){
		
		//获取请求方式，根据不同方式处理乱码
		String method = request.getMethod();//获得请求方式。post...get...
		if(method.equalsIgnoreCase("post")){
			try {
				request.setCharacterEncoding("utf-8");
				//重新返回编码之后的map对象 ok
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return super.getParameterMap();
				// TODO: handle exception
			}
		}else if(method.equalsIgnoreCase("get")){
			//get
			//将所有的请求参数获取出来 然后  一个一个地处理乱码
			Map<String,String[]> map = request.getParameterMap();
			//如果控制编码，让他只执行一次？
			//flag默认是false 所以往下执行
			//flag第二次执行true直接结束，不再执行。
			if(flag){
				return map;
			}
			//变量map集合获取数据
			if(map!=null){
				//keySet();你从前台传递过来的所有的name属性  组合成的set集合
				for(String key:map.keySet()){
					//根据key拿到对应的value  name="汤姆，杰克，哈哈 " age="10岁"
					String[] values = map.get(key);
					if(values!=null){
						//
						for(int i =0;i<values.length;i++){
							try {
								String string = new String(values[i].getBytes("iso-8859-1"),"utf-8");
								values[i]=string;
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
								// TODO: handle exception
								continue;
							}
						}
						
					}
				}
			}
			//true  已经转码完成.。。
			flag=true;
			//转完码之后的map给他返回
			return map;
		}else{
			return super.getParameterMap();
		}	
	}
	
	public String[] getParamenterValues(String name){
		//先调用上一个方法  整体转码
		Map<String,String[]>map = this.getParameterMap();
		if(map!=null){
			//根据传入的name 将转码之后的map中的value[]取出来
			String[] values=map.get(name);
			//返回转码之后的值
			return values;
		}
		//如果说不满足上述条件  还去掉哟个父类中的方法
		return super.getParameterValues(name);
	}
	@Override
	public String getParameter(String name){
		//及时还是会调用getParameterMap 进行整体转码
		String[] values = this.getParamenterValues(name);
		if(values!=null){
			//根据name拿到的都是单个的值
			return values[0];
		}
		//否则去调用父类中的方法。
		return super.getParameter(name);
	}
}
