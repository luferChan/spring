package com.te.empl.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * TeModule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "te_module", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class TeModule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -9115059351726270640L;
	private long id;
	private Date timestamp;
	private String name;
	private String code;
	private String superCode;
	private String page;
	private Integer level;

	// Constructors

	/** default constructor */
	public TeModule() {
	}

	/** full constructor */
	public TeModule(String name, String code, String superCode, String page,
			Integer level) {
		this.name = name;
		this.code = code;
		this.superCode = superCode;
		this.page = page;
		this.level = level;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Version
	@Column(name = "timestamp", length = 19)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "name", length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", unique = true, length = 24)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "superCode", length = 24)
	public String getSuperCode() {
		return this.superCode;
	}

	public void setSuperCode(String superCode) {
		this.superCode = superCode;
	}

	@Column(name = "page", length = 128)
	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "TeModule [id=" + id + ", timestamp=" + timestamp + ", name="
				+ name + ", code=" + code + ", superCode=" + superCode
				+ ", page=" + page + ", level=" + level + "]";
	}

}