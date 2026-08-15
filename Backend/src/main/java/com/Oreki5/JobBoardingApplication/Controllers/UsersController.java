package com.Oreki5.JobBoardingApplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Oreki5.JobBoardingApplication.Entities.Employers;
import com.Oreki5.JobBoardingApplication.Services.UsersService;

@RestController
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/users")
    public void saveUser(@RequestBody Employers user) {
        usersService.saveUser(user);

    }

    @GetMapping("/users")
    public List<Employers> getEmployers() {
        return usersService.getAll();
    }



}
