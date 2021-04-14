package com.surveybuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public interface surveyorService {
	public Surveyor createSurveyorService(Surveyor s);
	public Surveyor viewSurveyorByIdService(long id);
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException;
	public boolean deleteSurveyorByIdService(long id) throws ResourceNotFoundException;
	public List<Surveyor> listAllSurveyorService();
	public Surveyor authSurveyor(String emailId, String pass);

}
