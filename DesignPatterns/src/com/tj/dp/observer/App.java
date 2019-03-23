package com.tj.dp.observer;

import java.util.Date;

public class App {

	public static void main(String[] args) {
		Observer payroll = new PayrollDepartment();
		Observer hrSystem = new HRDepartment();
		
		EmployeeManagementSystem ems = new EmployeeManagementSystem();
		
		ems.registerObserver(payroll);
		ems.registerObserver(hrSystem);
		
		Employee bob = new Employee("Bob",new Date(), 35000, true);
		ems.hireNewEmployee(bob);
	}
}
