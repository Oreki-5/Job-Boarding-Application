package com.Oreki5.JobBoardingApplication.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class Users {
    @Id
    private ObjectId id;

    private String username;

    private String password;

    private String role;

}
