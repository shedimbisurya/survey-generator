package com.surveygen.service;

import com.google.api.services.gmail.Gmail;
import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.Repository.Mongo.UserRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.model.Mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GmailService gmailService;

    public Survey create(Survey survey){

        survey.setRequested(0);
        survey.setResponses(0);         //initially the survey isn't shared to anyone
        Survey survey1 = surveyRepository.insert(survey);

        User user = userRepository.findByEmail("sshedimb@uci.edu");
        user.addSurveytoSurveysList(survey1);
        userRepository.save(user);

        return survey1;
    }

    public void share(List<String> contacts) throws GeneralSecurityException, MessagingException, IOException {
        String body = new String("<User> has requested you to fill out a survey. ");

        for(String contact : contacts){
            gmailService.sendMail("onlinesurveygen@gmail.com", contact, "SurveyGen","<User> would like you to fill out a survey.");
        }

    }

    public Survey getSurvey(){

        User user = userRepository.findByEmail("sshedimb@uci.edu");

        Survey survey = user.getSurveysList().get(user.getSurveysList().size()-1);

        System.out.println(survey);

        return survey;
    }

    public Survey getSurveyFromId(String id){
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.get();
    }

}