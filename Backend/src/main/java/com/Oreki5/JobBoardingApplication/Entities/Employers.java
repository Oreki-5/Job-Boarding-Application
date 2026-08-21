package com.Oreki5.JobBoardingApplication.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersRequestModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "employers")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employers extends Users {

    public String companyName;
    public String companyDesc;
    public String rating;
    public int employeeCount;
    public String foundedYear;


    public class companyName {
    }

    public class companyDesc {
    }

    public void mapToEmployers(EmployersRequestModel employersRequestModel) {
        this.setId(employersRequestModel.getId());
        this.setUsername(employersRequestModel.getUsername());
        this.companyName = employersRequestModel.getCompanyName();
        this.companyDesc = employersRequestModel.getCompanyDesc();
        this.rating = employersRequestModel.getRating();
        this.employeeCount = employersRequestModel.getEmployeeCount();
        this.foundedYear = employersRequestModel.getFoundedYear();
    }

}
