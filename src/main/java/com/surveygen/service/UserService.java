package com.surveygen.service;

import com.surveygen.Repository.Mongo.UserRepository;
import com.surveygen.model.Mongo.User;
import com.surveygen.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserLogin userLogin){

        User user = new User();                     // Create a mongo user and add username, email to that object
        user.setName(userLogin.getUsername());      // by fetching info from userLogin object and store it in
        user.setEmail(userLogin.getEmail());        // mongo database

        userRepository.insert(user);
    }


}