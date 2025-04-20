package com.calendarapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarapp.model.Event;
import com.calendarapp.repository.IEventsRepository;
import com.calendarapp.service.IEventsService;

@Service
public class EventsServiceImpl implements IEventsService {
	
	private IEventsRepository repository;
	
	public EventsServiceImpl(IEventsRepository eventsRepository) {
		this.repository = eventsRepository;
	}

	@Override
	public List<Event> findAll() {
		return repository.findAll();
	}

	@Override
	public Event findById(String id) {
		Event event = repository.findById(id).orElse(null);
		return event;
	}

	@Override
	public Event create(Event event) {
		Event newEvent = new Event();
		newEvent = repository.save(newEvent);
		return newEvent;
	}

	@Override
	public Event update(Event event, String id) {
		Event oldEvent = findById(id);
		oldEvent.id = event.id;
		oldEvent = repository.save(oldEvent);
		return null;
	}

	@Override
	public void delete(String id) {
		Event deleteEvent = findById(id);
		repository.delete(deleteEvent);
	}

}
