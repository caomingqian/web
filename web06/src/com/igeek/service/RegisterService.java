package com.igeek.service;

import com.igeek.dao.BaseDao;
import com.igeek.domain.User;

public class RegisterService {
	
	private BaseDao<User> dao = new BaseDao<User>();
	//封装方法  用来拆入数据库。。。先查询是否存在数据
	public User checkUser(String username){
		String sql = "select * from user where username=?";
		Object [] params = {username};
		Object obj = dao.getUserByOne(sql, params, new User());
		return (User)obj;
	}
	//封装插入方法
	public void inserUser(User user){
		String sql = "insert into user values(?,?,?,?)";
		Object [] params ={user.getId(),user.getUsername(),user.getPassword(),user.getPhone()};
		dao.update(sql, params);
	}

}
