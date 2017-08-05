package com.example.testframework.service;

import org.springframework.transaction.annotation.Transactional;
import com.example.testframework.domain.User;

@Transactional
public interface UserService {
    boolean hasMatchUser(String userName, String password);
    User findUserByUserName(String userName);
    void loginSuccess(User user);
    void registerUser(User user);
}
