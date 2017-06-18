package com.itra.authentication.service;

import com.itra.dto.Authentication.UserListDto;
import com.itra.entity.models.User;
import com.itra.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceAuth {
    private final UserRepository userRepository;
    private final UserListCreateDto userListCreateDto;

    @Transactional
    public List<UserListDto> findAll(){
        List<User> users = userRepository.findAll();
        List<UserListDto> userListDtos = new ArrayList<>();
        for (User user:users){
            UserListDto dto = this.userListCreateDto.createDto(user);
            userListDtos.add(dto);
        }
        return userListDtos;
    }
}
