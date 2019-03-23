package com.tj.singleResponsibilityPrinciple.domain.dao;

import com.tj.singleResponsibilityPrinciple.domain.Employee;

public class EmployeeDAO {

	public void saveEmployee(Employee employee) {
		/*DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getManagerInstance();
		connectionManager.connect();
		connectionManager.getConnectionObject().prepareStatement("insert into Employee tbl");
		connectionManager.disconnect();*/
		System.out.println("Saved employee to database");
	}
	
	public void deleteEmployee(Employee employee) {
		System.out.println("deleted employee to database");
	}
}
