package com.tj.singleResponsibilityPrinciple.clients;

import com.tj.openClosedPrinciple.domain.Nurse;
import com.tj.singleResponsibilityPrinciple.domain.Employee;
import com.tj.singleResponsibilityPrinciple.domain.dao.EmployeeDAO;
import com.tj.singleResponsibilityPrinciple.reporting.EmployeeReportFormatter;
import com.tj.singleResponsibilityPrinciple.reporting.FormatType;

public class ClientModule {
	
	public static void main(String[] args) {
	Employee peggy = new Nurse(1, "peggy", "accounting", true);
	ClientModule.hireNewEmployee(peggy);
	printEmployeeReport(peggy, FormatType.CSV);
	}

	public static void hireNewEmployee(Employee employee){
		EmployeeDAO employeeDao = new EmployeeDAO();
		employeeDao.saveEmployee(employee);
	}
	
	public static void terminateEmployee(Employee employee) {
		EmployeeDAO employeeDao = new EmployeeDAO();
		employeeDao.deleteEmployee(employee);
	}
	
	public static void printEmployeeReport(Employee employee, FormatType formatType) {
		EmployeeReportFormatter formatter = new EmployeeReportFormatter(employee, FormatType.CSV);
		System.out.println(formatter.getFormattedEmployee());
	}
}
