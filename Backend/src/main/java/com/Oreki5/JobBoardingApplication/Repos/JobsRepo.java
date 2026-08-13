package com.Oreki5.JobBoardingApplication.Repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Jobs;

public interface JobsRepo extends MongoRepository<Jobs, ObjectId>{

}
