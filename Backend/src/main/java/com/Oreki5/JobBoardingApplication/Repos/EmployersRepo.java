package com.Oreki5.JobBoardingApplication.Repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Employers;

public interface EmployersRepo extends MongoRepository<Employers, String>{
    Employers findByUsername(String username);
}
