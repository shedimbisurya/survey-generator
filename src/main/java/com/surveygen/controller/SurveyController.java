package com.surveygen.controller;

import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.model.Mongo.User;
import com.surveygen.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyRepository surveyRepository;

    @PostMapping("/survey")
    public @ResponseBody Survey createSurvey(@RequestBody Survey survey, HttpSession session){
        return surveyService.create(survey);  // inserts the survey in mongo db
        //Add this survey to user collection(only refs will be stored)
        //User user_from_session = session.getAttribute("");
        //user_from_session.addSurveytoSurveysList(survey1);
    }

    // this method is not completed
    @PostMapping("/shareSurvey")
    public @ResponseBody List<String> shareSurvey(@RequestBody List<String> contacts) throws GeneralSecurityException, IOException, MessagingException {
        surveyService.share(contacts);
        return contacts;
    }

    @GetMapping("/survey")
    public @ResponseBody Survey getSurveyDetails() {
        return surveyService.getSurvey();
    }




}
