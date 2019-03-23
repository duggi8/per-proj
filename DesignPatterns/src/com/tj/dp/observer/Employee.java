package com.tj.dp.observer;

import java.util.Date;

public class Employee {

	public String name;
	public Date hireDate;
	public int salary;
	public int employeeID;
	public boolean fired = false;
	
	private static int COUNTER;

	public Employee(String name, Date hireDate, int salary, boolean fired) {
		super();
		this.name = name;
		this.hireDate = hireDate;
		this.salary = salary;
		this.fired = fired;
		
		employeeID = ++COUNTER;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + ", employeeID=" + employeeID
				+ ", fired=" + fired + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public boolean isFired() {
		return fired;
	}

	public void setFired(boolean fired) {
		this.fired = fired;
	}

	public static int getCOUNTER() {
		return COUNTER;
	}

	public static void setCOUNTER(int cOUNTER) {
		COUNTER = cOUNTER;
	}
	
	
}
