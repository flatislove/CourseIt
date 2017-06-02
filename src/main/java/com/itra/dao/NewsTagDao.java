package com.itra.dao;

import com.itra.models.News;
import com.itra.models.Tag;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface NewsTagDao extends CrudRepository<User,Long> {
    public News findNewsById(int id_news);
    public Tag findTagById(int id_tag);
}
