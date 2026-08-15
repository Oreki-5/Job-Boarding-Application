package com.Oreki5.JobBoardingApplication.Models.Jobs;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class JobsRequestModel {

    private String id;

    private String jobTitle;

    private String jobDescription;

    private List<String> reqSkills;

    private List<String> optionalSkills;

    private String workMode;

    private int salary;
    
    private LocalDateTime updatedAt = LocalDateTime.now();
}
