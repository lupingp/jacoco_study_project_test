package com.example.studyprojectservice.Service.serviceImpl;

import com.example.studyprojectservice.Service.StudyService;
import com.example.studyprojectservice.entity.StudyEmtity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luping
 * @date 2023/11/8 00:19
 */
@Slf4j
@Service
public class StudyServiceImpl implements StudyService {

    private static List<StudyEmtity> studyEmtityList = new ArrayList<>();

    static {
        StudyEmtity study1 = new StudyEmtity(1,"学习小子",18,"男","SUCCESS");
        StudyEmtity study2 = new StudyEmtity(2,"学习小子01",18,"男","SUCCESS");
        StudyEmtity study3 = new StudyEmtity(3,"学习小子02",18,"男","SUCCESS");
        StudyEmtity study4 = new StudyEmtity(4,"学习小子03",18,"男","SUCCESS");
        StudyEmtity study5 = new StudyEmtity(5,"学习小子04",18,"男","SUCCESS");
        studyEmtityList.add(study1);
        studyEmtityList.add(study2);
        studyEmtityList.add(study3);
        studyEmtityList.add(study4);
        studyEmtityList.add(study5);
    }

    @Override
    public List<StudyEmtity> studyByQuery01(String name, Integer age) {
        log.info("【查询学习人的入参：{}--{}】",name,age);
        if ("学习小子".equals(name) && age == 18){
            log.info("【返回数据是：{}】",studyEmtityList);
            return studyEmtityList;
        }
        if ("学习小子01".equals(name)){
            log.info("【返回数据是：{}】",studyEmtityList);
            return studyEmtityList;
        }
        if ("学习小子02".equals(name)){
            log.info("【返回数据是：{}】",studyEmtityList);
            return studyEmtityList;
        }
        return new ArrayList<>();
    }

    @Override
    public StudyEmtity studyByQuery02(Integer id) {
        log.info("【查询学习人的入参：{}--{}】",id);
       if (id == null){
           return null;
       }
       if (id == 1){
           for (StudyEmtity studyEmtity:studyEmtityList){
               if (studyEmtity.getId() == id){
                   return studyEmtity;
               }
           }
       }else {
           return studyEmtityList.get(2);
       }
       return studyEmtityList.get(5);
    }
}
