package com.itrh.rh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7751572660823042268L;
	
	private String  username;
	private String  password;
	private String  description;
	private int  enabled;
	
	
	
	@Id
    @Column(name="username", unique = true, nullable = false)
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Id
    @Column(name="password", unique = false, nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
    @Column(name="description", unique = false, nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Id
    @Column(name="enabled", unique = false, nullable = false)
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	  	
}
