package com.Oreki5.JobBoardingApplication.Models.Employers;

import lombok.Data;

@Data
public class EmployersRequestModel {
    private String companyName;
    private String companyDesc;
    private String rating;
    private int employeeCount;
    private String foundedYear;
}
