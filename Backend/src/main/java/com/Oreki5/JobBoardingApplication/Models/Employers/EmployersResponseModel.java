package com.Oreki5.JobBoardingApplication.Models.Employers;

import java.time.LocalDateTime;

import com.Oreki5.JobBoardingApplication.Entities.Employers;

import lombok.Data;

@Data
public class EmployersResponseModel {
    public String id;
    public String username;
    public String companyName;
    public String companyDesc;
    public String rating;
    public int employeeCount;
    public String foundedYear;
    public LocalDateTime updatedAt;

    public EmployersResponseModel(Employers employer){
        mapFromEmployers(employer);
    }

    public final void mapFromEmployers(Employers employer) {
        this.id = employer.getId();
        this.username = employer.getUsername();
        this.companyName = employer.getCompanyName();
        this.companyDesc = employer.getCompanyDesc();
        this.rating = employer.getRating();
        this.employeeCount = employer.getEmployeeCount();
        this.foundedYear = employer.getFoundedYear();
        this.updatedAt = employer.getUpdatedAt();
    }
}
