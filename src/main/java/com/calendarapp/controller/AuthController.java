package com.calendarapp.controller;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendarapp.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthenticationConfiguration authenticationConfiguration;
	
	public AuthController(AuthenticationConfiguration authenticationConfiguration) {
		this.authenticationConfiguration = authenticationConfiguration;
	}
	
}
