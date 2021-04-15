package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.entity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;


public interface SurveyService {
	public Survey createSurveyService(Survey s);
	public Survey viewSurveyByIdService(long id);
	public Survey updateSurveyService(Survey s, long id) throws ResourceNotFoundException;
	public boolean deleteSurveyByIdService(long id) throws ResourceNotFoundException;
	public List<Survey> listAllSurveyService();
	public Survey distributeSurvey(long id) throws ResourceNotFoundException;
	public Survey stopSurvey(long id) throws ResourceNotFoundException;
	
}
