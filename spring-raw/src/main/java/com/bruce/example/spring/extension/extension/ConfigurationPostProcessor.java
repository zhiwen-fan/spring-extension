package com.bruce.example.spring.extension.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by bruce on 2019/1/25.s
 *
 * load config-app.properties from classpath and load to spring environment
 */
@Component
public class ConfigurationPostProcessor implements BeanFactoryPostProcessor,EnvironmentAware, PriorityOrdered {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private Environment environment;

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        if(null == environment) {
            log.warn("environment is null");
        }
        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment)environment;
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
        for (Properties properties: loadProperties()) {
            propertySources.addLast(new PropertiesPropertySource("app-config", properties));
        }
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public List<Properties> loadProperties() {
        List<Properties> result = new ArrayList<Properties>();
        Enumeration<URL> resources = null;
        try {
            resources = this.getClass().getClassLoader().getResources("config-app.properties");

            if(resources.hasMoreElements()) {
                Properties pro = new Properties();
                URL url = resources.nextElement();
                URLConnection con = url.openConnection();
                InputStream is = con.getInputStream();
                pro.load(is);
                result.add(pro);
            }
        } catch (IOException e) {
            log.error("load config-app.properties from classpath failed",e);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        ConfigurationPostProcessor processor = new ConfigurationPostProcessor();
        System.out.println(processor.loadProperties());

    }

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
