package com.itra.controllers;

import com.itra.entity.models.User;
import com.itra.entity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Web service for getting all the appUsers in the application.
     * @return list of all AppUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.getAll();
    }

    /**
     * Web service for getting a user by his ID
     *
     * @param id
     *            appUser ID
     * @return appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> userById(@PathVariable long id) {
        User appUser = userService.getById(id);
        if (appUser == null) {

            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<User>(appUser, HttpStatus.OK);
        }
    }

    /**
     * Method for deleting a user by his ID
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User appUser = userService.getById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUsername = auth.getName();
        if (appUser == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } else if (appUser.getUsername().equalsIgnoreCase(loggedUsername)) {
            throw new RuntimeException("You cannot delete your account");
        } else {
            userService.delete(appUser.getId());
            return new ResponseEntity<User>(appUser, HttpStatus.OK);
        }
    }

    /**
     * Method for adding a appUser
     *
     * @param appUser
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User appUser) {
        if (userService.getByNickname(appUser.getUsername()) != null) {
            throw new RuntimeException("Username already exist");
        }
        return new ResponseEntity<User>(userService.addUser(appUser), HttpStatus.CREATED);
    }

    /**
     * Method for editing an user details
     *
     * @param user
     * @return modified appUser
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        if (userService.getByNickname(user.getName()) != null
                && userService.getByNickname(user.getName()).getId() != user.getId()) {
            throw new RuntimeException("Username already exist");
        }
        return userService.addUser(user);
    }


}

//    // ------------------------
//    // PUBLIC METHODS
//    // ------------------------
//
//    /**
//     * /create  --> Create a new user and save it in the entity.
//     *
//     * @param email User's email
//     * @param name User's name
//     * @return A string describing if the user is succesfully created or not.
//     */
//    @RequestMapping("/create")
//    @ResponseBody
//    public String create(String name, String nickname,String email,String password) {
//        User user = null;
//        Role role =null;
//        try {
//            user = new User(name, nickname, email, password);
//            userDao.save(user);
//        }
//        catch (Exception ex) {
//            return "Error creating the user: " + ex.toString();
//        }
//        return "User succesfully created! (id = " + user.getName() + ")";
//    }
//
//    /**
//     * /delete  --> Delete the user having the passed id.
//     *
//     * @param id The id of the user to delete
//     * @return A string describing if the user is succesfully deleted or not.
//     */
//    @RequestMapping("/delete")
//    @ResponseBody
//    public String delete(long id) {
//        try {
//            User user = new User(id);
//            userDao.delete(user);
//        }
//        catch (Exception ex) {
//            return "Error deleting the user: " + ex.toString();
//        }
//        return "User succesfully deleted!";
//    }
//
//    /**
//     * /get-by-email  --> Return the id for the user having the passed email.
//     *
//     * @param email The email to search in the entity.
//     * @return The user id or a message error if the user is not found.
//     */
//    @RequestMapping("/get-by-email")
//    @ResponseBody
//    public String getByEmail(String email) {
//        String userId;
//        try {
//            User user = userDao.findByEmail(email);
//            userId = String.valueOf(user.getId());
//        }
//        catch (Exception ex) {
//            return "User not found";
//        }
//        return "The user id is: " + userId;
//    }
//
//    /**
//     * /update  --> Update the email and the name for the user in the entity
//     * having the passed id.
//     *
//     * @param id The id for the user to update.
//     * @param email The new email.
//     * @param name The new name.
//     * @return A string describing if the user is succesfully updated or not.
//     */
//    @RequestMapping("/update")
//    @ResponseBody
//    public String updateUser(long id, String name, String nickname,String email) {
//        try {
//            User user = userDao.findOne(id);
//            user.setEmail(email);
//            user.setName(name);
//            user.setNickname(nickname);
//
//            userDao.save(user);
//        }
//        catch (Exception ex) {
//            return "Error updating the user: " + ex.toString();
//        }
//        return "User succesfully updated!";
//    }
//
//    // ------------------------
//    // PRIVATE FIELDS
//    // ------------------------
//
//    @Autowired
//    private UserRepository userDao;
//
//}