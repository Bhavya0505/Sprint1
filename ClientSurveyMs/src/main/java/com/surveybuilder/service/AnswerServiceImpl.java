package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.answerDao;
import com.surveybuilder.entity.Answer;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	answerDao ad;
	
	@Override
	public Answer createAnswerService(Answer s) {
		// TODO Auto-generated method stub
		return ad.save(s);
	}

	@Override
	public Answer viewAnswerByIdService(long id) {
		// TODO Auto-generated method stub
		return ad.findAnswerById(id);
	}

	@Override
	public Answer updateAnswerService(Answer s, long id) throws ResourceNotFoundException {
	Answer a = ad.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		s.setAid(a.getAid());
		
		final Answer updatedA= ad.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteAnswerByIdService(long id) throws ResourceNotFoundException {
		Answer a = ad.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer not found for this id :: " + id));
		
		ad.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}
	

	@Override
	public List<Answer> listAllAnswerService() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

}
