package com.te.empl.constant.db;

public enum TeDepartmentState {

	normal(0,"正常"),delete(-1,"删除");
	
	private int state;
	private String name;
	private TeDepartmentState() {
		// TODO Auto-generated constructor stub
	}
	private TeDepartmentState(int state, String name) {
		this.state = state;
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
