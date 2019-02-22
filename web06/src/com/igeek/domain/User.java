package com.igeek.domain;

import java.io.Serializable;

/*
 * 实体类  用来跟数据库中user表做映射
 */
public class User implements Serializable {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*user表中的id字段*/
	private String id;
	private String username;
	private String password;
	private int phone;
	
	public User(){
		
	}

	public User(String id, String username, String password, int phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}
	
	
}
