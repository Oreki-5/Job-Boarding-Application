package com.Oreki5.JobBoardingApplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Entities.JobApplications;
import com.Oreki5.JobBoardingApplication.Repos.CandidatesRepo;

@Service
public class CandidatesService {

    @Autowired
    private CandidatesRepo candidatesRepo;

    public Candidates createCandidate(Candidates candidate) {
        return candidatesRepo.save(candidate);
    }

    public Candidates updateCandidate(String id,Candidates candidate) {
        candidate.setId(id);
        return candidatesRepo.save(candidate);
    }

    public Candidates getCandidateProfile(String id) {
        return candidatesRepo.findById(id).orElseThrow();
    }

    public List<JobApplications> getAllApplicationsOfCandidate(String id) {
        return candidatesRepo.findById(id).orElseThrow().getApplications();
    }

    public void deleteCandidateProfileById(String id) {
        candidatesRepo.deleteById(id);
    }

}
