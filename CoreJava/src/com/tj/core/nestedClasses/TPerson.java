package com.tj.core.nestedClasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TPerson {

	interface CheckPerson{
		boolean test(TPerson p);
	}
	
	
	public enum Sex{
		MALE,FEMALE
	}
	int age;
	String name;
	LocalDate birthDay;
	Sex gender;
	String emailAddress;
	
	
	public TPerson(int age, Sex gender, String name) {
		super();
		this.age = age;
		this.gender = gender;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return this.age;
	}
	
	public void printPerson(List<TPerson> persons, CheckPerson cp) {
		for(TPerson p : persons) {
			if(cp.test(p)) {
				System.out.println(p.name);
			}
		}
	}
	
	public static void printPerson1(List<TPerson> persons, Predicate<TPerson> cp) {
		for(TPerson p : persons) {
			if(cp.test(p)) {
				System.out.println(p.name);
			}
		}
	}
	public static void printPerson2(List<TPerson> persons, Predicate<TPerson> cp, Consumer<TPerson> con) {
		for(TPerson p : persons) {
			if(cp.test(p)) {
				con.accept(p);
			}
		}
	}
	
	public static void printPerson3(List<TPerson> persons, Predicate<TPerson> cp, Function<TPerson, String> mapper,
			Consumer<String> con) {
		for(TPerson p : persons) {
			if(cp.test(p)) {
				String data  = mapper.apply(p);
				con.accept(data);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		TPerson tp = new TPerson(21,Sex.MALE,"Teja");
		TPerson tp1 = new TPerson(24,Sex.MALE,"Sachin");
		TPerson tp2 = new TPerson(17,Sex.MALE,"Peta");
		List<TPerson> persons = new ArrayList<TPerson>();
		persons.add(tp);
		persons.add(tp1);
		persons.add(tp2);
		/*printPerson(persons, new CheckPerson() {
			
			@Override
			public boolean test(TPerson p) {
				return false;
			}
		});*/
		
		printPerson1(persons, (TPerson p)-> p.getAge()>22);
		System.out.println("---------------------------");
		printPerson2(persons, p->p.getAge()>20,p->System.out.println(p.name));
		System.out.println("---------------------------");
		printPerson3(persons, p->p.getAge()>20, p->p.getName(), p->System.out.println(p));
		System.out.println("---------------------------");
	}
	
}
