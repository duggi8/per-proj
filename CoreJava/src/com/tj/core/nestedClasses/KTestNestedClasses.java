package com.tj.core.nestedClasses;

/*Nested classes are MEMBERS of enclosing class.
 * 
 * statics are part of blue print i.e. class
 * So static nested classes can only be accessed from enclosing class.
 * 
 * static methods interact with enclosing class using its instance, in the same way static nested classes also 
 * interacts only using the instance--> can't access enclosing class members directly*/
public class KTestNestedClasses {

	private int id;
	private String name;
	private static int val= 78;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	static class KStaticNestedClass{
	
		public String city;
		public String state;
		
		public static void getVal() {
			System.out.println(val);
		}
		
		public void printId() {
			KTestNestedClasses ktns  = new KTestNestedClasses();
			ktns.setId(4);
		}
		
	}
	
	
	
}
