package com.surveygen.service;

import com.surveygen.Repository.Mongo.UserRepository;
import com.surveygen.model.Mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){

    }


}
