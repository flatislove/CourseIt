package com.itra.authentication.service;

import com.itra.dto.Authentication.UserListDto;
import com.itra.entity.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserListCreateDto {
    public UserListDto createDto(final User user) {
        UserListDto dto = new UserListDto();
        dto.setId(user.getId());
        dto.setNickname(user.getNickname());
        dto.setRole(user.getRole().getName());

        return dto;
    }
}
