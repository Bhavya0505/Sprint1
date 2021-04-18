package com.surveybuilder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "surveyorms")
public class Surveyor implements Serializable{
	
	@Id
	private long surveyorId;
	
	@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
	private String name;
	
	@Email(message = "Email should be valid")
	private String emailId;
	
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	private String password;
	
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
	
	public long getSurveyorId() {
		return surveyorId;
	}
	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
	}
	public Surveyor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Surveyor(long surveyorId,
			@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String name,
			@Email(message = "Email should be valid") String emailId,
			@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters") String password) {
		super();
		this.surveyorId = surveyorId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Surveyor [surveyorId=" + surveyorId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + "]";
	}
	
	
}
