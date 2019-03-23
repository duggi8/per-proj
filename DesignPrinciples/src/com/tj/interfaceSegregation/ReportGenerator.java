package com.tj.interfaceSegregation;

public class ReportGenerator {

	private Reporting transactionObject;
	
	
	public void generateReport() {
		System.out.println(transactionObject.getName()+" "+transactionObject.getDate()
		+" "+transactionObject.productBreakDown());
	}
}
