package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.surveybuilder.dao.adminDao;
import com.surveybuilder.entity.Admin;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{

	public static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	
	@Autowired
	adminDao sr;
	
	//create admin service
	@Override
	public Admin createAdminService(Admin s) {
		Admin a = sr.save(s);
		if(a == null) {
			 new ResourceNotFoundException("Can not create admin profile :: ");
		}
		logger.info("create admin service");
		return a;
	}

	//view admin by id service
	@Override
	public Admin viewAdminByIdService(long id) {
		logger.info("view admin by id service");
	Admin a = sr.findAdminById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Admn not found for this id :: "+ id);
		}
		return a;
	}

	//update admin service
	@Override
	public Admin updateAdminService(Admin s, long id) throws ResourceNotFoundException {
		logger.info("update admin service");
		Admin a = sr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		//Admin a = sr.findAdminById(id);
		
		s.setAdminId(a.getAdminId());
		
		final Admin updatedA= sr.save(s);
		return updatedA;
	}

	
	//delete admin by id service
	@Override
	public boolean deleteAdminByIdService(long id) throws ResourceNotFoundException {
		logger.info("deleteAdminByIdService");
		Admin a = sr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		
		//Admin a = sr.findAdminById(id);
		
		sr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;	
	}

	//list all admin service
	@Override
	public List<Admin> listAllAdminService() {
		logger.info("list all admin service");
		return sr.findAll();
	}

	//authentication service
	@Override
	public Admin authAdmin(long id, String pass) {
		logger.info("authAdmin service");
		return sr.authAdmin(id, pass);
	}

}
