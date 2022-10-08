package com.maveric.techhub.project.mapper;

import com.maveric.techhub.project.entity.Project;
import com.maveric.techhub.project.model.ProjectDTO;
import com.maveric.techhub.project.model.ProjectRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toEntity(ProjectRequest request);
    ProjectDTO toDTO(Project project);

    List<ProjectDTO> toDTO(List<Project> projects);

}
