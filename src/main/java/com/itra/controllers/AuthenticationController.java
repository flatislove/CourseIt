package com.itra.controllers;

import com.itra.authentication.service.AuthenticationService;
import com.itra.dto.Authentication.AuthenticationUserDto;
import com.itra.dto.Authentication.LoginRequestDto;
import com.itra.dto.Authentication.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public LoginResponseDto login(
            @RequestBody final LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }

    @GetMapping(value = "/me")
    public AuthenticationUserDto me() {
        return authenticationService.getUser();
    }

}