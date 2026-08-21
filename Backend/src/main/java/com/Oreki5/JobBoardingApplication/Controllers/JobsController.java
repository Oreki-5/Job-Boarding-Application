package com.Oreki5.JobBoardingApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Entities.Jobs;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsEmployerResponseModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsResponseModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobsResponseModel;
import com.Oreki5.JobBoardingApplication.Models.ResponseModel;
import com.Oreki5.JobBoardingApplication.Services.JobApplicationService;
import com.Oreki5.JobBoardingApplication.Services.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    @Autowired
    private JobApplicationService applicationsService;
    /*
     * 
     * Job Listing related controls
     * 
     */

    @PostMapping("/{employerId}")
    public ResponseModel<JobsResponseModel> createJobListing(@RequestBody JobsRequestModel jobRequest,
            @PathVariable String employerId)
            throws Exception {
        return jobsService.saveJobListing(jobRequest, employerId);

    }

    @GetMapping("/{employerId}")
    public ResponseModel<List<Jobs>> getJobs(@PathVariable String employerId) {
        return jobsService.getJobListingsByUsername(employerId);

    }

    @GetMapping("/search/{text}")
    public ResponseModel<PagedModel<Jobs>> getCustomResults(@PathVariable String text, @RequestParam int page,
            @RequestParam int size) {
        return jobsService.getCustomResults(text, page, size);

    }

    @PutMapping("/{username}")
    public ResponseModel<JobsResponseModel> updateJobListing(@RequestBody JobsRequestModel jobRequest,
            @PathVariable String username)
            throws Exception {
        return jobsService.saveJobListing(jobRequest, username);
    }

    @DeleteMapping("/{id}")
    public void deleteJobListing(@PathVariable String id) {
        jobsService.deleteJobListing(id);
    }

    /*
     * 
     * Job Application related controls
     * 
     */

    @PostMapping("/apply")
    public ResponseEntity<?> applyForJob(@RequestBody JobApplicationsRequestModel jobApplicationsRequest) {
        // TODO: process POST request

        try {
            return new ResponseEntity<>(applicationsService.saveApplication(jobApplicationsRequest),
                    HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/apply/{id}")
    public void deleteJobApplication(@PathVariable String id) {
        applicationsService.deleteJobApplication(id);
        // delete application
    }

    // Needs Paginated response
    @GetMapping("/applications/{jobId}")
    public PagedModel<JobApplicationsEmployerResponseModel> getAllApplicationsForTheJob(@PathVariable String jobId,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {

        return applicationsService.getAllApplicationsByJobId(jobId, page, size);
    }

    @PutMapping("/applications/{id}")
    public JobApplications updateJobApplication(@PathVariable String id, @RequestBody JobApplications application) {
        // TODO: process PUT request

        return applicationsService.updateApplication(id, application);

    }

}
