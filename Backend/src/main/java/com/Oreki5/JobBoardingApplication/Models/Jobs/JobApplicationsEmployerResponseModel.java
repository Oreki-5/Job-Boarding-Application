package com.Oreki5.JobBoardingApplication.Models.Jobs;

import java.util.ArrayList;
import java.util.List;

import com.Oreki5.JobBoardingApplication.Entities.JobApplications;

import lombok.Data;

@Data
public class JobApplicationsEmployerResponseModel {

    private String candidateName;
    private int experience;
    private String resume;
    private String email;
    private int expectedSalary;
    private String coverLetter;

    public JobApplicationsEmployerResponseModel(JobApplications application) {
        this.candidateName = application.getCandidate().getFirstName() + " " + application.getCandidate().getLastName();
        this.experience = application.getCandidate().getExperience();
        this.resume = application.getCandidate().getResume();
        this.email = application.getCandidate().getEmail();
        this.expectedSalary = application.getCandidate().getExpectedSalary();
        this.coverLetter = application.getCoverLetter();
    }

    public static List<JobApplicationsEmployerResponseModel> toEmployersResponse(List<JobApplications> applications){

        List<JobApplicationsEmployerResponseModel> listOfApplications = new ArrayList<>();
        applications.forEach(application->{
            listOfApplications.add(new JobApplicationsEmployerResponseModel(application));
        });
        return listOfApplications;
    }




}
