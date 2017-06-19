package com.itra.controllers;

import com.itra.service.RoleService;
import com.itra.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AccountController {
    private RoleService roleService;
    private UserService userService;

    public AccountController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/account")
    public ResponseEntity<?> userByName(@PathVariable String nickname) {
        return ResponseEntity.ok(this.userService.getByNickname(nickname));
    }
}
