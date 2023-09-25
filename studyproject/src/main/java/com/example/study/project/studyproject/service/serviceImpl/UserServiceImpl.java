package com.example.study.project.studyproject.service.serviceImpl;

import com.example.study.project.studyproject.entity.UserEntity;
import com.example.study.project.studyproject.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luping
 * @date 2023/9/15 00:11
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<UserEntity> queryUsers() {
        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity(1,"张三1","男","20"));
        list.add(new UserEntity(2,"张三2","男","20"));
        list.add(new UserEntity(3,"张三3","男","20"));
        list.add(new UserEntity(4,"张三4","男","20"));
        list.add(new UserEntity(5,"张三5","男","20"));
        return list;
    }

    @Override
    public List<UserEntity> queryUsers01() {
        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity(1,"张三1","男","20"));
        list.add(new UserEntity(2,"张三2","男","20"));
        list.add(new UserEntity(3,"张三3","男","20"));
        list.add(new UserEntity(4,"张三4","男","20"));
        list.add(new UserEntity(5,"张三5","男","20"));
        return list;
    }
}
