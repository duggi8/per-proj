package com.tj.core.reflection;

//Any part that implements the interface ESEngine
//can replace that part in any ship

public interface KESEngine{

	// User is forced to implement this method
	// It outputs the string returned when the 
	// object is printed
	
	public String toString();

}