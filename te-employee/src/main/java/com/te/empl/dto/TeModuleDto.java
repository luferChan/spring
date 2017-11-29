package com.te.empl.dto;

import java.io.Serializable;

/**
 *  系统模块传输实体类
 * @author Administrator
 *
 */
public class TeModuleDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -289245286386644226L;
	private String code;
	private String superCode;
	private String name;
	private String page;
	private int level;
	
	public TeModuleDto() {
		// TODO Auto-generated constructor stub
	} 

	
	public TeModuleDto(String code, String superCode, String name,
			String page, int level) {
		super();
		this.code = code;
		this.superCode = superCode;
		this.name = name;
		this.page = page;
		this.level = level;
	}

	@Override
	public String toString() {
		return "TeModuleDto [code=" + code + ", superCode=" + superCode
				+ ", name=" + name + ", page=" + page + ", level=" + level
				+ "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuperCode() {
		return superCode;
	}

	public void setSuperCode(String superCode) {
		this.superCode = superCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
