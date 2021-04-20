package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class SurveyTest {

	private Survey survey= new Survey();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSid() {
		long mockId = 101;
		survey.setSid(mockId);
		
		long id = survey.getSid();

		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testSetSid() {
		long mockId = 101;
		survey.setSid(mockId);
		
		long id = survey.getSid();

		assertThat(id).isEqualTo(mockId);
	}


	@Test
	void testSetStatus() {
		String mockStatus = "Passive";
		survey.setStatus(mockStatus);
		
		String status = survey.getStatus();

		assertThat(status).isEqualTo(mockStatus);
	}

	@Test
	void testGetSurveyor() {
		Surveyor mockS = new Surveyor();
		mockS.setSurveyorId(501);
		
	
		survey.setSurveyor(mockS);
		
		Surveyor s = survey.getSurveyor();

		assertThat(s).isEqualTo(mockS);
	}


	@Test
	void testGetTitle() {
		String mockTitle = "title";
		survey.setTitle(mockTitle);
		
		String title = survey.getTitle();

		assertThat(title).isEqualTo(mockTitle);
	}

	@Test
	void testSetTitle() {
		String mockTitle = "title";
		survey.setTitle(mockTitle);
		
		String title = survey.getTitle();

		assertThat(title).isEqualTo(mockTitle);
	}



}
