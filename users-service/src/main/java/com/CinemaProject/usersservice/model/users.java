package com.CinemaProject.usersservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class users {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    @NotBlank(message = "First Name is mandatory")
	@Column(name="firstname")
	private String firstName;
    
    @NotBlank(message = "Last Name is mandatory")
	@Column(name="lastname")
	private String lastName;
    
    @NotBlank(message = "Email is mandatory")
	@Column(name="email")
	private String email;
    
    @ValidPassword
    @NotBlank(message = "Password is mandatory")
	@Column(name="passwordhash")
	private String password;
    
    @ValidPhonenumber
    @NotBlank(message = "Phone Number is mandatory")
	@Column(name="phonenumber")
	private String phoneNumber;
	
	
	public users()
	{	}
	
	public users(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
