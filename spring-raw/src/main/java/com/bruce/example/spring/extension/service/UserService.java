package com.bruce.example.spring.extension.service;

import com.bruce.example.spring.extension.anotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by bruce on 2019/1/23.
 */
@Service("userService")
public class UserService implements InitializingBean {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Inject
    private UserDao userDao;

    public String getUser() {
        return getUser("dafault");
    }

    public String getUser(String name) {
        return userDao.getUser(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("UserService is initialized");
    }
}
