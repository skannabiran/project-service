package com.maveric.techhub.project.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class ProjectDTO {

    private String id;
    private String title;
    private String description;
    private String technologies;
    private String dependencies;
    private String keyMembers;
    private String contactPerson;
    private String referenceMaterials;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
