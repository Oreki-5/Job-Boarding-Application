package com.Oreki5.JobBoardingApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersRequestModel;
import com.Oreki5.JobBoardingApplication.Models.Employers.EmployersResponseModel;
import com.Oreki5.JobBoardingApplication.Models.ResponseModel;
import com.Oreki5.JobBoardingApplication.Services.EmployersService;

@RestController
@RequestMapping("/employers")
public class EmployersController {

    @Autowired
    private EmployersService employersService;


    @PostMapping("/details")
    public ResponseModel<EmployersResponseModel> saveEmployeeDetails(@RequestBody EmployersRequestModel user) {
        return employersService.saveEmployeeDetails(user);

    }

    @GetMapping("/{id}")
    public ResponseModel<EmployersResponseModel> getEmployersById(@PathVariable String id) {
        return employersService.getById(id);
    }



}
