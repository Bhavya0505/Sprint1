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

@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	SurveyService ss;
	
	@GetMapping("/AllSurvey")
	public List<Survey> getAllSurveyController(){
		
		return ss.listAllSurveyService();
	}
	
	@PostMapping("/createSurvey")
	public Survey createSurveyController(@RequestBody Survey survey) {
		return ss.createSurveyService(survey);	
	}
	
	@GetMapping("viewSurveyById/{id}")
	public Survey viewSurveyByIdController(@PathVariable("id") Long id){
	return ss.viewSurveyByIdService(id);
	}
	
	@PutMapping("updateSurvey/{id}")
	public Survey updateSurveyController(@RequestBody Survey survey,@PathVariable("id") Long id) throws ResourceNotFoundException {
		return ss.updateSurveyService(survey,id);
	}
	

	@DeleteMapping("deleteSurveyById/{id}")
	public String deleteSurveyByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(ss.deleteSurveyByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@PutMapping("stopSurvey/{id}")
	public Survey stopSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return ss.stopSurvey(id);
	}
	@PutMapping("startSurvey/{id}")
	public Survey startSurveyController(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return ss.distributeSurvey(id);
	}
}
