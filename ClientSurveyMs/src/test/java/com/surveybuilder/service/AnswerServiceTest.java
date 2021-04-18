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
import com.surveybuilder.dao.answerDao;
import com.surveybuilder.entity.Answer;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientSurveyMsApplication.class)
@WebMvcTest(value = AnswerService.class)
class AnswerServiceTest {

	@Autowired
	private AnswerService answerService;
	   
	@MockBean
	private answerDao answerDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateAnswerController() throws Exception {
		Answer answer = getAnswer();
	   
	    Mockito.when(answerDao.save(Mockito.any(Answer.class))).thenReturn(answer);
	    
	    Answer result = answerService.createAnswerService(answer);
	    
	    assertThat(answer).isEqualTo(result);

	}

	@Test
	void testViewAnswerByIdController() throws Exception {
		
		Answer answer = getAnswer();

	    Mockito.when(answerDao.findAnswerById(Mockito.anyLong())).thenReturn(answer);

	    Answer result = answerService.viewAnswerByIdService(101);
	    
	    assertThat(answer).isEqualTo(result);

	}

	@Test
	void testUpdateAnswerController() throws Exception {
		
		Optional<Answer> a = Optional.of(getAnswer());
		
		
		Answer answer = getAnswer();
	  
	    Mockito.when(answerDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(answerDao.save(Mockito.any(Answer.class))).thenReturn(answer);
	    
	    Answer result = answerService.updateAnswerService(answer, 101);
	    
	    assertThat(answer).isEqualTo(result);
	}

	@Test
	void testDeleteAnswerByIdController() throws Exception {
		Optional<Answer> a = Optional.of(getAnswer());

	    boolean b = true;
	    
	    Mockito.when(answerDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(answerDao).deleteById(Mockito.anyLong());
	    
	    boolean result = answerService.deleteAnswerByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllAnswerController() throws Exception {

		List<Answer> a = new ArrayList<Answer>();
		
		Answer answer = getAnswer();
		a.add(answer);
	    
	    Mockito.when(answerDao.findAll()).thenReturn(a);
	   
	    List<Answer> result = answerService.listAllAnswerService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Answer getAnswer() {
		Answer a = new Answer();
		
		a.setAid(101);
		a.setAns("Answer");
		
		return a;
	}


}
