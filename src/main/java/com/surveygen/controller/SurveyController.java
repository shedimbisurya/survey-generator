package com.surveygen.controller;

import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.model.Mongo.User;
import com.surveygen.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    public @ResponseBody Survey createSurvey(@RequestBody Survey survey){
        return surveyService.create(survey);
    }

    // this method is not completed
    @PostMapping("/shareSurvey")
    public @ResponseBody List<String> shareSurvey(@RequestBody List<String> contacts) throws GeneralSecurityException, IOException, MessagingException {
        surveyService.share(contacts);
        return contacts;
    }

    @GetMapping("/survey")
    public @ResponseBody List<Survey> getSurveyDetails(@RequestParam("id") int responses) {
        System.out.println( surveyRepository.findAll());
        System.out.println("over over over.............................");

        List<Survey> temp = surveyRepository.findAll();

        return temp;
    }



}
