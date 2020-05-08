package com.acompany.restapp.service;

import com.acompany.restapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Integer userid);

    User registUser(User user);

    void modifyUser(Integer userid, User user);

    void removeUser(Integer userid);
}
