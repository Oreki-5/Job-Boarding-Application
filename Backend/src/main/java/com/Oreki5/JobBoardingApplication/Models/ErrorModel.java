package com.Oreki5.JobBoardingApplication.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorModel {
    private String status;
    private String desc;
    private String message;


}
