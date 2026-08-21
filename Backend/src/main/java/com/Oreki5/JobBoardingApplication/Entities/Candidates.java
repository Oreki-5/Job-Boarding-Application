package com.Oreki5.JobBoardingApplication.Entities;

import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Oreki5.JobBoardingApplication.Models.WorkExperience;
import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection="candidates")
@Data
public class Candidates extends Users{
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Date dob;
    @NonNull
    private List<String> skills = new ArrayList<>();
    private int experience;
    private WorkExperience workExperience; //workExperience Object
    private String resume; // stores path
    private String employmentStatus;
    private String location;
    @NonNull
    private String email;
    private int expectedSalary; //in LPA
    private String professionalSummary;
    private String profilePicture; // stores path


    

}
