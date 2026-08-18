package com.Oreki5.JobBoardingApplication.Models.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;
import com.Oreki5.JobBoardingApplication.Repos.JobsRepo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JobApplicationsResponseModel {
    private String id;

    private String jobTitle;

    private String companyName;

    private String candidateName;

    private String status;
    
    private String coverLetter;


    public JobApplicationsResponseModel(JobApplications application) {
        this.id = application.getId();
        this.candidateName = application.getCandidate().getFirstName() +" " + application.getCandidate().getLastName();
        this.jobTitle = application.getJob().getJobTitle();
        this.companyName = application.getJob().getEmployer().getCompanyName();
        this.status = application.getStatus();
        this.coverLetter = application.getCoverLetter();
    }


    
    



}
