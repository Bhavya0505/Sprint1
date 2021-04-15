package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.surveybuilder.entity.Answer;

public interface answerDao extends JpaRepository<Answer, Long>{
	@Query("select a from Answer a where a.aid = ?1")
	public Answer findAnswerById(Long id);

}
