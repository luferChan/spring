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
 * TeAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "te_account", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class TeAccount implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6107390586272715065L;
	private long id;
	private Date timestamp;
	private Date creation;
	private Integer type;
	private Integer state;
	private String username;
	private String password;
	private String nickname;
	private String creator;

	// Constructors

	/** default constructor */
	public TeAccount() {
	}

	/** full constructor */
	public TeAccount(Date creation, Integer type, Integer state,
			String username, String password, String nickname, String creator) {
		this.creation = creation;
		this.type = type;
		this.state = state;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.creator = creator;
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

	@Column(name = "creation", length = 19)
	public Date getCreation() {
		return this.creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "username", unique = true, length = 128)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname", length = 128)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "creator", length = 128)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "TeAccount [id=" + id + ", timestamp=" + timestamp
				+ ", creation=" + creation + ", type=" + type + ", state="
				+ state + ", username=" + username + ", password=" + password
				+ ", nickname=" + nickname + ", creator=" + creator + "]";
	}

}