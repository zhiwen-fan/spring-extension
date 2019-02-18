package com.bruce.example.spring.extension.service;

import com.bruce.example.spring.extension.anotation.BruceBean;

/**
 * Created by bruce on 2019/1/29.
 */
@BruceBean
public class MyBeanService {

    public String hello() {
        return "hello !  this is bruce bean!!!!!!!!!";
    }
}
