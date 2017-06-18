package com.itra.controllers;

import com.itra.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects(){
        return ResponseEntity.ok(this.projectService.getAll());
    }
//    public List<ProjectDto> listProjects() {
//        return projectService.getAll();
//    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> projectById(@PathVariable long id) {
        return ResponseEntity.ok(this.projectService.getById(id));
//        ProjectDto projectDto = projectService.getById(id);
//        if (projectDto == null) {
//            return new ResponseEntity<ProjectDto>(HttpStatus.NO_CONTENT);
//        } else return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.OK);
    }
}
