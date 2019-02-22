package com.igeek.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDBUtils {
	private static ComboPooledDataSource cp = new ComboPooledDataSource();
	
	//��ǰ��������һ�����ݿ����Ӷ���ͨ�����ӳأ�
	public static Connection getConnection()throws Exception{
		Connection connection = cp.getConnection();
		return connection;
	}
	//��ǰ��������һ��QueryRunner����
	public static QueryRunner getQueryRunner(){
		QueryRunner qr = new QueryRunner(cp);
		return qr;
	}
	public static void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����ǹر����е�jdbc����
	public static void closeJdbcObjectAll(Connection connection,Statement statement,ResultSet result){
		try {
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
