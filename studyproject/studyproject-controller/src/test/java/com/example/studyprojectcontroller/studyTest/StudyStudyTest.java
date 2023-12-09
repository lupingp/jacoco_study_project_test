package com.example.studyprojectcontroller.studyTest;

import com.example.studyprojectservice.Service.StudyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author luping
 * @date 2023/12/9 18:11
 */
@SpringBootTest
public class StudyStudyTest {

    @Resource
    private StudyService studyService;

    @Test
    void StudyTest01(){
        studyService.studyByQuery01("学习小子",18);
    }
}
