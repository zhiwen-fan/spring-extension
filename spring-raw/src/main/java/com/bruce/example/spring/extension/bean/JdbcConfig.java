package com.bruce.example.spring.extension.bean;

import com.bruce.example.spring.extension.anotation.DefaultStringValue;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/1/23.
 */

@Component
public class JdbcConfig {
    @DefaultStringValue(value = "test url")
    private String url;
    @DefaultStringValue(value = "test username")
    private String username;
    @DefaultStringValue(value = "test password")
    private String password;
    @DefaultStringValue(value = "test driver")
    private String driver;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String toString() {
        return "url: " + url + " username: " + username + " password: " + password + " driver: " + driver;
    }
}
