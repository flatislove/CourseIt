package com.itra.authentication;

import com.itra.dto.Authentication.AuthenticationUserDto;
import com.itra.entity.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUserToDto {
    public AuthenticationUserDto toDto(final User user){
        AuthenticationUserDto authenticationUserDto = new AuthenticationUserDto();
        authenticationUserDto.setId(user.getId());
        authenticationUserDto.setNickname(user.getNickname());
        authenticationUserDto.setRole(user.getRole().getName());
        return authenticationUserDto;
    }
}
