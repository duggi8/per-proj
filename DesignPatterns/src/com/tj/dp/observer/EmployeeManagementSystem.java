package com.tj.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem implements Subject{

	private List<Employee> employees;
	private List<Observer> observers;
	private EmployeeDAO employeeDao;
	
	private Employee employee;
	private String msg;
	
	public EmployeeManagementSystem() {
		super();
		this.employees = new ArrayList<>();
		this.employeeDao = new EmployeeDAO();
		this.observers = new ArrayList<>();
	}


	@Override
	public void registerObserver(Observer o) {
	observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
	observers.remove(o);	
	}
	
	@Override
	public void notifyObservers() {
		for(Observer obs:observers) {
			obs.callMe(employee,msg);
		}
	}
	
	public void hireNewEmployee(Employee emp) {
		employee = emp;
		msg= "New Hire: ";
		employees.add(emp);
		notifyObservers();
		
	}
}
