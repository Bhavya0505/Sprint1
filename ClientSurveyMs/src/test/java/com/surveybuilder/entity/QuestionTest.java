package com.surveybuilder.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class QuestionTest {

	private Question q = new Question();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSurvey() {
		Survey mockS = new Survey();
		mockS.setSid(501);

		
		q.setSurvey(mockS);
		
		Survey s = q.getSurvey();
		assertThat(s).isEqualTo(mockS);
	}

	@Test
	void testSetSurvey() {
		Survey mockS = new Survey();
		mockS.setSid(501);

		
		q.setSurvey(mockS);
		
		Survey s = q.getSurvey();
		assertThat(s).isEqualTo(mockS);
	}



	@Test
	void testGetQid() {
		long mockId = 101;
		q.setQid(mockId);
		
		long id = q.getQid();
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testSetQid() {
		long mockId = 101;
		q.setQid(mockId);
		
		long id = q.getQid();
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testSetQuestion() {
		String mockQue = "Que1";
		q.setQuestion(mockQue);
		
		String que = q.getQuestion();
		assertThat(que).isEqualTo(mockQue);
	}

	@Test
	void testGetQuestion() {
		String mockQue = "Que1";
		q.setQuestion(mockQue);
		
		String que = q.getQuestion();
		assertThat(que).isEqualTo(mockQue);
	}

	@Test
	void testGetOption1() {
		String mockOpt = "Opt";
		q.setOption1(mockOpt);
		
		String opt = q.getOption1();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testSetOption1() {
		String mockOpt = "Opt";
		q.setOption1(mockOpt);
		
		String opt = q.getOption1();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testGetOption2() {
		String mockOpt = "Opt";
		q.setOption2(mockOpt);
		
		String opt = q.getOption2();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testSetOption2() {
		String mockOpt = "Opt";
		q.setOption2(mockOpt);
		
		String opt = q.getOption2();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testGetOption3() {
		String mockOpt = "Opt";
		q.setOption3(mockOpt);
		
		String opt = q.getOption3();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testSetOption3() {
		String mockOpt = "Opt";
		q.setOption3(mockOpt);
		
		String opt = q.getOption3();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testGetOption4() {
		String mockOpt = "Opt";
		q.setOption4(mockOpt);
		
		String opt = q.getOption4();
		assertThat(opt).isEqualTo(mockOpt);
	}

	@Test
	void testSetOption4() {
		String mockOpt = "Opt";
		q.setOption4(mockOpt);
		
		String opt = q.getOption4();
		assertThat(opt).isEqualTo(mockOpt);
	}



	
}
