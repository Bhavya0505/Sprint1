package com.surveybuilder.dto;

import java.io.Serializable;


public class SurveyDto implements Serializable
{
	private long sid;
	private String title;
	private String status;
	private SurveyorDto surveyor;
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
	public SurveyorDto getSurveyor() {
		return surveyor;
	}
	public void setSurveyor(SurveyorDto surveyor) {
		this.surveyor = surveyor;
	}
	@Override
	public String toString() {
		return "SurveyDto [sid=" + sid + ", title=" + title + ", status=" + status + ", surveyor=" + surveyor + "]";
	}
	public SurveyDto(long sid, String title, String status, SurveyorDto surveyor) {
		super();
		this.sid = sid;
		this.title = title;
		this.status = status;
		this.surveyor = surveyor;
	}
	public SurveyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
