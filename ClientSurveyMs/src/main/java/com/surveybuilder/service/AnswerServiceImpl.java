package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.answerDao;
import com.surveybuilder.entity.Answer;
import com.surveybuilder.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class AnswerServiceImpl implements AnswerService{

	public static final Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);

	
	@Autowired
	answerDao ad;
	
	//createAnswerService
	@Override
	public Answer createAnswerService(Answer s) {

		logger.info("createAnswerService");
		return ad.save(s);
	}

	//viewAnswerByIdService
	@Override
	public Answer viewAnswerByIdService(long id) {

		logger.info("viewAnswerByIdService");
		return ad.findAnswerById(id);
	}

	//updateAnswerService
	@Override
	public Answer updateAnswerService(Answer s, long id) throws ResourceNotFoundException {
	
		logger.info("updateAnswerService");
		Answer a = ad.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		s.setAid(a.getAid());
		
		final Answer updatedA= ad.save(s);
		return updatedA;
	}

	//deleteAnswerByIdService
	@Override
	public boolean deleteAnswerByIdService(long id) throws ResourceNotFoundException {
		logger.info("deleteAnswerByIdService");
		Answer a = ad.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		ad.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}
	

	//listAllAnswerService
	@Override
	public List<Answer> listAllAnswerService() {

		logger.info("listAllAnswerService");
		return ad.findAll();
	}

}
