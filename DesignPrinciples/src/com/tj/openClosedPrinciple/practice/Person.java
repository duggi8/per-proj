package com.tj.openClosedPrinciple.practice;

public class Person {

	public static void main(String[] args) {
		//setup home entertainment
		Projector projector = new Projector();
		TV tv = new TV();
		//controlling home using remote
		RemoteControl remoteControl = RemoteControl.getInstance();
		remoteControl.chooseDevice(tv);
		remoteControl.turnOn();
		remoteControl.turnOff();
		
		remoteControl.chooseDevice(projector);
		remoteControl.turnOn();
		remoteControl.turnOff();
	}
}
