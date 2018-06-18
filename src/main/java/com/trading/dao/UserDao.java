package com.trading.dao;

import com.trading.entity.User;

public interface UserDao {
    void register(User user);

    //    User validateUser(Login login);
    User applyChanges(User user);
}