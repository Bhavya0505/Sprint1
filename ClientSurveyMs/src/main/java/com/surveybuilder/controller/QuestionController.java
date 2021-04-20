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

import com.surveybuilder.entity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.QuestionService;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api(description =  "Rest API of Question Controller.. here we can create,update,delete and search question.")
@RestController
@RequestMapping("/question")
public class QuestionController {

	
	public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	
	@Autowired
	QuestionService ss;
	

	/****************************************************************************************************************************
	 - Method Name      : listAllQuestionController
	 - Input Parameters :
	 - Return type      : List<Question>
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : view all the Question from  the database.
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/viewAllQuestion")
public List<Question> getAllQuestionController(){
		logger.info("getAllQuestionController");
		return ss.listAllQuestionService();
	}
	

	/****************************************************************************************************************************
	 - Method Name      : createQuestionController
	 - Input Parameters :Question s
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : create the question and store it into  the database.
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/createQuestion")
	public Question createQuestionController(@RequestBody Question q) {
		logger.info("createQuestionController");
		return ss.createQuestionService(q);	
	}


	/****************************************************************************************************************************
	 - Method Name      : viewQuestionByIdController
	 - Input Parameters :long id
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : view question by id from the  the database.
	  ****************************************************************************************************************************/ 

	@GetMapping("viewQuestionById/{id}")
	public Question viewQuestionByIdController(@PathVariable("id") Long id){
		logger.info("viewQuestionByIdController");
		Question q = ss.viewQuestionByIdService(id);

		return q;
	}
	
	/****************************************************************************************************************************
	 - Method Name      : updateQuestionController
	 - Input Parameters :Question s, long id
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : update the Question and store into  the database.
	  ****************************************************************************************************************************/ 

	@PutMapping("updateQuestion/{id}")
	public Question updateQuestionController(@RequestBody Question s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("updateQuestionController");
		return ss.updateQuestionService(s, id);
	}
	
	/****************************************************************************************************************************
	 - Method Name      : deleteQuestionByIdController
	 - Input Parameters :boolean
	 - Return type      : long id
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : delete the Question from  the database.
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("deleteQuestionById/{id}")
	public String deleteQuestionByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteQuestionByIdController");
		if(ss.deleteQuestionByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	/****************************************************************************************************************************
	 - Method Name      : getQuestionBySurveyId
	 - Input Parameters :long id
	 - Return type      : List<Question>
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : view survey by id from the  the database.
	  ****************************************************************************************************************************/ 

	@GetMapping("getQuestionBySurveyId/{id}")
	public List<Question> getQuestionBySurveyId(@PathVariable("id") Long id){

		logger.info("getQuestionBySurveyId");
		return ss.getQuestionBySurveyIdService(id);
	}
	

}
