package com.tj.core.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kcomparator {

	public static void main(String[] args) {
		
		Comparator<Employee> idComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
		};
		
		Comparator<Employee> salaryComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary()-o2.getSalary();
			}
		};
		
		Employee emp1  = new Employee(4, "Teja", 27, 40);
		Employee emp2  = new Employee(3, "Sachin", 35, 50);
		Employee emp3  = new Employee(2, "Harish", 26, 10);
		Employee emp4  = new Employee(1, "Sai", 28, 30);

		List<Employee> lis = new ArrayList<>();
		lis.add(emp1);
		lis.add(emp2);
		lis.add(emp3);
		lis.add(emp4);
		
		Collections.sort(lis,salaryComparator);
		
		for (Employee employee : lis) {
			System.out.println(employee.getId());
		}
		
	}
}
