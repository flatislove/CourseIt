package com.itra.dao;

import com.itra.models.Project;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserProjectDao extends CrudRepository<User,Long>{
    //rewrite this methods!!
    public User findUserById(int id_user);
    public Project findProjectById(int id_project);
}
