package com.example.user;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface REPO extends MongoRepository<Users,String>{
	Users findByUsername(String username);

}
