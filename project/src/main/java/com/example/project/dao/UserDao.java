package com.example.project.dao;

import com.example.project.entity.User;

public interface UserDao extends Dao<User>{
    User readByLoginAndPassword(String login, String password);
}
