package com.igeek.service;

import java.util.List;

import com.igeek.dao.BaseDao;
import com.igeek.domain.Product;
import com.igeek.domain.User;

//负责书写SQL语句  完成复杂的逻辑业务  dao跟 servlet的桥梁
//servlet（web层）==> service层 ==> dao层。
//MVC 设计模式  构架风格  Model模型  view视图  controller 控制器
public class LoginService {
	private BaseDao<User> dao = new BaseDao<User>();
	private BaseDao<Product> daoProduct = new BaseDao<Product>();
	//如果说账号跟密码，在数据存在该方法返回true 否则返回false；
	public User checkLogin(String loginName,String password){
		//默认账号密码是错误的
		String sql = "select * from user where username = ? and password=?";
		//LoginName，password就是用户输入的账号密码
		Object [] params = {loginName,password};
		//select * from user where username = sbsb and password = 456;
		//???BaseDao中的查询方式
		User user =(User) dao.getUserByOne(sql,params,new User());
		if(user!=null){
			//表示查询到用户，把查询到的用户数据，返回出去（查询到的用户数据封装到user对象中。）
			//当前的user对象  就有了用户输入的这个记录的所有信息
			return user;
		}
		//没有查询到数据就是一个null
		return null;
	}
	
	//封装一个方法  方法的作用就是  查询product表中的5条数据  int index  用来表示sql语句中的limit下标
	public List<Product>getProductList(int index){
		String sql = "select * from product limit ?,5";
		Object[] params = {index};
		Object objectList = daoProduct.getProductList(sql,params,new Product());
		List<Product> productList = (List<Product>) objectList;
		return productList;
	}
}
