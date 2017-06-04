package com.itra.database.repository;

import com.itra.database.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findIdByName(String name);
   // public Role getNameById(int id);
}
