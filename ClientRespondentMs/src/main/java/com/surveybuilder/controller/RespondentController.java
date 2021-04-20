package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

import com.surveybuilder.dto.Answer;
import com.surveybuilder.entity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.RespondentService;

import io.swagger.annotations.Api;


@Api(description =  "Rest API for Respondent Controller")
@RestController
@RequestMapping("/respondentms")
public class RespondentController {

	public static final Logger logger = LoggerFactory.getLogger(RespondentController.class);

	
	@Autowired
	RespondentService rs;
	
	
	@Autowired
	RestTemplate rest;	
	
	
	
	
//authentication of respondent
	@GetMapping("authRespondent/{emailId}/{pass}")
	public String authRespondentController(@PathVariable("emailId") String emailId, @PathVariable("pass") String pass){
		logger.info("authRespondent controller");
		if( rs.authRespondent(emailId, pass) != null)
			return "Login successful";
		else
			return "Login failed.. pls check emailId and password";
	}
	
	//create respondent controller
	@PostMapping("createRespondent")
	public Respondent createRespondentController(@Valid @RequestBody Respondent s) {
		logger.info("create respondent controller");
		return rs.createRespondentService(s);
	}
	
	//viewRespondentById
	@GetMapping("viewRespondentById/{id}")
	public Respondent viewRespondentByIdController(@PathVariable("id") Long id){
		logger.info("viewRespondentById controller");
		Respondent r = rs.viewRespondentByIdService(id);
		return r;
	}
	
	//update respondent by id
	@PutMapping("updateRespondent/{id}")
	public Respondent updateRespondentController(@RequestBody Respondent s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("update respondent by id");
		return rs.updateRespondentService(s, id);
	}
	
	//delete respondent by id
	@DeleteMapping("deleteRespondentById/{id}")
	public String deleteRespondentByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("delete respondent by id controller");
		if(rs.deleteRespondentByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	//list all respondent
	@GetMapping("listAllRespondent")
	public List<Respondent> listAllRespondentController(){
		logger.info("get list of all respondents");
		return rs.listAllRespondentService();
	}
	

	//get all survey using resttemplate
	@GetMapping(value = "/viewallsurveys")
	public ResponseEntity<String> viewAllSurvey() {
		logger.info("get all surveys from admin controller");
		String survey = rest.getForObject("http://localhost/survey/survey/viewallsurveystatus", String.class);
		return ResponseEntity.ok(survey);
	}
	
	@PostMapping(value = "/createAnswer")
	public String addAnswer(@RequestBody Answer answer) {
		return rs.createAnswerService(answer);
			}
}
