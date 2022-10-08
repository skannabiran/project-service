package com.maveric.techhub.project.service;

import com.maveric.techhub.project.entity.Project;
import com.maveric.techhub.project.mapper.ProjectMapper;
import com.maveric.techhub.project.model.ProjectDTO;
import com.maveric.techhub.project.model.ProjectRequest;
import com.maveric.techhub.project.repository.ProjectRepository;
import com.maveric.techhub.project.exception.EntityNotFoundException;
import com.maveric.techhub.project.model.ServiceResponse;
import com.maveric.techhub.project.util.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ResponseEntity<ServiceResponse> createProject(ProjectRequest projectRequest) {
        String title = projectRequest.getTitle();
        Optional<Project> optionalIdea = projectRepository.findByTitle(projectRequest.getTitle());
        if (!optionalIdea.isPresent()) {
            Project project = projectMapper.toEntity(projectRequest);
            project.setId(ServiceConstants._UUID());
            projectRepository.save(project);
            ProjectDTO projectDTO = projectMapper.toDTO(project);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ServiceResponse.builder().response(projectDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_ALREADY_EXISTS, title));
    }

    public ResponseEntity<ServiceResponse> getProject(String id) {
        Optional<Project> optionalUser = projectRepository.findById(id);
        if (optionalUser.isPresent()) {
            Project project = optionalUser.get();
            ProjectDTO projectDTO = projectMapper.toDTO(project);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(projectDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> updateProject(String id, ProjectRequest projectRequest) {
        Optional<Project> optionalUserDB = projectRepository.findById(id);
        if (optionalUserDB.isPresent()) {
            Project projectDB = optionalUserDB.get();
            Project project = projectMapper.toEntity(projectRequest);
            project.setId(projectDB.getId());
            projectRepository.save(project);
            ProjectDTO projectDTO = projectMapper.toDTO(project);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(projectDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> deleteProject(String id) {
        Optional<Project> optionalUser = projectRepository.findById(id);
        if (optionalUser.isPresent()) {
            Project project = optionalUser.get();
            projectRepository.delete(project);
            ServiceResponse response = ServiceResponse.builder().
                    message(String.format(ServiceConstants.ENTITY_DELETED, id)).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> getIdeas() {
        ServiceResponse response = ServiceResponse.builder().build();
        List<Project> projects = projectRepository.findAll();
        if (!projects.isEmpty()) {
            List<ProjectDTO> projectDTOS = projectMapper.toDTO(projects);
            response.setResponse(projectDTOS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
