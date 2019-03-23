package com.tj.liskovSubstitutionPrinciple.domain;

public class ScienceTeacher extends SchoolStaff   implements CourseInstructor{

	@Override
	public void teach() {
		System.out.println("teaching science...");
	}
	
	

}
