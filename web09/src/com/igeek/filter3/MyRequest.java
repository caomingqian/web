package com.igeek.filter3;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//HttpServletRequestWrapper  װ��3��  �㶨��
public class MyRequest extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;
	//����һ����ǣ���Ǳ���Ĵ�����ִֻ��һ��
	private boolean flag=false;//ת���ʱ��  ֻ��Ҫת��һ�Ρ�false��ʾ��û��ת��
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request=request;
	}
	//���˼̳й�ϵ  �����о����˸������е����Ը�����
	@Override
	public Map<String,String[]> getParameterMap(){
		
		//��ȡ����ʽ�����ݲ�ͬ��ʽ��������
		String method = request.getMethod();//�������ʽ��post...get...
		if(method.equalsIgnoreCase("post")){
			try {
				request.setCharacterEncoding("utf-8");
				//���·��ر���֮���map���� ok
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return super.getParameterMap();
				// TODO: handle exception
			}
		}else if(method.equalsIgnoreCase("get")){
			//get
			//�����е����������ȡ���� Ȼ��  һ��һ���ش�������
			Map<String,String[]> map = request.getParameterMap();
			//������Ʊ��룬����ִֻ��һ�Σ�
			//flagĬ����false ��������ִ��
			//flag�ڶ���ִ��trueֱ�ӽ���������ִ�С�
			if(flag){
				return map;
			}
			//����map���ϻ�ȡ����
			if(map!=null){
				//keySet();���ǰ̨���ݹ��������е�name����  ��ϳɵ�set����
				for(String key:map.keySet()){
					//����key�õ���Ӧ��value  name="��ķ���ܿˣ����� " age="10��"
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
			//true  �Ѿ�ת�����.����
			flag=true;
			//ת����֮���map��������
			return map;
		}else{
			return super.getParameterMap();
		}	
	}
	
	public String[] getParamenterValues(String name){
		//�ȵ�����һ������  ����ת��
		Map<String,String[]>map = this.getParameterMap();
		if(map!=null){
			//���ݴ����name ��ת��֮���map�е�value[]ȡ����
			String[] values=map.get(name);
			//����ת��֮���ֵ
			return values;
		}
		//���˵��������������  ��ȥ��Ӵ�������еķ���
		return super.getParameterValues(name);
	}
	@Override
	public String getParameter(String name){
		//��ʱ���ǻ����getParameterMap ��������ת��
		String[] values = this.getParamenterValues(name);
		if(values!=null){
			//����name�õ��Ķ��ǵ�����ֵ
			return values[0];
		}
		//����ȥ���ø����еķ�����
		return super.getParameter(name);
	}
}
