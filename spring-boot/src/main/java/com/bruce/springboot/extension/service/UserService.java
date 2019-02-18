package com.bruce.springboot.extension.service;

import com.bruce.springboot.extension.noscan.NoScanService;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 2019/1/29.
 */
@Component
@Import(NoScanService.class)
public class UserService {
    public String toString() {
        return "to string method";
    }
}
