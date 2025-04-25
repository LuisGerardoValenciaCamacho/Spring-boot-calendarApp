package com.calendarapp.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calendarapp.service.IUserService;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	private IUserService userService;
	
	public JpaUserDetailsService(IUserService service) {
		this.userService = service;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.calendarapp.model.User user = userService.findByUsername(username);
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return new User(user.getUsername(), user.getPassword(), true, true, true , true, authorities);
	}

}
