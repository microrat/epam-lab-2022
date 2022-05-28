package com.example.project.service.serviceImpl;

import com.example.project.dao.UserDao;
import com.example.project.entity.User;
import com.example.project.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getOrderDao() {
        return userDao;
    }

    public void setOrderDao(UserDao orderDao) {
        this.userDao = orderDao;
    }

    @Override
    public User findById(Long id) {
        return userDao.read(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.readAll();
    }

    @Override
    public void save(User user) throws SQLException {
        List<User> users= userDao.readAll();
        if(!users.stream().anyMatch(u-> Objects.equals(u.getId(), user.getId()))){
            userDao.create(user);
        }else{
            userDao.update(user);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        userDao.delete(id);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userDao.readByLoginAndPassword(login,password);
    }
}
