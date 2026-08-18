package com.Oreki5.JobBoardingApplication.Models;

import java.sql.Date;
import lombok.Data;

@Data
public class WorkExperience {
    private String companyName;
    private String jobOverview;
    private Date startDate;
    private Date endDate;
    private int experienceYears;
}
