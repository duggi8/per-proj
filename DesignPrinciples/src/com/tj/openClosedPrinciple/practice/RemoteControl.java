package com.tj.openClosedPrinciple.practice;

//Singleton bean
//Class should be open for extension and closed for modification.
public class RemoteControl {
	
	private Device device;
	private static final RemoteControl INSTANCE = new RemoteControl();
	
	private RemoteControl() {
		
	}
	
	public static RemoteControl getInstance() {
		return INSTANCE;
	}
	
	
	public void chooseDevice(Device aDevice) {
		this.device = aDevice;
		System.out.println("RemoteControl connected to " + device + "--");
	}
	
	public void turnOn() {
		device.on();
	}
	
	public void turnOff() {
		device.off();
	}
}
