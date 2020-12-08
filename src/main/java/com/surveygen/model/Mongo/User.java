package com.surveygen.model.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@Document(collection = "users")
public class User {
    
    @Id
    private String id;

    private String name;

    private String email;

    @DBRef
    private List<Survey> surveysList;

    public List<Survey> getSurveysList() {
        return surveysList;
    }

    public void addSurveytoSurveysList(Survey survey){
        System.out.println("sdkfjlhaskljdfhaskdjfh;awdlfsF  WF  GWG     ");
        surveysList.add(survey);
        System.out.println("ADDED");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
