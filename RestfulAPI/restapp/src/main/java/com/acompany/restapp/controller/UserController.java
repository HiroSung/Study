package com.acompany.restapp.controller;

import com.acompany.restapp.annotation.TokenRequired;
import com.acompany.restapp.model.User;
import com.acompany.restapp.service.UserService;
import com.acompany.restapp.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @TokenRequired
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserid(@PathVariable Integer userid) {
        logger.debug("" + userid);

        // int a = 3 / 0;

        return userService.getUserById(userid);
    }

    @PostMapping("")
    public User registUser(@RequestBody User user) {
        System.out.println(user);
        return userService.registUser(user);
    }

    @PutMapping("/{userid}")
    public void modifyUser(
            @PathVariable Integer userid,
            @RequestBody User user) {
        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }
}
