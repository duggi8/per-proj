package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@ContextConfiguration(classes = {TaxService.class}) to tell spring boot to load only specific classes.
//@SpringBootTest will load the application context with all the beans in the application and takes time if app is large.

@RunWith(SpringRunner.class)
public class TaxServiceTest {

	@Autowired
	private TaxService taxService;
	
	@Test
	void testTaxBracket() {
		final String taxBracket = taxService.getBracket(500);
		assertEquals("LOW", taxBracket);
		assertThat(taxBracket).isEqualTo("LOW");
		
	}
	
	@Test
	void testAllBrackets(){
		final List<String> allBrackets = taxService.allBrackets();
		assertThat(allBrackets).isNotEmpty();
		assertThat(allBrackets).contains("LOW","HIGH","MEDIUM");
	}

}
