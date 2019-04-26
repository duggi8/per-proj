package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.pkgA.PkgBeanA;

@Configuration
public class AppTestConfig {

	@Bean("bean1")
	public PkgBeanA beanA() {
		return new PkgBeanA();
	}
	
	@Bean("bean2")
	public PkgBeanA beanA1() {
		return new PkgBeanA();
	}
}
