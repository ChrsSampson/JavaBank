package com.squidco.demo.service;

import java.util.List;

import com.squidco.demo.entity.User;

public interface UserService {
    List<User> findAll();

    User save(User userData);

    User findById(long id);
}
