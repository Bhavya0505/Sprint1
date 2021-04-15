package com.surveybuilder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surveybuilder.entity.Respondent;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public interface RespondentService {

	public Respondent createRespondentService(Respondent s);
	public Respondent viewRespondentByIdService(long id);
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException;
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException;
	public List<Respondent> listAllRespondentService();
	public Respondent authRespondent(String emailId, String pass);
}
