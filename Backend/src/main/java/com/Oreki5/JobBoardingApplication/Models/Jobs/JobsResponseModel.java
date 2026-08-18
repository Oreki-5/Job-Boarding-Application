package com.Oreki5.JobBoardingApplication.Models.Jobs;

import java.util.List;

import org.springframework.data.mongodb.core.index.TextIndexed;

import com.Oreki5.JobBoardingApplication.Entities.Employers;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;

import lombok.Data;

@Data
public class JobsResponseModel {
    
    private String id;

    private String jobTitle;

    private String jobDescription;

    private String employerName;

    private String companyName;

    private List<String> reqSkills;

    private List<String> optionalSkills;

    private String workMode;

    private int salary;

    public JobsResponseModel(Jobs job) {
        this.id = job.getId();
        this.jobTitle = job.getJobTitle();
        this.jobDescription = job.getJobDescription();
        this.reqSkills = job.getReqSkills();
        this.optionalSkills = job.getOptionalSkills();
        this.workMode = job.getWorkMode();
        this.salary = job.getSalary();
        this.employerName = job.getEmployer().getUsername();
        this.companyName = job.getEmployer().getCompanyName();
    }

    



}
