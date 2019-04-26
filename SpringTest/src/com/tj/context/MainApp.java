package com.tj.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//HelloWorld hw = (HelloWorld)context.getBean("helloWorld2");
		//System.out.println(hw.getMessage());
		
		//TextEditor te = (TextEditor) context.getBean("textEditor");
	    //te.spellCheck();
		//context.registerShutdownHook();
	    
		ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		TextEditor te = (TextEditor)context.getBean(TextEditor.class);
		te.spellCheck();
	    
	}
}
