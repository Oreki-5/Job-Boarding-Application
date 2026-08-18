package com.Oreki5.JobBoardingApplication.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;

public interface CandidatesRepo extends MongoRepository<Candidates, String>{

    

}
