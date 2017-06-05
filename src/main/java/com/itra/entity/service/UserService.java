package com.itra.entity.service;

import com.itra.entity.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getByNickname(String nickname);
    User editUser(User user);
    List<User> getAll();
}