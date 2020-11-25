package com.surveygen.Repository.Mongo;

import com.surveygen.model.Mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
