package com.te.empl.dto;

import java.io.Serializable;

public class TePositionDto implements Serializable{


	private static final long serialVersionUID = 460623536903057506L;
	
	private long id;
	private String name; //职位名称
	private String createTime;
	private String creator;
	private String department; //所属部门
	private String description; //职位描述
	
	public TePositionDto() {
		// TODO Auto-generated constructor stub
	}

	public TePositionDto(long id, String name, String createTime,
			String creator, String department, String description) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.creator = creator;
		this.department = department;
		this.description = description;
	}

	@Override
	public String toString() {
		return "TePositionDto [id=" + id + ", name=" + name + ", createTime="
				+ createTime + ", creator=" + creator + ", department="
				+ department + ", description=" + description + "]";
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
