package com.example.demo;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//WebMvcTest - for unit testing-loads only current modules defined in this test class.
@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringBootLearn1ApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PersonRepository personRepo;
	
	@Test
	public void contextLoads() throws Exception {
	
		Mockito.when(personRepo.findAll()).thenReturn(Collections.emptyList());
		
		MvcResult mvcRes = mockMvc.perform(MockMvcRequestBuilders.get("/all/").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		System.out.println(mvcRes.getResponse());
		
		Mockito.verify(personRepo).findAll();
	}

}
