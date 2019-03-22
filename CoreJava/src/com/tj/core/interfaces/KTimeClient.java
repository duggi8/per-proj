package com.tj.core.interfaces;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface KTimeClient {

	    void setTime(int hour, int minute, int second);
	    void setDate(int day, int month, int year);
	    void setDateAndTime(int day, int month, int year,
	                               int hour, int minute, int second);
	    LocalDateTime getLocalDateTime();
	    
	    static ZoneId getZoneId (String zoneString) {
	        try {
	            return ZoneId.of(zoneString);
	        } catch (DateTimeException e) {
	            System.err.println("Invalid time zone: " + zoneString +
	                "; using default time zone instead.");
	            return ZoneId.systemDefault();
	        }
	    }
	        //when people need to add additional methods in interfaces the client needs to implement the methods even when won't use it and 
	    //changes need to be made in impl code. So default implementation is provided in the interface itself so that impl code does not need to 
	    //override it ifthey won't use it. That is the use of default method in interface. Static methods are provided to support default methods like below.
	    default ZonedDateTime getZonedDateTime(String zoneString) {
	        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
	    }
}
