package com.itra.service.impl;

import com.itra.dto.ProjectDto;
import com.itra.entity.models.Project;
import com.itra.entity.repository.ProjectRepository;
import com.itra.entity.repository.UserRepository;
import com.itra.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProjectDto> getAll() {
        return this.toDto(projectRepository.findAll());
    }

    public List<ProjectDto> toDto(List<Project> list) {
        List<ProjectDto> listDto = new ArrayList<>();
        for (Project project : list) {
            listDto.add(new ProjectDto(project));
        }
        return listDto;
    }

    @Override
    public ProjectDto getById(long id) {

        return new ProjectDto(projectRepository.findById(id));
    }

    @Override
    public ProjectDto getByName(String name) {
        return new ProjectDto(projectRepository.findByName(name));
    }

    @Override
    public Project addProject(Project project) {
        Project savedProject = projectRepository.saveAndFlush(project);
        return savedProject;
    }

    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project editProject(Project tag) {
        return projectRepository.saveAndFlush(tag);
    }

    @Override
    public String getMarkdownArea(long project_id) {
        return this.projectRepository.findMarkdownById(project_id);
    }

    @Override
    public Project outDto(ProjectDto projectDto) {
        return new Project(projectDto.getId(),projectDto.getName(),projectDto.getDescription(),projectDto.getText(),
                projectDto.getMarkdown(),projectDto.getStatus(),userRepository.findOne(projectDto.getManager()));
    }

    public static ArrayList<Long> getIdAll(List<Project> projects) {
        ArrayList<Long> listId = new ArrayList<>();
        for (Project project : projects) {
            listId.add(project.getId());
        }
        return listId;
    }
}