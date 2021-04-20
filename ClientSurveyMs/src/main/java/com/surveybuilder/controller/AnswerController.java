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

import com.surveybuilder.entity.Answer;
import com.surveybuilder.entity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.AnswerService;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api(description =  "Rest API for Answer Controller.. here we can create,update,delete or search the answers.")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	public static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

	
	@Autowired
	AnswerService as;
	
	

	/****************************************************************************************************************************
	 - Method Name      : listAllAnswerController
	 - Input Parameters :
	 - Return type      : List<Answer>
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : view all the answers from  the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/viewAllAnswer")
	public List<Answer> getAllAnswerController(){
		logger.info("getAllAnswers Controller");
		return as.listAllAnswerService();
	}
	
	/****************************************************************************************************************************
	 - Method Name      : createAnswerController
	 - Input Parameters :Answer s
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : create the Answer information entered by respondent and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/createAnswer")
	public Answer createAnswerController(@RequestBody Answer a) {
		logger.info("createAnswerController");
		return as.createAnswerService(a);	
	}

	/****************************************************************************************************************************
	 - Method Name      : viewAnswerByIdController
	 - Input Parameters :long id
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : view all the answers stored in the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("viewAnswerById/{id}")
	public Answer viewAnswerByIdController(@PathVariable("id") Long id){
		
		logger.info("viewAnswerByIdController");
		
		Answer a = as.viewAnswerByIdService(id);
		Answer a1 = new Answer();
		a1.setAid(a.getAid());
		a1.setAns(a.getAns());
		return a1;
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateAnswerController
	 - Input Parameters :Answer s, long id
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : update the answer information entered by respondent and store into  the database.
	  ****************************************************************************************************************************/ 

	@PutMapping("updateAnswer/{id}")
	public Answer updateAnswerController(@RequestBody Answer s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("updateAnswerController");
		return as.updateAnswerService(s, id);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : deleteAnswerByIdController
	 - Input Parameters : long id
	 - Return type      : boolean
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : delete the answer information entered by respondent from the database.
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("deleteAnswerById/{id}")
	public String deleteAnswerByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteAnswerByIdController");
		if(as.deleteAnswerByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}



	
}
