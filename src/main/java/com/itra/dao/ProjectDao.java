package com.itra.dao;


import com.itra.models.Project;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProjectDao extends CrudRepository<User,Long>{
    public Project findProjectById(int id);
}
