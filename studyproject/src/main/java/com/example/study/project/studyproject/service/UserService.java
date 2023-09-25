package com.example.study.project.studyproject.service;

import com.example.study.project.studyproject.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luping
 * @date 2023/9/15 00:06
 */
@Service
public interface UserService {

    /**
     * 查询全部User
     * @return
     */
    List<UserEntity> queryUsers();

    List<UserEntity> queryUsers01();
}
