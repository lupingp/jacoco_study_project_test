package com.example.studyprojectcontroller.controller;

import com.example.studyprojectservice.entity.UserEntity;
import com.example.studyprojectservice.userService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping("queryUserAlls/")
    public List<UserEntity> queryUserAll() {
        log.info("【查询全部用户信息】：【{}】", userService.queryUsers());
        return userService.queryUsers();
    }

    @GetMapping("queryUserAll01/")
    public List<UserEntity> queryUserAll01() {
        log.info("【查询全部用户信息】：【{}】", userService.queryUsers());
        return userService.queryUsers01();
    }

    @GetMapping("queryUserAll02/")
    public List<UserEntity> queryUserAll02() {
        log.info("【查询全部用户信息】：【{}】", userService.queryUsers02());
        return userService.queryUsers01();
    }
}
