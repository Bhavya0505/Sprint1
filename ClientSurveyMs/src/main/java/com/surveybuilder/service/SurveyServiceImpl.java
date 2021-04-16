package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.surveyDao;
import com.surveybuilder.entity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class SurveyServiceImpl implements SurveyService{
	
	public static final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

	
	@Autowired
	private surveyDao rr;

	//createSurveyService
	@Override
	public Survey createSurveyService(Survey s) {
		logger.info("createSurveyService");
		Survey a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save Survey :: ");
		}
		
		return a ;
	}

	//viewSurveyByIdService
	@Override
	public Survey viewSurveyByIdService(long id) {
		logger.info("viewSurveyByIdService");
		Survey a = rr.findSurveyById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Survey not found for this id :: "+ id);
		}
		return a;
	}

	//deleteSurveyByIdService
	@Override
	public boolean deleteSurveyByIdService(long id) throws ResourceNotFoundException {

		logger.info("deleteSurveyByIdService");
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	//get list of All Survey Service
	@Override
	public List<Survey> listAllSurveyService() {
		logger.info("listAllSurveyService");
		return rr.findAll();
	}

	//updateSurveyService
	@Override
	public Survey updateSurveyService(Survey s, long id) throws ResourceNotFoundException {
	
		logger.info("updateSurveyService");
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSid(a.getSid());
		
		final Survey updatedA= rr.save(s);
		return updatedA;
	}

	//distribute Survey.. passive to active
	@Override
	public Survey distributeSurvey(long id) throws ResourceNotFoundException {
		logger.info("distributeSurveyService");
		Survey s = new Survey();
			Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
				s = a;
				s.setSid(a.getSid());
				s.setStatus("Active");
				
				
				final Survey updatedA= rr.save(s);
				return updatedA;
	}
	
	//active to passive
	@Override
	public Survey stopSurvey(long id) throws ResourceNotFoundException {
		logger.info("stopDistributeSurvey");
		Survey s = new Survey();
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		s=a;
		s.setSid(a.getSid());
		s.setStatus("Passive");
		
		final Survey updatedA= rr.save(s);
		return updatedA;
	}
	



}
