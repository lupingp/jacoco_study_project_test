package com.example.studyprojectcontroller.configuation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = "classpath:/properties/xiaofu.yaml",factory = YamlPropertySourceFactory.class)
public class PropertySourcesConf2 {

    @Value("${env101.var9}")
    private String var9;

    @Value("${env101.var10}")
    private String var10;

    @Override
    public String toString() {
        return "PropertySourcesConf2{" +
                "var9='" + var9 + '\'' +
                ", var10='" + var10 + '\'' +
                '}';
    }
}
