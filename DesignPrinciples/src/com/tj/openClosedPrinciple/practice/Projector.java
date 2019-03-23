package com.tj.openClosedPrinciple.practice;

public class Projector implements Device {

	@Override
	public void on() {
		System.out.println("Projector turned ON");
	}

	@Override
	public void off() {
		System.out.println("Projector turned OFF");
	}

	@Override
	public String toString() {
		return "Projector";
	}

	
}
