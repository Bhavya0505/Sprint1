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
	
	//createQuestionService
	@Override
	public Question createQuestionService(Question s) {

		logger.info("createQuestionService");
		return qd.save(s);
	}

	//viewQuestionByIdService
	@Override
	public Question viewQuestionByIdService(long id) {

		logger.info("viewQuestionByIdService");
		Optional<Question> que = qd.findById(id);
		return que.get();
	}

	//updateQuestionService
	@Override
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException {

		logger.info("updateQuestionService");
		Question a = qd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		s.setQid(a.getQid());
		
		final Question updatedA= qd.save(s);
		return updatedA;

	}

	//deleteQuestionByIdService
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
	

	//get list of AllQuestionService
	@Override
	public List<Question> listAllQuestionService() {

		logger.info("listAllQuestionService");
		return qd.findAll();
	}

	//getQuestionBySurveyIdService
	@Override
	public List<Question> getQuestionBySurveyIdService(long id) {

		logger.info("getQuestionBySurveyIdService");
		return qd.getQuestionBySurveyId(id);
	}

}
