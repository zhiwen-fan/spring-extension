package com.bruce.example.spring.extension.extension;

import com.bruce.example.spring.extension.anotation.DefaultStringValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by bruce on 2019/1/23.
 */
@Component
public class DefaultStringValueBeanFactoryPostProcessor implements BeanFactoryPostProcessor{


    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

       for (String beanName: configurableListableBeanFactory.getBeanDefinitionNames()){
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> clazz = null;
            try {
                clazz = Class.forName(beanClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(null != clazz) {
                addDefaultBeanFieldValue(beanDefinition,clazz);
            }

        }
    }

    private void addDefaultBeanFieldValue(BeanDefinition beanDefinition, Class<?> clazz) {
        for(Field field: clazz.getDeclaredFields()) {
            DefaultStringValue annotation = field.getAnnotation(DefaultStringValue.class);
            if(null == annotation) {
                continue;
            }
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            if(null == propertyValues.get(field.getName())) {
                propertyValues.addPropertyValue(field.getName(), annotation.value());
            }
        }
    }


}
