package com.itra.database.service;

import com.itra.database.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getByNickname(String nickname);
    User editUser(User user);
    List<User> getAll();
}
