package com.tj.spring.security;

import org.springframework.security.authentication.AuthenticationManager;

public class JwtAuthenticationTokenFilter {

	private AuthenticationManager authenticationManager;
	private JwtSuccessHandler authenticationSuccessHandler;
	
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void setAuthenticationSuccessHandler(JwtSuccessHandler jwtSuccessHandler) {
		this.authenticationSuccessHandler = jwtSuccessHandler;
	}

	
}
