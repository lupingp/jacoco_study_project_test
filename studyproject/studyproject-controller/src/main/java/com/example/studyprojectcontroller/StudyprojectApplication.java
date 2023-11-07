package com.example.studyprojectcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class StudyprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyprojectApplication.class, args);
        System.out.println("SpringBoot启动成功");
    }
//-javaagent:/Users/luping/jacocoJar/org.jacoco.agent-0.8.5-runtime.jar=includes=*,output=tcpserver,address=*,port=18513
}
