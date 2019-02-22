package com.igeek.test;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igeek.dao.BaseDao;
import com.igeek.domain.Area;
import com.igeek.domain.Product;
import com.igeek.domain.User;
import com.igeek.utils.MyDBUtils;
import com.igeek.utils.StringUtils;

public class DaoTest {
	@Test
	public void test(){
		try {
			Connection connection = MyDBUtils.getConnection();
			System.out.println(connection);
			
			QueryRunner queryRunner = MyDBUtils.getQueryRunner();
			System.out.println(queryRunner);
			
			BaseDao dao = new BaseDao();
			/*String sql = "insert into product(pid,pname,price,category_id) values(?,?,?,?)";
			Object[] params = {111,"测试",111,"c009"};
			int i = dao.update(sql, params);
			System.out.println(i);*/
			
			String sql2 = "select * from user where username=? and password=?";
			Object[] params1 = {"john","8888"};
			User i2 = (User)dao.getUserByOne(sql2, params1, new User());
			System.out.println(i2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testGetProductList(){
		BaseDao<Product> dao = new BaseDao<Product>();
		String sql = "select * from product limt ?,5";//
		Object [] params = {0};
		Object objectList = dao.getList(sql, params, new Product());
		List<Product> productList = (List<Product>)objectList;
		for (Product product : productList) {
			System.out.println(product);
		}
	}

	@Test
	public void insert(){
		BaseDao dao = new BaseDao();
		String sql = "insert into user values(?,?,?,?)";
		Object [] params = {StringUtils.getUUID(),"catalina","123",180250};
		int i = dao.update(sql, params);
		System.out.println(i);
	}
	@Test
	public void link() throws Exception{
		BaseDao dao = new BaseDao();
		String sql =  "select * from area where area_parent_id=?";
		Object[] params={0};
		Object list = dao.getList(sql, params, new Area());
		System.out.println(list);
		List<Area> areaList = (List<Area>) list;
		//areaList  List  嵌套Area 类。  每一个Area对象代表了一行数据库中的数据
		/**
		 * for(Area sb:areaList){
		 * 		System.out.println(sb);
		 * }
		 */
		//json.
		//使用工具  自动将查询到的结果转换成json格式
		ObjectMapper mapper = new ObjectMapper();
		//将数据转换成json格式
		String json = mapper.writeValueAsString(areaList);
		System.out.println(json);
	}

}
