package com.bruce.example.spring.extension.anotation;

import com.bruce.example.spring.extension.extension.BruceBeanProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see BruceBeanProcessor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BruceBean {
}
