package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entity.Admin;

@Repository
public interface adminDao extends JpaRepository<Admin, Long>{

	@Query("select a from Admin a where a.adminId = ?1")
	public Admin findAdminById(Long id);

	@Query("select a from Admin a where (a.adminId = ?1 and a.password = ?2)")
	public Admin authAdmin(long id, String pass);

}
