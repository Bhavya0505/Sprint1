package com.surveybuilder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.surveybuilder.entity.Question;

public interface questionDao extends JpaRepository<Question, Long>{
	
	@Query("select q from Question q where Survey_fk = ?1")
	public List<Question> getQuestionBySurveyId(long id);
	
}
