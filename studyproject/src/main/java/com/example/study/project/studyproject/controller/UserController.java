package com.example.study.project.studyproject.controller;

import com.example.study.project.studyproject.entity.UserEntity;
import com.example.study.project.studyproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("queryUserAll/")
    public List<UserEntity> queryUserAll() {
        log.info("【查询全部用户信息】：【{}】", userService.queryUsers());
        return userService.queryUsers();
    }

    @GetMapping("queryUserAll01/")
    public List<UserEntity> queryUserAll01() {
        log.info("【查询全部用户信息】：【{}】", userService.queryUsers());
        return userService.queryUsers01();
    }
}
