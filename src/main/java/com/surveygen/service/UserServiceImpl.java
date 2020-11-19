package com.surveygen.service;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.surveygen.Repository.SurveyRepository;
import com.surveygen.Repository.UserRepository;
import com.surveygen.model.Survey;
import com.surveygen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private GmailService gmailService;
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public User findById(int id){
        return userRepository.findById(id);
    }

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean checkPassword(String username, String password){

        System.out.println("Reached checkPassword()!");

        User user = findByUsername(username);
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
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
//    public void createSurvey(int userId){
//        surveyRepository.save(survey);
//    }

    @Override
    public String getStatusOfSurvey(int surveyId){
        Survey survey = surveyRepository.findById(surveyId);

        int requested = survey.getRequested();
        int responses = survey.getResponded();

        String status = responses + "out of " + requested + "have submitted their response.";
        return status;
    }

}
