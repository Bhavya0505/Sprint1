package com.surveybuilder.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.surveybuilder.dto.*;

@Entity
@Table(name = "respondentms")
public class Respondent {


	@Id
	private long respondentId;
	
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String name;
	
	@Email(message = "Email should be valid")
	private String emailId;
	
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	private String password;
	
//getters and setters
	public long getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(long respondentId) {
		this.respondentId = respondentId;
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


//toString
	@Override
	public String toString() {
		return "Respondent [respondentId=" + respondentId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + "]";
	}

//param constructor

	public Respondent(long respondentId,
			@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String name,
			@Email(message = "Email should be valid") String emailId,
			@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters") String password) {
		super();
		this.respondentId = respondentId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}

	//default constructor
	public Respondent() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
}
