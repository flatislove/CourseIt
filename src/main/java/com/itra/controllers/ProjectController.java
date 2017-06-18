package com.itra.controllers;

import com.itra.dto.MessageDto;
import com.itra.dto.ProjectDto;
import com.itra.service.MessageService;
import com.itra.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "dev")
public class ProjectController {

    private ProjectService projectService;
    private MessageService messageService;

    public ProjectController(ProjectService projectService, MessageService messageService) {
        this.projectService = projectService;
        this.messageService = messageService;
    }

    @GetMapping(value = "projects")
    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.ok(this.projectService.getAll());
    }
//    public List<ProjectDto> listProjects() {
//        return projectService.getAll();
//    }

    @GetMapping(value = "projects/{id}")
    public ResponseEntity<?> projectById(@PathVariable long id) {
        return ResponseEntity.ok(this.projectService.getById(id));
//        ProjectDto projectDto = projectService.getById(id);
//        if (projectDto == null) {
//            return new ResponseEntity<ProjectDto>(HttpStatus.NO_CONTENT);
//        } else return new ResponseEntity<ProjectDto>(projectDto, HttpStatus.OK);
    }

    @GetMapping(value = "projects/{id}/message")
    public ResponseEntity<?> getMessagesOfProject(@PathVariable long id_project) {
        return ResponseEntity.ok(this.messageService.getAllMessagesOfProject(id_project));
    }

    @PostMapping(value = "projects/{id}/message")
    public ResponseEntity<?> addMessageForDiscussion(@RequestBody MessageDto message) {
        this.messageService.addMessage(this.messageService.outDto(message));
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "projects/{id}/markdown")
    public ResponseEntity<?> getAreaMarkdown(@PathVariable long id_project) {
        return ResponseEntity.ok(this.projectService.getMarkdownArea(id_project));
    }

    @PostMapping(value = "projects/{id}/markdown")
    public ResponseEntity<?> saveMarkdownArea(@RequestBody ProjectDto projectDto) {
        this.projectService.editProject(this.projectService.outDto(projectDto));
        return ResponseEntity.ok("ok");
    }
}
