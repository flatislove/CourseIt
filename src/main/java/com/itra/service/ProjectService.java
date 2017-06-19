package com.itra.service;

import com.itra.dto.ProjectDto;
import com.itra.entity.models.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAll();

    ProjectDto getById(long id);

    ProjectDto getByName(String name);

    Project addProject(Project project);

    void delete(long id);

    Project editProject(Project project);

    String getMarkdownArea(long project_id);

    Project outDto(ProjectDto projectDto);

}
