package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entity.*;

@Repository
public interface RespondentDao extends JpaRepository<Respondent, Long>{

	@Query("select r from Respondent r where r.respondentId = ?1")
	public Respondent findRespondentById(Long id);


	@Query("select a from Respondent a where (a.emailId  = ?1 and a.password = ?2)")
	public Respondent authRespondent(String emailId, String pass);
	
}
