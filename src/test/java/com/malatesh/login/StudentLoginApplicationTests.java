package com.malatesh.login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.malatesh.beans.UserLoginDetails;
import com.malatesh.beans.UserRegistrationInfo;

@SpringBootTest
class StudentLoginApplicationTests {

	@Autowired
	private LoginController controller;

	@MockBean
	private UserDataAccessLayer userLayer;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testAddUser() {

		UserRegistrationInfo user = new UserRegistrationInfo();
		user.setEmailId("mala.mala.com");
		user.setMobileNumber("100");
		user.setPassword("mala");
		user.setPassword("mala");
		user.update();

		Mockito.when(userLayer.getUserDetailsByUserName(user.getUserName()))
	      .thenReturn(user.getUserLoginDetails());
		
		// when
		UserLoginDetails found = userLayer.getUserDetailsByUserName(user.getUserName());

		// then
		assertThat(found.getUserName()).isEqualTo(user.getUserName());
	}

}
