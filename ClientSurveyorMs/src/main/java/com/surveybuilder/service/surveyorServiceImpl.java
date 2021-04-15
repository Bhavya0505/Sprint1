package com.surveybuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.surveyorDao;
import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
public class surveyorServiceImpl implements surveyorService{

	@Autowired
	surveyorDao sd;

	@Override
	public Surveyor createSurveyorService(Surveyor s) {
	Surveyor a = sd.save(s);
		
		if(a == null) {
			 new ResourceNotFoundException("Can not create surveyor profile :: ");
		}
		
		return a ;
	}

	@Override
	public Surveyor viewSurveyorByIdService(long id) {
		// TODO Auto-generated method stub
		Optional<Surveyor> s= sd.findById(id);
		return s.get();
	}

	@Override
	public Surveyor updateSurveyorService(Surveyor s, long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
	Surveyor a = sd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		s.setSurveyorId(a.getSurveyorId());
		
		final Surveyor updatedA= sd.save(s);
		return updatedA;
	
	}

	@Override
	public boolean deleteSurveyorByIdService(long id) throws ResourceNotFoundException {

		Surveyor a = sd.findById(id).orElseThrow(() -> new ResourceNotFoundException("Surveyor not found for this id :: " + id));
		
		sd.deleteById(id);
		
		if(a == null)
			return false;
		else
			return true;
		
	}

	@Override
	public List<Surveyor> listAllSurveyorService() {
		// TODO Auto-generated method stub
		return sd.findAll();
	}

	@Override
	public Surveyor authSurveyor(String emailId, String pass) {
		// TODO Auto-generated method stub
		return sd.authSurveyor(emailId, pass);
	}
	
	
}

