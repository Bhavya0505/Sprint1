package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.surveyDao;
import com.surveybuilder.entity.Survey;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class SurveyServiceImpl implements SurveyService{
	@Autowired
	private surveyDao rr;
	
	@Override
	public Survey createSurveyService(Survey s) {
		Survey a = rr.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not save Survey :: ");
		}
		
		return a ;
	}

	@Override
	public Survey viewSurveyByIdService(long id) {
		Survey a = rr.findSurveyById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Survey not found for this id :: "+ id);
		}
		return a;
	}



	@Override
	public boolean deleteSurveyByIdService(long id) throws ResourceNotFoundException {
		
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + id));
		
		rr.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Survey> listAllSurveyService() {
		return rr.findAll();
	}

	@Override
	public Survey updateSurveyService(Survey s, long id) throws ResourceNotFoundException {
	Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSid(a.getSid());
		
		final Survey updatedA= rr.save(s);
		return updatedA;
	}

	@Override
	public Survey distributeSurvey(long id) throws ResourceNotFoundException {
		
		Survey s = new Survey();
			Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
				
				s.setSid(a.getSid());
				s.setStatus("Active");
				s.setTitle(a.getTitle());
				final Survey updatedA= rr.save(s);
				return updatedA;
	}
	
	@Override
	public Survey stopSurvey(long id) throws ResourceNotFoundException {
		Survey s = new Survey();
		Survey a = rr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSid(a.getSid());
		s.setStatus("Passive");
		s.setTitle(a.getTitle());
		final Survey updatedA= rr.save(s);
		return updatedA;
	}
	



}
