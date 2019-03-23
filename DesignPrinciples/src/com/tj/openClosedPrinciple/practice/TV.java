package com.tj.openClosedPrinciple.practice;

public class TV implements Device {

	@Override
	public void on() {
		System.out.println("TV turned ON");
	}

	@Override
	public void off() {
		System.out.println("TV turned OFF");
	}

	@Override
	public String toString() {
		return "TV";
	}

	
	
}
