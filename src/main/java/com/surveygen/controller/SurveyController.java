package com.surveygen.controller;

import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.model.Mongo.User;
import com.surveygen.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @CrossOrigin(origins="*")
    @PostMapping("/survey")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey, HttpSession session){
        return new ResponseEntity<Survey>(surveyService.create(survey), HttpStatus.OK);
        // inserts the survey in mongo db
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

    @CrossOrigin(origins="*")
    @GetMapping("/retrieveSurvey")
    public ResponseEntity<Survey> getSurveyDetails() {
        return new ResponseEntity<Survey>(surveyService.getSurvey(), HttpStatus.OK);
    }

    @GetMapping("/getSurvey")
    public @ResponseBody Survey getSurveyFromId(@RequestParam String id){
        return surveyService.getSurveyFromId(id);
    }

}
