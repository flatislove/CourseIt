package com.itra.entity.service.impl;

import com.itra.entity.dto.ProjectDto;
import com.itra.entity.models.Project;
import com.itra.entity.repository.ProjectRepository;
import com.itra.entity.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

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

    public static ArrayList<Long> getIdAll(List<Project> projects) {
        ArrayList<Long> listId = new ArrayList<>();
        for (Project project : projects) {
            listId.add(project.getId());
        }
        return listId;
    }
}