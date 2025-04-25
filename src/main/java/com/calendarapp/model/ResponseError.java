package com.calendarapp.model;

import java.util.Date;

public class ResponseError {
	
	private String message;
	private String error;
	private int status;
	private Date date;
	
	public ResponseError(String message, String error, int status, Date date) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}