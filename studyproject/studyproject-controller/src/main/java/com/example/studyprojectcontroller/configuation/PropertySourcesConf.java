package com.example.studyprojectcontroller.configuation;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Data
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:/properties/xiaofu.properties", encoding = "UTF-8"),
        @PropertySource(value = "classpath:/properties/xiaofu.properties", encoding = "UTF-8")
})
//@PropertySource(value = "classpath:/properties/xiaofu.properties", encoding = "UTF-8")
public class PropertySourcesConf {

    @Value("${env101.var9}")
    private String var9;

    @Value("${env101.var10}")
    private String var10;

    @Override
    public String toString() {
        return "PropertySourcesConf{" +
                "var9='" + var9 + '\'' +
                ", var10='" + var10 + '\'' +
                '}';
    }
}
