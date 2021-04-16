package com.surveybuilder.entity;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.ClientAdminMs1Application;
import com.surveybuilder.entity.Admin;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientAdminMs1Application.class)
@WebMvcTest(value = Admin.class)
class AdminTest {

	
	private Admin admin = new Admin();
	   
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAdminId() {
		long mockId = 101;
		admin.setAdminId(mockId);
		long id = admin.getAdminId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}

	@Test
	void testSetAdminId() {
		long mockId = 101;
		admin.setAdminId(mockId);
		long id = admin.getAdminId();
		
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetName() {
		String mockName = "Bhavya";
		admin.setName(mockName);
		String name = admin.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "Bhavya";
		admin.setName(mockName);
		String name = admin.getName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testGetEmailId() {
		String mockEmail = "Bhavya@gmail.com";
		admin.setEmailId(mockEmail);
		String email = admin.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testSetEmailId() {
		String mockEmail = "Bhavya@gmail.com";
		admin.setEmailId(mockEmail);
		String email = admin.getEmailId();
		
		assertThat(email).isEqualTo(mockEmail);
	}

	@Test
	void testGetPassword() {
		String mockPass = "Bhavya123";
		admin.setPassword(mockPass);
		String pass = admin.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "Bhavya123";
		admin.setPassword(mockPass);
		String pass = admin.getPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

}
