package com.bruce.example.spring.extension.service;

import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/1/23.
 */
@Component
public class UserDao {

    public String getUser(String name) {
        return "user with name: " + name;
    }
}
