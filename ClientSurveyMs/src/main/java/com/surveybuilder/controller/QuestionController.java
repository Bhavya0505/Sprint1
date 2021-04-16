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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/question")
public class QuestionController {

	
	public static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	
	@Autowired
	QuestionService ss;
	
	//get all questions
	@GetMapping("/findall")
public List<Question> getAllQuestionController(){
		logger.info("getAllQuestionController");
		return ss.listAllQuestionService();
	}
	
	//createQuestionController
	@PostMapping("/createQuestion")
	public Question createQuestionController(@RequestBody Question q) {
		logger.info("createQuestionController");
		return ss.createQuestionService(q);	
	}

	//viewQuestionByIdController
	@GetMapping("viewQuestionById/{id}")
	public Question viewQuestionByIdController(@PathVariable("id") Long id){
		logger.info("viewQuestionByIdController");
		Question q = ss.viewQuestionByIdService(id);

		return q;
	}
	
	//updateQuestionController
	@PutMapping("updateQuestion/{id}")
	public Question updateQuestionController(@RequestBody Question s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("updateQuestionController");
		return ss.updateQuestionService(s, id);
	}
	
	//deleteQuestionByIdController
	@DeleteMapping("deleteQuestionById/{id}")
	public String deleteQuestionByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteQuestionByIdController");
		if(ss.deleteQuestionByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	//getQuestionBySurveyId
	@GetMapping("getQuestionBySurveyId/{id}")
	public List<Question> getQuestionBySurveyId(@PathVariable("id") Long id){

		logger.info("getQuestionBySurveyId");
		return ss.getQuestionBySurveyIdService(id);
	}
	

}
