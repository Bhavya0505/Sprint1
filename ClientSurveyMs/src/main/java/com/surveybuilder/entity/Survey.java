package com.surveybuilder.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.surveybuilder.entity.*;



@Entity
@Table(name = "surveyms")
public class Survey {

	@Id
	private long sid;
	
	private String title;
	
	private String status;

	@JsonManagedReference
	@OneToMany(targetEntity = Question.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name ="Survey_fk",referencedColumnName = "sid")
    private List<Question> question;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "surveyor_fk")
	private Surveyor surveyor;
	

	


	public Survey(long sid, String title, String status, List<Question> question, Surveyor surveyor) {
		super();
		this.sid = sid;
		this.title = title;
		this.status = status;
		this.question = question;
		this.surveyor = surveyor;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Survey [sid=" + sid + ", title=" + title + ", status=" + status + ", question=" + question
				+ ", surveyor=" + surveyor + "]";
	}


	public Surveyor getSurveyor() {
		return surveyor;
	}

	public void setSurveyor(Surveyor surveyor) {
		this.surveyor = surveyor;
	}



	public Survey() {
		super();
	}


	
	
}
