package com.tj.dependencyInversion.processes;

public class SmartPhoneManufacturingProcess extends GeneralManufacturingProcess {

	public SmartPhoneManufacturingProcess(String processName) {
		super(processName);
	}

	@Override
	protected void assembleDevice() {
		System.out.println("assembled smartphone");
		
	}

	@Override
	protected void testDevice() {
		System.out.println("tested smartphone");		
	}

	@Override
	protected void packageDevice() {
		System.out.println("packaged smartphone");		
	}

	@Override
	protected void storeDevice() {
		System.out.println("stored smartphone");		
	}

}
