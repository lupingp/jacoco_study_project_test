package com.example.study.project.studyproject.study;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 学习System代码库
 */
public class StudySystemPerties {

    /**
     * System提供的数据拷贝方法
     * public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
     * src 表示源数组
     * srcPos 表示从源数组中复制的起始位置
     * dest 表示目标数组
     * destPos 表示要复制到的目标数组的起始位置
     * length 表示复制的个数
     */
    public static void copyArray() {
        String[] ArraysA = new String[]{"A", "B", "C"};
        String[] ArraysB = new String[]{"E", "F", "G"};
        System.arraycopy(ArraysA, 0, ArraysB, 0, 3);
        // 输出目标数组
        System.out.println(Arrays.stream(ArraysB).collect(Collectors.toList()));
        // 结果：源数组：[E, F, G] 变更后的：[A, B, C]
    }

    /**
     * 输入时间戳
     * currentTimeMillis
     */
    public static void timeMillis() {
        long time = System.currentTimeMillis();
        System.out.println("当前时间戳是：" + time);
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e) {
            System.out.println("时间戳方法执行出错");
        }
        long end = System.currentTimeMillis();
        long result = end - time;
        System.out.println("开始时间减去结束时间结果：" + result);
        // 结果：开始时间减去结束时间结果：4007
    }

    public static void main(String[] args) {
//        StudySystemPerties.copyArray();
//        StudySystemPerties.timeMillis();

        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vm.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.version"));
//        System.out.println(System.getProperty("java.class.path"));
//        System.out.println(System.getProperty("java.library.path"));
//        System.setProperty("DB","mysql");
//        System.out.println(System.getProperty("DB"));

//        System.out.println(System.getProperty("user.home"));
    }
}
