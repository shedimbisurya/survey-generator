package com.surveygen.Repository.Mongo;

import com.surveygen.model.Mongo.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


public interface SurveyRepository extends MongoRepository<Survey, String> {

}
