package com.itra.dao;

import com.itra.models.Tag;
import com.itra.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TagDao extends CrudRepository<User,Long>{
    public Tag findById(int id);

}
