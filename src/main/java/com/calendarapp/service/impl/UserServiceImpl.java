package com.calendarapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.calendarapp.exeception.UserNotFoundException;
import com.calendarapp.model.User;
import com.calendarapp.repository.IUserRepository;
import com.calendarapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository repository;
	private PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(IUserRepository userRepository, PasswordEncoder encoder) {
		this.repository = userRepository;
		this.passwordEncoder = encoder;
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String id) {
		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario no existe"));
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		User user = repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuario no existe"));
		return user;
	}
	
	@Override
	public User findByUsername(String username) {
		User user = repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Usuario no existe"));
		return user;
	}

	@Override
	public User create(User user) {
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		User newUser = new User(user.getName(), user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail(), user.getPhone(), roles);
		newUser = repository.save(newUser);
		return newUser;
	}

	@Override
	public User update(User user, String id) {
		User newUser = findById(id);
		newUser.setName(user.getName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
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
