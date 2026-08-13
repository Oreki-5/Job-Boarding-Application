package com.Oreki5.JobBoardingApplication.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Users {
    @Id
    private ObjectId id;

    private String username;

    private String password;

    private String role;

}
