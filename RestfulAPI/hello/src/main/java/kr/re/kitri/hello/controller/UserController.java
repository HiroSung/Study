package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.domain.User;
import kr.re.kitri.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{Id}")
    public User getUser(@PathVariable Integer Id) {
        return userService.getUser( Id);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.createUser( user);
    }

    @PutMapping("")
    public User createUserPut(@RequestBody User user) {
        logger.debug("USER INFO: " + user.toString());
        return userService.createUser( user);
    }

    @PutMapping("/{Id}")
    public boolean updateUser(@PathVariable Integer Id,
                              @RequestBody User user) {
        return userService.modifyUser( Id, user);
    }

    @DeleteMapping("/{Id}")
    public boolean deleteUser(@PathVariable Integer Id) {
        return userService.deleteUser( Id);
    }

    @GetMapping("/checkVersion")
    public String checkVersion(@RequestHeader("x-resource-version") String version) {
        System.out.println("Version : " + version);
        return "Version : " + version;
    }
}
