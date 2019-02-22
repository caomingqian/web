package com.igeek.service;

import java.util.List;

import com.igeek.dao.BaseDao;
import com.igeek.domain.Product;
import com.igeek.domain.User;

//������дSQL���  ��ɸ��ӵ��߼�ҵ��  dao�� servlet������
//servlet��web�㣩==> service�� ==> dao�㡣
//MVC ���ģʽ  ���ܷ��  Modelģ��  view��ͼ  controller ������
public class LoginService {
	private BaseDao<User> dao = new BaseDao<User>();
	private BaseDao<Product> daoProduct = new BaseDao<Product>();
	//���˵�˺Ÿ����룬�����ݴ��ڸ÷�������true ���򷵻�false��
	public User checkLogin(String loginName,String password){
		//Ĭ���˺������Ǵ����
		String sql = "select * from user where username = ? and password=?";
		//LoginName��password�����û�������˺�����
		Object [] params = {loginName,password};
		//select * from user where username = sbsb and password = 456;
		//???BaseDao�еĲ�ѯ��ʽ
		User user =(User) dao.getUserByOne(sql,params,new User());
		if(user!=null){
			//��ʾ��ѯ���û����Ѳ�ѯ�����û����ݣ����س�ȥ����ѯ�����û����ݷ�װ��user�����С���
			//��ǰ��user����  �������û�����������¼��������Ϣ
			return user;
		}
		//û�в�ѯ�����ݾ���һ��null
		return null;
	}
	
	//��װһ������  ���������þ���  ��ѯproduct���е�5������  int index  ������ʾsql����е�limit�±�
	public List<Product>getProductList(int index){
		String sql = "select * from product limit ?,5";
		Object[] params = {index};
		Object objectList = daoProduct.getProductList(sql,params,new Product());
		List<Product> productList = (List<Product>) objectList;
		return productList;
	}
}
