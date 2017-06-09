package com.itra.entity.service;

import com.itra.entity.dto.UserDto;
import com.itra.entity.models.News;
import com.itra.entity.models.User;

import java.util.List;

public interface UserService {
    UserDto getById(long id);
    User addUser(User user);
    void delete(long id);
    UserDto getByNickname(String nickname);
    User editUser(User user);
    List<UserDto> getAll();
    //User changeName(String name);
}