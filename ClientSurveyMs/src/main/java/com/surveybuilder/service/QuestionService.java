package com.surveybuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surveybuilder.entity.*;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public interface QuestionService {
	public Question createQuestionService(Question s);
	public Question viewQuestionByIdService(long id);
	public Question updateQuestionService(Question s, long id) throws ResourceNotFoundException ;
	public boolean deleteQuestionByIdService(long id) throws ResourceNotFoundException ;
	public List<Question> listAllQuestionService();
	public List<Question> getQuestionBySurveyIdService(long id);
}
