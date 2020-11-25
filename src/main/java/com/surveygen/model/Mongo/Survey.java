package com.surveygen.model.Mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "surveys")
public class Survey {

    @Id
    private String id;

    private int requested;

    private int responses;

    @DBRef
    private User owner;

    private List<String> questions;
}
