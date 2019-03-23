package com.tj.dependencyInversion.clients;

import com.tj.dependencyInversion.processes.GeneralManufacturingProcess;
import com.tj.dependencyInversion.processes.SmartPhoneManufacturingProcess;

public class DeviceFactory {

	public static void main(String[] args) {
		GeneralManufacturingProcess manufacturer = new SmartPhoneManufacturingProcess("iphone manufacturing");
		manufacturer.launchProcess();
	}
}
