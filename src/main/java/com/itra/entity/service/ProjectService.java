package com.itra.entity.service;

import com.itra.entity.models.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAll();
    Project getById(long id);
    Project getByName(String name);
    Project addNews(Project tag);
    void delete(long id);
    Project editNews(Project tag);
}
