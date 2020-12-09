package com.surveygen.controller;

import com.surveygen.model.Mongo.Response;
import com.surveygen.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @CrossOrigin(origins="*")
    @PostMapping("/responses")
    public ResponseEntity<Response> addResponse(@RequestBody Response response){
        return new ResponseEntity<Response>(responseService.addResponseDetails(response), HttpStatus.OK);
    }
    
    @CrossOrigin(origins="*")
    @GetMapping("/retrieveResponses")
    public ResponseEntity<Response> getResponse(){
        return new ResponseEntity<Response>(responseService.getResponseDetails(), HttpStatus.OK);
    }
 
}
