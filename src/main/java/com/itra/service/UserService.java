package com.itra.service;

import com.itra.dto.RegisterUserDto;
import com.itra.dto.UserDto;
import com.itra.entity.models.User;

import java.util.List;

public interface UserService {
    UserDto getById(long id);

    User addUser(UserDto user);

    User addRegistrationUser(RegisterUserDto user);

    void delete(long id);

    UserDto getByNickname(String nickname);

    User editUser(User user);

    List<UserDto> getAll();

//    User outDto(UserDto userDto);

    List<Long> getIdAll(List<User> users);

    List<UserDto> toDto(List<User> list);

    User outDto(UserDto userDto);

    User registerUserDtoToUser(RegisterUserDto registerUserDto);


}