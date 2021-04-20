package com.surveybuilder.dto;

import java.io.Serializable;

public class QuestionDto implements Serializable{

	private long Qid;
	
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	private SurveyDto survey;

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

	public SurveyDto getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDto survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "QuestionDto [Qid=" + Qid + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", survey=" + survey + "]";
	}

	public QuestionDto(long qid, String question, String option1, String option2, String option3, String option4,
			SurveyDto survey) {
		super();
		Qid = qid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.survey = survey;
	}

	public QuestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
