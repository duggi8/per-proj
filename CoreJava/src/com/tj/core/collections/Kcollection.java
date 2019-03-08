package com.tj.core.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.tj.core.comparableAndComparator.Employee;

public class Kcollection {

	public static void main(String[] args) {
		Employee emp1  = new Employee(4, "Teja", 27, 20);
		Employee emp2  = new Employee(3, "Sachin", 35, 30);
		Employee emp3  = new Employee(1, "Harish", 26, 40);
		Employee emp4  = new Employee(1, "Sai", 28, 50);
		Employee emp5  = new Employee(1, "Sai", 28, 50);

		List<Employee> arrlist = new ArrayList<>();
		arrlist.add(emp1);
		arrlist.add(emp2);
		arrlist.add(emp3);
		arrlist.add(emp4);
		arrlist.add(emp5);
		
		Set<Employee> empSet = new HashSet<>(arrlist);
		for (Employee employee : empSet) {
			System.out.println(employee.getSalary());
		}
		
		System.out.println("------------------------");
		
		Set<Employee> empSet1 = new TreeSet<>(arrlist);
		for (Employee employee : empSet1) {
			System.out.println(employee.getSalary());
		}
		
	}
}
