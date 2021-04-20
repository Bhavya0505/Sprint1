package com.surveybuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="questionms")
public class Question implements Serializable{
	
	
	@Id
	private long Qid;
	
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	@JsonManagedReference
	@OneToMany(targetEntity = Answer.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name ="Que_fk",referencedColumnName = "Qid")
    private List<Answer> answer;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "survey_fk")
	private Survey survey;
	
	
	public Question(long qid, String question, String option1, String option2, String option3, String option4,
			List<Answer> answer, Survey survey) {
		super();
		Qid = qid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
		this.survey = survey;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	@Override
	public String toString() {
		return "Question [Qid=" + Qid + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", survey=" + survey + "]";
	}
	public long getQid() {
		return Qid;
	}

	public void setQid(long qid) {
		Qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Question(long qid, String question, String option1, String option2, String option3, String option4,
			List<Answer> answer) {
		super();
		Qid = qid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
