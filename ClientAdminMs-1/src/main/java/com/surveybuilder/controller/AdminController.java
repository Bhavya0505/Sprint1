package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.surveybuilder.entity.*;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);	

	@Autowired
	private AdminService as ;
	
	//authentication of admin
	@GetMapping("authAdmin/{id}/{pass}")
	public String authAdminController(@PathVariable("id") long id, @PathVariable("pass") String pass){
		logger.info("admin authentication controller");
		if( as.authAdmin(id, pass) != null)
			return "Login Successful";
		else
			return "Login failed";
	}
	

	//create admin
	@PostMapping("createAdmin")
	public Admin createAdminController(@Valid @RequestBody Admin s) {
		logger.info("admin controller createadmin");
		return as.createAdminService(s);
	}
	
	//view admin data by id
	@GetMapping("viewAdminById/{id}")
	public Admin viewAdminByIdController(@PathVariable("id") long id){
		logger.info("admin controller viewbyid");
		Admin a = as.viewAdminByIdService(id);
		return a;
	}
	
	//update admin data by id
	@PutMapping("updateAdmin/{id}")
	public Admin updateAdminController(@RequestBody Admin s, @PathVariable("id") long id) throws ResourceNotFoundException {
		logger.info("updateAdmin admin controller");
		return as.updateAdminService(s, id);
	}
	
	//delete by id
	@DeleteMapping("deleteAdminById/{id}")
	public String deleteAdminByIdController(@PathVariable("id") long id) throws ResourceNotFoundException{
		logger.info("adminController delete by id");
		if(as.deleteAdminByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	//get all admin
	@GetMapping("listAllAdmin")
	public List<Admin> listAllAdminController(){
		logger.info("listAllAdmin AdminController");
		return as.listAllAdminService();
	}
	

}
