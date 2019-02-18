package com.bruce.example.spring.extension.extension.parser;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by bruce on 2019/1/29.
 */
public class BruceBeanDefinitionParser implements BeanDefinitionParser {


    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setLazyInit(false);
        String id = element.getAttribute("beanId");
        String className = element.getAttribute("beanClass");
        beanDefinition.setBeanClassName(className);
        parserContext.getRegistry().registerBeanDefinition(id,beanDefinition);

        return beanDefinition;
    }

}
