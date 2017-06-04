package com.itra.database.repository;


import com.itra.database.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface NewsRepository extends JpaRepository<News,Long> {
    public News findById(int id);
}
