package com.bruce.example.spring.extension.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bruce on 2019/1/25.
 */
@Configuration
public class AppConfig {
    @Value("${app.name}")
    private String appName;
    @Value("${app.owner}")
    private String appOwner;

    public String toString() {
        return "appName: " + appName + ", appOwner: " + appOwner;
    }
}
