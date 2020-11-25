package com.surveygen.service;

import com.surveygen.model.UserLogin;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface UserLoginService {

    void save(UserLogin userLogin);

    UserLogin findByUsername(String username);

    UserLogin findById(int id);

    boolean checkPassword(String username, String password);

    void emailConfirmation (String email) throws MessagingException, MessagingException, IOException, GeneralSecurityException;

    //void createSurvey(int userId);

    //String getStatusOfSurvey(int surveyId);

}