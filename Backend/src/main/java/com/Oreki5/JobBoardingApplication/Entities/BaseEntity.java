package com.Oreki5.JobBoardingApplication.Entities;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
public class BaseEntity {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
