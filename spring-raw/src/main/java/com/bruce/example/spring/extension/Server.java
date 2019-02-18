package com.bruce.example.spring.extension;

import com.bruce.example.spring.extension.bean.AppConfig;
import com.bruce.example.spring.extension.bean.JdbcConfig;
import com.bruce.example.spring.extension.service.MyBeanService;
import com.bruce.example.spring.extension.service.UserFacade;
import com.bruce.example.spring.extension.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bruce on 2019/1/23.
 */
public class Server {
    private static Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        log.info("user: " + userService.getUser());

        JdbcConfig jdbcConfig = applicationContext.getBean(JdbcConfig.class);
        log.info("jdbc config: " + jdbcConfig.toString());

        AppConfig appConfig = applicationContext.getBean(AppConfig.class);

        log.info(appConfig.toString());

        log.info(applicationContext.getBean(UserFacade.class).getUser());

        log.info(applicationContext.getBean(MyBeanService.class).hello());
    }
}
