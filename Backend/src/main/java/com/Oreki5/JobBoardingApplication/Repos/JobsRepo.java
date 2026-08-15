package com.Oreki5.JobBoardingApplication.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Oreki5.JobBoardingApplication.Entities.Jobs;

public interface JobsRepo extends MongoRepository<Jobs, String> {

    // Jobs findByJobTitle(String jobTitle);

    @Aggregation(pipeline = {
            "{'$search':{'index': 'title_skill_text', 'text': {'query': ?0, 'path': ['jobTitle', 'reqSkills', 'optionalSkills']}}}",
            "{'$skip': ?1}",
            "{'$limit': ?2}"
        })
    List<Jobs> getCustomResult(String text, int skip, int limit);

}
