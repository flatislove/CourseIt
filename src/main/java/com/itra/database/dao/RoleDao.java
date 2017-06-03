package com.itra.database.dao;

import com.itra.database.models.Role;
import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RoleDao extends JpaRepository<Role, Long> {
    public Role findIdByName(String name);
   // public Role getNameById(int id);
}
