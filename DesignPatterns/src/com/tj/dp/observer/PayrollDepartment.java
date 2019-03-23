package com.tj.dp.observer;

public class PayrollDepartment implements Observer{

	

	@Override
	public void callMe(Employee emp, String msg) {
		System.out.println("PayrollDepartment notified....");
		System.out.println(msg+" "+emp.getName());
	}

}
