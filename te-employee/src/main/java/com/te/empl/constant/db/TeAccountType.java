package com.te.empl.constant.db;

public enum TeAccountType {
	
	superAdmin(0,"超级管理员"), admin(1,"普通管理员");
	
	private int type;
	private String name;
	private TeAccountType() {
		// TODO Auto-generated constructor stub
	}
	private TeAccountType(int type, String name) {
		this.type = type;
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
