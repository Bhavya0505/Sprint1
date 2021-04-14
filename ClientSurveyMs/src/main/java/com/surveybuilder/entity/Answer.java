package com.surveybuilder.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="answerms")
public class Answer {
	@Id
	private long aid;
	String ans;
	String feedback;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "Que_fk")
	private Question question;
	
	
	
	public Answer(long aid, String ans, String feedback, Question question) {
		super();
		this.aid = aid;
		this.ans = ans;
		this.feedback = feedback;
		this.question = question;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", ans=" + ans + ", feedback=" + feedback + ", question=" + question + "]";
	}
	public Answer(long aid, String ans, String feedback) {
		super();
		this.aid = aid;
		this.ans = ans;
		this.feedback = feedback;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
