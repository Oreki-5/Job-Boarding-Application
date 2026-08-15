package com.Oreki5.JobBoardingApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.JobBoardingApplication.Entities.Jobs;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsRequestModel;
import com.Oreki5.JobBoardingApplication.Models.ResponseModel;
import com.Oreki5.JobBoardingApplication.Services.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobListingController {

    @Autowired
    private JobsService jobsService;

    @PostMapping("/{username}")
    public ResponseModel<Jobs> createJobListing(@RequestBody JobsRequestModel jobRequest, @PathVariable String username) {
        return jobsService.saveJobListing(jobRequest, username);

    }

    @GetMapping("/{username}")
    public ResponseModel<List<Jobs>> getJobs(@PathVariable String username) {
        return jobsService.getJobListingsByUsername(username);
        
    }
    @GetMapping("/search/{text}")
    public ResponseModel<PagedModel<Jobs>> getCustomResults(@PathVariable String text ,@RequestParam int page,  @RequestParam int size) {
        return jobsService.getCustomResults(text,page,size);
        
    }

    @PutMapping("/{username}")
    public ResponseModel<Jobs> updateJobListing(@RequestBody JobsRequestModel jobRequest, @PathVariable String username) {
        return jobsService.saveJobListing(jobRequest, username);
    }

    @DeleteMapping("/{id}")
    public void deleteJobListing(@PathVariable String id) {
        jobsService.deleteJobListing(id);
    }

}
