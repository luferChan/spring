package com.te.empl.constant.db;

public enum TePositionState {

	normal(0,"正常"),delete(-1,"删除");
	
	private int state;
	private String name;
	private TePositionState() {
		// TODO Auto-generated constructor stub
	}
	private TePositionState(int state, String name) {
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
