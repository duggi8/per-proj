package com.tj.interfaceSegregation;

import java.util.Date;
import java.util.List;

public class CustomerTransaction implements Accounting, Reporting {
	
	private List<Product> products;
	private Customer customer;

	public CustomerTransaction(List<Product> products, Customer customer) {
		super();
		this.products = products;
		this.customer = customer;
	}

	/* (non-Javadoc)
	 * @see com.tj.interfaceSegregation.Reporting#getName()
	 */
	@Override
	public String getName() {
		return customer.getCustomerName();
	}
	
	/* (non-Javadoc)
	 * @see com.tj.interfaceSegregation.Reporting#getDate()
	 */
	@Override
	public Date getDate() {
		return new Date();
	}
	
	/* (non-Javadoc)
	 * @see com.tj.interfaceSegregation.Reporting#productBreakDown()
	 */
	@Override
	public String productBreakDown() {
		String reportList = null;
		for(Product product : products) {
			reportList += product.getProductName();
		}
		return reportList;
	}
	
	/* (non-Javadoc)
	 * @see com.tj.interfaceSegregation.Accounting#prepareInvoice()
	 */
	@Override
	public void prepareInvoice() {
		System.out.println("invoice prepared....");
	}
	
	/* (non-Javadoc)
	 * @see com.tj.interfaceSegregation.Accounting#chargeCustomer()
	 */
	@Override
	public void chargeCustomer() {
		System.out.println("charged the customer....");
	}
}
