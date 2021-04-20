package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.surveybuilder.dao.RespondentDao;
import com.surveybuilder.dto.Answer;
import com.surveybuilder.entity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class RespondentServiceImpl implements RespondentService{

	public static final Logger logger = LoggerFactory.getLogger(RespondentServiceImpl.class);

	
	@Autowired
	RespondentDao rr;

	//createRespondentService
	@Override
	public Respondent createRespondentService(Respondent s) {
		logger.info("createRespondentService");
		Respondent a = rr.save(s);
		if(a == null) {
			 new ResourceNotFoundException("Can not create Respondent :: ");
		}
		
		return a ;
	}

	//viewRespondentByIdService
	@Override
	public Respondent viewRespondentByIdService(long id) {
		logger.info("viewRespondentByIdService");
	Respondent a = rr.findRespondentById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Respondent not found for this id :: "+ id);
		}
		return a;
	}

	//updateRespondentService
	@Override
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException {

		logger.info("updateRespondentService");
		Respondent a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		s.setRespondentId(a.getRespondentId());
		
		final Respondent updatedA= rr.save(s);
		return updatedA;
	}

	//deleteRespondentByIdService
	@Override
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException {
	
		logger.info("deleteRespondentByIdService");
		
		Respondent a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	//listAllRespondentService
	@Override
	public List<Respondent> listAllRespondentService() {
		logger.info("get listof all respondent service");
		return rr.findAll();
	}

	//auth respondent
	@Override
	public Respondent authRespondent(String emailId, String pass) {
		logger.info("authentication of respondent");
		return rr.authRespondent(emailId, pass);
	}

	@Autowired
	RestTemplate rest;
	
	@Override
	public String createAnswerService(Answer ans) {

		String url = "http://localhost/survey/answer/createAnswer";

			String a = rest.postForObject(url, ans, String.class);
			//rest.postForObject(url, object, class)
			
			return a;
			
		}
	
	}