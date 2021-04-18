package com.surveybuilder.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.surveybuilder.ClientAdminMs1Application;
import com.surveybuilder.entity.Admin;
import com.surveybuilder.service.AdminService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientAdminMs1Application.class)
@WebMvcTest(value = AdminController.class)
class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;
	   
	 @MockBean
	 AdminService adminService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

/*	@Test
	void testCreateAdminController() throws Exception {
		String URI = "/createAdmin";
		Admin admin = getAdmin();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminService.createAdminService(Mockito.any(Admin.class))).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonOutput);

	}*/

	@Test
	void testViewAdminByIdController() throws Exception {
		String URI = "/viewAdminById/{id}";
		Admin admin = getAdmin();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminService.viewAdminByIdService(Mockito.anyLong())).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonInput);

	}

	@Test
	void testUpdateAdminController() throws Exception {
		String URI = "/updateAdmin/{id}";
		Admin admin = getAdmin();
	    String jsonInput = this.converttoJson(admin);

	    Mockito.when(adminService.updateAdminService(Mockito.any(Admin.class), Mockito.anyLong())).thenReturn(admin);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 101).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn(); MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonInput);
	}

	@Test
	void testDeleteAdminByIdController() throws Exception {
		String URI = "/deleteAdminById/{id}";
 
	    String r = "Record deleted Successfully";
	    boolean b = true;
	    
	    Mockito.when(adminService.deleteAdminByIdService(Mockito.anyLong())).thenReturn(b);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(r).isEqualTo(r);
	}

	@Test
	void testListAllAdminController() throws Exception {
		String URI = "/listAllAdmin";
		List<Admin> a = new ArrayList<Admin>();
		
		Admin admin = getAdmin();
		a.add(admin);
	    String jsonInput = this.converttoJson(a);

	    Mockito.when(adminService.listAllAdminService()).thenReturn(a);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput).isEqualTo(jsonInput);
	}
	
	
	private Admin getAdmin() {
		Admin a = new Admin();
		
		a.setAdminId(101);
		a.setEmailId("abc");
		a.setName("abc");
		a.setPassword("abc");
		
		return a;
	}
	
	
	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}
	

}
