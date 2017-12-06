package com.te.empl.dto;

import java.io.Serializable;

/**
 * 封装下拉菜单的数据列表
 * @author Administrator
 *
 */
public class TeSelectDto implements Serializable{

	private static final long serialVersionUID = 5598222321909725141L;
	
	private long id;
	private String name;
	
	public TeSelectDto() {
		// TODO Auto-generated constructor stub
	}

	public TeSelectDto(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeSelectDto [id=" + id + ", name=" + name + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}	
