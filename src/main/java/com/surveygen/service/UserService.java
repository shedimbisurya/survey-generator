package com.surveygen.service;

import com.surveygen.model.User;
import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findById(int id);

    boolean checkPassword(String username, String password);

    void emailConfirmation (String email) throws MessagingException, MessagingException, IOException, GeneralSecurityException;
}