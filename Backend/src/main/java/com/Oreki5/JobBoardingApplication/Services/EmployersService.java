package com.Oreki5.JobBoardingApplication.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.JobBoardingApplication.Entities.Employers;
import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersResponseModel;
import com.Oreki5.JobBoardingApplication.Models.ResponseModel;
import com.Oreki5.JobBoardingApplication.Repos.EmployersRepo;

@Service
public class EmployersService {

    @Autowired
    private EmployersRepo employersRepo;

    public ResponseModel<EmployersResponseModel> saveEmployeeDetails(EmployersRequestModel user){
        
        Employers employer = new Employers();
        employer.setUpdatedAt(LocalDateTime.now());
        employer.mapToEmployers(user);
        return new ResponseModel<>(new EmployersResponseModel(employersRepo.save(employer)));
    }

    public ResponseModel<EmployersResponseModel> getById(String id) {
        Employers employer = employersRepo.findById(id).get();
        return new ResponseModel<>(new EmployersResponseModel(employer));
    }

}
