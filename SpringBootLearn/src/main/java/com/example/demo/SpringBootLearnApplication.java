package com.example.demo;

import java.util.Arrays;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.config.AppTestConfig;
//@Import(AppTestConfig.class)
@SpringBootApplication
public class SpringBootLearnApplication {

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext =  SpringApplication.run(SpringBootLearnApplication.class, args);
		checkBeansPresence("subDemoBeanA","pkgBeanA","subsubDemoBeanA","bean1");
	}

	private static void checkBeansPresence(String...beans) {

		Arrays.asList(beans).forEach((bean)->System.out.println("is "+bean+" in application context: "+ applicationContext.containsBean(bean) ));
	}

}
