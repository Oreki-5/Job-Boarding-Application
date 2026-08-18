package com.Oreki5.JobBoardingApplication.Entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection="jobApplications")
@Data
@EqualsAndHashCode(callSuper=false)
public class JobApplications extends BaseEntity {

    @NonNull
    @Indexed
    @DBRef
    private Jobs job;

    @NonNull
    @DBRef
    private Candidates candidate;
    
    private String status;
    
    private String coverLetter;

    public JobApplications(Jobs job, String coverLetter,Candidates candidate) {
        this.job = job;
        this.status = "applied";
        this.coverLetter = coverLetter;
        this.candidate = candidate;
    }



    public JobApplications copy(){
        return this;
    }
    
}
