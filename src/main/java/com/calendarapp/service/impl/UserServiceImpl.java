package com.calendarapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calendarapp.model.User;
import com.calendarapp.repository.IUserRepository;
import com.calendarapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository repository;
	
	public UserServiceImpl(IUserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String id) {
		User user = repository.findById(id).orElse(null);
		return user;
	}

	@Override
	public User create(User user) {
		User newUser = new User(user.getName(), user.getPassword(), user.getEmail(), user.getPhone());
		newUser = repository.save(newUser);
		return newUser;
	}

	@Override
	public User update(User user, String id) {
		User newUser = findById(id);
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());
		newUser = repository.save(newUser);
		return newUser;
	}

	@Override
	public void delete(String id) {
		User deleteEvent = findById(id);
		repository.delete(deleteEvent);
	}
}
