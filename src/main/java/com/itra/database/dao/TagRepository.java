package com.itra.database.dao;

import com.itra.database.models.Tag;
import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TagRepository extends JpaRepository<Tag,Long> {
    public Tag findById(int id);

}
