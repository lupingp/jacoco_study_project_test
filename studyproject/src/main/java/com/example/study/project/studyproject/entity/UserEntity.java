package com.example.study.project.studyproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author luping
 * @date 2023/9/15 00:08
 */
@Data
@AllArgsConstructor
public class UserEntity {

    private Integer id;

    private String username;

    private String sex;

    private String age;
}
