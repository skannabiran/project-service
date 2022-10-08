package com.maveric.techhub.project.controller;
import com.maveric.techhub.project.model.ProjectRequest;
import com.maveric.techhub.project.model.ServiceResponse;
import com.maveric.techhub.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * IdeaController is the class to manage for employee ideas
 * @author      Kannabiran Shanmugam
 * @version     %I%, %G%
 * @since       1.0
 */
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    ResponseEntity<ServiceResponse> createProject(@Valid @RequestBody ProjectRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<ServiceResponse> getProject(@PathVariable(name = "id") String id) {
        return projectService.getProject(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<ServiceResponse> updateProject(@PathVariable(name = "id") String id,
                                            @RequestBody ProjectRequest projectRequest) {
        return projectService.updateProject(id, projectRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ServiceResponse> deleteProject(@PathVariable(name = "id") String id) {
        return projectService.deleteProject(id);
    }

    @GetMapping
    ResponseEntity<ServiceResponse> getIdeas() {
        return projectService.getIdeas();
    }

}