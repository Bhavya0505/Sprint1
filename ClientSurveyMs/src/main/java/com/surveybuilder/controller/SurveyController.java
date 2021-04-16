package com.surveybuilder.controller;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/survey")
public class SurveyController {

	public static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	
	@Autowired
	SurveyService ss;

	//getAllSurveyController
	@GetMapping("/AllSurvey")
	public List<Survey> getAllSurveyController(){
		logger.info("getAllSurveyController");
		return ss.listAllSurveyService();
	}
	
	//createSurveyController
	@PostMapping("/createSurvey")
	public Survey createSurveyController(@RequestBody Survey survey) {
		logger.info("createSurveyController");
		return ss.createSurveyService(survey);	
	}
	
	//viewSurveyByIdController
	@GetMapping("viewSurveyById/{id}")
	public Survey viewSurveyByIdController(@PathVariable("id") Long id){
		logger.info("viewSurveyByIdController");
	return ss.viewSurveyByIdService(id);
	}
	
	//updateSurvey Controller
	@PutMapping("updateSurvey/{id}")
	public Survey updateSurveyController(@RequestBody Survey survey,@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("updateSurveyController");
		return ss.updateSurveyService(survey,id);
	}
	

	//deleteSurveyByIdController
	@DeleteMapping("deleteSurveyById/{id}")
	public String deleteSurveyByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteSurveyByIdController");
		if(ss.deleteSurveyByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	//in case we have to update the survey first we need to stop the distribution of survey
	//it changes status from active to passive 
	@PutMapping("stopSurvey/{id}")
	public Survey stopSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("stopDistribution of survey");
		return ss.stopSurvey(id);
	}
	
	//to change the status of survey from passive to active
	@PutMapping("startSurvey/{id}")
	public Survey startSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("start distribution of survey");
		return ss.distributeSurvey(id);
	}
}
