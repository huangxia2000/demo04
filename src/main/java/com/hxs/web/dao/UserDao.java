package com.hxs.web.dao;

import  com.hxs.web.entity.User;

public interface UserDao {
    public User findUserByUser(User user);

    // 登入
    boolean add(String name, String much, String type);

}
