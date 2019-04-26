package com.tj.context;

public class HelloWorld {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("called just after instance created");
	}
	
	public void destroy() {
		System.out.println("called just before removing this instance from IOC container");
	}
}
