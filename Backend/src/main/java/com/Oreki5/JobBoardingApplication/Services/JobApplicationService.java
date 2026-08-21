package com.Oreki5.JobBoardingApplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsEmployerResponseModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplicationsResponseModel;
import com.Oreki5.JobBoardingApplication.Repos.CandidatesRepo;
import com.Oreki5.JobBoardingApplication.Repos.JobApplicationsRepo;
import com.Oreki5.JobBoardingApplication.Repos.JobsRepo;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationsRepo applicationsRepo;

    @Autowired
    private CandidatesRepo candidatesRepo;

    @Autowired
    private JobsRepo jobsRepo;

    // cw
    // check for duplicate record -> remaining
    @Transactional
    public JobApplicationsResponseModel saveApplication(JobApplicationsRequestModel jobApplicationRequest)
            throws NullPointerException,IllegalStateException {

        JobApplications application = new JobApplications(
                jobsRepo.findById(jobApplicationRequest.getJobId()).orElseThrow(),
                jobApplicationRequest.getCoverLetter(),
                candidatesRepo.findById(jobApplicationRequest.getCandidateId()).orElseThrow());

        List<JobApplications> j = applicationsRepo.findAllByJobAndCandidate(application.getJob(),
                application.getCandidate());
        if (!j.isEmpty()) {
            throw new IllegalStateException("You Already Applied for this job");
        }
        String newApplicationId = applicationsRepo.save(application).getId();
        JobApplications savedApplication = applicationsRepo.findById(newApplicationId).orElseThrow();
        Candidates candidate = candidatesRepo.findById(savedApplication.getCandidate().getId()).orElseThrow();
        candidatesRepo.save(candidate.addApplication(application));
        return new JobApplicationsResponseModel(savedApplication);
    }

    public void deleteJobApplication(String id) {
        applicationsRepo.deleteById(id);
    }

    public PagedModel<JobApplicationsEmployerResponseModel> getAllApplicationsByJobId(String jobId, int pageOffset, int pageSize) {
        Pageable pageable = PageRequest.of(pageOffset,pageSize);
        List<JobApplicationsEmployerResponseModel> data = JobApplicationsEmployerResponseModel.toEmployersResponse(applicationsRepo.findCustom(pageOffset,pageSize,jobsRepo.findById(jobId).orElseThrow()));
        Page<JobApplicationsEmployerResponseModel> pagedList = new PageImpl<>(data,pageable,applicationsRepo.countByJob(jobsRepo.findById(jobId).orElseThrow()));
        return new PagedModel<>(pagedList);
    }

    public JobApplications updateApplication(String id, JobApplications application) {
        application.setId(id);
        return applicationsRepo.save(application);

    }

}
