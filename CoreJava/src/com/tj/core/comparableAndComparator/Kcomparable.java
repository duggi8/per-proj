package com.tj.core.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kcomparable {

	public static void main(String[] args) {
		
		Employee emp1  = new Employee(4, "Teja", 27, 20);
		Employee emp2  = new Employee(3, "Sachin", 35, 30);
		Employee emp3  = new Employee(2, "Harish", 26, 40);
		Employee emp4  = new Employee(1, "Sai", 28, 50);

		List<Employee> lis = new ArrayList<>();
		lis.add(emp1);
		lis.add(emp2);
		lis.add(emp3);
		lis.add(emp4);
		
		Collections.sort(lis);
		
		for (Employee employee : lis) {
			System.out.println(employee.getId());
		}
		
		
	}
}
