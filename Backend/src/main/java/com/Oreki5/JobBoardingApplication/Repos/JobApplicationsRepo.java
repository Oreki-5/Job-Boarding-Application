package com.Oreki5.JobBoardingApplication.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;

public interface JobApplicationsRepo extends MongoRepository<JobApplications, String>{

    public List<JobApplications> findAllByJobId(String jobId);

    public List<JobApplications> findAllByJobAndCandidate(Jobs job, Candidates candidate);



}
