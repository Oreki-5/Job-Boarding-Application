package com.Oreki5.JobBoardingApplication.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;

public interface JobApplicationsRepo extends MongoRepository<JobApplications, String> {

    @Query(value="{ 'job' : ?2 }")
    @Aggregation(pipeline = { "{'$skip': ?0}", "{'$limit': ?1}" })
    public List<JobApplications> findCustom(int skip, int limit, Jobs job);

    public List<JobApplications> findAllByJobAndCandidate(Jobs job, Candidates candidate);

    public long countByJob(Jobs jobId);

}
