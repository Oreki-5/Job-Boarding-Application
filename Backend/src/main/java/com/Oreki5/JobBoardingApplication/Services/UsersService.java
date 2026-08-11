package com.Oreki5.JobBoardingApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.JobBoardingApplication.Entities.Users;
import com.Oreki5.JobBoardingApplication.Repos.UsersRepo;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public void saveUser(Users user){
        usersRepo.save(user);
    }

}
