package com.itra.entity.service.impl;

import com.itra.entity.models.Project;
import com.itra.entity.repository.ProjectRepository;
import com.itra.entity.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public Project getByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Project addNews(Project project) {
        Project savedProject = projectRepository.saveAndFlush(project);
        return savedProject;
    }

    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project editNews(Project tag) {
        return projectRepository.saveAndFlush(tag);
    }
}