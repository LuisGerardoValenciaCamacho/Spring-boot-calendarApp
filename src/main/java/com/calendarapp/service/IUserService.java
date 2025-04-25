package com.calendarapp.service;

import java.util.List;

import com.calendarapp.model.User;


public interface IUserService {
	
	public List<User> findAll();
	
	public User findById(String id);
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public User create(User user);
	
	public User update(User user, String id);
	
	public void delete(String id);
}
