package com.tj.openClosedPrinciple.domain;

import com.tj.singleResponsibilityPrinciple.domain.Employee;

public class HospitalManagement {
	
	public void callUpon(Employee employee) {
		employee.performDuties();
	}
	
}
