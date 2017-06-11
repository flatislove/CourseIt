package com.itra.controllers;

import com.itra.entity.dto.UserDto;
import com.itra.entity.models.Role;
import com.itra.entity.models.User;
import com.itra.entity.service.RoleService;
import com.itra.entity.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
@CrossOrigin
@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * This method is used for user registration. Note: user registration is not
     * require any authentication.
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public ResponseEntity<User> createUser(@RequestBody UserDto user) {
        String token = null;
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (userService.getByNickname(user.getName()) != null) {
            throw new RuntimeException("Username already exist");
        }
        user.setRole(3l);
        token = Jwts.builder().claim("roles", user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        tokenMap.put("token", token);
        tokenMap.put("user", user);
        return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
    }
    /**
     * This method will return the logged user.
     *
     * @param principal
     * @return Principal java security principal object
     */
    @RequestMapping("/user")
    public UserDto user(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        return userService.getByNickname(loggedUsername);
    }

    /**
     * @param username
     * @param password
     * @param response
     * @return JSON contains token and user after success authentication.
     * @throws IOException
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
                                                     HttpServletResponse response) throws IOException {
        String token = null;
        UserDto user = userService.getByNickname(username);
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (user != null && user.getPassword().equals(password)) {
            token = Jwts.builder().setSubject(username).claim("roles", user.getRole()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            tokenMap.put("token", token);
            tokenMap.put("user", user);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
        } else {
            tokenMap.put("token", null);
            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
        }
    }
}