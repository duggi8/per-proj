package com.tj.dependencyInversion.processes;

public abstract class GeneralManufacturingProcess {

	private String processName;

	public GeneralManufacturingProcess(String processName) {
		super();
		this.processName = processName;
	}

	public void launchProcess() {
		if (processName != null && !processName.isEmpty()) {
			assembleDevice();
			testDevice();
			packageDevice();
			storeDevice();
		}
		else {
			System.out.println("no process name was specified");
		}

	}
	//we do not want client to see these methods. So we organize our processes and clients in different packages and make
	//below methods protected so that they can't see and call them in random order. Clients can only see launchProcess()
	protected abstract void assembleDevice();

	protected abstract void testDevice();

	protected abstract void packageDevice();

	protected abstract void storeDevice();
}
