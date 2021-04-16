package com.surveybuilder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name = "adminms")
public class Admin {

	@Id
	private long adminId;

	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String name;
	
	@Email(message = "Email should be valid")
	private String emailId;
	
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	private String password;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(long adminId,
			@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String name,
			@Email(message = "Email should be valid") String emailId,
			@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters") String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", emailId=" + emailId + ", password=" + password + "]";
	}

	public Admin() {
		super();

	}

	
}
