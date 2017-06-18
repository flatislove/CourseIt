package com.itra.dto.Authentication;

import com.itra.dto.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto implements Dto {
    private String token;

    public LoginResponseDto(final String token) {
        this.token = token;
    }
}
