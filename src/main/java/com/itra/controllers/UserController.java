package com.itra.controllers;

import com.itra.dto.UserDto;
import com.itra.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDto> fidAll() {
        return this.userService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "admin/users")
    public List<UserDto> users() {
        return userService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "admin/users/{id}")
    public ResponseEntity<UserDto> userById(@PathVariable long id) {
        UserDto user = userService.getById(id);
        if (user == null) {

            return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<UserDto>(user, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "admin/users/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        UserDto user = userService.getById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        if (user == null) {
            return new ResponseEntity<UserDto>(HttpStatus.NO_CONTENT);
        } else if (user.getName().equalsIgnoreCase(loggedUsername)) {
            throw new RuntimeException("You cannot delete your account");
        } else {
            userService.delete(user.getId());
            return new ResponseEntity<UserDto>(user, HttpStatus.OK);
        }
    }
}