package com.example.study.project.studyproject.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StudyReflect {

    public static void main(String[] args) throws Exception {
        //<?>
        Class<?> clases = StudyHttpClent.class;
        // 获取构造函数并创建对象
        Constructor<?> constructor = clases.getConstructor();
        StudyHttpClent http = (StudyHttpClent) constructor.newInstance();
        // 调用方法
        Method method = clases.getDeclaredMethod("httpGetheader");
        method.setAccessible(true);
        method.invoke(null);
        // 获取字段并访问
        Field field = clases.getDeclaredField("message");
        field.setAccessible(true);
        String message = (String) field.get(http);
        System.out.println("Field value: " + message);
        field.set(http, "撒打撒大声地撒");
        String message1 = (String) field.get(http);
        System.out.println("Field value: " + message1);

        System.out.println("Test。。。。。。。");
        List<String> list = new ArrayList<>();
        list.add("测试1");
        list.add("测试2");
        StringBuilder sb = new StringBuilder();
        for (String li : list) {
            System.out.println(list.indexOf(li));
            System.out.println(list.size() -1);
        }
    }
}
