package com.itra.database.repository;

import com.itra.database.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TagRepository extends JpaRepository<Tag,Long> {
    public Tag findById(int id);

}
