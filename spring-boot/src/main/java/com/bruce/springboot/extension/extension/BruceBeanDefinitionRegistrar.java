package com.bruce.springboot.extension.extension;

import com.bruce.springboot.extension.noscan.ImportService2;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by bruce on 2019/1/31.
 */

public class BruceBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(ImportService2.class);
        beanDefinition.setLazyInit(false);
        beanDefinitionRegistry.registerBeanDefinition("importService2",beanDefinition);
    }
}
