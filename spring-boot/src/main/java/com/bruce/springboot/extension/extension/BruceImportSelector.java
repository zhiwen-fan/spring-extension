package com.bruce.springboot.extension.extension;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;

/**
 * Created by bruce on 2019/1/31.
 */
@Service
public class BruceImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.bruce.springboot.extension.noscan.ImportService1"};
    }
}
