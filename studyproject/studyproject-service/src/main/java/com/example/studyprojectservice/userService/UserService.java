package com.example.studyprojectservice.userService;

import com.example.studyprojectservice.entity.UserEntity;

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
