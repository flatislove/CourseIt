package com.itra.database.repository;

import com.itra.database.models.Tag;
import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

@Transactional
public interface TagRepository extends JpaRepository<Tag,Long> {
    @Query("select t from Tag t where t.name = :name")
    Tag findByName(@Param("name") String name);
}