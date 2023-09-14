package com.example.study.project.studyproject.configuation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "env102")
public class Myconf {

    private String var1;

    private String var2;

    @Override
    public String toString() {
        return "Myconf{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                '}';
    }
}
