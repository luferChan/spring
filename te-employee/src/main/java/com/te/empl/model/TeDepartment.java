package com.te.empl.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * TeDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "te_department")
public class TeDepartment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6854979833602550181L;
	private long id;
	private Date timestamp;
	private Date creatTime;
	private String creator;
	private Integer state;
	private String name;
	private String descrition;

	// Constructors

	/** default constructor */
	public TeDepartment() {
	}

	/** full constructor */
	public TeDepartment(Date creatTime, String creator, Integer state,
			String name, String descrition) {
		this.creatTime = creatTime;
		this.creator = creator;
		this.state = state;
		this.name = name;
		this.descrition = descrition;
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

	@Column(name = "creatTime", length = 19)
	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name = "creator", length = 128)
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

	@Column(name = "name", length = 512)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "descrition", length = 1024)
	public String getDescrition() {
		return this.descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	@Override
	public String toString() {
		return "TeDepartment [id=" + id + ", timestamp=" + timestamp
				+ ", creatTime=" + creatTime + ", creator=" + creator
				+ ", state=" + state + ", name=" + name + ", descrition="
				+ descrition + "]";
	}

}