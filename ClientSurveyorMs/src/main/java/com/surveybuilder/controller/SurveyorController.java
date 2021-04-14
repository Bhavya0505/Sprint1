package com.surveybuilder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entity.Surveyor;
import com.surveybuilder.service.surveyorService;

@RestController
@RequestMapping("/surveyor")
public class SurveyorController {

	@Autowired
	surveyorService ss;
	
	@GetMapping("/AllSurveyor")
	public List<Surveyor> getAllSurveyController(){
		
		return ss.listAllSurveyorService();
	}
	
	@PostMapping("/createSurvey")
	public Surveyor createSurveyController(@RequestBody Surveyor surveyor) {
		return ss.createSurveyorService(surveyor);	
	}
}
