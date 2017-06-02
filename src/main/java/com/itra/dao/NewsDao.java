package com.itra.dao;


import com.itra.models.News;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface NewsDao extends CrudRepository<User,Long>{
    public News findById(int id);
}
