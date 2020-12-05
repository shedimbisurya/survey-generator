package com.surveygen.service;

import com.google.api.services.gmail.Gmail;
//import com.surveygen.Repository.SurveyRepository;
import com.surveygen.Repository.UserLoginRepository;
import com.surveygen.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private GmailService gmailService;

    @Override
    public UserLogin findById(int id){
        return userLoginRepository.findById(id);
    }

    @Override
    public void save(UserLogin userLogin){
        userLogin.setPassword(bCryptPasswordEncoder.encode(userLogin.getPassword()));
        userLoginRepository.save(userLogin);
    }

    @Override
    public UserLogin findByUsername(String username){
        return userLoginRepository.findByUsername(username);
    }

    @Override
    public boolean checkPassword(String username, String password){

        System.out.println("Reached checkPassword()!");

        UserLogin userLogin = findByUsername(username);
        if(userLogin != null && bCryptPasswordEncoder.matches(password, userLogin.getPassword())){
            System.out.println("Matching passwords!");
            return true;
        }
        else return false;
    }

    @Override
    public void emailConfirmation(String email) throws MessagingException, MessagingException, IOException, GeneralSecurityException {
        String confirmationBody = new String("This is a test email.");
        // body needs to be inserted

        MimeMessage mimeMessage =  gmailService.createEmail(email, "onlinesurveygen@gmail.com", "Confirmation link", confirmationBody);

        //Message message = gmailService.createMessageWithEmail(mimeMessage);

        Gmail gmail = gmailService.instantiateGmailService();
        gmailService.sendMessage(gmail, "onlinesurveygen@gmail.com", mimeMessage);

    }

//    @Override
//    public String getStatusOfSurvey(int surveyId){
//        Survey survey = surveyRepository.findById(surveyId).get();
//
//        int requested = survey.getRequested();
//        int responses = survey.getResponded();
//
//        String status = responses + "out of " + requested + "have submitted their response.";
//        return status;
//    }

}
