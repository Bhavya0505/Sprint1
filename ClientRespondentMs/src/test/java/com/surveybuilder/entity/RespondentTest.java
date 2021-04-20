package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.ClientRespondentMsApplication;
import com.surveybuilder.entity.Respondent;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientRespondentMsApplication.class)
@WebMvcTest(value = Respondent.class)
class RespondentTest {

	private Respondent respondent = new Respondent();
	   
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetRespondentId() {
		long mockId = 101;
		respondent.setRespondentId(mockId);
		long id = respondent.getRespondentId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}

	@Test
	void testSetRespondentId() {
		long mockId = 101;
		respondent.setRespondentId(mockId);
		long id = respondent.getRespondentId();
		
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetName() {
		String mockName = "shah";
		respondent.setName(mockName);
		String name = respondent.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "shah";
		respondent.setName(mockName);
		String name = respondent.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testGetEmailId() {
		String mockEmail = "shah@gmail.com";
		respondent.setEmailId(mockEmail);
		String email = respondent.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testSetEmailId() {
		String mockEmail = "shah@gmail.com";
		respondent.setEmailId(mockEmail);
		String email = respondent.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testGetPassword() {
		String mockPass = "shah123";
		respondent.setPassword(mockPass);
		String pass = respondent.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "shah123";
		respondent.setPassword(mockPass);
		String pass = respondent.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

}
