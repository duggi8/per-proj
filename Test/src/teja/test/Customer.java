package teja.test;

public abstract class Customer {

	private String name;

	
	public Customer(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return this.name;
	}
	
}
