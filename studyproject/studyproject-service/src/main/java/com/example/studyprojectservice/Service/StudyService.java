package com.example.studyprojectservice.Service;

import com.example.studyprojectservice.entity.StudyEmtity;

import java.util.List;

/**
 * @author luping
 * @date 2023/11/8 00:18
 */
public interface StudyService {

    List<StudyEmtity> studyByQuery01(String name,Integer age);
    StudyEmtity studyByQuery02(Integer id);
}
