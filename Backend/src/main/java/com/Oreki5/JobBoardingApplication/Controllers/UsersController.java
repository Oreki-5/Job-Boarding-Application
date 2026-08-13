package com.Oreki5.JobBoardingApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.Oreki5.JobBoardingApplication.Services.UsersService;
import com.Oreki5.JobBoardingApplication.Services.JobsService;
import com.Oreki5.JobBoardingApplication.Entities.Employers;
// import com.Oreki5.JobBoardingApplication.Entities.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Oreki5.JobBoardingApplication.Entities.Jobs;

@RestController
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JobsService jobsService;

    @PostMapping("/users")
    public void saveUser(@RequestBody Employers user) {
        usersService.saveUser(user);

    }

    @GetMapping("/users")
    public List<Employers> getEmployers() {
        return usersService.getAll();
    }

    @PostMapping("/jobs/{username}")
    public void saveJobs(@RequestBody Jobs job ,@PathVariable String username) {
        jobsService.createJob(job,username);

    }

    @GetMapping("/jobs/{username}")
    public List<Jobs> getJobs() {
        return null;
    }

}
