package com.Oreki5.JobBoardingApplication.Models.Jobs;

import java.time.LocalDateTime;
import java.util.List;

import com.Oreki5.JobBoardingApplication.Entities.Employers;

import lombok.Data;

@Data
public class JobsRequestModel {


    private String jobTitle;

    private Employers employer;

    private String jobDescription;

    private List<String> reqSkills;

    private List<String> optionalSkills;

    private String workMode;

    private int salary;

}
