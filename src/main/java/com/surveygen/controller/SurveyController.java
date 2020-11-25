package com.surveygen.controller;

import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import com.surveygen.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SurveyController {

    @Autowired
    SurveyService surveyService;

//    @GetMapping("/survey")
//    public @ResponseBody List<Survey> getSurveyDetails(@RequestParam("id") int responses) {
//
//        return surveyService.findByResponses(responses);
//
//        System.out.println( surveyRepository.findAll());
//        System.out.println("over over over.............................");
//
//        List<Survey> temp = surveyRepository.findAll();
//
//        return temp;
//    }

    @PostMapping("/survey")
    public @ResponseBody Survey createSurvey(@RequestBody Survey survey){
        return surveyService.create(survey);
    }




}
