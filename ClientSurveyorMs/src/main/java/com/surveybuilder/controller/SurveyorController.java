package com.surveybuilder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.surveybuilder.dto.QuestionDto;
import com.surveybuilder.dto.SurveyDto;
import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.surveyorService;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Api(description =  "Rest API of Surveyor Controller.. surveyor can create survey and question.")
@RestController
@RequestMapping("/surveyor")
public class SurveyorController {

	public static final Logger logger = LoggerFactory.getLogger(SurveyorController.class);

	
	@Autowired
	surveyorService ss;
	
	@Autowired
	RestTemplate rest;	
	
	/****************************************************************************************************************************
	 - Method Name      : listAllSurveyorController
	 - Input Parameters :
	 - Return type      : List<Surveyor>
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : view all the surveyor information from  the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/AllSurveyor")
	public List<Surveyor> getAllSurveyController(){
		logger.info("get all surveyor controller");
		return ss.listAllSurveyorService();
	}
	

	/****************************************************************************************************************************
	 - Method Name      : createSurveyorController
	 - Input Parameters :Surveyor s
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : Create the surveyor information entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/createSurveyor")
	public Surveyor createSurveyController(@Valid @RequestBody Surveyor surveyor) {
		logger.info("create survey");
		return ss.createSurveyorService(surveyor);	
	}

	//authenticate surveyor
	@GetMapping("authSurveyor/{emailId}/{pass}")
	public String authSurveyorController(@PathVariable("emailId") String emailId, @PathVariable("pass") String pass){
		logger.info("auth surveyor");
		Surveyor s = ss.authSurveyor(emailId, pass);
		
		if( s != null) {
			return "login successful";
		}else
			return "login failed";
	}
	

	/****************************************************************************************************************************
	 - Method Name      : viewSurveyorByIdController
	 - Input Parameters : long id
	 - Return type      : Surveyor
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : view the surveyor information entered by surveyor from the database.
	  ****************************************************************************************************************************/ 
	

	@GetMapping("viewSurveyorById/{id}")
	public Surveyor viewSurveyorByIdController(@PathVariable("id") long id){
		logger.info("view by id surveyor controller");
		Surveyor s = ss.viewSurveyorByIdService(id);
		return s;
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateSurveyorController
	 - Input Parameters :Surveyor s, long id
	 - Return type      : Surveyor
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : update the surveyor information entered by surveyor and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@PutMapping("updateSurveyor/{id}")
	public Surveyor updateSurveyorController(@RequestBody Surveyor s, @PathVariable("id") long id) throws ResourceNotFoundException {
	
		logger.info("update surveyor controller");
		return ss.updateSurveyorService(s, id);
	}
	



	/****************************************************************************************************************************
	 - Method Name      : deleteSurveyorByIdController
	 - Input Parameters :long id
	 - Return type      : Boolean
	 - Author           : Capgemini
	 - Creation Date    : 19-04-2021
	 - Description      : Delete the surveyor information entered by surveyor and from  the database.
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("deleteSurveyorById/{id}")
	public String deleteSurveyorByIdController(@PathVariable("id") long id) throws ResourceNotFoundException{
		logger.info("delete surveyor by id");
		if(ss.deleteSurveyorByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";	
	}
	
//get all survey using resttemplate
	@GetMapping(value = "/viewallsurveys")
	public ResponseEntity<String> viewAllSurvey() {
		logger.info("get all surveys from surveyor controller");
		String survey = rest.getForObject("http://localhost/survey/survey/AllSurvey", String.class);
		return ResponseEntity.ok(survey);
	}

	//get all answers using RestTemplate
		@GetMapping(value = "/viewallanswer")
		public ResponseEntity<String> viewAllAnswers() {
			logger.info("get all answers from surveyor controller");
			String survey = rest.getForObject("http://localhost/survey/answer/viewAllAnswer", String.class);
			return ResponseEntity.ok(survey);
		}
		
		@PostMapping(value = "/createSurvey")
		public String addAnswer(@RequestBody SurveyDto answer) {
			return ss.createSurveyrService(answer);
				}
	
		@PostMapping(value = "/createQuestion")
		public String addQuestion(@RequestBody QuestionDto answer) {
			return ss.createQuestionService(answer);
				}
		
}
