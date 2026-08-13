package com.Oreki5.JobBoardingApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.JobBoardingApplication.Entities.Employers;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;
import com.Oreki5.JobBoardingApplication.Repos.EmployersRepo;
import com.Oreki5.JobBoardingApplication.Repos.JobsRepo;

@Service
public class JobsService {

    @Autowired
    private JobsRepo jobsRepo;
    @Autowired
    private EmployersRepo employersRepo;

    public void createJob(Jobs job, String username){
        jobsRepo.save(job);
        Employers employer = employersRepo.findByUsername(username);
        employer.getJobListings().add(job);

        employersRepo.save(employer);

    }

}
