package com.maveric.techhub.project.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Project")
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @Column
    private String id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String technologies;
    @Column
    private String dependencies;
    @Column
    private String keyMembers;
    @Column
    private String contactPerson;
    @Column
    private String referenceMaterials;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
