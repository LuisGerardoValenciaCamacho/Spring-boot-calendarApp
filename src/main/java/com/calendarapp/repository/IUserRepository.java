package com.calendarapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.calendarapp.model.User;

@EnableMongoRepositories
@Repository
public interface IUserRepository extends MongoRepository<User, String> {
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByUsername(String username);
}
