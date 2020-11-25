package com.surveygen.model.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String name;

    private String email;

    @DBRef
    private List<Survey> surveysList;

}
