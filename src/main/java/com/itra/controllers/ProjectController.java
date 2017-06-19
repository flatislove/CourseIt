package com.itra.controllers;

import com.itra.dto.MessageDto;
import com.itra.dto.ProjectDto;
import com.itra.service.MessageService;
import com.itra.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProjectController {

    private ProjectService projectService;
    private MessageService messageService;

    public ProjectController(ProjectService projectService, MessageService messageService) {
        this.projectService = projectService;
        this.messageService = messageService;
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.ok(this.projectService.getAll());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> projectById(@PathVariable long id) {
        return ResponseEntity.ok(this.projectService.getById(id));
    }

    @GetMapping("/projects/{id}/message")
    public ResponseEntity<?> getMessagesOfProject(@PathVariable long id_project) {
        return ResponseEntity.ok(this.messageService.getAllMessagesOfProject(id_project));
    }

    @PostMapping("/projects/{id}/message")
    public ResponseEntity<?> addMessageForDiscussion(@RequestBody MessageDto message) {
        this.messageService.addMessage(this.messageService.outDto(message));
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/projects/{id}/markdown")
    public ResponseEntity<?> getAreaMarkdown(@PathVariable long id_project) {
        return ResponseEntity.ok(this.projectService.getMarkdownArea(id_project));
    }

    @PostMapping("/projects/{id}/markdown")
    public ResponseEntity<?> saveMarkdownArea(@RequestBody ProjectDto projectDto) {
        this.projectService.editProject(this.projectService.outDto(projectDto));
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/projects/{id}/files")
    public ResponseEntity<?> getFilesArea(@PathVariable long id_project) {
        return ResponseEntity.ok(this.projectService.getMarkdownArea(id_project));
    }

    @PostMapping("/projects/{id}/files")
    public ResponseEntity<?> saveFilesArea(@RequestBody ProjectDto projectDto) {
        this.projectService.editProject(this.projectService.outDto(projectDto));
        return ResponseEntity.ok("ok");
    }
}