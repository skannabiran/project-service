package com.maveric.techhub.project.repository;

import com.maveric.techhub.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {

    Optional<Project> findById(String Id);

    Optional<Project> findByTitle(String title);

}