package com.surveybuilder.dto;

import java.io.Serializable;

public class SurveyorDto implements Serializable{

	private long surveyorId;

	public long getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
	}

	public SurveyorDto(long surveyorId) {
		super();
		this.surveyorId = surveyorId;
	}

	@Override
	public String toString() {
		return "SurveyorDto [surveyorId=" + surveyorId + "]";
	}

	public SurveyorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
