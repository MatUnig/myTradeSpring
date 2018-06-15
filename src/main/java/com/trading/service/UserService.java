package com.trading.service;

import com.trading.entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}