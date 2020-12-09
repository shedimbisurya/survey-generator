package com.surveygen.model.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Document(collection = "surveys")
public class Survey {

    @Id
    private String id;

    private int requested;

    private int responses;

    private List<String> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRequested() {
        return requested;
    }

    public void setRequested(int requested) {
        this.requested = requested;
    }

    public int getResponses() {
        return responses;
    }

    public void setResponses(int responses) {
        this.responses = responses;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

}
