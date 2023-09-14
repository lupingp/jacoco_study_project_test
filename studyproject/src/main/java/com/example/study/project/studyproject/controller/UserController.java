package com.example.study.project.studyproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("queryUser/")
    public Map<String,String> queryUserAll(){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name","陆平");
        hashMap.put("age","25");
        log.info("【queryUserAll】【查询用户全部姓名】【结果】：【{}】",hashMap);
        return hashMap;
    }
}
