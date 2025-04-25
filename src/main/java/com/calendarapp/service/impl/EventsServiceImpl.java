package com.calendarapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarapp.exeception.EventNotFoundException;
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
	public Event findById(Long id) {
		Event event = repository.findById(id).orElseThrow(() -> new EventNotFoundException("Evento no encontrado"));
		return event;
	}

	@Override
	public Event create(Event event) {
		Event newEvent = new Event(event.getTitle(), event.getNotes(), event.getStart(), event.getEnd(), event.getBgColor(), event.getUser());
		newEvent = repository.save(newEvent);
		return newEvent;
	}

	@Override
	public Event update(Event event, Long id) {
		Event oldEvent = findById(id);
		oldEvent.setTitle(event.getTitle());
		oldEvent.setNotes(event.getNotes());
		oldEvent.setStart(event.getStart());
		oldEvent.setEnd(event.getEnd());
		oldEvent.setBgColor(event.getBgColor());
		oldEvent.setUser(event.getUser());
		oldEvent = repository.save(oldEvent);
		return oldEvent;
	}

	@Override
	public void delete(Long id) {
		Event deleteEvent = findById(id);
		repository.delete(deleteEvent);
	}
}
