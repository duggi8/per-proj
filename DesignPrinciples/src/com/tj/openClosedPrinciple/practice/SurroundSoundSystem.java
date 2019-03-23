package com.tj.openClosedPrinciple.practice;

public class SurroundSoundSystem implements Device{

	@Override
	public void on() {
		System.out.println("SSS turned ON");
	}

	@Override
	public void off() {
		System.out.println("SSS turned OFF");
	}

	
}
