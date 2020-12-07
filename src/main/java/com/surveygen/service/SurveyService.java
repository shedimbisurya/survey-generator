package com.surveygen.service;

import com.google.api.services.gmail.Gmail;
import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.model.Mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    GmailService gmailService;

    public Survey create(Survey survey){

        survey.setRequested(0);
        survey.setResponses(0);         //initially the survey isn't shared to anyone
        //survey.setOwner(user);

        return surveyRepository.insert(survey);
    }

    public void share(List<String> contacts) throws GeneralSecurityException, MessagingException, IOException {

        String body = new String("<User> has requested you to fill out a survey. ");

        for(String contact : contacts){
            gmailService.sendMail("onlinesurveygen@gmail.com", contact, "SurveyGen","<User> would like you to fill out a survey.");
        }

    }

}