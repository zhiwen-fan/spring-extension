package com.bruce.example.spring.extension.extension;

import com.bruce.example.spring.extension.anotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by bruce on 2019/1/23.
 *
 * inject bean whith anotation com.bruce.example.spring.extension.anotation.Inject
 */
@Component
public class InjectBeanPostProcessor implements BeanPostProcessor,ApplicationContextAware {
    private Logger log = LoggerFactory.getLogger(InjectBeanPostProcessor.class);

    private ApplicationContext applicationContext;

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        log.info("bean class: {}, bean name: {}",o.getClass().getCanonicalName(),s);
        Field[] fields = o.getClass().getDeclaredFields();
        if(null == fields || fields.length == 0) {
            return o;
        }

        for (Field field: fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if(null != annotation) {
                Object bean = applicationContext.getBean(field.getType());
                if(null == bean) {
                    throw new RuntimeException("can not find bean with type: " + field.getType().getCanonicalName() + " when inject " + o.getClass().getCanonicalName());
                }
                field.setAccessible(true);
                try {
                    field.set(o,bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
