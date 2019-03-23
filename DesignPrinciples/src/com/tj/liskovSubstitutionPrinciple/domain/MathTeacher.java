package com.tj.liskovSubstitutionPrinciple.domain;

public class MathTeacher extends SchoolStaff   implements CourseInstructor{

	@Override
	public void teach() {
		System.out.println("teaching math...");
	}

	
}
