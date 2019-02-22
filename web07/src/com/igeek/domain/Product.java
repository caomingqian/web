package com.igeek.domain;

import java.io.Serializable;

//一般的实体类（Entity），又叫JavaBean,叫Domain,叫POJO（简单java对象）
//是根据数据库中的字段做一一对应（映射关系）
public class Product implements Serializable {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pid;
	private String pname;
	private double price;
	private String category_id;
	public Product(){
		
	}
	
	public Product(int pid, String pname, double price, String category_id) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category_id = category_id;
	}
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	//当你输出对象名称的时候。会调用tiStrig...
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category_id=" + category_id + "]";
	}
	
}
