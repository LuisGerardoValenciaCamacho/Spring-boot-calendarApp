package com.calendarapp.controller;

import java.util.Date;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.calendarapp.exeception.EventNotFoundException;
import com.calendarapp.exeception.MethodNotAllowed;
import com.calendarapp.exeception.UserNotFoundException;
import com.calendarapp.model.ResponseError;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler({NotFoundException.class, UserNotFoundException.class, EventNotFoundException.class})
	public ResponseEntity<ResponseError> notFound(Exception ex) {
		ResponseError response = new ResponseError(ex.getMessage(), "No encontrado", 404, new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ResponseError> internalServerError(Exception ex) {
		ResponseError response = new ResponseError(ex.getMessage(), "Error interno", 500, new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
	}
	
	@ExceptionHandler(MethodNotAllowed.class)
	public ResponseEntity<ResponseError> methodNotAllowed(Exception ex) {
		ResponseError response = new ResponseError(ex.getMessage(), "Método invalido", 405, new Date());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED.value()).body(response);
	}
}
