package com.surveygen.model.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Data
@Document(collection="responses")
public class Response {

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef
    private Survey survey;

    private List<String> answers;

}
