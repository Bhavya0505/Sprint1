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

import com.surveybuilder.ClientAdminMs1Application;
import com.surveybuilder.dao.adminDao;
import com.surveybuilder.entity.Admin;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ClientAdminMs1Application.class)
@WebMvcTest(value = AdminService.class)
class AdminServiceTest {

	@Autowired
	private AdminService adminService;

	@MockBean
	private adminDao adminDao;
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	private Admin getAdmin() {
		Admin a = new Admin();
		
		a.setAdminId(101);
		a.setEmailId("abc");
		a.setName("abc");
		a.setPassword("abc");
		
		return a;
	}

	
	@Test
	void testCreateAdminController() throws Exception {
		Admin admin = getAdmin();
	   
	    Mockito.when(adminDao.save(Mockito.any(Admin.class))).thenReturn(admin);
	    
	    Admin result = adminService.createAdminService(admin);
	    
	    assertThat(admin).isEqualTo(result);

	}

	@Test
	void testViewAdminByIdController() throws Exception {
		
		Admin admin = getAdmin();

	    Mockito.when(adminDao.findAdminById(Mockito.anyLong())).thenReturn(admin);

	    Admin result = adminService.viewAdminByIdService(101);
	    
	    assertThat(admin).isEqualTo(result);

	}

	@Test
	void testUpdateAdminController() throws Exception {
		
		Optional<Admin> a = Optional.of(getAdmin());
		
		Admin admin = getAdmin();
	  
	    Mockito.when(adminDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.when(adminDao.save(Mockito.any(Admin.class))).thenReturn(admin);
	    
	    Admin result = adminService.updateAdminService(admin, 101);
	    
	    assertThat(admin).isEqualTo(result);
	}

	@Test
	void testDeleteAdminByIdController() throws Exception {
		Optional<Admin> a = Optional.of(getAdmin());

	    boolean b = true;
	    
	    Mockito.when(adminDao.findById(Mockito.anyLong())).thenReturn(a);
	    Mockito.doNothing().when(adminDao).deleteById(Mockito.anyLong());
	    
	    boolean result = adminService.deleteAdminByIdService(101);
	    
	    assertThat(b).isEqualTo(result);
	}

	@Test
	void testListAllAdminController() throws Exception {

		List<Admin> a = new ArrayList<Admin>();
		
		Admin admin = getAdmin();
		a.add(admin);
	    
	    Mockito.when(adminDao.findAll()).thenReturn(a);
	   
	    List<Admin> result = adminService.listAllAdminService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}

}
