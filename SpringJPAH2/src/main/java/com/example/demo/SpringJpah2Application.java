package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.Repository;


@SpringBootApplication
public class SpringJpah2Application {

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringJpah2Application.class, args);
		checkBeansPresence("userService2","userService1","userService","userResource","userRepo","user");
	}

	private static void checkBeansPresence(String...beans) {
		for(String beanName:beans) {
			System.out.println("Is "+ beanName + " in Application context " + applicationContext.containsBean(beanName));
		}
	}
	
}
