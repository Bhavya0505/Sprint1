package com.surveybuilder.dto;

public class Question {

	private long Qid;

	public long getQid() {
		return Qid;
	}

	public void setQid(long qid) {
		Qid = qid;
	}

	@Override
	public String toString() {
		return "Question [Qid=" + Qid + "]";
	}

	public Question(long qid) {
		super();
		Qid = qid;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
