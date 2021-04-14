package com.surveybuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.questionDao;
import com.surveybuilder.entity.Question;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	questionDao qd;
	
	@Override
	public Question createQuestionService(Question s) {
		// TODO Auto-generated method stub
		return qd.save(s);
	}

	@Override
	public Question viewQuestionByIdService(long id) {
		// TODO Auto-generated method stub
		Optional<Question> que = qd.findById(id);
		return que.get();
	}

	@Override
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Question a = qd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		s.setQid(a.getQid());
		
		final Question updatedA= qd.save(s);
		return updatedA;

	}

	@Override
	public boolean deleteQuestionByIdService(long id) throws ResourceNotFoundException {
		Question a = qd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + id));
		
		qd.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}
	

	@Override
	public List<Question> listAllQuestionService() {
		// TODO Auto-generated method stub
		return qd.findAll();
	}

	@Override
	public List<Question> getQuestionBySurveyIdService(long id) {
		// TODO Auto-generated method stub
		return qd.getQuestionBySurveyId(id);
	}

}
