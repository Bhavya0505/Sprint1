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

import com.surveybuilder.ClientSurveyorMsApplication;
import com.surveybuilder.dao.surveyorDao;
import com.surveybuilder.entity.Surveyor;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientSurveyorMsApplication.class)
@WebMvcTest(value = surveyorService.class)
public class SurveyorServiceTest {


	@Autowired
	private surveyorService surveyorService;
	   
	@MockBean
	private surveyorDao surveyorDao;


	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	private Surveyor getSurveyor() {
		Surveyor a = new Surveyor();
		
		a.setSurveyorId(101);
		a.setEmailId("shah@gmail.com");
		a.setName("shah");
		a.setPassword("shah");
		
		return a;
	}
	
	@Test
	void testCreateSurveyorController() throws Exception {
		Surveyor surveyor = getSurveyor();
	   
	    Mockito.when(surveyorDao.save(Mockito.any(Surveyor.class))).thenReturn(surveyor);
	    
	    Surveyor result = surveyorService.createSurveyorService(surveyor);
	    
	    assertThat(surveyor).isEqualTo(result);

	}



	@Test
	void testUpdateSurveyorController() throws Exception {
		
		Optional<Surveyor> a = Optional.of(getSurveyor());
		
		
		Surveyor surveyor = getSurveyor();
	  
	    Mockito.when(surveyorDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(surveyorDao.save(Mockito.any(Surveyor.class))).thenReturn(surveyor);
	    
	    Surveyor result = surveyorService.updateSurveyorService(surveyor, 101);
	    
	    assertThat(surveyor).isEqualTo(result);
	}

	@Test
	void testDeleteSurveyorByIdController() throws Exception {
		Optional<Surveyor> a = Optional.of(getSurveyor());

	    boolean b = true;
	    
	    Mockito.when(surveyorDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(surveyorDao).deleteById(Mockito.anyLong());
	    
	    boolean result = surveyorService.deleteSurveyorByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllSurveyorController() throws Exception {

		List<Surveyor> a = new ArrayList<Surveyor>();
		
		Surveyor surveyor = getSurveyor();
		a.add(surveyor);
	    
	    Mockito.when(surveyorDao.findAll()).thenReturn(a);
	   
	    List<Surveyor> result = surveyorService.listAllSurveyorService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	



	
}
