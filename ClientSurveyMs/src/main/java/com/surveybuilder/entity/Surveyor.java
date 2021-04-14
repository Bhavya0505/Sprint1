package com.surveybuilder.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="surveyorms")
public class Surveyor {

	@Id
	private long surveyorId;
	
	private String name;
	
	private String emailId;
		
	private String password;
	
	@JsonManagedReference
	@OneToMany(targetEntity = Survey.class, cascade = CascadeType.ALL)
	@JoinColumn(name ="surveyor_fk",referencedColumnName = "surveyorId")
	private List<Survey> survey;

	public long getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
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

	public List<Survey> getSurvey() {
		return survey;
	}

	public void setSurvey(List<Survey> survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "Surveyor [surveyorId=" + surveyorId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + ", survey=" + survey + "]";
	}

	public Surveyor(long surveyorId, String name, String emailId, String password, List<Survey> survey) {
		super();
		this.surveyorId = surveyorId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.survey = survey;
	}

	public Surveyor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
