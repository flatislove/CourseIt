package com.itra.entity.repository;


import com.itra.entity.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface NewsRepository extends JpaRepository<News,Long> {
    @Query("select n from News n where n.description = :description")
    News findByName(@Param("description") String description);
}
