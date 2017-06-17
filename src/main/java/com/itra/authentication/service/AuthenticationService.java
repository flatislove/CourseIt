package com.itra.authentication.service;

import com.itra.authentication.AuthUserToDto;
import com.itra.authentication.SecurityHelper;
import com.itra.authentication.exception.JsonException;
import com.itra.authentication.model.JwtUserDetails;
import com.itra.dto.Authentication.AuthenticationUserDto;
import com.itra.dto.Authentication.LoginRequestDto;
import com.itra.dto.Authentication.LoginResponseDto;
import com.itra.entity.models.User;
import com.itra.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthUserToDto authUserToDto;
    private final AuthenticationHelper authenticationHelper;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(final LoginRequestDto loginRequestDto) {
        try {
            String nickname = Optional.ofNullable(loginRequestDto.getNickname())
                    .orElseThrow(() -> new BadCredentialsException("Nickname should be passed."));
            String password = Optional.ofNullable(loginRequestDto.getNickname())
                    .orElseThrow(() -> new BadCredentialsException("Password should be passed."));

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(nickname, password);
            final Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

            if (authentication.isAuthenticated()) {
                JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
                User user = userRepository.findOne(userDetails.getId());
                if (Objects.isNull(user)) {
                    throw new JsonException("User already is exist.");
                }
                String token = this.authenticationHelper.generateToken(userDetails.getId());

                return new LoginResponseDto(token);
            } else {
                throw new JsonException("Authentication failed");
            }
        } catch (BadCredentialsException exception) {
            throw new JsonException("Username or password incorrect.", exception);
        }
    }

    @Transactional
    public AuthenticationUserDto getUser() {
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
        User byUserName = userRepository.findByNickname(authentication.getName());
        return authUserToDto.toDto(byUserName);
    }
}
