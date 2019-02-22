package com.igeek.domain;

import java.io.Serializable;

public class Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	/*ÇøÓòµÄid¡£¡£¡£¡£*/
	private int id;
	private String area_name;
	private String area_code;
	private int area_parent_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public int getArea_parent_id() {
		return area_parent_id;
	}
	public void setArea_parent_id(int area_parent_id) {
		this.area_parent_id = area_parent_id;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", area_name=" + area_name + ", area_code=" + area_code + ", area_parent_id="
				+ area_parent_id + "]";
	}
	public Area(int id, String area_name, String area_code, int area_parent_id) {
		super();
		this.id = id;
		this.area_name = area_name;
		this.area_code = area_code;
		this.area_parent_id = area_parent_id;
	}
	public Area() {
		super();
	}
	
}
