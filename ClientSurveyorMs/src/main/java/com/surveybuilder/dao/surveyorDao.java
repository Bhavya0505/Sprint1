package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entity.Surveyor;

@Repository
public interface surveyorDao extends JpaRepository<Surveyor, Long>{

	
	@Query("select a from Surveyor a where (a.emailId = ?1 and a.password = ?2)")
	public Surveyor authSurveyor(String emailId, String pass);

}
