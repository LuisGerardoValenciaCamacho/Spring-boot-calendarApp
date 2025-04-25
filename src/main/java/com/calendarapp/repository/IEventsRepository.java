package com.calendarapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.calendarapp.model.Event;

@EnableMongoRepositories
@Repository
public interface IEventsRepository extends MongoRepository<Event, Long> {

}
