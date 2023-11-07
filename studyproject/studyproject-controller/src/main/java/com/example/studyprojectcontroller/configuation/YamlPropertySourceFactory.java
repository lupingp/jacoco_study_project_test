package com.example.studyprojectcontroller.configuation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        log.info("【YamlPropertySourceFactory】【createPropertySource】【入参】：【{}】【{}】",name,resource.getResource());
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        log.info("【YamlPropertiesFactoryBean】【结果】：【{}】",factory);
        log.info(resource.getResource().getFilename());

        Properties properties = factory.getObject();
        log.info("【properties】【结果】：【{}】",properties.getProperty("env101.var9"));
        return new PropertiesPropertySource(resource.getResource().getFilename(), properties);
    }
}
