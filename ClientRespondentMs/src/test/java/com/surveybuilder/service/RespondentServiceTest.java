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

import com.surveybuilder.ClientRespondentMsApplication;
import com.surveybuilder.dao.RespondentDao;
import com.surveybuilder.entity.Respondent;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientRespondentMsApplication.class)
@WebMvcTest(value = RespondentService.class)
class RespondentServiceTest {


	@Autowired
	private RespondentService respondentService;
	   
	@MockBean
	private RespondentDao respondentDao;


	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateRespondentController() throws Exception {
		Respondent respondent = getRespondent();
	   
	    Mockito.when(respondentDao.save(Mockito.any(Respondent.class))).thenReturn(respondent);
	    
	    Respondent result = respondentService.createRespondentService(respondent);
	    
	    assertThat(respondent).isEqualTo(result);

	}

	@Test
	void testViewRespondentByIdController() throws Exception {
		
		Respondent respondent = getRespondent();

	    Mockito.when(respondentDao.findRespondentById(Mockito.anyLong())).thenReturn(respondent);

	    Respondent result = respondentService.viewRespondentByIdService(101);
	    
	    assertThat(respondent).isEqualTo(result);

	}

	@Test
	void testUpdateRespondentController() throws Exception {
		
		Optional<Respondent> a = Optional.of(getRespondent());
		
		
		Respondent respondent = getRespondent();
	  
	    Mockito.when(respondentDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(respondentDao.save(Mockito.any(Respondent.class))).thenReturn(respondent);
	    
	    Respondent result = respondentService.updateRespondentService(respondent, 101);
	    
	    assertThat(respondent).isEqualTo(result);
	}

	@Test
	void testDeleteRespondentByIdController() throws Exception {
		Optional<Respondent> a = Optional.of(getRespondent());

	    boolean b = true;
	    
	    Mockito.when(respondentDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(respondentDao).deleteById(Mockito.anyLong());
	    
	    boolean result = respondentService.deleteRespondentByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllRespondentController() throws Exception {

		List<Respondent> a = new ArrayList<Respondent>();
		
		Respondent respondent = getRespondent();
		a.add(respondent);
	    
	    Mockito.when(respondentDao.findAll()).thenReturn(a);
	   
	    List<Respondent> result = respondentService.listAllRespondentService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Respondent getRespondent() {
		Respondent a = new Respondent();
		
		a.setRespondentId(101);
		a.setEmailId("shah@gmail.com");
		a.setName("Shah");
		a.setPassword("shah");
		
		return a;
	}


	
}
