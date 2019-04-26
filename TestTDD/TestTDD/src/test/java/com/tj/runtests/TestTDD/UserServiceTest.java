package com.tj.runtests.TestTDD;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestTddApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private NameService nameService;
	
	@Test
	public void whenUserIsProvided_thenRetreivedNameIsCorrect() {
	
		Mockito.when(userService.getUserName(1)).thenReturn("Rama Singh");
		String temp = userService.getUserName(1);
		Assert.assertEquals("Krishna Singh", temp);
		
	}
}
