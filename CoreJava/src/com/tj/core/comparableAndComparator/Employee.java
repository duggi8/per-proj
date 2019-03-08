package com.tj.core.comparableAndComparator;
// 
public class Employee implements Comparable<Employee>{
	 private int id;
	 private String name;
	 private int age;
	 private int salary;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	public int getSalary() {
		return salary;
	}
	public Employee(int id, String name, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.id - o.id;
	}

}
