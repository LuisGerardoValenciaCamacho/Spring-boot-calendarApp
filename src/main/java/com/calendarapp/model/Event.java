package com.calendarapp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {

	@Id
	private Long id;
	
	private String title; 
	
	private String notes;
	
	private Date start;
	
	private Date end;
	
	private String bgColor;
	
	private User user;

	public Event() {
		super();
	}

	public Event(String title, String notes, Date start, Date end, String bgColor, User user) {
		super();
		this.title = title;
		this.notes = notes;
		this.start = start;
		this.end = end;
		this.bgColor = bgColor;
		this.user = user;
	}

	public Event(Long id, String title, String notes, Date start, Date end, String bgColor, User user) {
		super();
		this.id = id;
		this.title = title;
		this.notes = notes;
		this.start = start;
		this.end = end;
		this.bgColor = bgColor;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
