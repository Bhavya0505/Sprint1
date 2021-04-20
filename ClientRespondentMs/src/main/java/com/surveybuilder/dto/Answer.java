package com.surveybuilder.dto;

import java.io.Serializable;

public class Answer implements Serializable{

	private long aid;
	String ans;
	String feedback;
	private Question question;
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", ans=" + ans + ", feedback=" + feedback + ", question=" + question + "]";
	}
	public Answer(long aid, String ans, String feedback, com.surveybuilder.dto.Question question) {
		super();
		this.aid = aid;
		this.ans = ans;
		this.feedback = feedback;
		this.question = question;
	}
	public Answer() {
		super();
	}


	
	
}
