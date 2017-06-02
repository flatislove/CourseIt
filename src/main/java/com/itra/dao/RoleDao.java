package com.itra.dao;

import com.itra.models.Role;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RoleDao extends CrudRepository<User, Long>{
    public Role findIdByName(String name);
}
