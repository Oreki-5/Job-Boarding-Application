package com.Oreki5.JobBoardingApplication.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersRequestModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employers extends Users {

    public String companyName;
    public String companyDesc;
    public String rating;
    public int employeeCount;
    public String foundedYear;

    @DBRef
    private List<Jobs> jobListings = new ArrayList<>();

    public class companyName {
    }

    public class companyDesc {
    }

    public void mapToEmployers(EmployersRequestModel employersRequestModel) {
        this.companyName = employersRequestModel.getCompanyDesc();
        this.companyDesc = employersRequestModel.getCompanyDesc();
        this.rating = employersRequestModel.getRating();
        this.employeeCount = employersRequestModel.getEmployeeCount();
        this.foundedYear = employersRequestModel.getFoundedYear();
    }

}
