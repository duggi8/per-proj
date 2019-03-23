package com.tj.openClosedPrinciple.domain;

import com.tj.singleResponsibilityPrinciple.domain.Employee;

public class EmergencyRoomProcess {

	public static void main(String[] args) {
		HospitalManagement erDirector = new HospitalManagement();
		Employee peggy = new Nurse(1, "peggy", "emergency", true);
		erDirector.callUpon(peggy);
		
		Employee susan = new Doctor(2, "susan", "emergency", true);
		erDirector.callUpon(susan);
	}
}
