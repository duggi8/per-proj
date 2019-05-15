package com.example.demo.serviceImpl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ApplicationUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ApplicationUser user = repo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUserName(),user.getPassword(),Collections.emptyList());
	}

	
}
