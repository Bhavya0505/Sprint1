package com.surveybuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.surveybuilder.dao.surveyorDao;
import com.surveybuilder.dto.QuestionDto;
import com.surveybuilder.dto.SurveyDto;
import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class surveyorServiceImpl implements surveyorService{

	public static final Logger logger = LoggerFactory.getLogger(surveyorServiceImpl.class);

	
	@Autowired
	surveyorDao sd;


	/****************************************************************************************************************************
	 - Method Name      : createSurveyorService
	 - Input Parameters :Surveyor s
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : Create the surveyor information entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
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

	/****************************************************************************************************************************
	 - Method Name      : viewSurveyorByIdService
	 - Input Parameters : long id
	 - Return type      : Surveyor
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : view the surveyor information entered by surveyor from the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Surveyor viewSurveyorByIdService(long id) {

		logger.info("viewSurveyorByIdService");
		Optional<Surveyor> s= sd.findById(id);
		return s.get();
	}

	/****************************************************************************************************************************
	 - Method Name      : updateSurveyorService
	 - Input Parameters :Surveyor s, long id
	 - Return type      : Surveyor
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : update the surveyor information entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException {

		logger.info("updateSurveyorService");
		Surveyor a = sd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSurveyorId(a.getSurveyorId());
		
		final Surveyor updatedA= sd.save(s);
		return updatedA;
	
	}


	/****************************************************************************************************************************
	 - Method Name      : deleteSurveyorByIdService
	 - Input Parameters :long id
	 - Return type      : Boolean
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : Delete the surveyor information entered by surveyor and from  the database.
	  ****************************************************************************************************************************/ 
	
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

	/****************************************************************************************************************************
	 - Method Name      : listAllSurveyorService
	 - Input Parameters :
	 - Return type      : List<Surveyor>
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : view all the surveyor information from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public List<Surveyor> listAllSurveyorService() {
		logger.info("listAllSurveyorService");
		return sd.findAll();
	}

	/****************************************************************************************************************************
	 - Method Name      : authSurveyor
	 - Input Parameters :String emailId, String pass
	 - Return type      : Surveyor
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : authenticate the surveyor information entered by surveyor and from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Surveyor authSurveyor(String emailId, String pass) {

		logger.info("authSurevyorService");
		return sd.authSurveyor(emailId, pass);
	}

	
	@Autowired
	RestTemplate rest;
	
	
	/****************************************************************************************************************************
	 - Method Name      : createSurveyrService
	 - Input Parameters :SurveyDto s
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 23-04-2021
	 - Description      : create the survey information entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public String createSurveyrService(SurveyDto s) {

		String url = "http://localhost/survey/survey/createSurvey";
		String a = rest.postForObject(url, s, String.class);
		return a;
	}

	/****************************************************************************************************************************
	 - Method Name      : createQuestionService
	 - Input Parameters :QuestionDto s
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 23-04-2021
	 - Description      : create the question entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public String createQuestionService(QuestionDto s) {
		String url = "http://localhost/survey/question/createQuestion";
		String a = rest.postForObject(url, s, String.class);
		return a;
	}
	
	
}

