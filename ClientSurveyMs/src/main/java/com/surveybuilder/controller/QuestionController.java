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

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService ss;
	
	@GetMapping("/findall")
public List<Question> getAllQuestionController(){
		
		return ss.listAllQuestionService();
	}
	
	@PostMapping("/createQuestion")
	public Question createQuestionController(@RequestBody Question q) {
		return ss.createQuestionService(q);	
	}

	@GetMapping("viewQuestionById/{id}")
	public Question viewQuestionByIdController(@PathVariable("id") Long id){
		Question q = ss.viewQuestionByIdService(id);

		return q;
	}
	
	@PutMapping("updateQuestion/{id}")
	public Question updateQuestionController(@RequestBody Question s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return ss.updateQuestionService(s, id);
	}
	
	@DeleteMapping("deleteQuestionById/{id}")
	public String deleteQuestionByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(ss.deleteQuestionByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}

	@GetMapping("getQuestionBySurveyId/{id}")
	public List<Question> getQuestionBySurveyId(@PathVariable("id") Long id){

		return ss.getQuestionBySurveyIdService(id);
	}
	

}
