package com.itra.service.impl;

import com.itra.dto.UserDto;
import com.itra.entity.models.User;
import com.itra.entity.repository.RoleRepository;
import com.itra.entity.repository.UserRepository;
import com.itra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getById(long id) {
        return new UserDto(userRepository.findOne(id));
    }


    @Override
    public User addUser(UserDto user) {
        User savedUser = userRepository.saveAndFlush(outDto(user));
        return savedUser;
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDto getByNickname(String nickname) {
        return new UserDto(userRepository.findByNickname(nickname));
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> getAll() {
        return this.toDto(userRepository.findAll());
    }

    @Override
    public User outDto(UserDto userDto) {
        return new User(userDto.getName(), userDto.getNickname(), userDto.getEmail(), userDto.getPassword(), roleRepository.findByName(userDto.getRole()).getName());
    }

    public List<UserDto> toDto(List<User> list) {
        List<UserDto> listDto = new ArrayList<>();
        for (User user : list) {
            listDto.add(new UserDto(user));
        }
        return listDto;
    }

    public static ArrayList<Long> getIdAll(List<User> users) {
        ArrayList<Long> listId = new ArrayList<>();
        for (User user : users) {
            listId.add(user.getId());
        }
        return listId;
    }
}