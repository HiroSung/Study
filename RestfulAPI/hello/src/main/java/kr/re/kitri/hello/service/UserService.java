package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.UserDao;
import kr.re.kitri.hello.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    public User getUser( Integer Id) {
        return userDao.getUserById( Id);
    }

    public User createUser( User user) {
        return userDao.insertUser( user);
    }

    public boolean modifyUser( Integer Id, User user) {
        user.setUserId( Id);
        return userDao.updateUser( user);
    }

    public boolean deleteUser( Integer userId) {
        return userDao.deleteUser( userId);
    }
}
