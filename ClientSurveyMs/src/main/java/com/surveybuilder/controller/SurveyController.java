package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.SurveyService;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api(description =  "Rest API of Survey Controller.. here we can create,update,delete and search survey.")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	public static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	
	@Autowired
	SurveyService ss;

	/****************************************************************************************************************************
	 - Method Name      : getAllSurveyController
	 - Input Parameters : 
	 - Return type      : List<Survey>
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : Retrive all the surveys present into  the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/AllSurvey")
	public List<Survey> getAllSurveyController(){
		logger.info("getAllSurveyController");
		return ss.listAllSurveyService();
	}
	

	/****************************************************************************************************************************
	 - Method Name      : createSurvey
	 - Input Parameters : Survey s
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : Inserting the survey information entered by surveyor   into  the database.
	  ****************************************************************************************************************************/ 

	@PostMapping("/createSurvey")
	public Survey createSurveyController(@RequestBody Survey survey) {
		logger.info("createSurveyController");
		return ss.createSurveyService(survey);	
	}
	
	/****************************************************************************************************************************
	 - Method Name      : viewSurveyByIdController
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : view Survey By Id Service entered by surveyor from the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("viewSurveyById/{id}")
	public Survey viewSurveyByIdController(@PathVariable("id") Long id){
		logger.info("viewSurveyByIdController");
	return ss.viewSurveyByIdService(id);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateSurveyController
	 - Input Parameters : Survey s, long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : deleting the survey information entered by surveyor   from  the database.
	  ****************************************************************************************************************************/ 
	
	@PutMapping("updateSurvey/{id}")
	public Survey updateSurveyController(@RequestBody Survey survey,@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("updateSurveyController");
		return ss.updateSurveyService(survey,id);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : deleteSurveyByIdController
	 - Input Parameters : long id
	 - Return type      : String
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : deleting the survey information entered by surveyor   from  the database.
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("deleteSurveyById/{id}")
	public String deleteSurveyByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteSurveyByIdController");
		if(ss.deleteSurveyByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	/****************************************************************************************************************************
	 - Method Name      : stopSurveyController
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : stop distributing the survey present into  the database.
	  ****************************************************************************************************************************/ 
	
	@PutMapping("stopSurvey/{id}")
	public Survey stopSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("stopDistribution of survey");
		return ss.stopSurvey(id);
	}
	

	/****************************************************************************************************************************
	 - Method Name      : startSurveyController
	 - Input Parameters : long id
	 - Return type      : Survey
	 - Author           : Bhavya Shah
	 - Creation Date    : 19-04-2021
	 - Description      : distribute the surveys present into  the database.
	  ****************************************************************************************************************************/ 
	
	@PutMapping("startSurvey/{id}")
	public Survey startSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("start distribution of survey");
		return ss.distributeSurvey(id);
	}
	

	/****************************************************************************************************************************
	 - Method Name      : viewOnlyAllSurveyController
	 - Input Parameters : 
	 - Return type      : List<Survey>
	 - Author           : capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : Retrive only sid,title and status of all the surveys from the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("viewallsurveystatus")
	public List<Survey> viewOnlyAllSurveyController(){
		List<Survey> lst = new ArrayList<Survey>();
		
		for(Survey s : ss.listAllSurveyService()) {
			Survey s1 = new Survey();
			
			s1.setSid(s.getSid());
			s1.setTitle(s.getTitle());
			s1.setStatus(s.getStatus());

			lst.add(s1);
		}
		
		return lst;
	}
}
