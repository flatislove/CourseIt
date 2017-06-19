package com.itra.service;

import com.itra.dto.UserDto;
import com.itra.entity.models.User;

import java.util.List;

public interface UserService {
    UserDto getById(long id);
    User addUser(UserDto user);
    void delete(long id);
    UserDto getByNickname(String nickname);
    User editUser(User user);
    List<UserDto> getAll();
    User outDto(UserDto userDto);
    //User changeName(String name);
}