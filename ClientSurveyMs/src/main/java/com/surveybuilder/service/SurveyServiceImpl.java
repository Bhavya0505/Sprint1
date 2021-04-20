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


	
	/****************************************************************************************************************************
	 - Method Name      : createSurvey
	 - Input Parameters : Survey s
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : Inserting the survey information entered by surveyor   into  the database.
	  ****************************************************************************************************************************/ 

	@Override
	public Survey createSurveyService(Survey s) {
		logger.info("createSurveyService");
		Survey a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save Survey :: ");
		}
		
		return a ;
	}

	/****************************************************************************************************************************
	 - Method Name      : viewSurveyByIdService
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : view Survey By Id Service entered by surveyor from the database.
	  ****************************************************************************************************************************/ 
	@Override
	public Survey viewSurveyByIdService(long id) {
		logger.info("viewSurveyByIdService");
		Survey a = rr.findSurveyById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Survey not found for this id :: "+ id);
		}
		return a;
	}

	
	/****************************************************************************************************************************
	 - Method Name      : updateSurveyService
	 - Input Parameters : Survey s, long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : deleting the survey information entered by surveyor   from  the database.
	  ****************************************************************************************************************************/ 
	@Override
	public Survey updateSurveyService(Survey s, long id) throws ResourceNotFoundException {
	
		logger.info("updateSurveyService");
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));

		String str = "Active";
		Survey sur = new Survey();
		sur = a;
		String str1 =  sur.getStatus();
		if(str.equals(str1)) {
			throw new ResourceNotFoundException("Stop distribution of survey before updating it :: "+ id);
		}
	
		s.setSid(a.getSid());
	
		final Survey updatedA= rr.save(s);
		
		return updatedA;
	}

	
	
	/****************************************************************************************************************************
	 - Method Name      : deleteSurveyByIdService
	 - Input Parameters : long id
	 - Return type      : String
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : deleting the survey information entered by surveyor   from  the database.
	  ****************************************************************************************************************************/ 
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

	/****************************************************************************************************************************
	 - Method Name      : listAllSurveyService
	 - Input Parameters : 
	 - Return type      : List<Survey>
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : display all the surveys present into  the database.
	  ****************************************************************************************************************************/ 
	@Override
	public List<Survey> listAllSurveyService() {
		logger.info("listAllSurveyService");
		return rr.findAll();
	}


	/****************************************************************************************************************************
	 - Method Name      : distributeSurvey
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : distribute the surveys present into  the database.
	  ****************************************************************************************************************************/ 
	@Override
	public Survey distributeSurvey(long id) throws ResourceNotFoundException {
		logger.info("distributeSurveyService");
		Survey s = new Survey();
			Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
				s = a;
				s.setSid(a.getSid());
				s.setStatus("Active");
				
				
				final Survey updatedA= rr.save(s);
				return updatedA;
	}
	

	/****************************************************************************************************************************
	 - Method Name      : stopSurvey
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : stop distributing the survey present into  the database.
	  ****************************************************************************************************************************/ 
	@Override
	public Survey stopSurvey(long id) throws ResourceNotFoundException {
		logger.info("stopDistributeSurvey");
		Survey s = new Survey();
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
		s=a;
		s.setSid(a.getSid());
		s.setStatus("Passive");
		
		final Survey updatedA= rr.save(s);
		return updatedA;
	}
	
}
