package com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplications;

import lombok.Data;

@Data
public class JobApplicationsRequestModel {

    private String jobId;

    private String candidateId;

    private String coverLetter;
}
