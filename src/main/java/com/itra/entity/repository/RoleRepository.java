package com.itra.entity.repository;

import com.itra.entity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.name = :name")
    Role findByName(@Param("name") String name);

    Role findFirstByName(String name);
}
