package com.itra.controllers;

import com.itra.entity.dto.ProjectDto;
import com.itra.entity.dto.RoleDto;
import com.itra.entity.service.ProjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }

    @GetMapping("/project")
    public List<ProjectDto> listRole(){
        return projectService.getAll();
    }

}
