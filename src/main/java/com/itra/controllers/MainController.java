package com.itra.controllers;

import com.itra.entity.repository.UserRepository;
import com.itra.entity.models.User;
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

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;


    /**
     * This method is used for user registration. Note: user registration is not
     * require any authentication.
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String token = null;

        Map<String, Object> tokenMap = new HashMap<String, Object>();
        if (userRepository.findByNickname(user.getName()) != null) {
            throw new RuntimeException("Username already exist");
        }
        //System.out.println("jjjjjjjjjjjjjjjjjjjjjjjj");
        List<String> roles = new ArrayList<>();
        roles.add("DEVELOPER");
        user.setRole("DEVELOPER");

        token = Jwts.builder().claim("roles", user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        tokenMap.put("token", token);
        tokenMap.put("user", user);

        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }
    /**
     * This method will return the logged user.
     *
     * @param principal
     * @return Principal java security principal object
     */
    @RequestMapping("/user")
    public User user(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        return userRepository.findByNickname(loggedUsername);
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
        User user = userRepository.findByNickname(username);
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

 /*   @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "return text for itrascreen";
    }

}*/