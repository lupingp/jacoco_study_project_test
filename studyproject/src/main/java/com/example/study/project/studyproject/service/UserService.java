package com.example.study.project.studyproject.service;

import com.example.study.project.studyproject.entity.UserEntity;

import java.util.List;


public interface UserService {

    /**
     * 查询全部User
     * @return
     */
    List<UserEntity> queryUsers();

    List<UserEntity> queryUsers01();

    List<UserEntity> queryUsers02();
}
