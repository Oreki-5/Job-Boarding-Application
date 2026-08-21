package com.Oreki5.JobBoardingApplication.Entities;

import java.util.List;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsRequestModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "jobs")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Jobs extends BaseEntity{

    @TextIndexed
    private String jobTitle;

    private String jobDescription;

    @DBRef
    private Employers employer;

    @TextIndexed
    private List<String> reqSkills;

    private List<String> optionalSkills;

    private String workMode;

    private int salary;

    
    
    public void mapToJob(JobsRequestModel jobRequest){
        this.jobTitle =  jobRequest.getJobTitle();
        this.jobDescription = jobRequest.getJobDescription();
        this.employer = jobRequest.getEmployer();
        this.reqSkills = jobRequest.getReqSkills();
        this.optionalSkills = jobRequest.getOptionalSkills();
        this.workMode = jobRequest.getWorkMode();
        this.salary = jobRequest.getSalary();
        System.out.println("Hi");
    }


}
