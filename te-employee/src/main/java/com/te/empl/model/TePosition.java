package com.te.empl.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * TePosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "te_position")
public class TePosition implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2867045854630887598L;
	private long id;
	private Date timestamp;
	private Date createTime;
	private String creator;
	private Integer state;
	private long department;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public TePosition() {
	}

	/** minimal constructor */
	public TePosition(long department) {
		this.department = department;
	}

	/** full constructor */
	public TePosition(Date createTime, String creator, Integer state,
			long department, String name, String description) {
		this.createTime = createTime;
		this.creator = creator;
		this.state = state;
		this.department = department;
		this.name = name;
		this.description = description;
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
	@Column(name = "timestamp", nullable = false, length = 19)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creator", length = 64)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "department", nullable = false)
	public long getDepartment() {
		return this.department;
	}

	public void setDepartment(long department) {
		this.department = department;
	}

	@Column(name = "name", length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TePosition [id=" + id + ", timestamp=" + timestamp
				+ ", createTime=" + createTime + ", creator=" + creator
				+ ", state=" + state + ", department=" + department + ", name="
				+ name + ", description=" + description + "]";
	}

}