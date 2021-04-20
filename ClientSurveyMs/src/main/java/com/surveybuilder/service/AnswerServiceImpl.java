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
	
	
	/****************************************************************************************************************************
	 - Method Name      : createAnswerService
	 - Input Parameters :Answer s
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 20-04-2021
	 - Description      : create the Answer information entered by respondent and store into  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Answer createAnswerService(Answer s) {

		logger.info("createAnswerService");
		return ad.save(s);
	}

	/****************************************************************************************************************************
	 - Method Name      : viewAnswerByIdService
	 - Input Parameters :long id
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : view all the answers stored in the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Answer viewAnswerByIdService(long id) {

		logger.info("viewAnswerByIdService");
		return ad.findAnswerById(id);
	}

	/****************************************************************************************************************************
	 - Method Name      : updateAnswerService
	 - Input Parameters :Answer s, long id
	 - Return type      : Answer
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : update the answer information entered by respondent and store into  the database.
	  ****************************************************************************************************************************/ 

	@Override
	public Answer updateAnswerService(Answer s, long id) throws ResourceNotFoundException {
	
		logger.info("updateAnswerService");
		Answer a = ad.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		s.setAid(a.getAid());
		
		final Answer updatedA= ad.save(s);
		return updatedA;
	}

	/****************************************************************************************************************************
	 - Method Name      : deleteAnswerByIdService
	 - Input Parameters : long id
	 - Return type      : boolean
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : delete the answer information entered by respondent from the database.
	  ****************************************************************************************************************************/ 
	
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
	

	/****************************************************************************************************************************
	 - Method Name      : listAllAnswerService
	 - Input Parameters :
	 - Return type      : List<Answer>
	 - Author           : Capgemini
	 - Creation Date    : 21-04-2021
	 - Description      : view all the answers from  the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public List<Answer> listAllAnswerService() {

		logger.info("listAllAnswerService");
		return ad.findAll();
	}

}
