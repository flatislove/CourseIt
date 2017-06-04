package com.itra.database.service.impl;


import com.itra.database.models.User;
import com.itra.database.repository.UserRepository;
import com.itra.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User getByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
