package com.itra.database.dao;


import com.itra.database.models.News;
import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface NewsDao extends JpaRepository<News,Long> {
    public News findById(int id);
}
