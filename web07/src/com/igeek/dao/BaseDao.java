package com.igeek.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.utils.MyDBUtils;

public class BaseDao<T> {
	//���������е��޸Ĳ��� �����ķ���ֵΪ��ǰsql���Ӱ������ݡ�sql��ʾ�����Ҫִ�е�sql��䡣params ��Ӧsql����еģ���Ԥ������ֹSQLע��
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
	
	//��װһ����ѯ��һ���ݵķ���������ѯ�������ݷ�װ��user�����С�user??��������Ŀ�е�ʵ��Ӧ��
	public Object getUserByOne(String sql,Object[] params,T t){
		Object obj = null;//����һ���յ�user����
		QueryRunner queryRunner = MyDBUtils.getQueryRunner();//�õ�queryRunner��������ִ��sql
		try {
			//String sql,new,BeanHandler<>(),object [] params;
			//Product
			//�Զ��Ѳ�ѯ�����װ��user����
			obj = queryRunner.query(sql, new BeanHandler<T>((Class<T>) t.getClass()),params);//ִ��sql���Ѳ�ѯ����Զ���װ��user������
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}
	
	//user product beatut ... boys  ��Ҫ��д����
	
	//��ѯ��Ʒ�б�
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
