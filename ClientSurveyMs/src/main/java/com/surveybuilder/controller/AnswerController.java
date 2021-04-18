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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	public static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

	
	@Autowired
	AnswerService as;
	
	
	//getAllAnswers controller
	@GetMapping("/Allanswer")
	public List<Answer> getAllAnswerController(){
		logger.info("getAllAnswers Controller");
		return as.listAllAnswerService();
	}
	
	//createAnswerController
	@PostMapping("/createAnswer")
	public Answer createAnswerController(@RequestBody Answer a) {
		logger.info("createAnswerController");
		return as.createAnswerService(a);	
	}

	//viewAnswerByIdController
	@GetMapping("viewAnswerById/{id}")
	public Answer viewAnswerByIdController(@PathVariable("id") Long id){
		
		logger.info("viewAnswerByIdController");
		
		Answer a = as.viewAnswerByIdService(id);
		Answer a1 = new Answer();
		a1.setAid(a.getAid());
		a1.setAns(a.getAns());
		return a1;
	}
	
	//updateAnswerController
	@PutMapping("updateAnswer/{id}")
	public Answer updateAnswerController(@RequestBody Answer s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("updateAnswerController");
		return as.updateAnswerService(s, id);
	}
	
	//deleteAnswerByIdController
	@DeleteMapping("deleteAnswerById/{id}")
	public String deleteAnswerByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		logger.info("deleteAnswerByIdController");
		if(as.deleteAnswerByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	//@PostMapping
	//public String addAnswer(@RequestBody Answer answer) {
		//return service.addFlight(flight);
		//	}

	
}
