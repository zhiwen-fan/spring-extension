package com.bruce.example.spring.extension.extension;

import com.bruce.example.spring.extension.extension.parser.BruceBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by bruce on 2019/1/29.
 *
 * parse bruce.xsd to register beans to spring context
 */
public class BruceNameSpaceHandler extends NamespaceHandlerSupport {

    public void init() {
        super.registerBeanDefinitionParser("service", new BruceBeanDefinitionParser());
    }
}
