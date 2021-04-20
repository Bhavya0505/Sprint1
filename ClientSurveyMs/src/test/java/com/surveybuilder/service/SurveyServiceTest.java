package com.surveybuilder.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.ClientSurveyMsApplication;
import com.surveybuilder.dao.surveyDao;
import com.surveybuilder.entity.Survey;




@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientSurveyMsApplication.class)
@WebMvcTest(value = SurveyService.class)
class SurveyServiceTest {

	@Autowired
	private SurveyService surveyService;
	   
	@MockBean
	private surveyDao surveyDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateSurveyController() throws Exception {
		Survey survey = getSurvey();
	   
	    Mockito.when(surveyDao.save(Mockito.any(Survey.class))).thenReturn(survey);
	    
	    Survey result = surveyService.createSurveyService(survey);
	    
	    assertThat(survey).isEqualTo(result);

	}

	@Test
	void testViewSurveyByIdController() throws Exception {
		
		Survey survey = getSurvey();

	    Mockito.when(surveyDao.findSurveyById(Mockito.anyLong())).thenReturn(survey);

	    Survey result = surveyService.viewSurveyByIdService(101);
	    
	    assertThat(survey).isEqualTo(result);

	}



	@Test
	void testDeleteSurveyByIdController() throws Exception {
		Optional<Survey> a = Optional.of(getSurvey());

	    boolean b = true;
	    
	    Mockito.when(surveyDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(surveyDao).deleteById(Mockito.anyLong());
	    
	    boolean result = surveyService.deleteSurveyByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllSurveyController() throws Exception {

		List<Survey> a = new ArrayList<Survey>();
		
		Survey survey = getSurvey();
		a.add(survey);
	    
	    Mockito.when(surveyDao.findAll()).thenReturn(a);
	   
	    List<Survey> result = surveyService.listAllSurveyService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Survey getSurvey() {
Survey a = new Survey();
		
		a.setSid(101);
		a.setTitle("Survey");
		a.setStatus("passive");

		return a;
	}


}
