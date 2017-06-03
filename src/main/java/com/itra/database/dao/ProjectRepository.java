package com.itra.database.dao;


import com.itra.database.models.Project;
import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProjectRepository extends JpaRepository<Project,Long> {
    public Project findProjectById(int id);
}
