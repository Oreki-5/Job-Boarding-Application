package com.Oreki5.JobBoardingApplication.Entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Users extends BaseEntity {

    private String username;

    private String password;

    private String role;

}
