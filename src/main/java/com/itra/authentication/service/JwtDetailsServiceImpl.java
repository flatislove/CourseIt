package com.itra.authentication.service;

import com.itra.authentication.exception.JsonException;
import com.itra.authentication.model.JwtUserDetails;
import com.itra.entity.models.User;
import com.itra.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = this.userRepository.findByNickname(username);

        return Optional.ofNullable(byUsername).map(JwtUserDetails::new)
                .orElseThrow(()->new JsonException("User not found"));
    }
}
