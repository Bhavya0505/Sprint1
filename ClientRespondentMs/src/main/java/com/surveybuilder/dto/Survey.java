package com.surveybuilder.dto;

import javax.persistence.Id;

public class Survey {

	
	private long sid;
	
	private String title;
	
	private String status;

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
		return "Survey [sid=" + sid + ", title=" + title + ", status=" + status + "]";
	}

	public Survey(long sid, String title, String status) {
		super();
		this.sid = sid;
		this.title = title;
		this.status = status;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

