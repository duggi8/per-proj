package com.example.demo.resource;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

	@GetMapping(value = "/age",produces = "application/xml" )
	public ResponseEntity<String> age(@RequestParam("yob") int birthYear){
		if(birthYear > 2019)
			return new ResponseEntity<>("Birth year is in furture ",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Your age is " + (2019 - birthYear) , HttpStatus.OK);
	}
	
	@GetMapping("/customHeader")
	public ResponseEntity<String> customHeader(){
		HttpHeaders headers  = new HttpHeaders();
		headers.add("Custom-Header", "foo");
		return new ResponseEntity<>("Custom header Set", headers, HttpStatus.OK);
	}
	
	
}
