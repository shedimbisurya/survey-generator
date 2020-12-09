package com.surveygen.controller;

import com.surveygen.model.Mongo.Response;
import com.surveygen.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/responses")
    public @ResponseBody Response addResponse(@RequestBody Response response){
        return responseService.addResponseDetails(response);
    }

    @GetMapping("/responses")
    public @ResponseBody Response getResponse(){
        return responseService.getResponseDetails();
    }
 
}
