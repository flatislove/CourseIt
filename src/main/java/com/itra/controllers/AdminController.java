package com.itra.controllers;

import com.itra.dto.*;
import com.itra.entity.models.News;
import com.itra.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/admin/news")
    public List<NewsDto> getListNewsForAdmin() {
        return newsService.getAll();
    }

    @PostMapping(value = "/admin/news")
    public News addNews(@RequestBody NewsDto newsDto) {
        News savedNews = newsService.addNews(newsService.outDto(newsDto));
        return savedNews;
    }

    @GetMapping(value = "/admin/projects")
    public List<ProjectDto> getListProjectForAdmin() {
        return projectService.getAll();
    }

    @GetMapping(value = "/admin/tags")
    public List<TagDto> getListTagsForAdmin() {
        return tagService.getAll();
    }

    @GetMapping(value = "/admin/users")
    public List<UserDto> getListUsersForAdmin() {
        return userService.getAll();
    }

    @GetMapping(value = "/admin/message")
    public List<MessageDto> getListMessageForAdmin() {
        return messageService.listMessageToDto(messageService.getAll());
    }

    @GetMapping(value = "/admin/roles")
    public List<RoleDto> getListRoleForAdmin() {
        return roleService.getAll();
    }
}