package com.springmvc.qlcb.model;
// Generated May 30, 2016 7:31:33 AM by Hibernate Tools 4.3.1.Final

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

/**
 * User generated by hbm2java
 */
@Entity
//@Table(name = "user", catalog = "qlcb")
public class User implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	@ManyToMany
	@JoinTable(name="UsersAndRoles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roles;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	public User() {
	}
	

public User(int id, String username, String password, List<Role> roles, UserStatus status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.status = status;
	}


	//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//
//	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@Column(name = "status", length = 45)
	public UserStatus getStatus() {
		return this.status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
