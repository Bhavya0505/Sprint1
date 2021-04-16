package com.surveybuilder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.surveyorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/surveyor")
public class SurveyorController {

	public static final Logger logger = LoggerFactory.getLogger(SurveyorController.class);

	
	@Autowired
	surveyorService ss;
	
	//print all surveyor
	@GetMapping("/AllSurveyor")
	public List<Surveyor> getAllSurveyController(){
		logger.info("get all surveyor controller");
		return ss.listAllSurveyorService();
	}
	
	//create survey
	@PostMapping("/createSurvey")
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
	
	//view surveyor by id
	@GetMapping("viewSurveyorById/{id}")
	public Surveyor viewSurveyorByIdController(@PathVariable("id") long id){
		logger.info("view by id surveyor controller");
		Surveyor s = ss.viewSurveyorByIdService(id);
		return s;
	}
	
	//updateSurveyor
	@PutMapping("updateSurveyor/{id}")
	public Surveyor updateSurveyorController(@RequestBody Surveyor s, @PathVariable("id") long id) throws ResourceNotFoundException {
	
		logger.info("update surveyor controller");
		return ss.updateSurveyorService(s, id);
	}
	
	//delete surveyor by id
	@DeleteMapping("deleteSurveyorById/{id}")
	public String deleteSurveyorByIdController(@PathVariable("id") long id) throws ResourceNotFoundException{
		logger.info("delete surveyor by id");
		if(ss.deleteSurveyorByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";	
	}

	
}
