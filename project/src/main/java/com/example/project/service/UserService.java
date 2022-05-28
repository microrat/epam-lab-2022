package com.example.project.service;

import com.example.project.entity.User;

public interface UserService extends BaseService<User>{
    User findByLoginAndPassword(String login, String password);
}
