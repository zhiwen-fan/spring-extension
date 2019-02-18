package com.bruce.springboot.extension;

import com.bruce.springboot.extension.annotation.EnableNoScanService;
import com.bruce.springboot.extension.noscan.ImportService1;
import com.bruce.springboot.extension.noscan.ImportService2;
import com.bruce.springboot.extension.noscan.NoScanService;
import com.bruce.springboot.extension.service.UserService;
import com.bruce.springboot.extension.starter.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by bruce on 2019/1/29.
 */
@SpringBootApplication(scanBasePackages = "com.bruce.springboot.extension.service,com.bruce.springboot.extension.bean")
@EnableNoScanService
public class Server {
    private static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Server.class, args);
       log.info(applicationContext.getBean(UserService.class).toString());
       log.info(applicationContext.getBean(NoScanService.class).noscan());
       log.info(applicationContext.getBean(CacheService.class).toString());
       log.info(applicationContext.getBean(ImportService1.class).toString());
       log.info(applicationContext.getBean(ImportService2.class).toString());
    }
}
