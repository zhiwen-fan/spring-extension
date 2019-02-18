package com.bruce.example.spring.extension.extension;

import com.bruce.example.spring.extension.anotation.BruceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * register beans with BruceBean annotated to spring context
 */
@Component
public class BruceBeanProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
       //let it empty
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry,false);
        beanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(BruceBean.class));
        int count = beanDefinitionScanner.scan("com.bruce.example.spring.extension");


    }
}
