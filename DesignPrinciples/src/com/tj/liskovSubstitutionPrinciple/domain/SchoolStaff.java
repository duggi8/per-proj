package com.tj.liskovSubstitutionPrinciple.domain;

public class SchoolStaff {

	
	private void makeAnnouncements() {
		System.out.println("made announcements...");
	}
	
	private void takeAttendance(){
		System.out.println("took attendance...");
	}
	
	private void collectPaperwork(){
		System.out.println("collect paperwork...");
	}

	private void conductHallwayDuties(){
		System.out.println("collect hallway duties....");
	}
	
	public void performOtherResponsibilities() {
		makeAnnouncements();
		takeAttendance();
		collectPaperwork();
		conductHallwayDuties();
	}
}
