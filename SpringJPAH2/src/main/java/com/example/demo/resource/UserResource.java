package com.example.demo.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	@Qualifier("userService1")
	UserService userService;

	@GetMapping("/all")
	public List<User> users() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer i) throws ResourceNotFoundException {
		User user = userService.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Resource Not found for user ID- " + i));
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer i, @Valid @RequestBody User userObj ) throws ResourceNotFoundException{
		User user = userService.findById(i).orElseThrow(()->new ResourceNotFoundException("User with user ID- "+ i +" not found to UPDATE"));
		user.setName(userObj.getName());
		user.setSalary(userObj.getSalary());
		user.setTeamName(userObj.getName());
		final User updateUser = userService.save(user);
		return ResponseEntity.ok().body(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable("id") Integer i) throws ResourceNotFoundException{
		userService.findById(i).orElseThrow(()-> new ResourceNotFoundException("User with user ID- "+ i +" not found to DELETE"));
		userService.deleteById(i);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
}

