package com.surveybuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.RespondentService;

@RestController
@RequestMapping("/respondentms")
public class RespondentController {

	@Autowired
	RespondentService rs;
	

	@GetMapping("authRespondent/{emailId}/{pass}")
	public String authRespondentController(@PathVariable("emailId") String emailId, @PathVariable("pass") String pass){
		if( rs.authRespondent(emailId, pass) != null)
			return "Login successful";
		else
			return "Login failed.. pls check emailId and password";
	}
	
	@PostMapping("createRespondent")
	public Respondent createRespondentController(@RequestBody Respondent s) {
		return rs.createRespondentService(s);
	}
	
	@GetMapping("viewRespondentById/{id}")
	public Respondent viewRespondentByIdController(@PathVariable("id") Long id){
		
		Respondent r = rs.viewRespondentByIdService(id);
		Respondent r1 = new Respondent();
		r1.setEmailId(r.getEmailId());
		r1.setName(r.getName());
		r1.setPassword(r.getPassword());
		r1.setRespondentId(r.getRespondentId());
		return r1;
	}
	
	@PutMapping("updateRespondent/{id}")
	public Respondent updateRespondentController(@RequestBody Respondent s, @PathVariable("id") long id) throws ResourceNotFoundException {
		return rs.updateRespondentService(s, id);
	}
	
	@DeleteMapping("deleteRespondentById/{id}")
	public String deleteRespondentByIdController(@PathVariable("id") Long id) throws ResourceNotFoundException{
		if(rs.deleteRespondentByIdService(id))
			return "Record deleted Successfully";
		else
			return "Can not delete record";
	}
	
	@GetMapping("listAllRespondent")
	public List<Respondent> listAllRespondentController(){
		
		List<Respondent> lst = new ArrayList<Respondent>();
		
		for(Respondent a : rs.listAllRespondentService()) {
			Respondent a1 = new Respondent();
			a1.setRespondentId(a.getRespondentId());
			a1.setEmailId(a.getEmailId());
			a1.setName(a.getName());
			a1.setPassword(a.getPassword());
			lst.add(a1);
		}
		
		return lst;
	}
	

}
