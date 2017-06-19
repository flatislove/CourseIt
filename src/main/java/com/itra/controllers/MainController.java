package com.itra.controllers;

import com.itra.dto.RegisterUserDto;
import com.itra.dto.UserDto;
import com.itra.entity.models.User;
import com.itra.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/api/users")
    public User createUser(@RequestBody RegisterUserDto user) {
        String token = null;
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (userService.getByNickname(user.getNickname()) != null) {
            throw new RuntimeException("This user already exist(nickname)");
        }
        user.setRole("DEVELOPER");
        token = Jwts.builder().claim("roles", user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        tokenMap.put("token", token);
        tokenMap.put("user", user);
        return userService.addRegistrationUser(user);

    }

    @RequestMapping("/user")
    public UserDto user(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        return userService.getByNickname(loggedUsername);
    }

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
            return new ResponseEntity<>(tokenMap, HttpStatus.OK);
        } else {
            tokenMap.put("token", null);
            return new ResponseEntity<>(tokenMap, HttpStatus.UNAUTHORIZED);
        }
    }
}