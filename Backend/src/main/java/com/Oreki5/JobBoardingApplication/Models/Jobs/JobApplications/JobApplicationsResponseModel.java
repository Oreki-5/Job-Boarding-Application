package com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplications;

import java.util.ArrayList;
import java.util.List;

import com.Oreki5.JobBoardingApplication.Entities.JobApplications;

import lombok.Data;

@Data
public class JobApplicationsResponseModel {
    private String id;

    private String jobTitle;

    private String companyName;

    private String status;
    
    private String coverLetter;


    public JobApplicationsResponseModel(JobApplications application) {
        this.id = application.getId();
        // this.candidateName = application.getCandidate().getFirstName() +" " + application.getCandidate().getLastName();
        this.jobTitle = application.getJob().getJobTitle();
        this.companyName = application.getJob().getEmployer().getCompanyName();
        this.status = application.getStatus();
        this.coverLetter = application.getCoverLetter();
    }


    public static List<JobApplicationsResponseModel> convertFromJobApplications(List<JobApplications> applications){
        List<JobApplicationsResponseModel> converted = new ArrayList<>();
        for(JobApplications application : applications){
            converted.add(new JobApplicationsResponseModel(application));
        }
        return converted;
    }
    



}
