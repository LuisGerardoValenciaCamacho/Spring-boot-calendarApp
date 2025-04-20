package com.calendarapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.calendarapp.model.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

}
