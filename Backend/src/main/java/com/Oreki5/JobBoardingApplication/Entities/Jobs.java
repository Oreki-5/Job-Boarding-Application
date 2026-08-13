package com.Oreki5.JobBoardingApplication.Entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="jobs")
@Data
@NoArgsConstructor
public class Jobs {
    @Id
    private ObjectId id;

    @Indexed
    private String jobTitle;

    private String jobDescription;

    @Indexed
    private List<String> reqSkills;

    private List<String> optionalSkills;

    private String workMode;

    private int salary;

}
