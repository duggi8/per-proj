package com.tj.interfaceSegregation;

/*Customer Transaction object has 5 methods.
 *But Accounts Receivable object only using 2 methods from those 5 methods.So when we modify the other 3 methods in 
 *Customer Transaction object we need to build our Account Receivable class too. This is not good.
 *  */
public class AccountsReceivable {

	private Accounting transactionObject;

	public AccountsReceivable(Accounting atransactionObject) {
		super();
		this.transactionObject = atransactionObject;
	}
	
	public void postPayment() {
		transactionObject.chargeCustomer();
	}

	public void sendInvoice() {
		transactionObject.prepareInvoice();  
		//logic to send prepared invoice
	}
}
