package com.calendarapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendarapp.model.Event;
import com.calendarapp.service.IEventsService;

@RestController
@RequestMapping("/api/event")
@CrossOrigin("http://localhost:5173")
public class EventsController {
	
	private IEventsService service;
	
	public EventsController(IEventsService eventsService) {
		this.service = eventsService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Event>> findAll() {
		List<Event> listEvents = service.findAll();
		return ResponseEntity.ok(listEvents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> findById(@PathVariable("id") String id) {
		Event event = service.findById(id);
		return ResponseEntity.ok(event);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Event> create(@RequestBody Event event) {
		Event newEvent = service.create(event);
		return ResponseEntity.ok(newEvent);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Event> update(@RequestBody Event event, @PathVariable("id") String id) {
		Event updateEvent = service.update(event, id);
		return ResponseEntity.ok(updateEvent);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		service.delete(id);
		return ResponseEntity.ok(true);
	}
}
