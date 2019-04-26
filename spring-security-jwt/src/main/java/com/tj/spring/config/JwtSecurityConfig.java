package com.tj.spring.config;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.tj.spring.security.JwtAuthenticationEntryPoint;
import com.tj.spring.security.JwtAuthenticationProvider;
import com.tj.spring.security.JwtAuthenticationTokenFilter;
import com.tj.spring.security.JwtSuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	
	private JwtAuthenticationProvider authenticationProvider;
	private JwtAuthenticationEntryPoint entryPoint;
	
	/*The main strategy interface for authentication is AuthenticationManager
	 * 
	 * The most commonly used implementation of AuthenticationManager is ProviderManager,
	 * which delegates to a chain of AuthenticationProvider instances. An AuthenticationProvider
	 * is a bit like an AuthenticationManager but it has an extra method to allow the caller to
	 * query if it supports a given Authentication type*/
	
	@Bean
	public AuthenticationManager authenticationManager() {
		AuthenticationProvider provider = new JwtAuthenticationProvider();
		List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
		providers.add(provider);
		return new ProviderManager(providers);
	}
	
	//custom filter
	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilter() {
		JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
		return filter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("**/rest/**").authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint);
		
	}
}
