package com.example.studyprojectcontroller.controller;

import com.example.studyprojectservice.Service.StudyService;
import com.example.studyprojectservice.Service.UserService;
import com.example.studyprojectservice.entity.StudyEmtity;
import com.example.studyprojectservice.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luping
 * @date 2023/11/8 00:16
 */
@Slf4j
@RestController
@RequestMapping("/study/")
public class StudyController {

    @Resource
    private StudyService studyService;

    @RequestMapping(value = "studyQuery/v1/name01", method= RequestMethod.GET)
    public List<StudyEmtity> queryStudyName(String name,Integer age) {
        log.info("【查询学习用户信息】：【{}】", name);
        if (name != null && name != "" && age != null){
            return studyService.studyByQuery01(name,age);
        }
        return null;
    }

    @RequestMapping(value = "studyQuery/v1/age01", method= RequestMethod.GET)
    public StudyEmtity queryStudyId(Integer id) {
        log.info("【查询学习用户信息】：【{}】", id);
        if (id != null && id != 0){
            return studyService.studyByQuery02(id);
        }
        return null;
    }
}
