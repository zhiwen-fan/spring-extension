package com.bruce.springboot.extension.annotation;

import com.bruce.springboot.extension.extension.BruceBeanDefinitionRegistrar;
import com.bruce.springboot.extension.extension.BruceImportSelector;
import com.bruce.springboot.extension.noscan.NoScanService;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bruce on 2019/1/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({NoScanService.class, BruceImportSelector.class, BruceBeanDefinitionRegistrar.class})
public @interface EnableNoScanService {
}
