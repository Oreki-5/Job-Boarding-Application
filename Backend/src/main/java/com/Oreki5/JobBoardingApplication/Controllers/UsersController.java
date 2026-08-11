package com.Oreki5.JobBoardingApplication.Controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Oreki5.JobBoardingApplication.Services.UsersService;
import com.Oreki5.JobBoardingApplication.Entities.Users;


@RestController
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/user")
    public void saveUser(@RequestBody Users user) {
        usersService.saveUser(user);
        
    }
    

}
