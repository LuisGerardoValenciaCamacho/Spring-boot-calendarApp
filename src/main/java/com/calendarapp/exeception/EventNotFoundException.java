package com.calendarapp.exeception;

public class EventNotFoundException extends RuntimeException {
	
	public EventNotFoundException(String message) {
		super(message);
	}

}
