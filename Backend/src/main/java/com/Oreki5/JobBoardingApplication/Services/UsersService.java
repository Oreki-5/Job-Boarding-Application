package com.Oreki5.JobBoardingApplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Oreki5.JobBoardingApplication.Entities.Employers;
import com.Oreki5.JobBoardingApplication.Repos.EmployersRepo;

@Service
public class UsersService {

    @Autowired
    private EmployersRepo usersRepo;

    public void saveUser(Employers user){
        usersRepo.save(user);
    }
    public List<Employers> getAll(){
        return usersRepo.findAll();
    }

}
