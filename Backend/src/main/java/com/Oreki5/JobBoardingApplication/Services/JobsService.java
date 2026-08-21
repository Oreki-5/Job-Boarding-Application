package com.Oreki5.JobBoardingApplication.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Oreki5.JobBoardingApplication.Entities.Jobs;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsResponseModel;
import com.Oreki5.JobBoardingApplication.Models.ResponseModel;
import com.Oreki5.JobBoardingApplication.Repos.EmployersRepo;
import com.Oreki5.JobBoardingApplication.Repos.JobsRepo;

@Service
public class JobsService {

    @Autowired
    private JobsRepo jobsRepo;
    @Autowired
    private EmployersRepo employersRepo;

    public void createJob(Jobs job, String username) {

    }

    @Transactional
    public ResponseModel<JobsResponseModel> saveJobListing(JobsRequestModel jobRequest, String employerId)
            throws Exception {

        jobRequest.setEmployer(employersRepo.findById(employerId).orElseThrow());
        Jobs job = new Jobs();
        job.mapToJob(jobRequest);
        job.setCreatedAt(LocalDateTime.now());
        // throw new Exception("custom exception");
        jobsRepo.save(job);
        return new ResponseModel<>(new JobsResponseModel(job));

    }

    public ResponseModel<JobsResponseModel> updateJobListing(JobsRequestModel jobRequest, String id) throws Exception {

        Jobs existingJob = jobsRepo.findById(id).orElseThrow();
        existingJob.mapToJob(jobRequest);
        existingJob.setUpdatedAt(LocalDateTime.now());
        return new ResponseModel<>(new JobsResponseModel(jobsRepo.save(existingJob)));

    }

    // Need to created a separate response model since it has infinite nested Refs
    // of each other
    public ResponseModel<List<Jobs>> getJobListingsByEmployerId(String employerId) {
        // List<Jobs> list = jobsRepo.findByEmployer(employersRepo.findById(employerId).orElseThrow());
        return new ResponseModel<>(jobsRepo.findByEmployer(employersRepo.findById(employerId).orElseThrow()));
    }

    public ResponseModel<PagedModel<Jobs>> getCustomResults(String text, int page, int size) {

        int skip = page * size;
        List<Jobs> data = jobsRepo.getCustomResult(text, skip, size);

        Pageable p = PageRequest.of(page, size);
        Page<Jobs> pagedJobs = new PageImpl<>(data, p, jobsRepo.count());
        return new ResponseModel<>(new PagedModel<>(pagedJobs));
    }

    public void deleteJobListing(String id) {
        jobsRepo.deleteById(id);
    }

}
