package com.igeek.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.utils.MyDBUtils;

public class BaseDao<T> {
	//用来做所有的修改操作 方法的返回值为当前sql语句影响的数据。sql表示传入的要执行的sql语句。params 对应sql语句中的？做预处理。防止SQL注入
	public int update(String sql,Object[] params){
		int i = -1;
		try {
			QueryRunner queryRunner = MyDBUtils.getQueryRunner();
			i = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	//分装一个查询单一数据的方法。将查询到的数据分装到user对象中。user??泛型在项目中的实际应用
	public Object getUserByOne(String sql,Object[] params,T t){
		Object obj = null;//声明一个空的user对象
		QueryRunner queryRunner = MyDBUtils.getQueryRunner();//拿到queryRunner对象用来执行sql
		try {
			//String sql,new,BeanHandler<>(),object [] params;
			//Product
			//自动把查询结果封装成user对象
			obj = queryRunner.query(sql, new BeanHandler<T>((Class<T>) t.getClass()),params);//执行sql并把查询结果自动封装到user对象中
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}
	
	//user product beatut ... boys  都要重写方法
	
	//查询商品列表
	public Object getProductList(String sql,Object[] params ,T t){
		Object objectList = null;
		QueryRunner queryRunner = MyDBUtils.getQueryRunner();
		try {
			objectList = queryRunner.query(sql,new BeanListHandler<T>((Class<T>) t.getClass()),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectList;
	}
}
