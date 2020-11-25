package com.surveygen.Repository.Mongo;

import com.surveygen.model.Mongo.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SurveyRepository extends MongoRepository<Survey, String> {

}
