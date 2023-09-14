package com.example.study.project.studyproject.commontest;

import com.example.study.project.studyproject.configuation.Myconf;
import com.example.study.project.studyproject.configuation.PropertySourcesConf;
import com.example.study.project.studyproject.configuation.PropertySourcesConf2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class EnvironmentTest {

    // 因外儿闷特
    @Resource
    private Environment env;

    @Value("${env101.var1:我是小富}")
    private String name;

    @Resource
    private Myconf myconf;

    @Resource
    private PropertySourcesConf propertySourcesConf;

    @Resource
    private PropertySourcesConf2 propertySourcesConf2;

    @Test
    public void var1Test(){
        String var1 = env.getProperty("name");
        log.info("Environment 配置获取:【{}】",var1);
        log.info("Value 配置获取:【{}】",name);
        log.info("ConfigurationProperties 配置获取：{}",myconf.toString());
        log.info("propertySourcesConf 配置获取：{}",propertySourcesConf.toString());
        log.info("PropertySourcesConf2 配置获取：{}",propertySourcesConf2.toString());
    }
}
