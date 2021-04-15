package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

	

	@Autowired
	private AdminService as ;
	
	@GetMapping("authAdmin/{id}/{pass}")
	public String authAdminController(@PathVariable("id") long id, @PathVariable("pass") String pass){
		
		if( as.authAdmin(id, pass) != null)
			return "Login Successful";
		else
			return "Login failed";
	}
	

	@PostMapping("createAdmin")
	public Admin createAdminController(@Valid @RequestBody Admin s) {
		return as.createAdminService(s);
	}
	
	@GetMapping("viewAdminById/{id}")
	public Admin viewAdminByIdController(@PathVariable("id") long id){
		Admin a = as.viewAdminByIdService(id);
		Admin a1 = new Admin();
		a1.setAdminId(a.getAdminId());
		a1.setEmailId(a.getEmailId());
		a1.setName(a.getName());
		a1.setPassword(a.getPassword());
		return a1;
	}
	
	@PutMapping("updateAdmin/{id}")
	public Admin updateAdminController(@RequestBody Admin s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return as.updateAdminService(s, id);
	}
	
	@DeleteMapping("deleteAdminById/{id}")
	public String deleteAdminByIdController(@PathVariable("id") long id) throws ResourceNotFoundException{
		if(as.deleteAdminByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllAdmin")
	public List<Admin> listAllAdminController(){
		List<Admin> lst = new ArrayList<Admin>();
		
		for(Admin a : as.listAllAdminService()) {
			Admin a1 = new Admin();
			a1.setAdminId(a.getAdminId());
			a1.setEmailId(a.getEmailId());
			a1.setName(a.getName());
			a1.setPassword(a.getPassword());
			lst.add(a1);
		}
		
		return lst;
	}
	

}
