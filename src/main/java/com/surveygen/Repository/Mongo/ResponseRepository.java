package com.surveygen.Repository.Mongo;

import com.surveygen.model.Mongo.Response;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseRepository extends MongoRepository<Response, String> {

    public List<Response> findByEmail(String email);
    public List<Response> findBySurvey(String survey_id);

}
