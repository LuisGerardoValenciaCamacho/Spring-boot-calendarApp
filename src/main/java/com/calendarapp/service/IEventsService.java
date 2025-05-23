package com.calendarapp.service;

import java.util.List;

import com.calendarapp.model.Event;

public interface IEventsService {
	
	public List<Event> findAll();
	
	public Event findById(String id);
	
	public Event create(Event event);
	
	public Event update(Event event, String id);
	
	public void delete(String id);
}
