package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.adminDao;
import com.surveybuilder.entity.Admin;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	adminDao sr;
	
	@Override
	public Admin createAdminService(Admin s) {
		Admin a = sr.save(s);
		if(a == null) {
			 new ResourceNotFoundException("Can not create admin profile :: ");
		}
		return a;
	}

	@Override
	public Admin viewAdminByIdService(long id) {
	Admin a = sr.findAdminById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Admn not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Admin updateAdminService(Admin s, long id) throws ResourceNotFoundException {
		Admin a = sr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		//Admin a = sr.findAdminById(id);
		
		s.setAdminId(a.getAdminId());
		
		final Admin updatedA= sr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteAdminByIdService(long id) throws ResourceNotFoundException {
		Admin a = sr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
		
		//Admin a = sr.findAdminById(id);
		
		sr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;	
	}

	@Override
	public List<Admin> listAllAdminService() {
		return sr.findAll();
	}

	@Override
	public Admin authAdmin(long id, String pass) {
		return sr.authAdmin(id, pass);
	}

}
