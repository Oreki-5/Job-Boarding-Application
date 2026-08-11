package com.Oreki5.JobBoardingApplication.Repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Users;

public interface UsersRepo extends MongoRepository<Users, ObjectId>{

}
