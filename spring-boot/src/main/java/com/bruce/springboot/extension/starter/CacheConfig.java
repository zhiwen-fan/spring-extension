package com.bruce.springboot.extension.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by bruce on 2019/1/30.
 */
@ConfigurationProperties(prefix = "cache")
public class CacheConfig {
    private String host;
    private String port;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "host: " + host +  "port: " + port + ", password: " + password;
    }
}
