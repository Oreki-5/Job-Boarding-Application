package com.Oreki5.JobBoardingApplication.Entities;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Document(collection = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Employers extends Users{

    private String companyName;
    private String companyDesc;

    @DBRef
    private List<Jobs> jobListings = new ArrayList<>();
    
}
