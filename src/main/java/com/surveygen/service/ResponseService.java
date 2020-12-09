package com.surveygen.service;

import com.surveygen.Repository.Mongo.ResponseRepository;
import com.surveygen.model.Mongo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    ResponseRepository responseRepository;

    public Response addResponseDetails(Response response){
        response.setEmail("test@uci.edu");
        response.setName("Tester");

        return responseRepository.insert(response);
    }

    public Response getResponseDetails(){
        List<Response> responses = responseRepository.findByEmail("test@uci.edu");

        return responses.get(responses.size()-1);
    }

}
