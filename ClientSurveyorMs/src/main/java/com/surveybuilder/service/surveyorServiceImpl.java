package com.surveybuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.surveyorDao;
import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class surveyorServiceImpl implements surveyorService{

	public static final Logger logger = LoggerFactory.getLogger(surveyorServiceImpl.class);

	
	@Autowired
	surveyorDao sd;

	//createSurveyorService
	@Override
	public Surveyor createSurveyorService(Surveyor s) {
	logger.info("createSurveyorService");
		Surveyor a = sd.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not create surveyor profile :: ");
		}
		
		return a ;
	}

	//viewSurveyorByIdService
	@Override
	public Surveyor viewSurveyorByIdService(long id) {

		logger.info("viewSurveyorByIdService");
		Optional<Surveyor> s= sd.findById(id);
		return s.get();
	}

	//updateSurveyorService
	@Override
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException {

		logger.info("updateSurveyorService");
		Surveyor a = sd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSurveyorId(a.getSurveyorId());
		
		final Surveyor updatedA= sd.save(s);
		return updatedA;
	
	}

	//deleteSurveyorByIdService
	@Override
	public boolean deleteSurveyorByIdService(long id) throws ResourceNotFoundException {

		logger.info("deleteSurveyorByIdService");
		Surveyor a = sd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		sd.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
		
	}

	//listAllSurveyorService
	@Override
	public List<Surveyor> listAllSurveyorService() {
		logger.info("listAllSurveyorService");
		return sd.findAll();
	}

	//authSurveyorService
	@Override
	public Surveyor authSurveyor(String emailId, String pass) {

		logger.info("authSurevyorService");
		return sd.authSurveyor(emailId, pass);
	}
	
	
}

