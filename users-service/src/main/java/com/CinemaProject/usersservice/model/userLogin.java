package com.CinemaProject.usersservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


public class userLogin {

	private long id;
	
	private String email;
	
	private String password;
	
	private String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public userLogin(long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	 public userLogin() {}
	
	
}
