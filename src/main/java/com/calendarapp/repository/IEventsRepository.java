package com.calendarapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.calendarapp.model.Event;

@Repository
public interface IEventsRepository extends MongoRepository<Event, String> {

}
