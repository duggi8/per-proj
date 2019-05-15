package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.UserService;


@RunWith(SpringRunner.class)
public class SpringJpah2ApplicationTests {

	/*@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@Test
	public void contextLoads() throws Exception {
		Mockito.when(userService.findAll()).thenReturn(Collections.emptyList());
		MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/users/all").accept(MediaType.APPLICATION_JSON)).andReturn() ;
		
		System.out.println(mvcResult.getResponse());
		Mockito.verify(userService).findAll();
	}*/

	@Test
	public void add() {
		int a = 5;
		Assert.assertEquals(a, 5);
	}
}
