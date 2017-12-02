package com.te.empl.dto;

import java.io.Serializable;

/**
 *  部门数据列表实体类 Dto
 * @author Administrator
 *
 */
public class TeDepartmentDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6207140313941325416L;
	private long id; // ID号
	private String name; //部门名称
	private String creator; //创建者
	private String creatTime;// 创建时间
	private String description; //部门描述
	
	public TeDepartmentDto() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public TeDepartmentDto(long id, String name, String creator,
			String creatTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.creatTime = creatTime;
		this.description = description;
	}

	@Override
	public String toString() {
		return "TeDepartmentDto [id=" + id + ", name=" + name + ", creator="
				+ creator + ", creatTime=" + creatTime + ", description="
				+ description + "]";
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
