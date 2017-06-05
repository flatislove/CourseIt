package com.itra.entity.service;

import com.itra.entity.models.News;
import com.itra.entity.models.User;

import java.util.List;

public interface UserService {
    User getById(long id);
    User addUser(User user);
    void delete(long id);
    User getByNickname(String nickname);
    User editUser(User user);
    List<User> getAll();
    //User changeName(String name);
}