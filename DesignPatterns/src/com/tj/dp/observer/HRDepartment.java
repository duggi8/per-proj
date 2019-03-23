package com.tj.dp.observer;

public class HRDepartment implements Observer{

	

	@Override
	public void callMe(Employee emp, String msg) {
		System.out.println("HRDepartment notified....");
		System.out.println(msg+" "+emp.getName());
		
	}

}
