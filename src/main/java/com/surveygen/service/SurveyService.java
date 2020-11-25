package com.surveygen.service;

import com.surveygen.Repository.Mongo.SurveyRepository;
import com.surveygen.model.Mongo.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    public Survey create(Survey survey){
        return surveyRepository.insert(survey);
    }

}
