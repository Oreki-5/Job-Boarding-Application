package com.Oreki5.JobBoardingApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.JobBoardingApplication.Entities.Candidates;
import com.Oreki5.JobBoardingApplication.Models.Jobs.JobApplications.JobApplicationsResponseModel;
import com.Oreki5.JobBoardingApplication.Services.CandidatesService;





@RestController
@RequestMapping("/candidates")
public class CandidatesController {

    @Autowired
    private CandidatesService candidatesService;

    @PostMapping
    public Candidates createCandidate(@RequestBody Candidates candidate) {

        return candidatesService.createCandidate(candidate);
        
    }

    @PutMapping("/{id}")
    public Candidates updaCandidate(@PathVariable String id, @RequestBody Candidates candidate) {
        //TODO: process PUT request
        return candidatesService.updateCandidate(id,candidate);        
    }


    @GetMapping("/{id}")
    public Candidates getCandidateInfo(@PathVariable String id) {

        return candidatesService.getCandidateProfile(id); 
    }

    @GetMapping("/applications/{id}")
    public List<JobApplicationsResponseModel> getAllApplicationsOfCandidate(@PathVariable String id) {
        return candidatesService.getAllApplicationsOfCandidate(id); 
        
    }


    @DeleteMapping("/{id}")
    public void deleteCandidateProfile(@PathVariable String id){

        candidatesService.deleteCandidateProfileById(id);
        
    }
    
    



    
}
