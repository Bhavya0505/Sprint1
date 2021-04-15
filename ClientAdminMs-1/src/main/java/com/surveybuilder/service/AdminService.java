package com.surveybuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surveybuilder.entity.*;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public interface AdminService {

	public Admin createAdminService(Admin s);
	public Admin viewAdminByIdService(long id);
	public Admin updateAdminService(Admin s, long id) throws ResourceNotFoundException;
	public boolean deleteAdminByIdService(long id) throws ResourceNotFoundException;
	public List<Admin> listAllAdminService();
	public Admin authAdmin(long id, String pass);
	
}
