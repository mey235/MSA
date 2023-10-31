package com.example.orders;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface ORD  extends MongoRepository<Orders,String>{

}
