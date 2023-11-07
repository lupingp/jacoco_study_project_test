package com.example.studyprojectservice.entity;

import lombok.Data;

/**
 * @author luping
 * @date 2023/11/8 00:16
 */
@Data
public class StudyEmtity {

    private Integer id;

    private String studyName;

    private Integer studyAge;

    private String studySex;

    private String status;

    public StudyEmtity(Integer id, String studyName, Integer studyAge, String studySex, String status) {
        this.id = id;
        this.studyName = studyName;
        this.studyAge = studyAge;
        this.studySex = studySex;
        this.status = status;
    }
}
