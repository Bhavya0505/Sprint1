package com.surveybuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.questionDao;
import com.surveybuilder.entity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class QuestionServiceImpl implements QuestionService{

	public static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	questionDao qd;
	
	/****************************************************************************************************************************
	 - Method Name      : createQuestionService
	 - Input Parameters :Question s
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : create the question and store it into  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Question createQuestionService(Question s) {

		logger.info("createQuestionService");
		return qd.save(s);
	}

	/****************************************************************************************************************************
	 - Method Name      : viewQuestionByIdService
	 - Input Parameters :long id
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : view question by id from the  the database.
	  ****************************************************************************************************************************/ 

	@Override
	public Question viewQuestionByIdService(long id) {

		logger.info("viewQuestionByIdService");
		Optional<Question> que = qd.findById(id);
		return que.get();
	}

	/****************************************************************************************************************************
	 - Method Name      : updateQuestionService
	 - Input Parameters :Question s, long id
	 - Return type      : Question
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : update the Question and store into  the database.
	  ****************************************************************************************************************************/ 

	@Override
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException {

		logger.info("updateQuestionService");
		Question a = qd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		s.setQid(a.getQid());
		
		final Question updatedA= qd.save(s);
		return updatedA;

	}

	/****************************************************************************************************************************
	 - Method Name      : deleteQuestionByIdService
	 - Input Parameters :boolean
	 - Return type      : long id
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : delete the Question from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public boolean deleteQuestionByIdService(long id) throws ResourceNotFoundException {
		logger.info("deleteQuestionByIdService");
		Question a = qd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		qd.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}
	
	/****************************************************************************************************************************
	 - Method Name      : listAllQuestionService
	 - Input Parameters :
	 - Return type      : List<Question>
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : view all the Question from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public List<Question> listAllQuestionService() {

		logger.info("listAllQuestionService");
		return qd.findAll();
	}


	/****************************************************************************************************************************
	 - Method Name      : getQuestionBySurveyIdService
	 - Input Parameters :long id
	 - Return type      : List<Question>
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : get Question By SurveyId from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public List<Question> getQuestionBySurveyIdService(long id) {

		logger.info("getQuestionBySurveyIdService");
		return qd.getQuestionBySurveyId(id);
	}

}
