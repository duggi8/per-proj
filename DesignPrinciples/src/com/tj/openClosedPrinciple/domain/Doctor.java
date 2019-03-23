package com.tj.openClosedPrinciple.domain;

import com.tj.singleResponsibilityPrinciple.domain.Employee;

public class Doctor extends Employee {

	public Doctor(int id, String name, String department, boolean working) {
		super(id, name, department, working);
		System.out.println("Doctor in action....");
	}

	private void prescribeMedicine() {
		System.out.println("Prescribing Medicine...");
	}

	private void diagnosePatients() {
		System.out.println("Diagnosing Patient...");
	}

	@Override
	public void performDuties() {
		diagnosePatients();
		prescribeMedicine();

	}
}
