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
import com.surveybuilder.dao.questionDao;
import com.surveybuilder.entity.Question;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientSurveyMsApplication.class)
@WebMvcTest(value = QuestionService.class)
class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;
	   
	@MockBean
	private questionDao questionDao;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateQuestionController() throws Exception {
		Question question = getQuestion();
	   
	    Mockito.when(questionDao.save(Mockito.any(Question.class))).thenReturn(question);
	    
	    Question result = questionService.createQuestionService(question);
	    
	    assertThat(question).isEqualTo(result);

	}



	@Test
	void testUpdateQuestionController() throws Exception {
		
		Optional<Question> a = Optional.of(getQuestion());
		
		
		Question question = getQuestion();
	  
	    Mockito.when(questionDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(questionDao.save(Mockito.any(Question.class))).thenReturn(question);
	    
	    Question result = questionService.updateQuestionService(question, 101);
	    
	    assertThat(question).isEqualTo(result);
	}

	@Test
	void testDeleteQuestionByIdController() throws Exception {
		Optional<Question> a = Optional.of(getQuestion());

	    boolean b = true;
	    
	    Mockito.when(questionDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(questionDao).deleteById(Mockito.anyLong());
	    
	    boolean result = questionService.deleteQuestionByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllQuestionController() throws Exception {

		List<Question> a = new ArrayList<Question>();
		
		Question question = getQuestion();
		a.add(question);
	    
	    Mockito.when(questionDao.findAll()).thenReturn(a);
	   
	    List<Question> result = questionService.listAllQuestionService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Question getQuestion() {
		Question a = new Question();
		
		a.setQid(101);
		a.setQuestion("Question 1");
		a.setOption1("option1");
		a.setOption2("option2");
		a.setOption3("option3");
		a.setOption4("option4");

		return a;
	}


}
