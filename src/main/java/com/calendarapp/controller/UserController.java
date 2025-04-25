package com.calendarapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendarapp.model.User;
import com.calendarapp.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private IUserService service;
	
	public UserController(IUserService userService) {
		this.service = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll() {
		List<User> listEvents = service.findAll();
		return ResponseEntity.ok(listEvents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") String id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		User newUser = service.create(user);
		return ResponseEntity.ok(newUser);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") String id) {
		User updateUser = service.update(user, id);
		return ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		service.delete(id);
		return ResponseEntity.ok(true);
	}
}
