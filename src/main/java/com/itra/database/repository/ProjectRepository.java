package com.itra.database.repository;


import com.itra.database.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProjectRepository extends JpaRepository<Project,Long> {
    public Project findProjectById(int id);
}
