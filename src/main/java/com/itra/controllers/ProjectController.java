package com.itra.controllers;

import com.itra.entity.dto.ProjectDto;
import com.itra.entity.dto.RoleDto;
import com.itra.entity.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectDto> listRole() {
        return projectService.getAll();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDto> projectById(@PathVariable long id) {
        ProjectDto projectDto = projectService.getById(id);
        if (projectDto == null) {
            return new ResponseEntity<ProjectDto>(HttpStatus.NO_CONTENT);
        } else return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.OK);
    }
}
