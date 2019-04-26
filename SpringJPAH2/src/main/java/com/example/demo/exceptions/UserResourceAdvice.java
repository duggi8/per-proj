package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.resource.UserResource;

@Component
@ControllerAdvice(assignableTypes = UserResource.class)
public class UserResourceAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> notFoundException(ResourceNotFoundException r){
		Map<String, String> map = new HashMap<>();
		map.put("error message",r.getLocalizedMessage());
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
}
