package com.te.empl.dto;

import java.io.Serializable;

public class PageDto implements Serializable{

	/**
	 *    分页实体类
	 */
	private static final long serialVersionUID = 7219046284112761174L;
	
	private int count; //总数
	private int total; //总页数
	private int current; //当前页码
	private int size; //每页显示多少行数据
	
	public PageDto() {
		// TODO Auto-generated constructor stub
	}

	public PageDto(int count, int total, int current, int size) {
		super();
		this.count = count;
		this.total = total;
		this.current = current;
		this.size = size;
	}

	@Override
	public String toString() {
		return "PageDto [count=" + count + ", total=" + total + ", current="
				+ current + ", size=" + size + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
